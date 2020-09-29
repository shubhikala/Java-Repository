package in.com.psi.dashboard.dao.impl;

import in.com.psi.dashboard.dao.IStateDao;
import in.com.psi.dashboard.entity.Country;
import in.com.psi.dashboard.entity.State;
import in.com.psi.dashboard.entity.VO.StateVO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// TODO: Auto-generated Javadoc
/**
 * The Class StateDaoImpl.
 */
@Repository
public class StateDaoImpl extends BaseDaoImpl<State> implements IStateDao {

	/** The session factory. */
	@Autowired
	SessionFactory sessionFactory;

	/**
	 * Instantiates a new city dao impl.
	 */
	public StateDaoImpl() {
		super(State.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * in.com.psi.dashboard.dao.IStateDao#listByName(in.com.psi.dashboard.entity
	 * .VO.StateVO, in.com.psi.dashboard.entity.Country)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<State> listByName(StateVO stateVO, Country country) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(State.class);
		if (country != null) {
			criteria.add(Restrictions.eq("country", country));
		}
		criteria.add(Restrictions.ilike("name", stateVO.getName() + "%"));
		criteria.setMaxResults(5);
		return criteria.list();
	}

}
