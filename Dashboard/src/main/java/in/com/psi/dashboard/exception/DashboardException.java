package in.com.psi.dashboard.exception;

import in.com.psi.dashboard.util.DashboardConstants;
import in.com.psi.dashboard.util.MessageReader;

import java.text.MessageFormat;

import org.slf4j.Logger;

public class DashboardException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;

	private Throwable nestedException;
	String propValue = null;

	public String getMessage() {
		return message;
	}

	public Throwable getNestedException() {
		return nestedException;
	}

	public DashboardException(Logger logger, String methodName, String msgKey,
			Object[] args) {

		try {
			logger.debug(DashboardConstants.MESSAGE_KEY + msgKey);
			propValue = readProperty(msgKey.toString());
			message = MessageFormat.format(propValue, args);
			logger.error(message);
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param key
	 * @return
	 */
	public String readProperty(String key) {
		return MessageReader.getInstance().getProperty(key);
	}

	/**
	 * 
	 * @param logger
	 * @param methodName
	 * @param msgKey
	 * @param args
	 * @param ex
	 */
	public DashboardException(Logger logger, String methodName, String msgKey,
			String[] args, Exception ex) {
		try {
			this.nestedException = ex;
			logger.error(DashboardConstants.ERROR, ex);
			logger.debug(DashboardConstants.MESSAGE_KEY + msgKey);
			try {
				propValue = readProperty(msgKey.toString());
				message = MessageFormat.format(propValue, args);
			} catch (NullPointerException e) {
				message = MessageReader.getInstance().getProperty(
						DashboardConstants.MESSAGE_KEY_NOT_FOUND);
				logger.error(DashboardConstants.ERROR, e);
			}
			logger.error(message);
		} catch (Exception e) {
			logger.error(DashboardConstants.ERROR, e);
		}
	}

	public DashboardException(Logger logger, String msgKey, String entityName) {

		try {
			logger.debug(DashboardConstants.MESSAGE_KEY + msgKey);
			propValue = readProperty(msgKey);
			message = MessageFormat.format(propValue, entityName);
			logger.error(message);
		} catch (NullPointerException e) {
			message = MessageReader.getInstance().getProperty(
					DashboardConstants.MESSAGE_KEY_NOT_FOUND);
			logger.error(DashboardConstants.ERROR, e);
		} catch (Exception e) {
			logger.error(DashboardConstants.ERROR, e);
		}
	}
}
