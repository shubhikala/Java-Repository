package in.com.psi.dashboard.dao;

import in.com.psi.dashboard.entity.Employee;
import in.com.psi.dashboard.entity.EmployeeDocuments;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface IEmployeeDocumentsDao.
 */
public interface IEmployeeDocumentsDao extends IBaseDao<EmployeeDocuments>{

	/**
	 * View user.
	 *
	 * @param employee the employee
	 * @return the list
	 */
	List<EmployeeDocuments> viewUser(Employee employee);

}
