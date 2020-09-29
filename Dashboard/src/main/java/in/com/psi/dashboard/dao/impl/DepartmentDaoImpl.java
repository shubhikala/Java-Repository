package in.com.psi.dashboard.dao.impl;

import in.com.psi.dashboard.dao.IDepartmentDao;
import in.com.psi.dashboard.entity.Department;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// TODO: Auto-generated Javadoc
/**
 * The Class DepartmentDaoImpl.
 */
@Repository
public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements
		IDepartmentDao {

	/** The session factory. */
	@Autowired
	SessionFactory sessionFactory;

	/**
	 * Instantiates a new city dao impl.
	 */
	public DepartmentDaoImpl() {
		super(Department.class);
	}

}
