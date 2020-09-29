package in.com.psi.dashboard.dao.impl;

import in.com.psi.dashboard.dao.IProfessionalDetailsDao;
import in.com.psi.dashboard.entity.Employee;
import in.com.psi.dashboard.entity.ProfessionalDetails;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// TODO: Auto-generated Javadoc
/**
 * The Class ProfessionalDetailsDaoImpl.
 */
@Repository
public class ProfessionalDetailsDaoImpl extends
		BaseDaoImpl<ProfessionalDetails> implements IProfessionalDetailsDao {

	/** The session factory. */
	@Autowired
	SessionFactory sessionFactory;

	/**
	 * Instantiates a new city dao impl.
	 */
	public ProfessionalDetailsDaoImpl() {
		super(ProfessionalDetails.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * in.com.psi.dashboard.dao.IProfessionalDetailsDao#viewUser(in.com.psi.
	 * dashboard.entity.Employee)
	 */
	@Override
	public ProfessionalDetails viewUser(Employee employee) {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(ProfessionalDetails.class);
		criteria.add(Restrictions.eq("employee", employee));
		return (ProfessionalDetails) criteria.uniqueResult();
	}
}
