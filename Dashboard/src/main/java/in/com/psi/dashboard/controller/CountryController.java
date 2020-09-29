package in.com.psi.dashboard.controller;

import in.com.psi.dashboard.entity.Country;
import in.com.psi.dashboard.entity.VO.CountryVO;
import in.com.psi.dashboard.exception.DashboardException;
import in.com.psi.dashboard.manager.ICountryManager;
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
 * The Class CountryController.
 */
@Controller
public class CountryController {

	/** The logger. */
	private final Logger logger = LoggerFactory
			.getLogger(CountryController.class);

	/** The country manager impl. */
	@Autowired
	ICountryManager countryManagerImpl;

	/**
	 * List country.
	 *
	 * @param countryVO
	 *            the request country vo
	 * @param httpServletRequest
	 *            the http servlet request
	 * @param httpServletResponse
	 *            the http servlet response
	 * @return the list
	 * @throws DashboardException
	 *             the dashboard exception
	 */
	@RequestMapping(method = RequestMethod.POST, value = DashboardMappings.LIST_COUNTRY)
	public @ResponseBody List<CountryVO> listCountry(
			@RequestBody CountryVO countryVO) throws DashboardException {
		List<CountryVO> countryVOList = null;
		List<Country> countryList = null;
		if (DashboardUtil.checkSession(countryVO.getSessionId())) {
			try {
				countryList = countryManagerImpl.listByName(countryVO
						.getName());
				if (countryList.size() == 0) {
					throw new DashboardException(logger, "listCountry",
							DashboardConstants.COUNTRY_NOT_FOUND, null);
				}
			}catch(DashboardException e){
				throw e;
			}
			catch (Exception e) {
				throw new DashboardException(logger, "listCountry",
						DashboardConstants.REQUEST_NOT_PROCESSED, null, e);
			}
			countryVOList = DashboardUtil.createCountryVOList(countryList);
		}
		return countryVOList;
	}
}
