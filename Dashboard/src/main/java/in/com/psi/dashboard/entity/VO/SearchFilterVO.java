package in.com.psi.dashboard.entity.VO;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class SearchFilterVO.
 */
public class SearchFilterVO extends BaseVO {
	
	/** The name. */
	private String name;
	
	/** The work email. */
	private String workEmail;
	
	/** The emp code. */
	private Integer empCode;
	
	/** The department id. */
	private Integer departmentId;
	
	/** The designation id. */
	private Integer designationId;
	
	/** The page offset. */
	private Integer pageOffset;
	
	private Long managerId;
	
	private Date dateOfJoining;
	
	private Integer employeeTypeId;
	
	private Date dateOfRelease;
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the work email.
	 *
	 * @return the work email
	 */
	public String getWorkEmail() {
		return workEmail;
	}
	
	/**
	 * Sets the work email.
	 *
	 * @param workEmail the new work email
	 */
	public void setWorkEmail(String workEmail) {
		this.workEmail = workEmail;
	}
	
	/**
	 * Gets the emp code.
	 *
	 * @return the emp code
	 */
	public Integer getEmpCode() {
		return empCode;
	}
	
	/**
	 * Sets the emp code.
	 *
	 * @param empCode the new emp code
	 */
	public void setEmpCode(Integer empCode) {
		this.empCode = empCode;
	}
	
	/**
	 * Gets the department id.
	 *
	 * @return the department id
	 */
	public Integer getDepartmentId() {
		return departmentId;
	}
	
	/**
	 * Sets the department id.
	 *
	 * @param departmentId the new department id
	 */
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	
	/**
	 * Gets the designation id.
	 *
	 * @return the designation id
	 */
	public Integer getDesignationId() {
		return designationId;
	}
	
	/**
	 * Sets the designation id.
	 *
	 * @param designationId the new designation id
	 */
	public void setDesignationId(Integer designationId) {
		this.designationId = designationId;
	}
	
	/**
	 * Gets the page offset.
	 *
	 * @return the page offset
	 */
	public Integer getPageOffset() {
		return pageOffset;
	}
	
	/**
	 * Sets the page offset.
	 *
	 * @param pageOffset the new page offset
	 */
	public void setPageOffset(Integer pageOffset) {
		this.pageOffset = pageOffset;
	}

	public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public Integer getEmployeeTypeId() {
		return employeeTypeId;
	}

	public void setEmployeeTypeId(Integer employeeTypeId) {
		this.employeeTypeId = employeeTypeId;
	}

	public Date getDateOfRelease() {
		return dateOfRelease;
	}

	public void setDateOfRelease(Date dateOfRelease) {
		this.dateOfRelease = dateOfRelease;
	}
	
	
	

}
