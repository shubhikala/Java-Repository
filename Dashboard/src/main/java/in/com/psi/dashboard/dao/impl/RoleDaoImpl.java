package in.com.psi.dashboard.dao.impl;

import in.com.psi.dashboard.dao.IRoleDao;
import in.com.psi.dashboard.entity.Role;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// TODO: Auto-generated Javadoc
/**
 * The Class RoleDaoImpl.
 */
@Repository
public class RoleDaoImpl extends BaseDaoImpl<Role> implements IRoleDao {

	/** The session factory. */
	@Autowired
	SessionFactory sessionFactory;

	/**
	 * Instantiates a new city dao impl.
	 */
	public RoleDaoImpl() {
		super(Role.class);
	}

}
