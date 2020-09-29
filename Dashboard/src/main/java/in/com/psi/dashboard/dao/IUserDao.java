package in.com.psi.dashboard.dao;

import in.com.psi.dashboard.entity.Department;
import in.com.psi.dashboard.entity.Designation;
import in.com.psi.dashboard.entity.Employee;
import in.com.psi.dashboard.entity.EmployeeDocuments;
import in.com.psi.dashboard.entity.EmployeePermission;
import in.com.psi.dashboard.entity.EmployeeType;
import in.com.psi.dashboard.entity.ProfessionalDetails;
import in.com.psi.dashboard.entity.WorkExperience;
import in.com.psi.dashboard.entity.VO.EmployeeVO;
import in.com.psi.dashboard.entity.VO.SearchFilterVO;
import in.com.psi.dashboard.exception.DashboardException;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface IUserDao.
 */
public interface IUserDao extends IBaseDao<Employee> {
	
	/**
	 * Login.
	 *
	 * @param userName the user name
	 * @param password the password
	 * @return true, if successful
	 * @throws DashboardException the dashboard exception
	 */
	boolean login(String userName, String password) throws DashboardException;

	/**
	 * Populate permissions.
	 *
	 * @param userName the user name
	 * @return the list
	 */
	List<EmployeePermission> populatePermissions(String userName);

	/**
	 * View user.
	 *
	 * @param userName the user name
	 * @return the employee
	 */
	Employee viewUser(String userName) ;

	/**
	 * List proposed employee code.
	 *
	 * @return the integer
	 */
	Integer listProposedEmployeeCode();

	/**
	 * List by name.
	 *
	 * @param name the name
	 * @return the list
	 */
	List<Employee> listByName(String name);

	/**
	 * Check permission.
	 *
	 * @param updaterUsername the updater username
	 * @param employeeVO the employee vo
	 * @return true, if successful
	 */
	boolean checkPermission(String updaterUsername, EmployeeVO employeeVO);
	
	/**
	 * Gets the saved employee permission.
	 *
	 * @param employee the employee
	 * @return the saved employee permission
	 */
	List<EmployeePermission> getSavedEmployeePermission(Employee employee);

	/**
	 * Gets the saved employee documents.
	 *
	 * @param employee the employee
	 * @return the saved employee documents
	 */
	List<EmployeeDocuments> getSavedEmployeeDocuments(Employee employee);

	/**
	 * Gets the saved professional details.
	 *
	 * @param employee the employee
	 * @return the saved professional details
	 */
	ProfessionalDetails getSavedProfessionalDetails(Employee employee);

	/**
	 * Gets the saved work experience.
	 *
	 * @param employee the employee
	 * @return the saved work experience
	 */
	WorkExperience getSavedWorkExperience(Employee employee);

	/**
	 * Search user.
	 *
	 * @param searchFilterVO the search filter vo
	 * @param designation 
	 * @param department 
	 * @param employeeType 
	 * @return the list
	 */
	List<Employee> searchUser(SearchFilterVO searchFilterVO, Department department, Designation designation, EmployeeType employeeType);

	List<Employee> listSubordinates(String managerUserName);

	
}
