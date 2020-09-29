package in.com.psi.dashboard.controller;

import in.com.psi.dashboard.entity.City;
import in.com.psi.dashboard.entity.State;
import in.com.psi.dashboard.entity.VO.CityVO;
import in.com.psi.dashboard.exception.DashboardException;
import in.com.psi.dashboard.manager.ICityManager;
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

/**
 * The Class CityController.
 */
@Controller
public class CityController {

	/** The logger. */
	private final Logger logger = LoggerFactory.getLogger(CityController.class);

	/** The city manager impl. */
	@Autowired
	ICityManager cityManagerImpl;

	/** The state manager impl. */
	@Autowired
	IStateManager stateManagerImpl;

	/**
	 * List state.
	 *
	 * @param cityVO
	 *            the request city vo
	 * @param httpServletRequest
	 *            the http servlet request
	 * @param httpServletResponse
	 *            the http servlet response
	 * @return the list
	 * @throws DashboardException
	 *             the dashboard exception
	 */
	@RequestMapping(method = RequestMethod.POST, value = DashboardMappings.LIST_CITY)
	public @ResponseBody List<CityVO> listCity(@RequestBody CityVO cityVO)
			throws DashboardException {
		List<CityVO> cityVOList = null;
		List<City> cityList = null;
		if (DashboardUtil.checkSession(cityVO.getSessionId())) {
			State state = null;
			try {
				state = stateManagerImpl.getById(cityVO.getStateId());
				if (state == null) {
					throw new DashboardException(logger, "listCity",
							DashboardConstants.STATE_ID_NOT_FOUND, null);
				}
				cityList = cityManagerImpl.listByName(cityVO.getName(), state);
				if (cityList.size() == 0) {
					throw new DashboardException(logger, "listCity",
							DashboardConstants.CITY_NOT_FOUND, null);
				}

			} catch (DashboardException e) {
				throw e;
			} catch (Exception e) {
				throw new DashboardException(logger, "listCity",
						DashboardConstants.REQUEST_NOT_PROCESSED, null, e);
			}
			cityVOList = DashboardUtil.createCityVOList(cityList);
		}
		return cityVOList;
	}
}
