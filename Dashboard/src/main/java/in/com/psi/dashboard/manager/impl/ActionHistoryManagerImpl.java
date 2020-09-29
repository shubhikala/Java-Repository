package in.com.psi.dashboard.manager.impl;

import in.com.psi.dashboard.dao.IActionHistoryDao;
import in.com.psi.dashboard.dao.IBaseDao;
import in.com.psi.dashboard.entity.ActionHistory;
import in.com.psi.dashboard.manager.IActionHistoryManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// TODO: Auto-generated Javadoc
/**
 * The Class ActionHistoryManagerImpl.
 */
@Service
@Transactional
public class ActionHistoryManagerImpl extends
		BaseManagerImpl<ActionHistory, IBaseDao<ActionHistory>> implements
		IActionHistoryManager {

	/** The city dao impl. */
	@Autowired
	IActionHistoryDao actionHistoryDaoImpl;

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.com.psi.mystay.manager.impl.BaseManagerImpl#getDao()
	 */
	@Override
	public IBaseDao<ActionHistory> getDao() {
		return actionHistoryDaoImpl;
	}

}
