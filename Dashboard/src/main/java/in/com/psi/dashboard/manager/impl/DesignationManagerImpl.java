package in.com.psi.dashboard.manager.impl;

import java.util.List;

import in.com.psi.dashboard.dao.IBaseDao;
import in.com.psi.dashboard.dao.IDesignationDao;
import in.com.psi.dashboard.entity.Designation;
import in.com.psi.dashboard.manager.IDesignationManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// TODO: Auto-generated Javadoc
/**
 * The Class DesignationManagerImpl.
 */
@Service
@Transactional
public class DesignationManagerImpl extends
		BaseManagerImpl<Designation, IBaseDao<Designation>> implements
		IDesignationManager {

	/** The city dao impl. */
	@Autowired
	IDesignationDao designationDaoImpl;

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.com.psi.mystay.manager.impl.BaseManagerImpl#getDao()
	 */
	@Override
	public IBaseDao<Designation> getDao() {
		return designationDaoImpl;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * in.com.psi.dashboard.manager.IDesignationManager#listByName(java.lang
	 * .String)
	 */
	@Override
	public List<Designation> listByName(String designationName) {
		return designationDaoImpl.listByName(designationName);
	}

}
