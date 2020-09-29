package in.com.psi.dashboard.dao.impl;

import in.com.psi.dashboard.dao.IBaseDao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// TODO: Auto-generated Javadoc
/**
 * The Class BaseDaoImpl.
 *
 * @param <T>
 *            the generic type
 */
@Repository
public class BaseDaoImpl<T> implements IBaseDao<T> {

	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory;

	/** The persistence class. */
	private Class<T> persistenceClass;

	/**
	 * Instantiates a new base dao impl.
	 */
	public BaseDaoImpl() {
		super();
	}

	/**
	 * Instantiates a new base dao impl.
	 *
	 * @param persistenceClass
	 *            the persistence class
	 */
	public BaseDaoImpl(Class<T> persistenceClass) {
		this.persistenceClass = persistenceClass;
	}

	/**
	 * Gets the current session.
	 *
	 * @return the current session
	 */
	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.com.crlms.dao.IBaseDao#save(java.lang.Object)
	 */
	@Override
	public void save(T obj) {
		getCurrentSession().save(obj);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.com.crlms.dao.IBaseDao#getById(java.io.Serializable)
	 */
	@Override
	public T getById(Serializable id) {
		return (T) getCurrentSession().get(persistenceClass, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.com.crlms.dao.IBaseDao#delete(java.io.Serializable)
	 */
	@Override
	public void delete(T obj) {
		getCurrentSession().delete(obj);
		getCurrentSession().flush();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.com.crlms.dao.IBaseDao#list(java.lang.String, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> list(String propertyName, String orderType) {
		Query query = getCurrentSession().createQuery(
				"from " + persistenceClass.getName() + " ORDER BY "
						+ propertyName + " " + orderType);
		return query.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.com.crlms.dao.IBaseDao#list()
	 */
	@SuppressWarnings("unchecked")
	public List<T> list() {
		Query query = getCurrentSession().createQuery(
				"from " + persistenceClass.getName());
		return query.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.com.crlms.dao.IBaseDao#saveOrUpdate(java.lang.Object)
	 */
	@Override
	public void saveOrUpdate(T obj) {
		getCurrentSession().saveOrUpdate(obj);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.com.psi.dashboard.dao.IBaseDao#update(java.lang.Object)
	 */
	@Override
	public void update(T obj) {

		getCurrentSession().update(obj);
	}

}
