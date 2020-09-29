package in.com.psi.dashboard.util;

import in.com.psi.dashboard.entity.ActionHistory;
import in.com.psi.dashboard.entity.City;
import in.com.psi.dashboard.entity.CompanyDetails;
import in.com.psi.dashboard.entity.Country;
import in.com.psi.dashboard.entity.Department;
import in.com.psi.dashboard.entity.Designation;
import in.com.psi.dashboard.entity.Employee;
import in.com.psi.dashboard.entity.EmployeeDocuments;
import in.com.psi.dashboard.entity.EmployeePermission;
import in.com.psi.dashboard.entity.EmployeeType;
import in.com.psi.dashboard.entity.House;
import in.com.psi.dashboard.entity.Permission;
import in.com.psi.dashboard.entity.ProfessionalDetails;
import in.com.psi.dashboard.entity.Role;
import in.com.psi.dashboard.entity.State;
import in.com.psi.dashboard.entity.WorkExperience;
import in.com.psi.dashboard.entity.VO.CityVO;
import in.com.psi.dashboard.entity.VO.CompanyDetailsVO;
import in.com.psi.dashboard.entity.VO.CountryVO;
import in.com.psi.dashboard.entity.VO.DepartmentVO;
import in.com.psi.dashboard.entity.VO.DesignationVO;
import in.com.psi.dashboard.entity.VO.EmployeeTypeVO;
import in.com.psi.dashboard.entity.VO.EmployeeVO;
import in.com.psi.dashboard.entity.VO.HouseVO;
import in.com.psi.dashboard.entity.VO.ManagerVO;
import in.com.psi.dashboard.entity.VO.PermissionVO;
import in.com.psi.dashboard.entity.VO.ResponseMessage;
import in.com.psi.dashboard.entity.VO.RoleVO;
import in.com.psi.dashboard.entity.VO.StateVO;
import in.com.psi.dashboard.entity.VO.UserVO;
import in.com.psi.dashboard.entity.VO.ViewResponseVO;
import in.com.psi.dashboard.entity.VO.ViewUserVO;
import in.com.psi.dashboard.exception.DashboardException;
import in.com.psi.dashboard.manager.IEmployeeDocumentsManager;
import in.com.psi.dashboard.manager.IEmployeePermissionManager;
import in.com.psi.dashboard.manager.IPermissionManager;
import in.com.psi.dashboard.manager.IUserManager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class DashboardUtil.
 */
public class DashboardUtil {

	/** The Constant logger. */
	private final static Logger logger = LoggerFactory
			.getLogger(DashboardUtil.class);

	/**
	 * Gets the current time.
	 *
	 * @return the current time
	 */
	public static long getCurrentTime() {
		return Calendar.getInstance().getTimeInMillis();
	}

	/**
	 * Gets the uuid.
	 *
	 * @return the uuid
	 */
	public static String getUuid() {
		return UUID.randomUUID().toString();
	}

	/**
	 * Check session.
	 *
	 * @param sessionId
	 *            the session id
	 * @return true, if successful
	 * @throws DashboardException
	 *             the dashboard exception
	 * @function check for the session expiry and update the last interaction
	 *           time
	 */
	public static boolean checkSession(String sessionId)
			throws DashboardException {
		boolean result = false;
		UserVO userVO = DashboardConstants.activeUsers.get(sessionId);
		if (userVO != null) {
			if (!checkSessionExpiry(userVO)) {
				throw new DashboardException(logger, "checkSession",
						DashboardConstants.SESSION_EXPIRED, null);
			} else {
				userVO.setLastInteractionTime(getCurrentTime());
				result = true;
			}
			DashboardConstants.activeUsers.put(sessionId, userVO);
		} else {
			throw new DashboardException(logger, "checkSession",
					DashboardConstants.SESSION_ID_NOT_FOUND, null);
		}
		return result;
	}

	private static boolean checkSessionExpiry(UserVO userVO) {
		boolean result = true;
		if (getCurrentTime() - userVO.getLastInteractionTime() > DashboardConstants.SESSION_TIMEOUT) {
			result = false;
		}
		return result;
	}

	/**
	 * Prepare response message.
	 *
	 * @param responseCode
	 *            the response code
	 * @param responseMessage
	 *            the response message
	 * @param responseObject
	 *            the response object
	 * @return the response message
	 */
	public static ResponseMessage prepareResponseMessage(String responseCode,
			String responseMessage, Object responseObject) {
		ResponseMessage message = new ResponseMessage();
		message.setResponseCode(responseCode);
		message.setResponseMessage(responseMessage);
		message.setResponseObject(responseObject);
		return message;
	}

	/**
	 * Prepare cross site allowance header.
	 *
	 * @param httpServletResponse
	 *            the http servlet response
	 */
	public static void prepareCrossSiteAllowanceHeader(
			HttpServletResponse httpServletResponse) {
		httpServletResponse.addHeader("Access-Control-Allow-Origin", "*");
		httpServletResponse.addHeader("Access-Control-Allow-Methods",
				"GET, POST, DELETE, PUT, OPTIONS");
		httpServletResponse.addHeader("Access-Control-Allow-Headers",
				"Content-Type, Accept, X-Requested-With, Session");
	}

