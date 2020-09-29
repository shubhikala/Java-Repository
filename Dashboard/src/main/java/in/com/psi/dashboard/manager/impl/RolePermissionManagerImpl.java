package in.com.psi.dashboard.manager.impl;

import in.com.psi.dashboard.dao.IBaseDao;
import in.com.psi.dashboard.dao.IRolePermissionDao;
import in.com.psi.dashboard.entity.RolePermission;
import in.com.psi.dashboard.manager.IRolePermissionManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// TODO: Auto-generated Javadoc
/**
 * The Class RolePermissionManagerImpl.
 */
@Service
@Transactional
public class RolePermissionManagerImpl extends
		BaseManagerImpl<RolePermission, IBaseDao<RolePermission>> implements
		IRolePermissionManager {

	/** The city dao impl. */
	@Autowired
	IRolePermissionDao rolePermissionDaoImpl;

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.com.psi.mystay.manager.impl.BaseManagerImpl#getDao()
	 */
	@Override
	public IBaseDao<RolePermission> getDao() {
		return rolePermissionDaoImpl;
	}

}
