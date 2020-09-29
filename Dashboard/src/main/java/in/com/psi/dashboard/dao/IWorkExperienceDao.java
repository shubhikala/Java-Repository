package in.com.psi.dashboard.dao;

import in.com.psi.dashboard.entity.Employee;
import in.com.psi.dashboard.entity.WorkExperience;

// TODO: Auto-generated Javadoc
/**
 * The Interface IWorkExperienceDao.
 */
public interface IWorkExperienceDao extends IBaseDao<WorkExperience>{

	/**
	 * View user.
	 *
	 * @param employee the employee
	 * @return the work experience
	 */
	WorkExperience viewUser(Employee employee);

}
