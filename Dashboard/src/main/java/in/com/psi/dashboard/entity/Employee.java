package in.com.psi.dashboard.entity;

// Generated 6 Feb, 2016 10:56:52 AM by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Employee generated by hbm2java
 */
@Entity
@Table(name = "employee", catalog = "dashboard", uniqueConstraints = @UniqueConstraint(columnNames = "emp_code"))
public class Employee implements java.io.Serializable {

	private Long id;
	private City cityByPermanentCityId;
	private City cityByPresentCityId;
	private CompanyDetails companyDetails;
	private Country countryByPermanentCountryId;
	private Country countryByPresentCountryId;
	private Department department;
	private Designation designation;
	private EmployeeType employeeType;
	private House house;
	private Role role;
	private State stateByPresentStateId;
	private State stateByPermanentStateId;
	private int empCode;
	private String username;
	private String firstname;
	private String middlename;
	private String lastname;
	private String fatherName;
	private String mobileNo;
	private Date dateOfBirth;
	private String workEmail;
	private String personalEmail;
	private String gender;
	private long managerId;
	private String bloodGroup;
	private String presentAddressStreet1;
	private String presentAddressStreet2;
	private long presentZipcode;
	private String permanentAddressStreet1;
	private String permanentAddressStreet2;
	private long permanentZipcode;
	private String permanentOfficePhoneNoWithExtension;
	private String emergencyContactName;
	private String emergencyContactNo;
	private String relationshipWithEmergencyContact;
	private Date dateOfJoining;
	private String passportNo;
	private String pancardNo;
	private String instantMessangerId;
	private String languagesKnown;
	private Date creationDate;
	private Date modificationDate;
	private Date dateOfRelease;
	private String status;
	private Date evaluationDate;
	private long lastLogin;
	private Set<EmployeePermission> employeePermissions = new HashSet<EmployeePermission>(
			0);
	private Set<ProfessionalDetails> professionalDetailses = new HashSet<ProfessionalDetails>(
			0);
	private Set<DesignationHistory> designationHistories = new HashSet<DesignationHistory>(
			0);
	private Set<EmployeeDocuments> employeeDocumentses = new HashSet<EmployeeDocuments>(
			0);
	private Set<WorkExperience> workExperiences = new HashSet<WorkExperience>(0);

	public Employee() {
	}

	public Employee(City cityByPermanentCityId, City cityByPresentCityId,
			CompanyDetails companyDetails, Country countryByPermanentCountryId,
			Country countryByPresentCountryId, Department department,
			Designation designation, EmployeeType employeeType, House house,
			Role role, State stateByPresentStateId,
			State stateByPermanentStateId, int empCode, String username,
			String firstname, String fatherName, String mobileNo,
			Date dateOfBirth, String workEmail, String personalEmail,
			String gender, long managerId, String bloodGroup,
			String presentAddressStreet1, long presentZipcode,
			String permanentAddressStreet1, long permanentZipcode,
			String permanentOfficePhoneNoWithExtension,
			String emergencyContactName, String emergencyContactNo,
			String relationshipWithEmergencyContact, Date dateOfJoining,
			String passportNo, String pancardNo, String instantMessangerId,
			Date creationDate, String status, long lastLogin) {
		this.cityByPermanentCityId = cityByPermanentCityId;
		this.cityByPresentCityId = cityByPresentCityId;
		this.companyDetails = companyDetails;
		this.countryByPermanentCountryId = countryByPermanentCountryId;
		this.countryByPresentCountryId = countryByPresentCountryId;
		this.department = department;
		this.designation = designation;
		this.employeeType = employeeType;
		this.house = house;
		this.role = role;
		this.stateByPresentStateId = stateByPresentStateId;
		this.stateByPermanentStateId = stateByPermanentStateId;
		this.empCode = empCode;
		this.username = username;
		this.firstname = firstname;
		this.fatherName = fatherName;
		this.mobileNo = mobileNo;
		this.dateOfBirth = dateOfBirth;
		this.workEmail = workEmail;
		this.personalEmail = personalEmail;
		this.gender = gender;
		this.managerId = managerId;
		this.bloodGroup = bloodGroup;
		this.presentAddressStreet1 = presentAddressStreet1;
		this.presentZipcode = presentZipcode;
		this.permanentAddressStreet1 = permanentAddressStreet1;
		this.permanentZipcode = permanentZipcode;
		this.permanentOfficePhoneNoWithExtension = permanentOfficePhoneNoWithExtension;
		this.emergencyContactName = emergencyContactName;
		this.emergencyContactNo = emergencyContactNo;
		this.relationshipWithEmergencyContact = relationshipWithEmergencyContact;
		this.dateOfJoining = dateOfJoining;
		this.passportNo = passportNo;
		this.pancardNo = pancardNo;
		this.instantMessangerId = instantMessangerId;
		this.creationDate = creationDate;
		this.status = status;
		this.lastLogin = lastLogin;
	}

