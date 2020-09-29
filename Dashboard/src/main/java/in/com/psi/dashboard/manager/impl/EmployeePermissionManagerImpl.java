package in.com.psi.dashboard.manager.impl;

import in.com.psi.dashboard.dao.IBaseDao;
import in.com.psi.dashboard.dao.IEmployeePermissionDao;
import in.com.psi.dashboard.entity.EmployeePermission;
import in.com.psi.dashboard.manager.IEmployeePermissionManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// TODO: Auto-generated Javadoc
/**
 * The Class EmployeePermissionManagerImpl.
 */
@Service
@Transactional
public class EmployeePermissionManagerImpl extends
		BaseManagerImpl<EmployeePermission, IBaseDao<EmployeePermission>>
		implements IEmployeePermissionManager {

	/** The city dao impl. */
	@Autowired
	IEmployeePermissionDao employeePermissionDaoImpl;

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.com.psi.mystay.manager.impl.BaseManagerImpl#getDao()
	 */
	@Override
	public IBaseDao<EmployeePermission> getDao() {
		return employeePermissionDaoImpl;
	}

}
