package in.com.psi.dashboard.manager.impl;

import in.com.psi.dashboard.dao.IBaseDao;
import in.com.psi.dashboard.dao.IWorkExperienceDao;
import in.com.psi.dashboard.entity.WorkExperience;
import in.com.psi.dashboard.manager.IWorkExperienceManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// TODO: Auto-generated Javadoc
/**
 * The Class WorkExperienceManagerImpl.
 */
@Service
@Transactional
public class WorkExperienceManagerImpl extends
		BaseManagerImpl<WorkExperience, IBaseDao<WorkExperience>> implements
		IWorkExperienceManager {

	/** The city dao impl. */
	@Autowired
	IWorkExperienceDao workExperienceDaoImpl;

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.com.psi.mystay.manager.impl.BaseManagerImpl#getDao()
	 */
	@Override
	public IBaseDao<WorkExperience> getDao() {
		return workExperienceDaoImpl;
	}

}