	public Employee(City cityByPermanentCityId, City cityByPresentCityId,
			CompanyDetails companyDetails, Country countryByPermanentCountryId,
			Country countryByPresentCountryId, Department department,
			Designation designation, EmployeeType employeeType, House house,
			Role role, State stateByPresentStateId,
			State stateByPermanentStateId, int empCode, String username,
			String firstname, String middlename, String lastname,
			String fatherName, String mobileNo, Date dateOfBirth,
			String workEmail, String personalEmail, String gender,
			long managerId, String bloodGroup, String presentAddressStreet1,
			String presentAddressStreet2, long presentZipcode,
			String permanentAddressStreet1, String permanentAddressStreet2,
			long permanentZipcode, String permanentOfficePhoneNoWithExtension,
			String emergencyContactName, String emergencyContactNo,
			String relationshipWithEmergencyContact, Date dateOfJoining,
			String passportNo, String pancardNo, String instantMessangerId,
			String languagesKnown, Date creationDate, Date modificationDate,
			Date dateOfRelease, String status, Date evaluationDate,
			long lastLogin, Set<EmployeePermission> employeePermissions,
			Set<ProfessionalDetails> professionalDetailses,
			Set<DesignationHistory> designationHistories,
			Set<EmployeeDocuments> employeeDocumentses,
			Set<WorkExperience> workExperiences) {
		this.cityByPermanentCityId = cityByPermanentCityId;
		this.cityByPresentCityId = cityByPresentCityId;
		this.companyDetails = companyDetails;
		this.countryByPermanentCountryId = countryByPermanentCountryId;
		this.countryByPresentCountryId = countryByPresentCountryId;
		this.department = department;
		this.designation = designation;
		this.employeeType = employeeType;
		this.house = house;
		this.role = role;
		this.stateByPresentStateId = stateByPresentStateId;
		this.stateByPermanentStateId = stateByPermanentStateId;
		this.empCode = empCode;
		this.username = username;
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.fatherName = fatherName;
		this.mobileNo = mobileNo;
		this.dateOfBirth = dateOfBirth;
		this.workEmail = workEmail;
		this.personalEmail = personalEmail;
		this.gender = gender;
		this.managerId = managerId;
		this.bloodGroup = bloodGroup;
		this.presentAddressStreet1 = presentAddressStreet1;
		this.presentAddressStreet2 = presentAddressStreet2;
		this.presentZipcode = presentZipcode;
		this.permanentAddressStreet1 = permanentAddressStreet1;
		this.permanentAddressStreet2 = permanentAddressStreet2;
		this.permanentZipcode = permanentZipcode;
		this.permanentOfficePhoneNoWithExtension = permanentOfficePhoneNoWithExtension;
		this.emergencyContactName = emergencyContactName;
		this.emergencyContactNo = emergencyContactNo;
		this.relationshipWithEmergencyContact = relationshipWithEmergencyContact;
		this.dateOfJoining = dateOfJoining;
		this.passportNo = passportNo;
		this.pancardNo = pancardNo;
		this.instantMessangerId = instantMessangerId;
		this.languagesKnown = languagesKnown;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
		this.dateOfRelease = dateOfRelease;
		this.status = status;
		this.evaluationDate = evaluationDate;
		this.lastLogin = lastLogin;
		this.employeePermissions = employeePermissions;
		this.professionalDetailses = professionalDetailses;
		this.designationHistories = designationHistories;
		this.employeeDocumentses = employeeDocumentses;
		this.workExperiences = workExperiences;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "permanent_city_id", nullable = false)
	public City getCityByPermanentCityId() {
		return this.cityByPermanentCityId;
	}

	public void setCityByPermanentCityId(City cityByPermanentCityId) {
		this.cityByPermanentCityId = cityByPermanentCityId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "present_city_id", nullable = false)
	public City getCityByPresentCityId() {
		return this.cityByPresentCityId;
	}

	public void setCityByPresentCityId(City cityByPresentCityId) {
		this.cityByPresentCityId = cityByPresentCityId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "company_details_id", nullable = false)
	public CompanyDetails getCompanyDetails() {
		return this.companyDetails;
	}

