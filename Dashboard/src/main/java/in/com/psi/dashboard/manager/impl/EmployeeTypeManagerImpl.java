package in.com.psi.dashboard.manager.impl;

import in.com.psi.dashboard.dao.IBaseDao;
import in.com.psi.dashboard.dao.IEmployeeTypeDao;
import in.com.psi.dashboard.entity.EmployeeType;
import in.com.psi.dashboard.manager.IEmployeeTypeManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// TODO: Auto-generated Javadoc
/**
 * The Class EmployeeTypeManagerImpl.
 */
@Service
@Transactional
public class EmployeeTypeManagerImpl extends
		BaseManagerImpl<EmployeeType, IBaseDao<EmployeeType>> implements
		IEmployeeTypeManager {

	/** The city dao impl. */
	@Autowired
	IEmployeeTypeDao employeeTypeDaoImpl;

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.com.psi.mystay.manager.impl.BaseManagerImpl#getDao()
	 */
	@Override
	public IBaseDao<EmployeeType> getDao() {
		return employeeTypeDaoImpl;
	}

}
