package in.com.psi.dashboard.dao;

import in.com.psi.dashboard.entity.Employee;
import in.com.psi.dashboard.entity.ProfessionalDetails;

// TODO: Auto-generated Javadoc
/**
 * The Interface IProfessionalDetailsDao.
 */
public interface IProfessionalDetailsDao extends IBaseDao<ProfessionalDetails>{

	/**
	 * View user.
	 *
	 * @param employee the employee
	 * @return the professional details
	 */
	ProfessionalDetails viewUser(Employee employee);

}
