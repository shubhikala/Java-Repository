package in.com.psi.dashboard.exception;

import in.com.psi.dashboard.entity.VO.ResponseMessage;
import in.com.psi.dashboard.util.DashboardConstants;
import in.com.psi.dashboard.util.MessageReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.google.gson.Gson;

@Component
public class ExceptionHandler extends SimpleMappingExceptionResolver {

	private final Logger slf4jLogger = LoggerFactory
			.getLogger(ExceptionHandler.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver
	 * #resolveException(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse, java.lang.Object,
	 * java.lang.Exception)
	 */
	public ModelAndView resolveException(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, Object obj, Exception e) {

		ResponseMessage message = new ResponseMessage();
		try {
			if (e instanceof DashboardException) {
				if (e.getMessage()
						.equalsIgnoreCase(
								(MessageReader.getInstance()
										.getProperty(DashboardConstants.EMPTY_MESSAGE)))) {
					message.setResponseCode(ResponseMessage.EMPTY);
				} else {
					message.setResponseCode(ResponseMessage.ERROR);
				}
				message.setResponseMessage(e.getMessage());
				slf4jLogger.error(e.getMessage());
			} else if (e instanceof NullPointerException) {
				message.setResponseCode(ResponseMessage.ERROR);
				message.setResponseMessage(MessageReader.getInstance()
						.getProperty(DashboardConstants.ERROR));
				slf4jLogger.error(e.getMessage());
			} else if (e instanceof EmptyResultDataAccessException) {
				message.setResponseCode(ResponseMessage.EMPTY);
				message.setResponseMessage(MessageReader.getInstance()
						.getProperty(DashboardConstants.EMPTY_MESSAGE));
			} else if (e instanceof DuplicateKeyException) {
				message.setResponseCode(ResponseMessage.DUPLICATE);
				message.setResponseMessage(MessageReader.getInstance()
						.getProperty(DashboardConstants.DUPLICATE));

			}

			Gson gson = new Gson();
			String jsonString = gson.toJson(message);
			httpServletResponse.setHeader(DashboardConstants.CONTENT_TYPE,
					DashboardConstants.APPLICATIONJSON);
			httpServletResponse.getOutputStream().write(jsonString.getBytes());
		} catch (Exception leftException) {
			slf4jLogger.error(leftException.getMessage(), e);
		}
		return new ModelAndView();
	}
}
