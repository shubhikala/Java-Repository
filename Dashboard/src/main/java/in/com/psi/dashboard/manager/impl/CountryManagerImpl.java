package in.com.psi.dashboard.manager.impl;

import java.util.List;

import in.com.psi.dashboard.dao.IBaseDao;
import in.com.psi.dashboard.dao.ICountryDao;
import in.com.psi.dashboard.entity.Country;
import in.com.psi.dashboard.manager.ICountryManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// TODO: Auto-generated Javadoc
/**
 * The Class CountryManagerImpl.
 */
@Service
@Transactional
public class CountryManagerImpl extends
		BaseManagerImpl<Country, IBaseDao<Country>> implements ICountryManager {

	/** The city dao impl. */
	@Autowired
	ICountryDao countryDaoImpl;

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.com.psi.mystay.manager.impl.BaseManagerImpl#getDao()
	 */
	@Override
	public IBaseDao<Country> getDao() {
		return countryDaoImpl;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * in.com.psi.dashboard.manager.ICountryManager#listByName(java.lang.String)
	 */
	@Override
	public List<Country> listByName(String name) {
		return countryDaoImpl.listByName(name);
	}

}
