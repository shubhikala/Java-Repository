package in.com.psi.dashboard.entity.VO;

import java.util.List;

import in.com.psi.dashboard.entity.Employee;
import in.com.psi.dashboard.entity.EmployeeDocuments;
import in.com.psi.dashboard.entity.ProfessionalDetails;
import in.com.psi.dashboard.entity.WorkExperience;

// TODO: Auto-generated Javadoc
/**
 * The Class ViewUserVO.
 */
public class ViewUserVO {
	
	/** The employee. */
	private Employee employee;
	
	/** The employee documents. */
	private List<EmployeeDocuments> employeeDocuments;
	
	/** The work experience. */
	private WorkExperience workExperience;
	
	/** The professional details. */
	private ProfessionalDetails professionalDetails;
	
	/**
	 * Gets the employee.
	 *
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}
	
	/**
	 * Sets the employee.
	 *
	 * @param employee the new employee
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	/**
	 * Gets the employee documents.
	 *
	 * @return the employee documents
	 */
	public List<EmployeeDocuments> getEmployeeDocuments() {
		return employeeDocuments;
	}
	
	/**
	 * Sets the employee documents.
	 *
	 * @param employeeDocuments the new employee documents
	 */
	public void setEmployeeDocuments(List<EmployeeDocuments> employeeDocuments) {
		this.employeeDocuments = employeeDocuments;
	}
	
	/**
	 * Gets the work experience.
	 *
	 * @return the work experience
	 */
	public WorkExperience getWorkExperience() {
		return workExperience;
	}
	
	/**
	 * Sets the work experience.
	 *
	 * @param workExperience the new work experience
	 */
	public void setWorkExperience(WorkExperience workExperience) {
		this.workExperience = workExperience;
	}
	
	/**
	 * Gets the professional details.
	 *
	 * @return the professional details
	 */
	public ProfessionalDetails getProfessionalDetails() {
		return professionalDetails;
	}
	
	/**
	 * Sets the professional details.
	 *
	 * @param professionalDetails the new professional details
	 */
	public void setProfessionalDetails(ProfessionalDetails professionalDetails) {
		this.professionalDetails = professionalDetails;
	}
	
	

}
