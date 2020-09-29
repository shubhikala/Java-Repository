package in.com.psi.dashboard.manager.impl;

import in.com.psi.dashboard.dao.IBaseDao;
import in.com.psi.dashboard.dao.IOtherUserDao;
import in.com.psi.dashboard.entity.ActionHistory;
import in.com.psi.dashboard.entity.OtherUser;
import in.com.psi.dashboard.manager.IActionHistoryManager;
import in.com.psi.dashboard.manager.IOtherUserManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// TODO: Auto-generated Javadoc
/**
 * The Class OtherUserManagerImpl.
 */
@Service
@Transactional
public class OtherUserManagerImpl extends
		BaseManagerImpl<OtherUser, IBaseDao<OtherUser>> implements
		IOtherUserManager {

	/** The city dao impl. */
	@Autowired
	IOtherUserDao otherUserDaoImpl;
	
	@Autowired
	IActionHistoryManager actionHistoryManagerImpl;

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.com.psi.mystay.manager.impl.BaseManagerImpl#getDao()
	 */
	@Override
	public IBaseDao<OtherUser> getDao() {
		return otherUserDaoImpl;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * in.com.psi.dashboard.manager.IOtherUserManager#login(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean login(String hostUsername, String hostPassword,
			String remoteAddress, String userName, ActionHistory actionHistory) {
		boolean result = false;
		result = otherUserDaoImpl.login(hostUsername, hostPassword,
				remoteAddress, userName);
		if (result) {
			actionHistoryManagerImpl.save(actionHistory);
		}
		return result;
	}
}
