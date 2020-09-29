package in.com.psi.dashboard.dao.impl;

import in.com.psi.dashboard.dao.IOtherUserDao;
import in.com.psi.dashboard.entity.Employee;
import in.com.psi.dashboard.entity.OtherUser;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

// TODO: Auto-generated Javadoc
/**
 * The Class OtherUserDaoImpl.
 */
@Repository
public class OtherUserDaoImpl extends BaseDaoImpl<OtherUser> implements
		IOtherUserDao {

	/** The session factory. */
	@Autowired
	SessionFactory sessionFactory;

	/**
	 * Instantiates a new city dao impl.
	 */
	public OtherUserDaoImpl() {
		super(OtherUser.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.com.psi.dashboard.dao.IOtherUserDao#login(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional
	public boolean login(String hostUsername, String hostPassword,
			String remoteAddress, String userName) {
		boolean result = false;
		Session session = sessionFactory.getCurrentSession();
		Criteria otherUserCriteria = session.createCriteria(OtherUser.class);
		otherUserCriteria.add(Restrictions.eq("hostUsername", hostUsername));
		otherUserCriteria.add(Restrictions.eq("hostPassword", hostPassword));
		otherUserCriteria.add(Restrictions.eq("hostIp", remoteAddress));
		otherUserCriteria.add(Restrictions.eq("status", Boolean.TRUE));
		OtherUser otherUser = (OtherUser) otherUserCriteria.uniqueResult();
		Criteria employeeCriteria = session.createCriteria(Employee.class);
		employeeCriteria.add(Restrictions.eq("username", userName));
		Employee employee = (Employee) employeeCriteria.uniqueResult();
		if (otherUser != null && employee != null) {
			result = true;
		}
		return result;
	}
}
