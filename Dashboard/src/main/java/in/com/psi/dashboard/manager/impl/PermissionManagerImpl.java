package in.com.psi.dashboard.manager.impl;

import in.com.psi.dashboard.dao.IBaseDao;
import in.com.psi.dashboard.dao.IPermissionDao;
import in.com.psi.dashboard.entity.Permission;
import in.com.psi.dashboard.manager.IPermissionManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// TODO: Auto-generated Javadoc
/**
 * The Class PermissionManagerImpl.
 */
@Service
@Transactional
public class PermissionManagerImpl extends
		BaseManagerImpl<Permission, IBaseDao<Permission>> implements
		IPermissionManager {

	/** The city dao impl. */
	@Autowired
	IPermissionDao permissionDaoImpl;

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.com.psi.mystay.manager.impl.BaseManagerImpl#getDao()
	 */
	@Override
	public IBaseDao<Permission> getDao() {
		return permissionDaoImpl;
	}

}
