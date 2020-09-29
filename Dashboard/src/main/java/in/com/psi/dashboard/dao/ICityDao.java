package in.com.psi.dashboard.dao;

import java.util.List;

import in.com.psi.dashboard.entity.City;
import in.com.psi.dashboard.entity.State;

// TODO: Auto-generated Javadoc
/**
 * The Interface ICityDao.
 */
public interface ICityDao extends IBaseDao<City>{

	/**
	 * List by name.
	 *
	 * @param name the name
	 * @param state the state
	 * @return the list
	 */
	List<City> listByName(String name, State state);

}
