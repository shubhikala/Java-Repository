package in.com.psi.dashboard.controller;

import in.com.psi.dashboard.entity.Role;
import in.com.psi.dashboard.entity.VO.BaseVO;
import in.com.psi.dashboard.entity.VO.RoleVO;
import in.com.psi.dashboard.exception.DashboardException;
import in.com.psi.dashboard.manager.IRoleManager;
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
 * The Class RoleController.
 */
@Controller
public class RoleController {

	/** The logger. */
	private final Logger logger = LoggerFactory.getLogger(RoleController.class);

	/** The role manager impl. */
	@Autowired
	IRoleManager roleManagerImpl;

	/**
	 * List role.
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
	@RequestMapping(method = RequestMethod.POST, value = DashboardMappings.LIST_ROLE)
	public @ResponseBody List<RoleVO> listRole(@RequestBody BaseVO baseVO)
			throws DashboardException {
		List<RoleVO> roleVOList = null;
		List<Role> roleList = null;
		if (DashboardUtil.checkSession(baseVO.getSessionId())) {
			try {
				roleList = roleManagerImpl.list();
			} catch (Exception e) {
				throw new DashboardException(logger, "listRole",
						DashboardConstants.REQUEST_NOT_PROCESSED, null, e);
			}
			roleVOList = DashboardUtil.createRoleVOList(roleList);
		}
		return roleVOList;
	}
}
