package in.com.psi.dashboard.filter;

import in.com.psi.dashboard.entity.VO.ResponseMessage;
import in.com.psi.dashboard.util.DashboardConstants;
import in.com.psi.dashboard.util.DashboardMappings;
import in.com.psi.dashboard.util.DashboardUtil;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

// TODO: Auto-generated Javadoc
/**
 * The Class AuthenticationAndPreflightFilter.
 */
public class AuthenticationAndPreflightFilter implements Filter {

	/** The context. */
	@SuppressWarnings("unused")
	private ServletContext context;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.context = filterConfig.getServletContext();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) req;
		HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
		String url = httpServletRequest.getRequestURI();
		if (url.contains(".do")) {
			if (!url.contains(DashboardMappings.LOGIN)
					&& !url.contains(DashboardMappings.RENEW)
					&& !url.contains(DashboardMappings.LDAPAUTHENTICATION)) {
				/*
				 * if (url.contains(DashboardMappings.ADD_USER)) {
				 * returnInvalidResponse(httpServletResponse,
				 * DashboardConstants.LDAP_AUTHENTICATION_REQUIRED); return; }
				 */
			}
		}
		DashboardUtil.prepareCrossSiteAllowanceHeader(httpServletResponse);
		chain.doFilter(httpServletRequest, httpServletResponse);

	}

	/**
	 * Return invalid response.
	 *
	 * @param httpServletResponse
	 *            the http servlet response
	 * @param responseMessage
	 *            the response message
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@SuppressWarnings("unused")
	private void returnInvalidResponse(HttpServletResponse httpServletResponse,
			String responseMessage) throws IOException {
		// Add this to prepareResponseMessage in UTIL
		ResponseMessage message = DashboardUtil.prepareResponseMessage(
				ResponseMessage.ERROR, responseMessage, null);
		Gson gson = new Gson();
		String jsonString = gson.toJson(message);
		httpServletResponse.setHeader(DashboardConstants.CONTENT_TYPE,
				DashboardConstants.APPLICATIONJSON);
		httpServletResponse.getOutputStream().write(jsonString.getBytes());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {

	}

}
