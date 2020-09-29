package in.com.psi.dashboard.dao.impl;

import in.com.psi.dashboard.dao.IUserDao;
import in.com.psi.dashboard.entity.Department;
import in.com.psi.dashboard.entity.Designation;
import in.com.psi.dashboard.entity.Employee;
import in.com.psi.dashboard.entity.EmployeeDocuments;
import in.com.psi.dashboard.entity.EmployeePermission;
import in.com.psi.dashboard.entity.EmployeeType;
import in.com.psi.dashboard.entity.ProfessionalDetails;
import in.com.psi.dashboard.entity.WorkExperience;
import in.com.psi.dashboard.entity.VO.EmployeeVO;
import in.com.psi.dashboard.entity.VO.SearchFilterVO;
import in.com.psi.dashboard.exception.DashboardException;
import in.com.psi.dashboard.util.DashboardConstants;

import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.ldap.InitialLdapContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// TODO: Auto-generated Javadoc
/**
 * The Class UserDaoImpl.
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<Employee> implements IUserDao {

	/** The logger. */
	private final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

	/** The session factory. */
	@Autowired
	SessionFactory sessionFactory;

	/**
	 * Instantiates a new city dao impl.
	 */
	public UserDaoImpl() {
		super(Employee.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.com.psi.dashboard.dao.IUserDao#login(java.lang.String,
	 * java.lang.String)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public boolean login(String userName, String password)
			throws DashboardException {
		boolean result = false;
		Hashtable properties = new Hashtable();
		properties.put(Context.SECURITY_PRINCIPAL, userName
				+ DashboardConstants.DOMAIN_NAME);
		properties.put(Context.SECURITY_CREDENTIALS, password);
		properties.put(Context.INITIAL_CONTEXT_FACTORY,
				DashboardConstants.LDAP_CTX);
		properties.put(Context.PROVIDER_URL, DashboardConstants.LDAP_URL);
		try {
			new InitialLdapContext(properties, null);
			result = true;
		} catch (javax.naming.CommunicationException e) {
			throw new DashboardException(logger, "login",
					DashboardConstants.PROBLEM_CONNECTING_DIRECTORY, null);
		} catch (NamingException e) {
			throw new DashboardException(logger, "login",
					DashboardConstants.USER_NOT_EXISTS, null);
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * in.com.psi.dashboard.dao.IUserDao#populatePermissions(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeePermission> populatePermissions(String userName) {
		Session session = sessionFactory.getCurrentSession();
		Criteria employeeCriteria = session.createCriteria(Employee.class);
		employeeCriteria.add(Restrictions.eq("username", userName));
		Employee employee = (Employee) employeeCriteria.uniqueResult();
		Criteria permissionCriteria = session
				.createCriteria(EmployeePermission.class);
		permissionCriteria.add(Restrictions.eq("employee", employee));
		return permissionCriteria.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.com.psi.dashboard.dao.IUserDao#viewUser(java.lang.String)
	 */
	@Override
	public Employee viewUser(String userName) {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("username", userName));
		return (Employee) criteria.uniqueResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.com.psi.dashboard.dao.IUserDao#listProposedEmployeeCode()
	 */
	@Override
	public Integer listProposedEmployeeCode() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Employee.class);
		return (Integer) criteria.setProjection(Projections.max("empCode"))
				.uniqueResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.com.psi.dashboard.dao.IUserDao#listByName(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> listByName(String name) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.ilike("firstname", name + "%"));
		criteria.setMaxResults(5);
		return criteria.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.com.psi.dashboard.dao.IUserDao#checkPermission(java.lang.String,
	 * in.com.psi.dashboard.entity.VO.EmployeeVO)
	 */
	@Override
	public boolean checkPermission(String updaterUsername, EmployeeVO employeeVO) {
		boolean result = false;
		Session session = sessionFactory.getCurrentSession();
		Criteria updaterCriteria = session.createCriteria(Employee.class);
		updaterCriteria.add(Restrictions.eq("username", updaterUsername));
		Employee updaterRecord = (Employee) updaterCriteria.uniqueResult();
		Criteria updateeCriteria = session.createCriteria(Employee.class);
		updateeCriteria.add(Restrictions.eq("id", employeeVO.getId()));
		Employee updateeRecord = (Employee) updateeCriteria.uniqueResult();
		if (updateeRecord != null
				&& (updateeRecord.getManagerId() == updaterRecord.getId()
						|| updateeRecord.getId() == updaterRecord.getId() || updaterRecord
						.getRole().getRole().equals(DashboardConstants.HR))) {
			result = true;
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * in.com.psi.dashboard.dao.IUserDao#getSavedEmployeePermission(in.com.psi
	 * .dashboard.entity.Employee)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeePermission> getSavedEmployeePermission(Employee employee) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(EmployeePermission.class);
		criteria.add(Restrictions.eq("employee", employee));
		return (List<EmployeePermission>) criteria.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * in.com.psi.dashboard.dao.IUserDao#getSavedEmployeeDocuments(in.com.psi
	 * .dashboard.entity.Employee)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeDocuments> getSavedEmployeeDocuments(Employee employee) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(EmployeeDocuments.class);
		criteria.add(Restrictions.eq("employee", employee));
		return criteria.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * in.com.psi.dashboard.dao.IUserDao#getSavedProfessionalDetails(in.com.
	 * psi.dashboard.entity.Employee)
	 */
	@Override
	public ProfessionalDetails getSavedProfessionalDetails(Employee employee) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(ProfessionalDetails.class);
		criteria.add(Restrictions.eq("employee", employee));
		return (ProfessionalDetails) criteria.uniqueResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * in.com.psi.dashboard.dao.IUserDao#getSavedWorkExperience(in.com.psi.dashboard
	 * .entity.Employee)
	 */
	@Override
	public WorkExperience getSavedWorkExperience(Employee employee) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(WorkExperience.class);
		criteria.add(Restrictions.eq("employee", employee));
		return (WorkExperience) criteria.uniqueResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * in.com.psi.dashboard.dao.IUserDao#searchUser(in.com.psi.dashboard.entity
	 * .VO.SearchFilterVO)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> searchUser(SearchFilterVO searchFilterVO,
			Department department, Designation designation, EmployeeType employeeType) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Employee.class);
		if (searchFilterVO.getEmpCode() != null) {
			criteria.add(Restrictions.eq("empCode", searchFilterVO.getEmpCode()));
		}
		if (searchFilterVO.getName() != null) {
			Disjunction disjunction = Restrictions.disjunction();
			disjunction.add(Restrictions.ilike("firstname",
					searchFilterVO.getName() + "%"));
			disjunction.add(Restrictions.ilike("middlename",
					"%" + searchFilterVO.getName() + "%"));
			disjunction.add(Restrictions.ilike("lastname",
					"%" + searchFilterVO.getName()));
			criteria.add(disjunction);
		}
		if (searchFilterVO.getWorkEmail() != null) {
			criteria.add(Restrictions.ilike("workEmail",
					searchFilterVO.getWorkEmail() + "%"));
		}
		if (searchFilterVO.getDepartmentId() != null) {
			criteria.add(Restrictions.eq("department", department));
		}
		if (searchFilterVO.getDesignationId() != null) {
			criteria.add(Restrictions.eq("designation", designation));
		}
		if(searchFilterVO.getEmployeeTypeId() != null){
			criteria.add(Restrictions.eq("employeeType", employeeType));
		}
		if(searchFilterVO.getDateOfJoining() != null){
			criteria.add(Restrictions.eq("dateOfJoining", searchFilterVO.getDateOfJoining()));
		}
		if(searchFilterVO.getDateOfRelease() != null){
			criteria.add(Restrictions.eq("dateOfRelease", searchFilterVO.getDateOfRelease()));
		}
		if(searchFilterVO.getManagerId() != null){
			criteria.add(Restrictions.eq("managerId", searchFilterVO.getManagerId()));
		}
		if(searchFilterVO.getPageOffset() != null){
		criteria.setFirstResult((searchFilterVO.getPageOffset() - 1)
				* DashboardConstants.PAGE_SIZE);
		criteria.setMaxResults(DashboardConstants.PAGE_SIZE);
		}
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> listSubordinates(String managerUserName) {
		Session session = sessionFactory.getCurrentSession();
		Criteria managerCriteria = session.createCriteria(Employee.class);
		managerCriteria.add(Restrictions.eq("username", managerUserName));
		Employee manager = (Employee) managerCriteria.uniqueResult();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("managerId", manager.getId()));
		return criteria.list();
	}

}
