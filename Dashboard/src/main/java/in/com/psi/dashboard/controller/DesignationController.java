package in.com.psi.dashboard.controller;

import in.com.psi.dashboard.entity.Designation;
import in.com.psi.dashboard.entity.VO.DesignationVO;
import in.com.psi.dashboard.exception.DashboardException;
import in.com.psi.dashboard.manager.IDesignationManager;
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
 * The Class DesignationController.
 */
@Controller
public class DesignationController {

	/** The logger. */
	private final Logger logger = LoggerFactory
			.getLogger(DesignationController.class);

	/** The designation manager impl. */
	@Autowired
	IDesignationManager designationManagerImpl;

	/**
	 * List designation.
	 *
	 * @param designationVO
	 *            the request designation vo
	 * @param httpServletRequest
	 *            the http servlet request
	 * @param httpServletResponse
	 *            the http servlet response
	 * @return the list
	 * @throws DashboardException
	 *             the dashboard exception
	 */
	@RequestMapping(method = RequestMethod.POST, value = DashboardMappings.LIST_DESIGNATION)
	public @ResponseBody List<DesignationVO> listDesignation(
			@RequestBody DesignationVO designationVO) throws DashboardException {
		List<DesignationVO> designationVOList = null;
		List<Designation> designationList = null;
		if (DashboardUtil.checkSession(designationVO.getSessionId())) {
			try {
				designationList = designationManagerImpl
						.listByName(designationVO.getName());
				if (designationList.size() == 0) {
					throw new DashboardException(logger, "listDesignation",
							DashboardConstants.DESIGNATION_NOT_FOUND, null);
				}
			} catch (DashboardException e) {
				throw e;
			} catch (Exception e) {

				throw new DashboardException(logger, "listDepartment",
						DashboardConstants.REQUEST_NOT_PROCESSED, null, e);
			}
			designationVOList = DashboardUtil
					.createDesignationVOList(designationList);
		}
		return designationVOList;
	}
}
