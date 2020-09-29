package in.com.psi.dashboard.manager;

import java.util.List;

import in.com.psi.dashboard.entity.Designation;

// TODO: Auto-generated Javadoc
/**
 * The Interface IDesignationManager.
 */
public interface IDesignationManager extends IBaseManager<Designation> {

	/**
	 * List by name.
	 *
	 * @param designationName the designation name
	 * @return the list
	 */
	List<Designation> listByName(String designationName);

}
