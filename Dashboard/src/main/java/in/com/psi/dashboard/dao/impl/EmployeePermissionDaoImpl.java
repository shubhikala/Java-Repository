package in.com.psi.dashboard.dao.impl;

import in.com.psi.dashboard.dao.IEmployeePermissionDao;
import in.com.psi.dashboard.entity.EmployeePermission;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// TODO: Auto-generated Javadoc
/**
 * The Class EmployeePermissionDaoImpl.
 */
@Repository
public class EmployeePermissionDaoImpl extends BaseDaoImpl<EmployeePermission>
		implements IEmployeePermissionDao {

	/** The session factory. */
	@Autowired
	SessionFactory sessionFactory;

	/**
	 * Instantiates a new city dao impl.
	 */
	public EmployeePermissionDaoImpl() {
		super(EmployeePermission.class);
	}

}
