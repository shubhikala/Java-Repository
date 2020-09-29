package in.com.psi.dashboard.entity.VO;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class AuthenticationVO.
 */
public class AuthenticationVO extends BaseVO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2307546318759719392L;

	/** The host username. */
	private String hostUsername;
	
	/** The host password. */
	private String hostPassword;
	
	/** The user name. */
	private String userName;
	
	/** The password. */
	private String password;

	/**
	 * Gets the host username.
	 *
	 * @return the host username
	 */
	public String getHostUsername() {
		return hostUsername;
	}

	/**
	 * Sets the host username.
	 *
	 * @param hostUsername the new host username
	 */
	public void setHostUsername(String hostUsername) {
		this.hostUsername = hostUsername;
	}

	/**
	 * Gets the host password.
	 *
	 * @return the host password
	 */
	public String getHostPassword() {
		return hostPassword;
	}

	/**
	 * Sets the host password.
	 *
	 * @param hostPassword the new host password
	 */
	public void setHostPassword(String hostPassword) {
		this.hostPassword = hostPassword;
	}

	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the user name.
	 *
	 * @param userName the new user name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
