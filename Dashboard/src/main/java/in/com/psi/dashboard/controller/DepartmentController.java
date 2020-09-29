package in.com.psi.dashboard.controller;

import in.com.psi.dashboard.entity.Department;
import in.com.psi.dashboard.entity.VO.BaseVO;
import in.com.psi.dashboard.entity.VO.DepartmentVO;
import in.com.psi.dashboard.exception.DashboardException;
import in.com.psi.dashboard.manager.IDepartmentManager;
import in.com.psi.dashboard.util.DashboardConstants;
import in.com.psi.dashboard.util.DashboardMappings;
import in.com.psi.dashboard.util.DashboardUtil;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

// TODO: Auto-generated Javadoc
/**
 * The Class DepartmentController.
 */
@Controller
public class DepartmentController {

	/** The logger. */
	private final Logger logger = LoggerFactory
			.getLogger(DepartmentController.class);

	/** The department manager impl. */
	@Autowired
	IDepartmentManager departmentManagerImpl;

	/**
	 * List department.
	 *
	 * @param baseVO
	 *            the base vo
	 * @param httpServletRequest
	 *            the http servlet request
	 * @param httpServletResponse
	 *            the http servlet response
	 * @return the list
	 * @throws DashboardException
	 *             the dashboard exception
	 */
	@RequestMapping(method = RequestMethod.POST, value = DashboardMappings.LIST_DEPARTMENT)
	public @ResponseBody List<DepartmentVO> listDepartment(
			@RequestBody BaseVO baseVO) throws DashboardException {
		List<DepartmentVO> departmentVOList = null;
		List<Department> departmentList = null;
		if (DashboardUtil.checkSession(baseVO.getSessionId())) {
			try {
				departmentList = departmentManagerImpl.list();
			} catch (Exception e) {
				throw new DashboardException(logger, "listDepartment",
						DashboardConstants.REQUEST_NOT_PROCESSED, null, e);
			}
			departmentVOList = DashboardUtil
					.createDepartmentVOList(departmentList);
		}
		return departmentVOList;
	}

}
