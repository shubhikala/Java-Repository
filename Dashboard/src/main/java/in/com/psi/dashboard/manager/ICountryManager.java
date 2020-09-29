package in.com.psi.dashboard.manager;

import java.util.List;

import in.com.psi.dashboard.entity.Country;

// TODO: Auto-generated Javadoc
/**
 * The Interface ICountryManager.
 */
public interface ICountryManager extends IBaseManager<Country>{

	/**
	 * List by name.
	 *
	 * @param name the name
	 * @return the list
	 */
	List<Country> listByName(String name);

}
