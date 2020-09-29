package in.com.psi.dashboard.dao;

import in.com.psi.dashboard.entity.OtherUser;



// TODO: Auto-generated Javadoc
/**
 * The Interface IOtherUserDao.
 */
public interface IOtherUserDao extends IBaseDao<OtherUser> {

	/**
	 * Login.
	 *
	 * @param hostUsername the host username
	 * @param hostPassword the host password
	 * @param remoteAddr the remote addr
	 * @param userName the user name
	 * @return true, if successful
	 */
	boolean login(String hostUsername, String hostPassword, String remoteAddr,
			String userName);

}
