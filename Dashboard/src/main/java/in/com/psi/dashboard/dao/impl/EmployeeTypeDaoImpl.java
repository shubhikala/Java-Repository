package in.com.psi.dashboard.dao.impl;

import in.com.psi.dashboard.dao.IEmployeeTypeDao;
import in.com.psi.dashboard.entity.EmployeeType;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// TODO: Auto-generated Javadoc
/**
 * The Class EmployeeTypeDaoImpl.
 */
@Repository
public class EmployeeTypeDaoImpl extends BaseDaoImpl<EmployeeType> implements
		IEmployeeTypeDao {

	/** The session factory. */
	@Autowired
	SessionFactory sessionFactory;

	/**
	 * Instantiates a new city dao impl.
	 */
	public EmployeeTypeDaoImpl() {
		super(EmployeeType.class);
	}

}
