package in.com.psi.dashboard.dao.impl;

import in.com.psi.dashboard.dao.IPermissionDao;
import in.com.psi.dashboard.entity.Permission;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// TODO: Auto-generated Javadoc
/**
 * The Class PermissionDaoImpl.
 */
@Repository
public class PermissionDaoImpl extends BaseDaoImpl<Permission> implements
		IPermissionDao {

	/** The session factory. */
	@Autowired
	SessionFactory sessionFactory;

	/**
	 * Instantiates a new city dao impl.
	 */
	public PermissionDaoImpl() {
		super(Permission.class);
	}

}