	/**
	 * Activate user.
	 *
	 * @param userName
	 *            the user name
	 * @param uuid
	 *            the uuid
	 * @param userManagerImpl
	 *            the user manager impl
	 * @return the user vo
	 */
	public static UserVO activateUser(String userName, String uuid,
			IUserManager userManagerImpl) {
		UserVO userVO = new UserVO();
		userVO.setUserName(userName);
		userVO.setLastInteractionTime(DashboardUtil.getCurrentTime());
		userVO.setLDAPAuthenticated(false);
		userVO.setPermissions(pupulatePermissions(uuid, userManagerImpl,
				userName));
		return userVO;
	}

	/**
	 * Gets the client ip.
	 *
	 * @param request
	 *            the request
	 * @return the client ip
	 */
	public static String getClientIP(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	/**
	 * Creates the work experience.
	 *
	 * @param employeeVO
	 *            the employee vo
	 * @param employee
	 *            the employee
	 * @param workExperience
	 *            the work experience
	 */
	public static void createWorkExperience(EmployeeVO employeeVO,
			Employee employee, WorkExperience workExperience) {
		Integer psExperience = (employeeVO.getPsYearExperience()
				* DashboardConstants.YEAR_TO_DAYS
				+ employeeVO.getPsMonthExperience()
				* DashboardConstants.MONTH_TO_DAYS + employeeVO
				.getPsDayExperience());
		Integer pastExperience = (employeeVO.getPastYearExperience()
				* DashboardConstants.YEAR_TO_DAYS
				+ employeeVO.getPastMonthExperience()
				* DashboardConstants.MONTH_TO_DAYS + employeeVO
				.getPastDayExperience());
		workExperience.setEmployee(employee);
		workExperience.setPastExperience((long) pastExperience);
		workExperience.setPsExperience((long) psExperience);
		workExperience
				.setTotalExperience((long) (pastExperience + psExperience));
	}

	/**
	 * Creates the professional details.
	 *
	 * @param employeeVO
	 *            the employee vo
	 * @param employee
	 *            the employee
	 * @param professionalDetails
	 *            the professional details
	 */
	public static void createProfessionalDetails(EmployeeVO employeeVO,
			Employee employee, ProfessionalDetails professionalDetails) {
		professionalDetails.setEmployee(employee);
		professionalDetails.setCertifications(employeeVO.getCertifications());
		professionalDetails.setQualifications(employeeVO.getQualifications());
		professionalDetails.setSkillSet(employeeVO.getSkillSet());
	}

	/**
	 * Creates the employee documents.
	 *
	 * @param employeeVO
	 *            the employee vo
	 * @param employeeDocumentsManagerImpl 
	 * @param employee
	 *            the employee
	 * @param employeeDocumentsList
	 *            the employee documents list
	 */
	public static void createEmployeeDocuments(EmployeeVO employeeVO,
			IEmployeeDocumentsManager employeeDocumentsManagerImpl, Employee employee, List<EmployeeDocuments> employeeDocumentsList) {
		Integer index = 0;
		List<byte[]> documentList = employeeVO.getDocument();
		List<String> documentTypeList = employeeVO.getDocumentType();
		if (employeeDocumentsList.size() != 0) {
			for (index = 0; index < employeeDocumentsList.size()
					&& index < employeeVO.getDocument().size(); index++) {
				employeeDocumentsList.get(index).setEmployee(employee);
				employeeDocumentsList.get(index).setDocument(
						documentList.get(index));
				employeeDocumentsList.get(index).setDocumentType(
						documentTypeList.get(index));
				employeeDocumentsList.get(index).setDisplayName(
						employeeVO.getFirstname() + "_"
								+ documentTypeList.get(index));
			}
			while (index < employeeDocumentsList.size()) {
				employeeDocumentsManagerImpl.delete(employeeDocumentsList.get(index));
				employeeDocumentsList.remove(index);
				index++;
			}
			while (index < employeeVO.getDocument().size()) {
				EmployeeDocuments employeeDocuments = new EmployeeDocuments();
				employeeDocuments.setEmployee(employee);
				employeeDocuments.setDocument(documentList.get(index));
				employeeDocuments.setDocumentType(documentTypeList.get(index));
				employeeDocuments.setDisplayName(employeeVO.getFirstname()
						+ "_" + documentTypeList.get(index));
				employeeDocumentsList.add(employeeDocuments);
				index++;
			}
		} else {
			for (index = 0; index < employeeVO.getDocument().size(); index++) {
				EmployeeDocuments employeeDocuments = new EmployeeDocuments();
				employeeDocuments.setEmployee(employee);
				employeeDocuments.setDocument(documentList.get(index));
				employeeDocuments.setDocumentType(documentTypeList.get(index));
				employeeDocuments.setDisplayName(employeeVO.getFirstname()
						+ "_" + documentTypeList.get(index));
				employeeDocumentsList.add(employeeDocuments);
			}
		}
	}

	/**
	 * Creates the employee.
	 *
	 * @param department
	 *            the department
	 * @param designation
	 *            the designation
	 * @param house
	 *            the house
	 * @param employeeType
	 *            the employee type
	 * @param companyDetails
	 *            the company details
	 * @param role
	 *            the role
	 * @param employeeVO
	 *            the employee vo
	 * @param employee
	 *            the employee
	 * @param presentCity
	 *            the present city
	 * @param permanentCity
	 *            the permanent city
	 * @param presentState
	 *            the present state
	 * @param permanentState
	 *            the permanent state
	 * @param presentCountry
	 *            the present country
	 * @param permanentCountry
	 *            the permanent country
	 */
	public static void createEmployee(Department department,
			Designation designation, House house, EmployeeType employeeType,
			CompanyDetails companyDetails, Role role, EmployeeVO employeeVO,
			Employee employee, City presentCity, City permanentCity,
			State presentState, State permanentState, Country presentCountry,
			Country permanentCountry) {
		employee.setDepartment(department);
		employee.setDesignation(designation);
		employee.setHouse(house);
		employee.setEmployeeType(employeeType);
		employee.setCompanyDetails(companyDetails);
		employee.setRole(role);
		employee.setCityByPresentCityId(presentCity);
		employee.setCityByPermanentCityId(permanentCity);
		employee.setStateByPresentStateId(presentState);
		employee.setStateByPermanentStateId(permanentState);
		employee.setCountryByPresentCountryId(presentCountry);
		employee.setCountryByPermanentCountryId(permanentCountry);
		employee.setDateOfBirth(employeeVO.getDateOfBirth());
		employee.setDateOfJoining(employeeVO.getDateOfJoining());
		employee.setEmergencyContactName(employeeVO.getEmergencyContactName());
		employee.setEmergencyContactNo(employeeVO.getEmergencyContactNo());
		employee.setRelationshipWithEmergencyContact(employeeVO
				.getRelationshipWithEmergencyContact());
		employee.setEmpCode(employeeVO.getEmpCode());
		employee.setFirstname(employeeVO.getFirstname());
		employee.setMiddlename(employeeVO.getMiddlename());
		employee.setLastname(employeeVO.getLastname());
		employee.setFatherName(employeeVO.getFatherName());
		employee.setBloodGroup(employeeVO.getBloodGroup());
		employee.setGender(employeeVO.getGender());
		employee.setInstantMessangerId(employeeVO.getInstantMessangerId());
		employee.setLanguagesKnown(employeeVO.getLanguagesKnown());
		employee.setManagerId(employeeVO.getManagerId());
		employee.setMobileNo(employeeVO.getMobileNo());
		employee.setPancardNo(employeeVO.getPancardNo());
		employee.setPassportNo(employeeVO.getPassportNo());
		employee.setPermanentAddressStreet1(employeeVO
				.getPermanentAddressStreet1());
		employee.setPermanentAddressStreet2(employeeVO
				.getPermanentAddressStreet2());
		employee.setPermanentZipcode(employeeVO.getPermanentZipcode());
		employee.setPermanentOfficePhoneNoWithExtension(employeeVO
				.getPermanentOfficePhoneNoWithExtension());
		employee.setPresentAddressStreet1(employeeVO.getPresentAddressStreet1());
		employee.setPresentAddressStreet2(employeeVO.getPresentAddressStreet2());
		employee.setPresentZipcode(employeeVO.getPresentZipcode());
		employee.setStatus(employeeVO.getStatus());
		employee.setUsername(employeeVO.getUsername());
		employee.setWorkEmail(employeeVO.getWorkEmail());
		employee.setPersonalEmail(employeeVO.getPersonalEmail());
		employee.setLastLogin(DashboardConstants.activeUsers.get(
				employeeVO.getSessionId()).getLastInteractionTime());
	}

	/**
	 * Sets the employee properties.
	 *
	 * @param employee
	 *            the employee
	 * @param viewResponseVO
	 *            the view response vo
	 * @param managerName
	 *            the name
	 */
	public static void setEmployeeProperties(Employee employee,
			ViewResponseVO viewResponseVO, String managerName) {
		viewResponseVO.setBloodGroup(employee.getBloodGroup());
		viewResponseVO
				.setCompanyDetailsId(employee.getCompanyDetails().getId());
		viewResponseVO
				.setCompanyDetails(employee.getCompanyDetails().getName());
		viewResponseVO.setCreationDate(employee.getCreationDate());
		viewResponseVO.setDateOfBirth(employee.getDateOfBirth());
		viewResponseVO.setDateOfJoining(employee.getDateOfJoining());
		viewResponseVO.setDateOfRelease(employee.getDateOfRelease());
		viewResponseVO.setDepartmentId(employee.getDepartment().getId());
		viewResponseVO.setDepartment(employee.getDepartment().getName());
		viewResponseVO.setDesignation(employee.getDesignation().getName());
		viewResponseVO.setDesignationId(employee.getDesignation().getId());
		viewResponseVO.setEmergencyContactName(employee
				.getEmergencyContactName());
		viewResponseVO.setEmergencyContactNo(employee.getEmergencyContactNo());
		viewResponseVO.setEmpCode(employee.getEmpCode());
		viewResponseVO.setEmployeeTypeId(employee.getEmployeeType().getId());
		viewResponseVO.setEmployeeType(employee.getEmployeeType().getName());
		viewResponseVO.setEvaluationDate(employee.getEvaluationDate());
		viewResponseVO.setFatherName(employee.getFatherName());
		viewResponseVO.setFirstname(employee.getFirstname());
		viewResponseVO.setGender(employee.getGender());
		viewResponseVO.setHouseId(employee.getHouse().getId());
		viewResponseVO.setHouse(employee.getHouse().getName());
		viewResponseVO.setId(employee.getId());
		viewResponseVO.setInstantMessangerId(employee.getInstantMessangerId());
		viewResponseVO.setLanguagesKnown(employee.getLanguagesKnown());
		viewResponseVO.setLastLogin(employee.getLastLogin());
		viewResponseVO.setLastname(employee.getLastname());
		viewResponseVO.setManager(managerName);
		viewResponseVO.setManagerId(employee.getManagerId());
		viewResponseVO.setMiddlename(employee.getMiddlename());
		viewResponseVO.setMobileNo(employee.getMobileNo());
		viewResponseVO.setModificationDate(employee.getModificationDate());
		viewResponseVO.setPancardNo(employee.getPancardNo());
		viewResponseVO.setPassportNo(employee.getPassportNo());
		viewResponseVO.setPermanentAddressStreet1(employee
				.getPermanentAddressStreet1());
		viewResponseVO.setPermanentAddressStreet2(employee
				.getPermanentAddressStreet2());
		viewResponseVO.setPermanentCity(employee.getCityByPermanentCityId()
				.getName());
		viewResponseVO.setPermanentCityId(employee.getCityByPermanentCityId()
				.getId());
		viewResponseVO.setPermanentCountry(employee
				.getCountryByPermanentCountryId().getName());
		viewResponseVO.setPermanentCountryId(employee
				.getCountryByPermanentCountryId().getId());
		viewResponseVO.setPermanentState(employee.getStateByPermanentStateId()
				.getName());
		viewResponseVO.setPermanentStateId(employee
				.getStateByPermanentStateId().getId());
		viewResponseVO.setPermanentOfficePhoneNoWithExtension(employee
				.getPermanentOfficePhoneNoWithExtension());
		viewResponseVO.setPermanentZipcode(employee.getPermanentZipcode());
		viewResponseVO.setPersonalEmail(employee.getPersonalEmail());
		viewResponseVO.setPresentAddressStreet1(employee
				.getPresentAddressStreet1());
		viewResponseVO.setPresentAddressStreet2(employee
				.getPresentAddressStreet2());
		viewResponseVO.setPresentCity(employee.getCityByPresentCityId()
				.getName());
		viewResponseVO.setPresentCityId(employee.getCityByPresentCityId()
				.getId());
		viewResponseVO.setPresentCountry(employee
				.getCountryByPresentCountryId().getName());
		viewResponseVO.setPresentCountryId(employee
				.getCountryByPresentCountryId().getId());
		viewResponseVO.setPresentState(employee.getStateByPresentStateId()
				.getName());
		viewResponseVO.setPresentStateId(employee.getStateByPresentStateId()
				.getId());
		viewResponseVO.setPresentZipcode(employee.getPresentZipcode());
		viewResponseVO.setRelationshipWithEmergencyContact(employee
				.getRelationshipWithEmergencyContact());
		viewResponseVO.setRoleId(employee.getRole().getId());
		viewResponseVO.setRole(employee.getRole().getRole());
		viewResponseVO.setStatus(employee.getStatus());
		viewResponseVO.setUsername(employee.getUsername());
		viewResponseVO.setWorkEmail(employee.getWorkEmail());

	}

	/**
	 * Sets the work experience properties.
	 *
	 * @param workExperience
	 *            the work experience
	 * @param viewResponseVO
	 *            the view response vo
	 */
	public static void setWorkExperienceProperties(
			WorkExperience workExperience, ViewResponseVO viewResponseVO) {

		viewResponseVO.setPastYearExperience((int) (workExperience
				.getPastExperience() / DashboardConstants.YEAR_TO_DAYS));
		viewResponseVO
				.setPastMonthExperience((int) (workExperience
						.getPastExperience() % DashboardConstants.YEAR_TO_DAYS / DashboardConstants.MONTH_TO_DAYS));
		viewResponseVO
				.setPastDayExperience((int) (workExperience.getPastExperience()
						% DashboardConstants.YEAR_TO_DAYS % DashboardConstants.MONTH_TO_DAYS));
		viewResponseVO.setPsYearExperience((int) (workExperience
				.getPsExperience() / DashboardConstants.YEAR_TO_DAYS));
		viewResponseVO
				.setPsMonthExperience((int) (workExperience.getPsExperience()
						% DashboardConstants.YEAR_TO_DAYS / DashboardConstants.MONTH_TO_DAYS));
		viewResponseVO
				.setPsDayExperience((int) (workExperience.getPsExperience()
						% DashboardConstants.YEAR_TO_DAYS % DashboardConstants.MONTH_TO_DAYS));
	}

	/**
	 * Sets the professional details properties.
	 *
	 * @param professionalDetails
	 *            the professional details
	 * @param viewResponseVO
	 *            the view response vo
	 */
	public static void setProfessionalDetailsProperties(
			ProfessionalDetails professionalDetails,
			ViewResponseVO viewResponseVO) {

		viewResponseVO.setSkillSet(professionalDetails.getSkillSet());
		viewResponseVO.setCertifications(professionalDetails
				.getCertifications());
		viewResponseVO.setQualifications(professionalDetails
				.getQualifications());
	}

	/**
	 * Sets the employee documents properties.
	 *
	 * @param employeeDocumentsList
	 *            the employee documents list
	 * @param viewResponseVO
	 *            the view response vo
	 */
	public static void setEmployeeDocumentsProperties(
			List<EmployeeDocuments> employeeDocumentsList,
			ViewResponseVO viewResponseVO) {
		List<byte[]> documentList = new ArrayList<byte[]>();
		List<String> documentTypeList = new ArrayList<String>();
		for (EmployeeDocuments employeeDocuments : employeeDocumentsList) {
			byte[] document = employeeDocuments.getDocument();
			String documentType = employeeDocuments.getDocumentType();
			documentList.add(document);
			documentTypeList.add(documentType);
		}
		viewResponseVO.setDocument(documentList);
		viewResponseVO.setDocumentType(documentTypeList);
	}

	/**
	 * Sets the permissions to urls.
	 */
	public static void setPermissionsToUrls() {

		DashboardConstants.urlPermission.put(DashboardMappings.ADD_USER,
				DashboardConstants.ADD_USER);
		DashboardConstants.urlPermission.put(DashboardMappings.UPDATE_USER,
				DashboardConstants.UPDATE_USER);
		// DashboardConstants.urlPermission.put(DashboardMappings.DOWNLOAD_REPORT,
		// DashboardConstants.DOWNLOAD_REPORT);

	}

	/*
	 * public static void cacheDepartments(IDepartmentManager
	 * departmentManagerImpl) throws DashboardException {
	 * 
	 * List<Department> departmentList = null; try{ departmentList =
	 * departmentManagerImpl.list(); } catch(Exception e){ throw new
	 * DashboardException(logger, "listDepartment",
	 * DashboardConstants.REQUEST_NOT_PROCESSED, null); } for(Department
	 * department : departmentList){ DepartmentVO departmentVO = new
	 * DepartmentVO(); departmentVO.setName(department.getName());
	 * departmentVO.setId(department.getId());
	 * DashboardConstants.department.put(departmentVO.getId(), departmentVO); }
	 * }
	 * 
	 * public static void cacheCompanyDetails( ICompanyDetailsManager
	 * companyDetailsManagerImpl) throws DashboardException {
	 * 
	 * List<CompanyDetails> companyDetailsList = null; try{ companyDetailsList =
	 * companyDetailsManagerImpl.list(); } catch(Exception e){ throw new
	 * DashboardException(logger, "listDepartment",
	 * DashboardConstants.REQUEST_NOT_PROCESSED, null); } for(CompanyDetails
	 * companyDetails : companyDetailsList){ CompanyDetailsVO companyDetailsVO =
	 * new CompanyDetailsVO();
	 * companyDetailsVO.setName(companyDetails.getCompanyName());
	 * companyDetailsVO.setId(companyDetails.getId());
	 * DashboardConstants.companyDetails.put(companyDetailsVO.getId(),
	 * companyDetailsVO); } }
	 * 
	 * public static void cacheDesignations( IDesignationManager
	 * designationManagerImpl) throws DashboardException {
	 * 
	 * List<Designation> designationList = null; try{ designationList =
	 * designationManagerImpl.list(); } catch(Exception e){ throw new
	 * DashboardException(logger, "listDesignation",
	 * DashboardConstants.REQUEST_NOT_PROCESSED, null); } for(Designation
	 * designation : designationList){ DesignationVO designationVO = new
	 * DesignationVO(); designationVO.setName(designation.getName());
	 * designationVO.setId(designation.getId());
	 * DashboardConstants.designation.put(designationVO.getId(), designationVO);
	 * } }
	 * 
	 * public static void cacheEmployeeType( IEmployeeTypeManager
	 * employeeTypeManagerImpl) throws DashboardException {
	 * 
	 * List<EmployeeType> employeeTypeList = null; try{ employeeTypeList =
	 * employeeTypeManagerImpl.list(); } catch(Exception e){ throw new
	 * DashboardException(logger, "cacheEmployeeType",
	 * DashboardConstants.REQUEST_NOT_PROCESSED, null); } for(EmployeeType
	 * employeeType : employeeTypeList){ EmployeeTypeVO employeeTypeVO = new
	 * EmployeeTypeVO(); employeeTypeVO.setName(employeeType.getName());
	 * employeeTypeVO.setId(employeeType.getId());
	 * DashboardConstants.employeeType.put(employeeTypeVO.getId(),
	 * employeeTypeVO); } }
	 * 
	 * public static void cacheHouses(IHouseManager houseManagerImpl) throws
	 * DashboardException {
	 * 
	 * List<House> houseList = null; try{ houseList = houseManagerImpl.list(); }
	 * catch(Exception e){ throw new DashboardException(logger, "cacheHouses",
	 * DashboardConstants.REQUEST_NOT_PROCESSED, null); } for(House house :
	 * houseList){ HouseVO houseVO = new HouseVO();
	 * houseVO.setName(house.getName()); houseVO.setId(house.getId());
	 * DashboardConstants.house.put(houseVO.getId(), houseVO); } }
	 * 
	 * public static void cacheRoles(IRoleManager roleManagerImpl) throws
	 * DashboardException {
	 * 
	 * List<Role> roleList = null; try{ roleList = roleManagerImpl.list(); }
	 * catch(Exception e){ throw new DashboardException(logger, "cacheRoles",
	 * DashboardConstants.REQUEST_NOT_PROCESSED, null); } for(Role role :
	 * roleList){ RoleVO roleVO = new RoleVO(); roleVO.setName(role.getRole());
	 * roleVO.setId(role.getId()); DashboardConstants.role.put(roleVO.getId(),
	 * roleVO); } }
	 * 
	 * public static void cachePermissions(IPermissionManager
	 * permissionManagerImpl) throws DashboardException {
	 * 
	 * List<Permission> permissionList = null; try{ permissionList =
	 * permissionManagerImpl.list(); } catch(Exception e){ throw new
	 * DashboardException(logger, "cachePermissions",
	 * DashboardConstants.REQUEST_NOT_PROCESSED, null); } for(Permission
	 * permission : permissionList){ PermissionVO permissionVO = new
	 * PermissionVO(); permissionVO.setName(permission.getPermission());
	 * permissionVO.setId(permission.getId());
	 * DashboardConstants.permission.put(permissionVO.getId(), permissionVO); }
	 * 
	 * }
	 * 
	 * public static void cacheCountries(ICountryManager countryManagerImpl)
	 * throws DashboardException {
	 * 
	 * List<Country> countryList = null; try{ countryList =
	 * countryManagerImpl.list(); } catch(Exception e){ throw new
	 * DashboardException(logger, "cacheCountries",
	 * DashboardConstants.REQUEST_NOT_PROCESSED, null); } for(Country country :
	 * countryList){ CountryVO countryVO = new CountryVO();
	 * countryVO.setName(country.getName()); countryVO.setId(country.getId());
	 * DashboardConstants.country.put(countryVO.getId(), countryVO); } }
	 * 
	 * public static void cacheStates(IStateManager stateManagerImpl) throws
	 * DashboardException {
	 * 
	 * List<State> stateList = null; try{ stateList = stateManagerImpl.list(); }
	 * catch(Exception e){ throw new DashboardException(logger, "cacheStates",
	 * DashboardConstants.REQUEST_NOT_PROCESSED, null); } for(State state :
	 * stateList){ StateVO stateVO = new StateVO();
	 * stateVO.setName(state.getName()); stateVO.setId(state.getId());
	 * DashboardConstants.state.put(stateVO.getId(), stateVO); } }
	 * 
	 * public static void cacheCities(ICityManager cityManagerImpl) throws
	 * DashboardException {
	 * 
	 * List<City> cityList = null; try{ cityList = cityManagerImpl.list(); }
	 * catch(Exception e){ throw new DashboardException(logger, "cacheCities",
	 * DashboardConstants.REQUEST_NOT_PROCESSED, null); } for(City city :
	 * cityList){ CityVO cityVO = new CityVO(); cityVO.setName(city.getName());
	 * cityVO.setId(city.getId()); DashboardConstants.city.put(cityVO.getId(),
	 * cityVO); }
	 * 
	 * }
	 */

	/**
	 * Creates the employee permission.
	 *
	 * @param employeeVO
	 *            the employee vo
	 * @param employeePermissionManagerImpl 
	 * @param permissionManagerImpl
	 *            the permission manager impl
	 * @param employee
	 *            the employee
	 * @param employeePermissionsList
	 *            the employee permissions list
	 * @throws DashboardException
	 *             the dashboard exception
	 */
	public static void createEmployeePermission(EmployeeVO employeeVO,
			IEmployeePermissionManager employeePermissionManagerImpl, IPermissionManager permissionManagerImpl, Employee employee,
			List<EmployeePermission> employeePermissionsList)
			throws DashboardException {
		Integer index;
		List<Permission> permissionList = new ArrayList<Permission>();
		for (Integer permissionId : employeeVO.getPermission()) {
			Permission permission = new Permission();
			permission = permissionManagerImpl.getById(permissionId);
			if (permission == null) {
				throw new DashboardException(logger, "addUser",
						DashboardConstants.PERMISSION_ID_NOT_FOUND, null);
			}
			permissionList.add(permission);
		}
		// in case of update
		if (employeePermissionsList.size() != 0) {
			for (index = 0; index < employeePermissionsList.size()
					&& index < permissionList.size(); index++) {
				employeePermissionsList.get(index).setPermission(
						permissionList.get(index));
				employeePermissionsList.get(index).setEmployee(employee);
			}
			while (index < employeePermissionsList.size()) {
				employeePermissionManagerImpl.delete(employeePermissionsList.get(index));
				employeePermissionsList.remove(index);
				index++;
			}
			while (index < permissionList.size()) {
				EmployeePermission employeePermission = new EmployeePermission();
				employeePermission.setPermission(permissionList.get(index));
				employeePermission.setEmployee(employee);
				employeePermissionsList.add(employeePermission);
				index++;
			}
		} else {
			for (Permission permission : permissionList) {
				EmployeePermission employeePermission = new EmployeePermission();
				employeePermission.setPermission(permission);
				employeePermission.setEmployee(employee);
				employeePermissionsList.add(employeePermission);
			}
		}
	}

	/**
	 * Pupulate permissions.
	 *
	 * @param sessionId
	 *            the session id
	 * @param userManagerImpl
	 *            the user manager impl
	 * @param userName
	 *            the user name
	 * @return the list
	 */
	public static List<String> pupulatePermissions(String sessionId,
			IUserManager userManagerImpl, String userName) {
		List<EmployeePermission> employeePermissionList = userManagerImpl
				.populatePermissions(userName);
		List<String> permissionList = new ArrayList<>();
		for (EmployeePermission employeePermission : employeePermissionList) {
			permissionList.add(employeePermission.getPermission()
					.getPermission());
		}
		return permissionList;
	}

	/**
	 * Creates the action history.
	 *
	 * @param actionPerformedBy
	 *            the action performed by
	 * @param action
	 *            the action
	 * @param actionPerformedFor
	 *            the action performed for
	 */
	public static ActionHistory createActionHistory(String actionPerformedBy,
			String action, String actionPerformedFor) {
		ActionHistory actionHistory = new ActionHistory();
		actionHistory.setAction(action);
		actionHistory.setActionPerformedBy(actionPerformedBy);
		if (actionPerformedFor == null) {
			actionHistory.setActionPerformedFor(actionPerformedBy);
		} else {
			actionHistory.setActionPerformedFor(actionPerformedFor);
		}
		actionHistory.setTimestamp(getCurrentTime());
		return actionHistory;
	}

	

	public static List<CityVO> createCityVOList(List<City> cityList) {
		List<CityVO> cityVOList = new ArrayList<CityVO>();
		for (City city : cityList) {
			CityVO cityVO = new CityVO();
			cityVO.setName(city.getName());
			cityVO.setId(city.getId());
			cityVO.setStateId(city.getState().getId());
			cityVOList.add(cityVO);
		}
		return cityVOList;
		
	}

	public static List<CompanyDetailsVO> createCompanyDetailsVOList(
			List<CompanyDetails> companyDetailsList) {
		List<CompanyDetailsVO> companyDetailsVOList = new ArrayList<CompanyDetailsVO>();
		for (CompanyDetails companyDetails : companyDetailsList) {
			CompanyDetailsVO companyDetailsVO = new CompanyDetailsVO();
			companyDetailsVO.setName(companyDetails.getName());
			companyDetailsVO.setId(companyDetails.getId());
			companyDetailsVOList.add(companyDetailsVO);
		}
		return companyDetailsVOList;
	}

	public static List<CountryVO> createCountryVOList(List<Country> countryList) {
		List<CountryVO> countryVOList = new ArrayList<CountryVO>();
		for (Country country : countryList) {
			CountryVO countryVO = new CountryVO();
			countryVO.setName(country.getName());
			countryVO.setId(country.getId());
			countryVOList.add(countryVO);
		}
		return countryVOList;
	}

	public static List<DepartmentVO> createDepartmentVOList(
			List<Department> departmentList) {
		List<DepartmentVO> departmentVOList = new ArrayList<DepartmentVO>();
		for (Department department : departmentList) {
			DepartmentVO departmentVO = new DepartmentVO();
			departmentVO.setName(department.getName());
			departmentVO.setId(department.getId());
			departmentVOList.add(departmentVO);
		}
		return departmentVOList;
	}

	public static List<DesignationVO> createDesignationVOList(
			List<Designation> designationList) {
		List<DesignationVO> designationVOList = new ArrayList<DesignationVO>();
		for (Designation designation : designationList) {
			DesignationVO designationVO = new DesignationVO();
			designationVO.setName(designation.getName());
			designationVO.setId(designation.getId());
			designationVOList.add(designationVO);
		}
		return designationVOList;
	}

	public static List<EmployeeTypeVO> createEmployeeTypeVOList(
			List<EmployeeType> employeeTypeList) {
		List<EmployeeTypeVO> employeeTypeVOList = new ArrayList<EmployeeTypeVO>();
		for (EmployeeType employeeType : employeeTypeList) {
			EmployeeTypeVO employeeTypeVO = new EmployeeTypeVO();
			employeeTypeVO.setName(employeeType.getName());
			employeeTypeVO.setId(employeeType.getId());
			employeeTypeVOList.add(employeeTypeVO);
		}
		return employeeTypeVOList;
	}

	public static List<HouseVO> createHouseVOList(List<House> houseList) {
		List<HouseVO> houseVOList = new ArrayList<HouseVO>();
		for (House house : houseList) {
			HouseVO houseVO = new HouseVO();
			houseVO.setName(house.getName());
			houseVO.setId(house.getId());
			houseVOList.add(houseVO);
		}
		return houseVOList;
	}

	public static List<PermissionVO> createPermissionVOList(
			List<Permission> permissionList) {
		List<PermissionVO> permissionVOList = new ArrayList<PermissionVO>();
		for (Permission permission : permissionList) {
			PermissionVO permissionVO = new PermissionVO();
			permissionVO.setName(permission.getPermission());
			permissionVO.setId(permission.getId());
			permissionVOList.add(permissionVO);
		}
		return permissionVOList;
	}

	public static List<RoleVO> createRoleVOList(List<Role> roleList) {
		List<RoleVO> roleVOList = new ArrayList<RoleVO>();
		for (Role role : roleList) {
			RoleVO roleVO = new RoleVO();
			roleVO.setName(role.getRole());
			roleVO.setId(role.getId());
			roleVOList.add(roleVO);
		}
		return roleVOList;
	}

	public static List<StateVO> createStateVOList(List<State> stateList) {
		List<StateVO> stateVOList = new ArrayList<StateVO>();
		for (State state : stateList) {
			StateVO stateVO = new StateVO();
			stateVO.setName(state.getName());
			stateVO.setId(state.getId());
			stateVO.setCountryId(state.getCountry().getId());
			stateVOList.add(stateVO);
		}
		return stateVOList;
	}

	public static ViewUserVO createViewUserVO(Employee employee,
			List<EmployeeDocuments> employeeDocumentsList,
			WorkExperience workExperience,
			ProfessionalDetails professionalDetails) {
		ViewUserVO viewUserVO = new ViewUserVO();
		viewUserVO.setEmployee(employee);
		viewUserVO.setEmployeeDocuments(employeeDocumentsList);
		viewUserVO.setProfessionalDetails(professionalDetails);
		viewUserVO.setWorkExperience(workExperience);
		return viewUserVO;
	}

	public static String getManagerName(Employee manager) {
		StringBuilder managerName = new StringBuilder();
		if (manager.getFirstname() != null) {
			managerName.append(manager.getFirstname());
		}
		if (manager.getMiddlename() != null) {
			managerName.append(" " + manager.getMiddlename());
		}
		if (manager.getLastname() != null) {
			managerName.append(" " + manager.getLastname());
		}
		return managerName.toString();
	}

	public static List<ManagerVO> createManagerList(List<Employee> employeeList) {
		List<ManagerVO> managerList = new ArrayList<ManagerVO>();
		for (Employee employee : employeeList) {
			ManagerVO responseManagerVO = new ManagerVO();
			String name = DashboardUtil.getManagerName(employee);
			responseManagerVO.setName(name);
			responseManagerVO.setId(employee.getId());
			managerList.add(responseManagerVO);
		}
		return managerList;
	}

	public static List<ViewResponseVO> createViewResponseVOList(
			List<Employee> employeeList, IUserManager userManagerImpl) {
		List<ViewResponseVO> viewResponseVOList = new ArrayList<ViewResponseVO>();
			for (Employee employee : employeeList) {
				ViewResponseVO viewResponseVO = new ViewResponseVO();
				viewResponseVO.setId(employee.getId());
				String middleName = employee.getMiddlename();
				String lastName = employee.getLastname();
					viewResponseVO.setMiddlename(middleName);
					viewResponseVO.setLastname(lastName);
				viewResponseVO.setFirstname(employee.getFirstname());
				viewResponseVO.setUsername(employee.getUsername());
				viewResponseVO.setEmpCode(employee.getEmpCode());
				viewResponseVO.setWorkEmail(employee.getWorkEmail());
				viewResponseVO.setManager(DashboardUtil.getManagerName(userManagerImpl.getById(employee.getManagerId())));
				viewResponseVO.setDepartment(employee.getDepartment().getName());
				viewResponseVO.setPermanentOfficePhoneNoWithExtension(employee.getPermanentOfficePhoneNoWithExtension());
				viewResponseVO.setMobileNo(employee.getMobileNo());
				viewResponseVOList.add(viewResponseVO);

			}
return viewResponseVOList;
		
	}

}
