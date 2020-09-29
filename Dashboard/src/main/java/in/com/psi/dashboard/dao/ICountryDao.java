package in.com.psi.dashboard.dao;

import java.util.List;

import in.com.psi.dashboard.entity.Country;

// TODO: Auto-generated Javadoc
/**
 * The Interface ICountryDao.
 */
public interface ICountryDao extends IBaseDao<Country> {

	/**
	 * List by name.
	 *
	 * @param name the name
	 * @return the list
	 */
	List<Country> listByName(String name);

}
