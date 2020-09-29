package in.com.psi.dashboard.controller;

import in.com.psi.dashboard.entity.EmployeeType;
import in.com.psi.dashboard.entity.VO.BaseVO;
import in.com.psi.dashboard.entity.VO.EmployeeTypeVO;
import in.com.psi.dashboard.exception.DashboardException;
import in.com.psi.dashboard.manager.IEmployeeTypeManager;
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
 * The Class EmployeeTypeController.
 */
@Controller
public class EmployeeTypeController {

	/** The logger. */
	private final Logger logger = LoggerFactory
			.getLogger(EmployeeTypeController.class);

	/** The employee type manager impl. */
	@Autowired
	IEmployeeTypeManager employeeTypeManagerImpl;

	/**
	 * List employee type.
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
	@RequestMapping(method = RequestMethod.POST, value = DashboardMappings.LIST_EMPLOYEE_TYPE)
	public @ResponseBody List<EmployeeTypeVO> listEmployeeType(
			@RequestBody BaseVO baseVO) throws DashboardException {
		List<EmployeeTypeVO> employeeTypeVOList = null;
		List<EmployeeType> employeeTypeList = null;
		if (DashboardUtil.checkSession(baseVO.getSessionId())) {
			try {
				employeeTypeList = employeeTypeManagerImpl.list();
			} catch (Exception e) {
				throw new DashboardException(logger, "listEmployeeType",
						DashboardConstants.REQUEST_NOT_PROCESSED, null, e);
			}
			employeeTypeVOList = DashboardUtil.createEmployeeTypeVOList(employeeTypeList);
		}
		return employeeTypeVOList;
	}
}
