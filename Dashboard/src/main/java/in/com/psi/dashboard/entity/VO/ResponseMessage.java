package in.com.psi.dashboard.entity.VO;

import in.com.psi.dashboard.entity.VO.GenericVO;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class ResponseMessage.
 */
public class ResponseMessage extends GenericVO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 9152667405336560239L;

	/** The Constant SUCCESS. */
	public static final String SUCCESS = "0";

	/** The Constant ERROR. */
	public static final String ERROR = "1";

	/** The Constant EMPTY. */
	public static final String EMPTY = "-1";

	/** The Constant ERROR. */
	public static final String DUPLICATE = "-2";

	/** The Constant ERROR. */
	public static final String LOGIN_REQUIRED = "-3";

	/**
	 * Gets the response.
	 *
	 * @return the response
	 */
	public String getResponseMessage() {
		return responseMessage;
	}

	/**
	 * Sets the response.
	 *
	 * @param responseMessage
	 *            the new response
	 */
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	/**
	 * Gets the response code.
	 *
	 * @return the response code
	 */
	public String getResponseCode() {
		return responseCode;
	}

	/**
	 * Sets the response code.
	 *
	 * @param responseCode
	 *            the new response code
	 */
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	/**
	 * Gets the object.
	 *
	 * @return the object
	 */
	public Object getResponseObject() {
		return responseObject;
	}

	/**
	 * Sets the object.
	 *
	 * @param responseObject
	 *            the new object
	 */
	public void setResponseObject(Object responseObject) {
		this.responseObject = responseObject;
	}

	/** The response. */
	String responseMessage;

	/** The response code. */
	private String responseCode;

	/** The object. */
	Object responseObject;

}
