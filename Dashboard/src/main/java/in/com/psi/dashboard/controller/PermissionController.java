package in.com.psi.dashboard.controller;

import in.com.psi.dashboard.entity.Permission;
import in.com.psi.dashboard.entity.VO.BaseVO;
import in.com.psi.dashboard.entity.VO.PermissionVO;
import in.com.psi.dashboard.exception.DashboardException;
import in.com.psi.dashboard.manager.IPermissionManager;
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
 * The Class PermissionController.
 */
@Controller
public class PermissionController {

	/** The permission manager impl. */
	@Autowired
	IPermissionManager permissionManagerImpl;

	/** The logger. */
	private final Logger logger = LoggerFactory
			.getLogger(PermissionController.class);

	/** The Permission manager impl. */
	@Autowired
	IPermissionManager PermissionManagerImpl;

	/**
	 * List permission.
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
	@RequestMapping(method = RequestMethod.POST, value = DashboardMappings.LIST_PERMISSION)
	public @ResponseBody List<PermissionVO> listPermission(
			@RequestBody BaseVO baseVO) throws DashboardException {
		List<PermissionVO> permissionVOList = null;
		List<Permission> permissionList = null;
		if (DashboardUtil.checkSession(baseVO.getSessionId())) {
			try {
				permissionList = permissionManagerImpl.list();
			} catch (Exception e) {
				throw new DashboardException(logger, "listPermission",
						DashboardConstants.REQUEST_NOT_PROCESSED, null, e);
			}
			permissionVOList = DashboardUtil
					.createPermissionVOList(permissionList);
		}
		return permissionVOList;
	}
}
