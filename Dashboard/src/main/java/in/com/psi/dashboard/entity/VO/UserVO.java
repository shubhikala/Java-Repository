package in.com.psi.dashboard.entity.VO;

import java.io.Serializable;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class UserVO.
 */
public class UserVO extends BaseVO implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The user name. */
	private String userName;
	
	/** The last interaction time. */
	private long lastInteractionTime;
	
	/** The is ldap authenticated. */
	private boolean isLDAPAuthenticated;
	
	/** The permissions. */
	private List<String> permissions;

	/**
	 * Gets the permissions.
	 *
	 * @return the permissions
	 */
	public List<String> getPermissions() {
		return permissions;
	}

	/**
	 * Sets the permissions.
	 *
	 * @param permissions the new permissions
	 */
	public void setPermissions(List<String> permissions) {
		this.permissions = permissions;
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
	 * Gets the last interaction time.
	 *
	 * @return the last interaction time
	 */
	public long getLastInteractionTime() {
		return lastInteractionTime;
	}

	/**
	 * Sets the last interaction time.
	 *
	 * @param lastInteractionTime the new last interaction time
	 */
	public void setLastInteractionTime(long lastInteractionTime) {
		this.lastInteractionTime = lastInteractionTime;
	}

	/**
	 * Checks if is LDAP authenticated.
	 *
	 * @return true, if is LDAP authenticated
	 */
	public boolean isLDAPAuthenticated() {
		return isLDAPAuthenticated;
	}

	/**
	 * Sets the LDAP authenticated.
	 *
	 * @param isLDAPAuthenticated the new LDAP authenticated
	 */
	public void setLDAPAuthenticated(boolean isLDAPAuthenticated) {
		this.isLDAPAuthenticated = isLDAPAuthenticated;
	}
}
