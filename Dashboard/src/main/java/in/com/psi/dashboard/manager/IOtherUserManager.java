package in.com.psi.dashboard.manager;

import in.com.psi.dashboard.entity.ActionHistory;
import in.com.psi.dashboard.entity.OtherUser;

// TODO: Auto-generated Javadoc
/**
 * The Interface IOtherUserManager.
 */
public interface IOtherUserManager extends IBaseManager<OtherUser> {

	/**
	 * Login.
	 *
	 * @param hostUsername the host username
	 * @param hostPassword the host password
	 * @param remoteAddr the remote addr
	 * @param userName the user name
	 * @param actionHistory 
	 * @return true, if successful
	 */
	boolean login(String hostUsername, String hostPassword, String remoteAddr,
			String userName, ActionHistory actionHistory);

}
