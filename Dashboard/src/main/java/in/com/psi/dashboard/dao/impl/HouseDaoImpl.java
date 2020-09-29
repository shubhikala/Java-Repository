package in.com.psi.dashboard.dao.impl;

import in.com.psi.dashboard.dao.IHouseDao;
import in.com.psi.dashboard.entity.House;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// TODO: Auto-generated Javadoc
/**
 * The Class HouseDaoImpl.
 */
@Repository
public class HouseDaoImpl extends BaseDaoImpl<House> implements IHouseDao {

	/** The session factory. */
	@Autowired
	SessionFactory sessionFactory;

	/**
	 * Instantiates a new city dao impl.
	 */
	public HouseDaoImpl() {
		super(House.class);
	}

}
