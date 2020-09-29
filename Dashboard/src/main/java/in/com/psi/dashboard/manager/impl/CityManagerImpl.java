package in.com.psi.dashboard.manager.impl;

import in.com.psi.dashboard.dao.IBaseDao;
import in.com.psi.dashboard.dao.ICityDao;
import in.com.psi.dashboard.entity.City;
import in.com.psi.dashboard.entity.State;
import in.com.psi.dashboard.manager.ICityManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// TODO: Auto-generated Javadoc
/**
 * The Class CityManagerImpl.
 */
@Service
@Transactional
public class CityManagerImpl extends BaseManagerImpl<City, IBaseDao<City>>
		implements ICityManager {

	/** The city dao impl. */
	@Autowired
	ICityDao cityDaoImpl;

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.com.psi.mystay.manager.impl.BaseManagerImpl#getDao()
	 */
	@Override
	public IBaseDao<City> getDao() {
		return cityDaoImpl;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * in.com.psi.dashboard.manager.ICityManager#listByName(java.lang.String,
	 * in.com.psi.dashboard.entity.State)
	 */
	@Override
	public List<City> listByName(String name, State state) {
		return cityDaoImpl.listByName(name, state);
	}

}
