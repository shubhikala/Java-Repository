package in.com.psi.dashboard.manager;

import java.io.Serializable;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface IBaseManager.
 *
 * @param <T> the generic type
 */
public interface IBaseManager<T> {

	/**
	 * Save.
	 *
	 * @param obj
	 *            the obj
	 */
	public void save(T obj);

	/**
	 * Save or update.
	 *
	 * @param obj
	 *            the obj
	 */
	public void saveOrUpdate(T obj);

	/**
	 * Gets the by id.
	 *
	 * @param id
	 *            the id
	 * @return the by id
	 */
	public T getById(Serializable id);

	/**
	 * Delete.
	 *
	 * @param obj
	 *            the obj
	 */
	public void delete(T obj);

	/**
	 * List.
	 *
	 * @return the list
	 */
	public List<T> list();

	/**
	 * List.
	 *
	 * @param propertyName
	 *            the property name
	 * @param orderType
	 *            the order type
	 * @return the list
	 */
	public List<T> list(String propertyName, String orderType);

	/**
	 * Update.
	 *
	 * @param obj the obj
	 */
	public void update(T obj);

}
