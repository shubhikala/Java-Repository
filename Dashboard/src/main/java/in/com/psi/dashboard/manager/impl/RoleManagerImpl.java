package in.com.psi.dashboard.manager.impl;

import in.com.psi.dashboard.dao.IBaseDao;
import in.com.psi.dashboard.dao.IRoleDao;
import in.com.psi.dashboard.entity.Role;
import in.com.psi.dashboard.manager.IRoleManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// TODO: Auto-generated Javadoc
/**
 * The Class RoleManagerImpl.
 */
@Service
@Transactional
public class RoleManagerImpl extends BaseManagerImpl<Role, IBaseDao<Role>>
		implements IRoleManager {

	/** The city dao impl. */
	@Autowired
	IRoleDao roleDaoImpl;

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.com.psi.mystay.manager.impl.BaseManagerImpl#getDao()
	 */
	@Override
	public IBaseDao<Role> getDao() {
		return roleDaoImpl;
	}

}