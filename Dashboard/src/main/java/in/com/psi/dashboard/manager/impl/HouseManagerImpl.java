package in.com.psi.dashboard.manager.impl;

import in.com.psi.dashboard.dao.IBaseDao;
import in.com.psi.dashboard.dao.IHouseDao;
import in.com.psi.dashboard.entity.House;
import in.com.psi.dashboard.manager.IHouseManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// TODO: Auto-generated Javadoc
/**
 * The Class HouseManagerImpl.
 */
@Service
@Transactional
public class HouseManagerImpl extends BaseManagerImpl<House, IBaseDao<House>>
		implements IHouseManager {

	/** The city dao impl. */
	@Autowired
	IHouseDao houseDaoImpl;

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.com.psi.mystay.manager.impl.BaseManagerImpl#getDao()
	 */
	@Override
	public IBaseDao<House> getDao() {
		return houseDaoImpl;
	}

}
