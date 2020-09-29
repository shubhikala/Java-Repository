package in.com.psi.dashboard.manager.impl;

import in.com.psi.dashboard.dao.IBaseDao;
import in.com.psi.dashboard.dao.IStateDao;
import in.com.psi.dashboard.entity.Country;
import in.com.psi.dashboard.entity.State;
import in.com.psi.dashboard.entity.VO.StateVO;
import in.com.psi.dashboard.manager.IStateManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// TODO: Auto-generated Javadoc
/**
 * The Class StateManagerImpl.
 */
@Service
@Transactional
public class StateManagerImpl extends BaseManagerImpl<State, IBaseDao<State>>
		implements IStateManager {

	/** The city dao impl. */
	@Autowired
	IStateDao stateDaoImpl;

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.com.psi.mystay.manager.impl.BaseManagerImpl#getDao()
	 */
	@Override
	public IBaseDao<State> getDao() {
		return stateDaoImpl;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * in.com.psi.dashboard.manager.IStateManager#listByName(in.com.psi.dashboard
	 * .entity.VO.StateVO, in.com.psi.dashboard.entity.Country)
	 */
	@Override
	public List<State> listByName(StateVO stateVO, Country country) {
		return stateDaoImpl.listByName(stateVO, country);
	}

}
