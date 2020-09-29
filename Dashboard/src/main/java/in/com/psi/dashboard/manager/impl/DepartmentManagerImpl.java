package in.com.psi.dashboard.manager.impl;

import in.com.psi.dashboard.dao.IBaseDao;
import in.com.psi.dashboard.dao.IDepartmentDao;
import in.com.psi.dashboard.entity.Department;
import in.com.psi.dashboard.manager.IDepartmentManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// TODO: Auto-generated Javadoc
/**
 * The Class DepartmentManagerImpl.
 */
@Service
@Transactional
public class DepartmentManagerImpl extends
		BaseManagerImpl<Department, IBaseDao<Department>> implements
		IDepartmentManager {

	/** The city dao impl. */
	@Autowired
	IDepartmentDao departmentDaoImpl;

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.com.psi.mystay.manager.impl.BaseManagerImpl#getDao()
	 */
	@Override
	public IBaseDao<Department> getDao() {
		return departmentDaoImpl;
	}

}
