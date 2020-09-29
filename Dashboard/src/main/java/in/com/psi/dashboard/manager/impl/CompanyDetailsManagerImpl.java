package in.com.psi.dashboard.manager.impl;

import in.com.psi.dashboard.dao.IBaseDao;
import in.com.psi.dashboard.dao.ICompanyDetailsDao;
import in.com.psi.dashboard.entity.CompanyDetails;
import in.com.psi.dashboard.manager.ICompanyDetailsManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// TODO: Auto-generated Javadoc
/**
 * The Class CompanyDetailsManagerImpl.
 */
@Service
@Transactional
public class CompanyDetailsManagerImpl extends
		BaseManagerImpl<CompanyDetails, IBaseDao<CompanyDetails>> implements
		ICompanyDetailsManager {

	/** The city dao impl. */
	@Autowired
	ICompanyDetailsDao companyDetailsDaoImpl;

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.com.psi.mystay.manager.impl.BaseManagerImpl#getDao()
	 */
	@Override
	public IBaseDao<CompanyDetails> getDao() {
		return companyDetailsDaoImpl;
	}

}
