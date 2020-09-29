package in.com.psi.dashboard.dao.impl;

import in.com.psi.dashboard.dao.ICountryDao;
import in.com.psi.dashboard.entity.Country;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// TODO: Auto-generated Javadoc
/**
 * The Class CountryDaoImpl.
 */
@Repository
public class CountryDaoImpl extends BaseDaoImpl<Country> implements ICountryDao {

	/** The session factory. */
	@Autowired
	SessionFactory sessionFactory;

	/**
	 * Instantiates a new city dao impl.
	 */
	public CountryDaoImpl() {
		super(Country.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.com.psi.dashboard.dao.ICountryDao#listByName(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Country> listByName(String name) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Country.class);
		criteria.add(Restrictions.ilike("name", name + "%"));
		criteria.setMaxResults(5);
		return criteria.list();
	}

}
