package in.com.psi.dashboard.manager.impl;

import in.com.psi.dashboard.dao.IBaseDao;
import in.com.psi.dashboard.dao.IProfessionalDetailsDao;
import in.com.psi.dashboard.entity.ProfessionalDetails;
import in.com.psi.dashboard.manager.IProfessionalDetailsManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// TODO: Auto-generated Javadoc
/**
 * The Class ProfessionalDetailsManagerImpl.
 */
@Service
@Transactional
public class ProfessionalDetailsManagerImpl extends
		BaseManagerImpl<ProfessionalDetails, IBaseDao<ProfessionalDetails>>
		implements IProfessionalDetailsManager {

	/** The city dao impl. */
	@Autowired
	IProfessionalDetailsDao professionalDetailsDaoImpl;

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.com.psi.mystay.manager.impl.BaseManagerImpl#getDao()
	 */
	@Override
	public IBaseDao<ProfessionalDetails> getDao() {
		return professionalDetailsDaoImpl;
	}

}
