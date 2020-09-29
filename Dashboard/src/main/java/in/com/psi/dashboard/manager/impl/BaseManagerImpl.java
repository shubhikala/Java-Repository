package in.com.psi.dashboard.manager.impl;

import in.com.psi.dashboard.dao.IBaseDao;
import in.com.psi.dashboard.manager.IBaseManager;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// TODO: Auto-generated Javadoc
/**
 * The Class BaseManagerImpl.
 *
 * @param <T>
 *            the generic type
 * @param <DAO>
 *            the generic type
 */
@Service
@Transactional
public abstract class BaseManagerImpl<T, DAO extends IBaseDao<T>> implements
		IBaseManager<T> {

	/**
	 * Gets the dao.
	 *
	 * @return the dao
	 */
	public abstract DAO getDao();

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.com.crlms.manager.IBaseManager#save(java.lang.Object)
	 */
	@Override
	public void save(T obj) {
		getDao().save(obj);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.com.crlms.manager.IBaseManager#saveOrUpdate(java.lang.Object)
	 */
	@Override
	public void saveOrUpdate(T obj) {
		getDao().saveOrUpdate(obj);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.com.psi.dashboard.manager.IBaseManager#update(java.lang.Object)
	 */
	@Override
	public void update(T obj) {
		getDao().update(obj);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.com.crlms.manager.IBaseManager#getById(java.io.Serializable)
	 */
	@Override
	public T getById(Serializable id) {
		return getDao().getById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.com.crlms.manager.IBaseManager#delete(java.io.Serializable)
	 */
	@Override
	public void delete(T obj) {
		getDao().delete(obj);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.com.crlms.manager.IBaseManager#list(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public List<T> list(String propertyName, String orderType) {
		return getDao().list(propertyName, orderType);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.com.crlms.manager.IBaseManager#list()
	 */
	@Override
	public List<T> list() {
		return getDao().list();
	}

}
