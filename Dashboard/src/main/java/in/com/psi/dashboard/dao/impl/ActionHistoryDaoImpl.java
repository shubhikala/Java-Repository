package in.com.psi.dashboard.dao.impl;

import in.com.psi.dashboard.dao.IActionHistoryDao;
import in.com.psi.dashboard.entity.ActionHistory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// TODO: Auto-generated Javadoc
/**
 * The Class ActionHistoryDaoImpl.
 */
@Repository
public class ActionHistoryDaoImpl extends BaseDaoImpl<ActionHistory> implements
		IActionHistoryDao {

	/** The session factory. */
	@Autowired
	SessionFactory sessionFactory;

	/**
	 * Instantiates a new city dao impl.
	 */
	public ActionHistoryDaoImpl() {
		super(ActionHistory.class);
	}
}
