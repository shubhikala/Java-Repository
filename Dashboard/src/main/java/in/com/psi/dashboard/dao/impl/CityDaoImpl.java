package in.com.psi.dashboard.dao.impl;

import in.com.psi.dashboard.dao.ICityDao;
import in.com.psi.dashboard.entity.City;
import in.com.psi.dashboard.entity.State;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// TODO: Auto-generated Javadoc
/**
 * The Class CityDaoImpl.
 */
@Repository
public class CityDaoImpl extends BaseDaoImpl<City> implements ICityDao {

	/** The session factory. */
	@Autowired
	SessionFactory sessionFactory;

	/**
	 * Instantiates a new city dao impl.
	 */
	public CityDaoImpl() {
		super(City.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.com.psi.dashboard.dao.ICityDao#listByName(java.lang.String,
	 * in.com.psi.dashboard.entity.State)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<City> listByName(String name, State state) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(City.class);
		if (state != null) {
			criteria.add(Restrictions.eq("state", state));
		}
		criteria.add(Restrictions.ilike("name", name + "%"));
		criteria.setMaxResults(5);
		return criteria.list();
	}

}