	public void setCompanyDetails(CompanyDetails companyDetails) {
		this.companyDetails = companyDetails;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "permanent_country_id", nullable = false)
	public Country getCountryByPermanentCountryId() {
		return this.countryByPermanentCountryId;
	}

	public void setCountryByPermanentCountryId(
			Country countryByPermanentCountryId) {
		this.countryByPermanentCountryId = countryByPermanentCountryId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "present_country_id", nullable = false)
	public Country getCountryByPresentCountryId() {
		return this.countryByPresentCountryId;
	}

	public void setCountryByPresentCountryId(Country countryByPresentCountryId) {
		this.countryByPresentCountryId = countryByPresentCountryId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "department_id", nullable = false)
	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "designation_id", nullable = false)
	public Designation getDesignation() {
		return this.designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_type_id", nullable = false)
	public EmployeeType getEmployeeType() {
		return this.employeeType;
	}

	public void setEmployeeType(EmployeeType employeeType) {
		this.employeeType = employeeType;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "house_id", nullable = false)
	public House getHouse() {
		return this.house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id", nullable = false)
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "present_state_id", nullable = false)
	public State getStateByPresentStateId() {
		return this.stateByPresentStateId;
	}

	public void setStateByPresentStateId(State stateByPresentStateId) {
		this.stateByPresentStateId = stateByPresentStateId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "permanent_state_id", nullable = false)
	public State getStateByPermanentStateId() {
		return this.stateByPermanentStateId;
	}

	public void setStateByPermanentStateId(State stateByPermanentStateId) {
		this.stateByPermanentStateId = stateByPermanentStateId;
	}

	@Column(name = "emp_code", unique = true, nullable = false)
	public int getEmpCode() {
		return this.empCode;
	}

	public void setEmpCode(int empCode) {
		this.empCode = empCode;
	}

	@Column(name = "username", nullable = false)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "firstname", nullable = false)
	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Column(name = "middlename")
	public String getMiddlename() {
		return this.middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	@Column(name = "lastname")
	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Column(name = "father_name", nullable = false)
	public String getFatherName() {
		return this.fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	@Column(name = "mobile_no", nullable = false, length = 15)
	public String getMobileNo() {
		return this.mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_birth", nullable = false, length = 10)
	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Column(name = "work_email", nullable = false)
	public String getWorkEmail() {
		return this.workEmail;
	}

	public void setWorkEmail(String workEmail) {
		this.workEmail = workEmail;
	}

	@Column(name = "personal_email", nullable = false)
	public String getPersonalEmail() {
		return this.personalEmail;
	}

	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}

	@Column(name = "gender", nullable = false, length = 6)
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "manager_id", nullable = false)
	public long getManagerId() {
		return this.managerId;
	}

	public void setManagerId(long managerId) {
		this.managerId = managerId;
	}

	@Column(name = "blood_group", nullable = false, length = 10)
	public String getBloodGroup() {
		return this.bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	@Column(name = "present_address_street1", nullable = false)
	public String getPresentAddressStreet1() {
		return this.presentAddressStreet1;
	}

	public void setPresentAddressStreet1(String presentAddressStreet1) {
		this.presentAddressStreet1 = presentAddressStreet1;
	}

	@Column(name = "present_address_street2")
	public String getPresentAddressStreet2() {
		return this.presentAddressStreet2;
	}

	public void setPresentAddressStreet2(String presentAddressStreet2) {
		this.presentAddressStreet2 = presentAddressStreet2;
	}

	@Column(name = "present_zipcode", nullable = false)
	public long getPresentZipcode() {
		return this.presentZipcode;
	}

	public void setPresentZipcode(long presentZipcode) {
		this.presentZipcode = presentZipcode;
	}

	@Column(name = "permanent_address_street1", nullable = false)
	public String getPermanentAddressStreet1() {
		return this.permanentAddressStreet1;
	}

	public void setPermanentAddressStreet1(String permanentAddressStreet1) {
		this.permanentAddressStreet1 = permanentAddressStreet1;
	}

	@Column(name = "permanent_address_street2")
	public String getPermanentAddressStreet2() {
		return this.permanentAddressStreet2;
	}

	public void setPermanentAddressStreet2(String permanentAddressStreet2) {
		this.permanentAddressStreet2 = permanentAddressStreet2;
	}

	@Column(name = "permanent_zipcode", nullable = false)
	public long getPermanentZipcode() {
		return this.permanentZipcode;
	}

	public void setPermanentZipcode(long permanentZipcode) {
		this.permanentZipcode = permanentZipcode;
	}

	@Column(name = "permanent_office_phone_no_with_extension", nullable = false, length = 30)
	public String getPermanentOfficePhoneNoWithExtension() {
		return this.permanentOfficePhoneNoWithExtension;
	}

	public void setPermanentOfficePhoneNoWithExtension(
			String permanentOfficePhoneNoWithExtension) {
		this.permanentOfficePhoneNoWithExtension = permanentOfficePhoneNoWithExtension;
	}

	@Column(name = "emergency_contact_name", nullable = false)
	public String getEmergencyContactName() {
		return this.emergencyContactName;
	}

	public void setEmergencyContactName(String emergencyContactName) {
		this.emergencyContactName = emergencyContactName;
	}

	@Column(name = "emergency_contact_no", nullable = false, length = 15)
	public String getEmergencyContactNo() {
		return this.emergencyContactNo;
	}

	public void setEmergencyContactNo(String emergencyContactNo) {
		this.emergencyContactNo = emergencyContactNo;
	}

	@Column(name = "relationship_with_emergency_contact", nullable = false)
	public String getRelationshipWithEmergencyContact() {
		return this.relationshipWithEmergencyContact;
	}

	public void setRelationshipWithEmergencyContact(
			String relationshipWithEmergencyContact) {
		this.relationshipWithEmergencyContact = relationshipWithEmergencyContact;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_joining", nullable = false, length = 10)
	public Date getDateOfJoining() {
		return this.dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	@Column(name = "passport_no", nullable = false)
	public String getPassportNo() {
		return this.passportNo;
	}

	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}

	@Column(name = "pancard_no", nullable = false)
	public String getPancardNo() {
		return this.pancardNo;
	}

	public void setPancardNo(String pancardNo) {
		this.pancardNo = pancardNo;
	}

	@Column(name = "instant_messanger_id", nullable = false)
	public String getInstantMessangerId() {
		return this.instantMessangerId;
	}

	public void setInstantMessangerId(String instantMessangerId) {
		this.instantMessangerId = instantMessangerId;
	}

	@Column(name = "languages_known", length = 1000)
	public String getLanguagesKnown() {
		return this.languagesKnown;
	}

	public void setLanguagesKnown(String languagesKnown) {
		this.languagesKnown = languagesKnown;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creation_date", nullable = false, length = 19)
	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modification_date", length = 19)
	public Date getModificationDate() {
		return this.modificationDate;
	}

	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_release", length = 10)
	public Date getDateOfRelease() {
		return this.dateOfRelease;
	}

	public void setDateOfRelease(Date dateOfRelease) {
		this.dateOfRelease = dateOfRelease;
	}

	@Column(name = "status", nullable = false, length = 8)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "evaluation_date", length = 10)
	public Date getEvaluationDate() {
		return this.evaluationDate;
	}

	public void setEvaluationDate(Date evaluationDate) {
		this.evaluationDate = evaluationDate;
	}

	@Column(name = "last_login", nullable = false)
	public long getLastLogin() {
		return this.lastLogin;
	}

	public void setLastLogin(long lastLogin) {
		this.lastLogin = lastLogin;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
	public Set<EmployeePermission> getEmployeePermissions() {
		return this.employeePermissions;
	}

	public void setEmployeePermissions(
			Set<EmployeePermission> employeePermissions) {
		this.employeePermissions = employeePermissions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
	public Set<ProfessionalDetails> getProfessionalDetailses() {
		return this.professionalDetailses;
	}

	public void setProfessionalDetailses(
			Set<ProfessionalDetails> professionalDetailses) {
		this.professionalDetailses = professionalDetailses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
	public Set<DesignationHistory> getDesignationHistories() {
		return this.designationHistories;
	}

	public void setDesignationHistories(
			Set<DesignationHistory> designationHistories) {
		this.designationHistories = designationHistories;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
	public Set<EmployeeDocuments> getEmployeeDocumentses() {
		return this.employeeDocumentses;
	}

	public void setEmployeeDocumentses(
			Set<EmployeeDocuments> employeeDocumentses) {
		this.employeeDocumentses = employeeDocumentses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
	public Set<WorkExperience> getWorkExperiences() {
		return this.workExperiences;
	}

	public void setWorkExperiences(Set<WorkExperience> workExperiences) {
		this.workExperiences = workExperiences;
	}

}
