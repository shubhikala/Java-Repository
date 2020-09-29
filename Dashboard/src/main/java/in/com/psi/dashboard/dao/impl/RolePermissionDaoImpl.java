package in.com.psi.dashboard.dao.impl;

import in.com.psi.dashboard.dao.IRolePermissionDao;
import in.com.psi.dashboard.entity.RolePermission;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// TODO: Auto-generated Javadoc
/**
 * The Class RolePermissionDaoImpl.
 */
@Repository
public class RolePermissionDaoImpl extends BaseDaoImpl<RolePermission>
		implements IRolePermissionDao {

	/** The session factory. */
	@Autowired
	SessionFactory sessionFactory;

	/**
	 * Instantiates a new city dao impl.
	 */
	public RolePermissionDaoImpl() {
		super(RolePermission.class);
	}

}
