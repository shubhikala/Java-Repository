package in.com.psi.dashboard.dao.impl;

import in.com.psi.dashboard.dao.IDesignationDao;
import in.com.psi.dashboard.entity.Designation;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// TODO: Auto-generated Javadoc
/**
 * The Class DesignationDaoImpl.
 */
@Repository
public class DesignationDaoImpl extends BaseDaoImpl<Designation> implements
		IDesignationDao {

	/** The session factory. */
	@Autowired
	SessionFactory sessionFactory;

	/**
	 * Instantiates a new city dao impl.
	 */
	public DesignationDaoImpl() {
		super(Designation.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * in.com.psi.dashboard.dao.IDesignationDao#listByName(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Designation> listByName(String designationName) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Designation.class);
		if (designationName != null) {
			criteria.add(Restrictions.ilike("name", designationName + "%"));
		}
		criteria.setMaxResults(5);
		return criteria.list();
	}
}
