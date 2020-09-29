package in.com.psi.dashboard.manager.impl;

import in.com.psi.dashboard.dao.IBaseDao;
import in.com.psi.dashboard.dao.IEmployeeDocumentsDao;
import in.com.psi.dashboard.entity.EmployeeDocuments;
import in.com.psi.dashboard.manager.IEmployeeDocumentsManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// TODO: Auto-generated Javadoc
/**
 * The Class EmployeeDocumentsManagerImpl.
 */
@Service
@Transactional
public class EmployeeDocumentsManagerImpl extends
		BaseManagerImpl<EmployeeDocuments, IBaseDao<EmployeeDocuments>>
		implements IEmployeeDocumentsManager {

	/** The city dao impl. */
	@Autowired
	IEmployeeDocumentsDao employeeDocumentsDaoImpl;

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.com.psi.mystay.manager.impl.BaseManagerImpl#getDao()
	 */
	@Override
	public IBaseDao<EmployeeDocuments> getDao() {
		return employeeDocumentsDaoImpl;
	}

}