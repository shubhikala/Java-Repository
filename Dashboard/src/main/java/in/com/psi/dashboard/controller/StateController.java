package in.com.psi.dashboard.controller;

import in.com.psi.dashboard.entity.Country;
import in.com.psi.dashboard.entity.State;
import in.com.psi.dashboard.entity.VO.StateVO;
import in.com.psi.dashboard.exception.DashboardException;
import in.com.psi.dashboard.manager.ICountryManager;
import in.com.psi.dashboard.manager.IStateManager;
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
 * The Class StateController.
 */
@Controller
public class StateController {

	/** The logger. */
	private final Logger logger = LoggerFactory
			.getLogger(StateController.class);

	/** The state manager impl. */
	@Autowired
	IStateManager stateManagerImpl;

	/** The country manager impl. */
	@Autowired
	ICountryManager countryManagerImpl;

	/**
	 * List state.
	 *
	 * @param stateVO
	 *            the request state vo
	 * @param httpServletRequest
	 *            the http servlet request
	 * @param httpServletResponse
	 *            the http servlet response
	 * @return the list
	 * @throws DashboardException
	 *             the dashboard exception
	 */
	@RequestMapping(method = RequestMethod.POST, value = DashboardMappings.LIST_STATE)
	public @ResponseBody List<StateVO> listState(@RequestBody StateVO stateVO)
			throws DashboardException {
		List<StateVO> stateVOList = null;
		List<State> stateList = null;
		if (DashboardUtil.checkSession(stateVO.getSessionId())) {
			Country country = null;
			try {
				country = countryManagerImpl.getById(stateVO.getCountryId());
				if (country == null) {
					throw new DashboardException(logger, "listState",
							DashboardConstants.COUNTRY_ID_NOT_FOUND, null);
				}
				stateList = stateManagerImpl.listByName(stateVO, country);
				if (stateList.size() == 0) {
					throw new DashboardException(logger, "listState",
							DashboardConstants.STATE_NOT_FOUND, null);
				}
			} catch (DashboardException e) {
				throw e;
			} catch (Exception e) {
				throw new DashboardException(logger, "listState",
						DashboardConstants.REQUEST_NOT_PROCESSED, null, e);
			}
			stateVOList = DashboardUtil.createStateVOList(stateList);
		}
		return stateVOList;
	}
}
