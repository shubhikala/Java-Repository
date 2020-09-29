package in.com.psi.dashboard.dao.impl;

import in.com.psi.dashboard.dao.IWorkExperienceDao;
import in.com.psi.dashboard.entity.Employee;
import in.com.psi.dashboard.entity.WorkExperience;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// TODO: Auto-generated Javadoc
/**
 * The Class WorkExperienceDaoImpl.
 */
@Repository
public class WorkExperienceDaoImpl extends BaseDaoImpl<WorkExperience>
		implements IWorkExperienceDao {

	/** The session factory. */
	@Autowired
	SessionFactory sessionFactory;

	/**
	 * Instantiates a new city dao impl.
	 */
	public WorkExperienceDaoImpl() {
		super(WorkExperience.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * in.com.psi.dashboard.dao.IWorkExperienceDao#viewUser(in.com.psi.dashboard
	 * .entity.Employee)
	 */
	@Override
	public WorkExperience viewUser(Employee employee) {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(WorkExperience.class);
		criteria.add(Restrictions.eq("employee", employee));
		return (WorkExperience) criteria.uniqueResult();
	}
}
