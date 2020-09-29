package in.com.psi.dashboard.dao;

import java.util.List;

import in.com.psi.dashboard.entity.Designation;

// TODO: Auto-generated Javadoc
/**
 * The Interface IDesignationDao.
 */
public interface IDesignationDao extends IBaseDao<Designation> {

	/**
	 * List by name.
	 *
	 * @param designationName the designation name
	 * @return the list
	 */
	List<Designation> listByName(String designationName);

}
