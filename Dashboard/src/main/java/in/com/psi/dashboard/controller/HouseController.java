package in.com.psi.dashboard.controller;

import in.com.psi.dashboard.entity.House;
import in.com.psi.dashboard.entity.VO.BaseVO;
import in.com.psi.dashboard.entity.VO.HouseVO;
import in.com.psi.dashboard.exception.DashboardException;
import in.com.psi.dashboard.manager.IHouseManager;
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
 * The Class HouseController.
 */
@Controller
public class HouseController {

	/** The logger. */
	private final Logger logger = LoggerFactory
			.getLogger(HouseController.class);

	/** The house manager impl. */
	@Autowired
	IHouseManager houseManagerImpl;

	/**
	 * List house.
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
	@RequestMapping(method = RequestMethod.POST, value = DashboardMappings.LIST_HOUSE)
	public @ResponseBody List<HouseVO> listHouse(@RequestBody BaseVO baseVO)
			throws DashboardException {
		List<HouseVO> houseVOList = null;
		List<House> houseList = null;
		if (DashboardUtil.checkSession(baseVO.getSessionId())) {
			try {
				houseList = houseManagerImpl.list();
			} catch (Exception e) {
				throw new DashboardException(logger, "listHouse",
						DashboardConstants.REQUEST_NOT_PROCESSED, null, e);
			}
			houseVOList = DashboardUtil.createHouseVOList(houseList);
		}
		return houseVOList;
	}
}
