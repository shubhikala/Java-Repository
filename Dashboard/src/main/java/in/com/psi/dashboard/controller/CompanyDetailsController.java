package in.com.psi.dashboard.controller;

import in.com.psi.dashboard.entity.CompanyDetails;
import in.com.psi.dashboard.entity.VO.BaseVO;
import in.com.psi.dashboard.entity.VO.CompanyDetailsVO;
import in.com.psi.dashboard.exception.DashboardException;
import in.com.psi.dashboard.manager.ICompanyDetailsManager;
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
 * The Class CompanyDetailsController.
 */
@Controller
public class CompanyDetailsController {

	/** The logger. */
	private final Logger logger = LoggerFactory
			.getLogger(CompanyDetailsController.class);

	/** The company details manager impl. */
	@Autowired
	ICompanyDetailsManager companyDetailsManagerImpl;

	/**
	 * List company details.
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
	@RequestMapping(method = RequestMethod.POST, value = DashboardMappings.LIST_COMPANY_DETAILS)
	public @ResponseBody List<CompanyDetailsVO> listCompanyDetails(
			@RequestBody BaseVO baseVO) throws DashboardException {
		List<CompanyDetailsVO> companyDetailsVOList = null;
		List<CompanyDetails> companyDetailsList = null;
		if (DashboardUtil.checkSession(baseVO.getSessionId())) {
			try {
				companyDetailsList = companyDetailsManagerImpl.list();
			} catch (Exception e) {
				throw new DashboardException(logger, "listCompanyDetails",
						DashboardConstants.REQUEST_NOT_PROCESSED, null, e);
			}
			companyDetailsVOList = DashboardUtil
					.createCompanyDetailsVOList(companyDetailsList);
		}
		return companyDetailsVOList;
	}
}
