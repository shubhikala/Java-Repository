package in.com.psi.dashboard.dao.impl;

import in.com.psi.dashboard.dao.IEmployeeDocumentsDao;
import in.com.psi.dashboard.entity.Employee;
import in.com.psi.dashboard.entity.EmployeeDocuments;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// TODO: Auto-generated Javadoc
/**
 * The Class EmployeeDocumentsDaoImpl.
 */
@Repository
public class EmployeeDocumentsDaoImpl extends BaseDaoImpl<EmployeeDocuments>
		implements IEmployeeDocumentsDao {

	/** The session factory. */
	@Autowired
	SessionFactory sessionFactory;

	/**
	 * Instantiates a new city dao impl.
	 */
	public EmployeeDocumentsDaoImpl() {
		super(EmployeeDocuments.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * in.com.psi.dashboard.dao.IEmployeeDocumentsDao#viewUser(in.com.psi.dashboard
	 * .entity.Employee)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeDocuments> viewUser(Employee employee) {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(EmployeeDocuments.class);
		criteria.add(Restrictions.eq("employee", employee));
		return criteria.list();
	}
}
