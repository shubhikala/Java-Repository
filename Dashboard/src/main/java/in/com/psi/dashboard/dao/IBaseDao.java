package in.com.psi.dashboard.dao;

import java.io.Serializable;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface IBaseDao.
 *
 * @param <T> the generic type
 */
public interface IBaseDao<T> {

	/**
	 * Save.
	 *
	 * @param obj the obj
	 */
	public void save(T obj);

	/**
	 * Save or update.
	 *
	 * @param obj the obj
	 */
	public void saveOrUpdate(T obj);
	
	/**
	 * Update.
	 *
	 * @param obj the obj
	 */
	public void update(T obj);

	/**
	 * Method to get a record by its id.
	 *
	 * @param id the id of the record to fetch
	 * @return the by id
	 */
	public T getById(Serializable id);

	/**
	 * Method to delete a record.
	 *
	 * @param obj the object
	 */
	public void delete(T obj);

	/**
	 * Method to get all records of a persistence class.
	 *
	 * @param propertyName the property name
	 * @param orderType the order type
	 * @return List of all records of a persistence class.
	 */


	List<T> list(String propertyName, String orderType);

	/**
	 * List.
	 *
	 * @return the list
	 */
	List<T> list();

}