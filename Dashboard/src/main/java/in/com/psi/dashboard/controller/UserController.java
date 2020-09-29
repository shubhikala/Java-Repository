package in.com.psi.dashboard.controller;

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
import in.com.psi.dashboard.entity.ProfessionalDetails;
import in.com.psi.dashboard.entity.Role;
import in.com.psi.dashboard.entity.State;
import in.com.psi.dashboard.entity.WorkExperience;
import in.com.psi.dashboard.entity.VO.AuthenticationVO;
import in.com.psi.dashboard.entity.VO.BaseVO;
import in.com.psi.dashboard.entity.VO.EmployeeVO;
import in.com.psi.dashboard.entity.VO.ManagerVO;
import in.com.psi.dashboard.entity.VO.SearchFilterVO;
import in.com.psi.dashboard.entity.VO.UserVO;
import in.com.psi.dashboard.entity.VO.ViewResponseVO;
import in.com.psi.dashboard.entity.VO.ViewUserVO;
import in.com.psi.dashboard.exception.DashboardException;
import in.com.psi.dashboard.manager.IActionHistoryManager;
import in.com.psi.dashboard.manager.ICityManager;
import in.com.psi.dashboard.manager.ICompanyDetailsManager;
import in.com.psi.dashboard.manager.ICountryManager;
import in.com.psi.dashboard.manager.IDepartmentManager;
import in.com.psi.dashboard.manager.IDesignationManager;
import in.com.psi.dashboard.manager.IEmployeeDocumentsManager;
import in.com.psi.dashboard.manager.IEmployeePermissionManager;
import in.com.psi.dashboard.manager.IEmployeeTypeManager;
import in.com.psi.dashboard.manager.IHouseManager;
import in.com.psi.dashboard.manager.IOtherUserManager;
import in.com.psi.dashboard.manager.IPermissionManager;
import in.com.psi.dashboard.manager.IProfessionalDetailsManager;
import in.com.psi.dashboard.manager.IRoleManager;
import in.com.psi.dashboard.manager.IStateManager;
import in.com.psi.dashboard.manager.IUserManager;
import in.com.psi.dashboard.manager.IWorkExperienceManager;
import in.com.psi.dashboard.util.DashboardConstants;
import in.com.psi.dashboard.util.DashboardMappings;
import in.com.psi.dashboard.util.DashboardUtil;
import in.com.psi.dashboard.util.ValidateInput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

// TODO: Auto-generated Javadoc
/**
 * The Class UserController.
 * 
 */
@Controller
public class UserController {

	/** The logger. */
	private final Logger logger = LoggerFactory.getLogger(UserController.class);

	/** The user manager impl. */
	@Autowired
	IUserManager userManagerImpl;

	/** The other user manager impl. */
	@Autowired
	IOtherUserManager otherUserManagerImpl;

	/** The department manager impl. */
	@Autowired
	IDepartmentManager departmentManagerImpl;

	/** The designation manager impl. */
	@Autowired
	IDesignationManager designationManagerImpl;

	/** The house manager impl. */
	@Autowired
	IHouseManager houseManagerImpl;

	/** The employee type manager impl. */
	@Autowired
	IEmployeeTypeManager employeeTypeManagerImpl;

	/** The company details manager impl. */
	@Autowired
	ICompanyDetailsManager companyDetailsManagerImpl;

	/** The role manager impl. */
	@Autowired
	IRoleManager roleManagerImpl;

	/** The employee documents manager impl. */
	@Autowired
	IEmployeeDocumentsManager employeeDocumentsManagerImpl;

	/** The professional details manager impl. */
	@Autowired
	IProfessionalDetailsManager professionalDetailsManagerImpl;

	/** The work experience manager impl. */
	@Autowired
	IWorkExperienceManager workExperienceManagerImpl;

	/** The permission manager impl. */
	@Autowired
	IPermissionManager permissionManagerImpl;

	/** The city manager impl. */
	@Autowired
	ICityManager cityManagerImpl;

	/** The state manager impl. */
	@Autowired
	IStateManager stateManagerImpl;

	/** The country manager impl. */
	@Autowired
	ICountryManager countryManagerImpl;

	/** The action history manager impl. */
	@Autowired
	IActionHistoryManager actionHistoryManagerImpl;
	
	@Autowired
	IEmployeePermissionManager employeePermissionManagerImpl;

	/**
	 * Login.
	 *
	 * @param authenticationVO
	 *            the authentication vo
	 * @return the string sessionId
	 * @throws DashboardException
	 *             the dashboard exception
	 * @function perform login of the user based on two criterias 1. username
	 *           and password is there(ldap authentication) 2. hostusername,
	 *           hostpassword and username is there(this is an extra security
	 *           level to ensure that only a particular machine can call the
	 *           services)
	 */
	@RequestMapping(method = RequestMethod.POST, value = DashboardMappings.LOGIN)
	public @ResponseBody String login(
			@RequestBody AuthenticationVO authenticationVO)
					throws DashboardException {
		// validating the input
		if (!ValidateInput.validateLoginInput(authenticationVO)) {
			throw new DashboardException(logger, "login",
					DashboardConstants.NO_SET_OF_VALID_CREDENTIALS, null);
		}
		// logging the history
		ActionHistory actionHistory = null;
		String userName = authenticationVO.getUserName();
		String password = authenticationVO.getPassword();
		try {
			actionHistory = DashboardUtil.createActionHistory(userName,
					DashboardMappings.LOGIN, null);
			if (userName != null && password != null) {
				if (userManagerImpl.login(userName, password, actionHistory)) {
					String uuid = DashboardUtil.getUuid();
					DashboardConstants.activeUsers.put(uuid, DashboardUtil
							.activateUser(userName, uuid, userManagerImpl));
					return uuid;
				} else {
					throw new DashboardException(logger, "login",
							DashboardConstants.INVALID_USERNAME_OR_PASSWORD,
							null);
				}
			} else {
				if (otherUserManagerImpl.login(
						authenticationVO.getHostUsername(),
						authenticationVO.getHostPassword(), "10.50.0.70",
						userName, actionHistory)) {
					String uuid = DashboardUtil.getUuid();
					DashboardConstants.activeUsers.put(uuid, DashboardUtil
							.activateUser(userName, uuid, userManagerImpl));
					return uuid;
				} else {
					throw new DashboardException(logger, "login",
							DashboardConstants.INVALID_CREDENTIALS, null);
				}
			}
		} catch (DashboardException e) {
			throw e;
		} catch (Exception e) {
			throw new DashboardException(logger, "login",
					DashboardConstants.REQUEST_NOT_PROCESSED, null, e);
		}
	}

	/**
	 * Renew.
	 *
	 * @param baseVO
	 *            the base vo
	 * @return the string sessionId
	 * @throws DashboardException
	 *             the dashboard exception
	 * @function renew user after timeout. Generates new sessionId and place it
	 *           in the active users list corresponding to that particular user
	 *           record.
	 */
	@RequestMapping(method = RequestMethod.POST, value = DashboardMappings.RENEW)
	public @ResponseBody String renew(@RequestBody BaseVO baseVO)
			throws DashboardException {
		//validating the input
		if (!ValidateInput.validateRenewInput(baseVO)) {
			throw new DashboardException(logger, "renew",
					DashboardConstants.NO_SET_OF_VALID_CREDENTIALS, null);
		}
		//logging the history
		ActionHistory actionHistory = null;
		UserVO userVO = DashboardConstants.activeUsers.get(baseVO
				.getSessionId());
		try {
			if (userVO != null) {
				userVO.setLastInteractionTime(DashboardUtil.getCurrentTime());
				String uuid = DashboardUtil.getUuid();
				DashboardConstants.activeUsers.put(uuid, userVO);
				actionHistory = DashboardUtil.createActionHistory(
						userVO.getUserName(), DashboardMappings.RENEW, null);
				actionHistoryManagerImpl.save(actionHistory);
				return uuid;
			} else {
				throw new DashboardException(logger, "renew",
						DashboardConstants.SESSION_ID_NOT_FOUND, null);
			}
		} catch (DashboardException e) {
			throw e;
		} catch (Exception e) {
			throw new DashboardException(logger, "renew",
					DashboardConstants.REQUEST_NOT_PROCESSED, null, e);
		}
	}

	/**
	 * Ldap authenticated.
	 *
	 * @param authenticationVO
	 *            the authentication vo
	 * @return the string sessionId
	 * @throws DashboardException
	 * @function   the dashboard exception ldap authentication for critical
	 *             actions. Generates new session id and place it in active
	 *             users list corresponding to that particular user record.
	 */
	@RequestMapping(method = RequestMethod.POST, value = DashboardMappings.LDAPAUTHENTICATION)
	public @ResponseBody String ldapAuthentication(
			@RequestBody AuthenticationVO authenticationVO)
					throws DashboardException {
		//validating the input
		if (!ValidateInput.validateLdapInput(authenticationVO)) {
			throw new DashboardException(logger, "ldapAuthentication",
					DashboardConstants.NO_SET_OF_VALID_CREDENTIALS, null);
		}
		//logging the history
		ActionHistory actionHistory = null;
		String sessionId = authenticationVO.getSessionId();
		UserVO userVO = DashboardConstants.activeUsers.get(sessionId);
		if (userVO != null) {
			if (userVO.isLDAPAuthenticated()) {
				return sessionId;
			}
			actionHistory = DashboardUtil.createActionHistory(
					userVO.getUserName(), DashboardMappings.LDAPAUTHENTICATION,
					null);
			try {
				if (userManagerImpl.login(authenticationVO.getUserName(),
						authenticationVO.getPassword(), actionHistory)) {

					userVO.setLastInteractionTime(DashboardUtil
							.getCurrentTime());
					userVO.setLDAPAuthenticated(true);
					String uuid = DashboardUtil.getUuid();
					DashboardConstants.activeUsers.put(uuid, userVO);
					return uuid;

				} else {
					throw new DashboardException(logger, "ldapAuthentication",
							DashboardConstants.INVALID_USERNAME_OR_PASSWORD,
							null);
				}
			} catch (Exception e) {
				throw new DashboardException(logger, "ldapAuthentication",
						DashboardConstants.REQUEST_NOT_PROCESSED, null, e);
			}
		} else {
			throw new DashboardException(logger, "ldapAuthentication",
					DashboardConstants.SESSION_ID_NOT_FOUND, null);
		}
	}

	/**
	 * Adds the user.
	 *
	 * @param employeeVO
	 *            the employee vo
	 * @return the string
	 * @throws DashboardException
	 *             the dashboard exception
	 * @function   add user to database
	 */
	@RequestMapping(method = RequestMethod.POST, value = DashboardMappings.ADD_USER)
	public @ResponseBody String addUser(@RequestBody EmployeeVO employeeVO)
			throws DashboardException {
		// logging the history
		ActionHistory actionHistory = null;
		if (DashboardUtil.checkSession(employeeVO.getSessionId())) {
			ValidateInput.validateAddOrUpdateUserInput(employeeVO, DashboardMappings.ADD_USER);
			// checking permission
			String urlPermission = DashboardConstants.urlPermission
					.get(DashboardMappings.ADD_USER);
			if (DashboardConstants.activeUsers.get(employeeVO.getSessionId())
					.getPermissions().contains(urlPermission)) {
				HashMap<String, Object> masterObjects = getMasterObjectsById(employeeVO);
				Employee employee = new Employee();
				DashboardUtil.createEmployee((Department) masterObjects
						.get(DashboardConstants.DEPARTMENT),
						(Designation) masterObjects
								.get(DashboardConstants.DESIGNATION),
						(House) masterObjects.get(DashboardConstants.HOUSE),
						(EmployeeType) masterObjects
								.get(DashboardConstants.EMPLOYEE_TYPE),
						(CompanyDetails) masterObjects
								.get(DashboardConstants.COMPANY_DETAILS),
						(Role) masterObjects.get(DashboardConstants.ROLE),
						employeeVO, employee, (City) masterObjects
								.get(DashboardConstants.PRESENT_CITY),
						(City) masterObjects
								.get(DashboardConstants.PERMANENT_CITY),
						(State) masterObjects
								.get(DashboardConstants.PRESENT_STATE),
						(State) masterObjects
								.get(DashboardConstants.PERMANENT_STATE),
						(Country) masterObjects
								.get(DashboardConstants.PRESENT_COUNTRY),
						(Country) masterObjects
								.get(DashboardConstants.PERMANENT_COUNTRY));

				List<EmployeePermission> employeePermissionList = new ArrayList<EmployeePermission>();
				DashboardUtil
						.createEmployeePermission(employeeVO,null,
								permissionManagerImpl, employee,
								employeePermissionList);

				List<EmployeeDocuments> employeeDocumentsList = new ArrayList<EmployeeDocuments>();
				if (employeeVO.getDocument() != null) {
					DashboardUtil.createEmployeeDocuments(employeeVO, null, employee,
							employeeDocumentsList);
				}

				ProfessionalDetails professionalDetails = new ProfessionalDetails();
				DashboardUtil.createProfessionalDetails(employeeVO, employee,
						professionalDetails);
				WorkExperience workExperience = new WorkExperience();
				DashboardUtil.createWorkExperience(employeeVO, employee,
						workExperience);

				DashboardUtil.createActionHistory(
						DashboardConstants.activeUsers.get(
								employeeVO.getSessionId()).getUserName(),
						DashboardMappings.ADD_USER, employeeVO.getUsername());
				try {

					userManagerImpl.saveEmployee(employee,
							employeeDocumentsList, professionalDetails,
							workExperience, employeePermissionList,
							actionHistory);
				} catch (ConstraintViolationException e) {
					throw new DashboardException(logger, "addUser",
							DashboardConstants.USER_ALREADY_EXISTS, null, e);
				} catch (Exception e) {
					throw new DashboardException(logger, "addUser",
							DashboardConstants.REQUEST_NOT_PROCESSED, null, e);
				}

			} else {
				throw new DashboardException(logger, "addUser",
						DashboardConstants.NOT_ALLOWED_TO_ADD_NEW_USER, null);
			}
		}
		return DashboardConstants.USER_ADDED_SUCCESSFULLY;
	}

	/**
	 * View user.
	 *
	 * @param employeeVO
	 *            the request employee vo
	 * @return the view response vo
	 * @throws DashboardException
	 *             the dashboard exception
	 */
	@RequestMapping(method = RequestMethod.POST, value = DashboardMappings.VIEW_USER)
	public @ResponseBody ViewResponseVO viewUser(
			@RequestBody EmployeeVO employeeVO)
			throws DashboardException {
		ViewResponseVO viewResponseVO = new ViewResponseVO();
		if (DashboardUtil.checkSession(employeeVO.getSessionId())) {
			Employee employee = null;
			try {
				String userName = null;
				if (employeeVO.getUsername() == null) {
					userName = DashboardConstants.activeUsers.get(
							employeeVO.getSessionId()).getUserName();
				} else {
					userName = employeeVO.getUsername();
				}
				ViewUserVO viewUserVO = userManagerImpl.viewUser(userName);
				employee = viewUserVO.getEmployee();
				if (employee != null) {
					// to set the name of the manager
					Employee manager = userManagerImpl.getById(employee.getManagerId());
					String managerName = DashboardUtil.getManagerName(manager);
					DashboardUtil.setEmployeeProperties(employee,
							viewResponseVO, managerName);
				} else {
					throw new DashboardException(logger, "viewUser",
							DashboardConstants.USER_NOT_EXISTS, null);
				}
				List<EmployeeDocuments> employeeDocumentsList = viewUserVO
						.getEmployeeDocuments();
				if (employeeDocumentsList != null
						&& !(employeeDocumentsList.isEmpty())) {
					DashboardUtil.setEmployeeDocumentsProperties(
							employeeDocumentsList, viewResponseVO);
				}
				WorkExperience workExperience = viewUserVO.getWorkExperience();
				if (workExperience != null) {
					DashboardUtil.setWorkExperienceProperties(workExperience,
							viewResponseVO);
				}
				ProfessionalDetails professionalDetails = viewUserVO
						.getProfessionalDetails();
				if (professionalDetails != null) {
					DashboardUtil.setProfessionalDetailsProperties(
							professionalDetails, viewResponseVO);
				}
			} catch (DashboardException e) {
				throw e;
			} catch (Exception e) {

				throw new DashboardException(logger, "viewUser",
						DashboardConstants.REQUEST_NOT_PROCESSED, null, e);
			}
		}
		return viewResponseVO;
	}

	/**
	 * List proposed employee code.
	 *
	 * @param baseVO
	 *            the base vo
	 * @return the integer
	 * @throws DashboardException
	 *             the dashboard exception
	 */
	@RequestMapping(method = RequestMethod.POST, value = DashboardMappings.LIST_PROPOSED_EMPLOYEE_CODE)
	public @ResponseBody Integer listProposedEmployeeCode(
			@RequestBody BaseVO baseVO) throws DashboardException {
		Integer empCode = 0;
		try{
		if (DashboardUtil.checkSession(baseVO.getSessionId())) {
			empCode = userManagerImpl.listProposedEmployeeCode();
		} 
		}catch(Exception e){
			throw new DashboardException(logger, "listProposedEmployeeCode",
					DashboardConstants.REQUEST_NOT_PROCESSED, null, e);
		}
		return empCode;
	}

	/**
	 * List manager.
	 *
	 * @param managerVO
	 *            the request manager vo
	 * @return the list
	 * @throws DashboardException
	 *             the dashboard exception
	 */
	@RequestMapping(method = RequestMethod.POST, value = DashboardMappings.LIST_MANAGER)
	public @ResponseBody List<ManagerVO> listManager(
			@RequestBody ManagerVO managerVO) throws DashboardException {
		List<ManagerVO> managerList = null;
		List<Employee> employeeList = null;
		if (DashboardUtil.checkSession(managerVO.getSessionId())) {
			try {
				employeeList = userManagerImpl.listByName(managerVO.getName());
				if (employeeList.size() == 0) {
					throw new DashboardException(logger, "listManager",
							DashboardConstants.MANAGER_NOT_FOUND, null);
				}
			} catch (DashboardException e) {
				throw e;
			} catch (Exception e) {

				throw new DashboardException(logger, "listManager",
						DashboardConstants.REQUEST_NOT_PROCESSED, null, e);
			}
			managerList = DashboardUtil.createManagerList(employeeList);
		}
		return managerList;
	}

	/**
	 * Update user.
	 *
	 * @param employeeVO
	 *            the employee vo
	 * @return the string
	 * @throws DashboardException
	 *             the dashboard exception
	 */
	@RequestMapping(method = RequestMethod.POST, value = DashboardMappings.UPDATE_USER)
	public @ResponseBody String updateUser(@RequestBody EmployeeVO employeeVO)
			throws DashboardException {
		ActionHistory actionHistory = null;
		if (DashboardUtil.checkSession(employeeVO.getSessionId())) {
			String urlPermission = DashboardConstants.urlPermission
					.get(DashboardMappings.UPDATE_USER);
			if (DashboardConstants.activeUsers.get(employeeVO.getSessionId())
					.getPermissions().contains(urlPermission)) {
				// first argument is username of updater
				// checking permission of this particular update
				if (checkPermission(
						DashboardConstants.activeUsers.get(
								employeeVO.getSessionId()).getUserName(),
						employeeVO)) {
					ValidateInput.validateAddOrUpdateUserInput(employeeVO,
							DashboardMappings.UPDATE_USER);
					try {
						Employee oldEmployee = userManagerImpl
								.getById(employeeVO.getId());
						// to send old employee object as argument for updation
						Employee employee = oldEmployee;
						HashMap<String, Object> masterObjects = getMasterObjectsById(employeeVO);

						DashboardUtil
								.createEmployee(
										(Department) masterObjects
												.get(DashboardConstants.DEPARTMENT),
										(Designation) masterObjects
												.get(DashboardConstants.DESIGNATION),
										(House) masterObjects
												.get(DashboardConstants.HOUSE),
										(EmployeeType) masterObjects
												.get(DashboardConstants.EMPLOYEE_TYPE),
										(CompanyDetails) masterObjects
												.get(DashboardConstants.COMPANY_DETAILS),
										(Role) masterObjects
												.get(DashboardConstants.ROLE),
										employeeVO,
										employee,
										(City) masterObjects
												.get(DashboardConstants.PRESENT_CITY),
										(City) masterObjects
												.get(DashboardConstants.PERMANENT_CITY),
										(State) masterObjects
												.get(DashboardConstants.PRESENT_STATE),
										(State) masterObjects
												.get(DashboardConstants.PERMANENT_STATE),
										(Country) masterObjects
												.get(DashboardConstants.PRESENT_COUNTRY),
										(Country) masterObjects
												.get(DashboardConstants.PERMANENT_COUNTRY));

						List<EmployeePermission> employeePermissionsList = userManagerImpl
								.getSavedEmployeePermission(oldEmployee);
						if (employeePermissionsList == null) {
							employeePermissionsList = new ArrayList<EmployeePermission>();
						}
						DashboardUtil.createEmployeePermission(employeeVO,
								employeePermissionManagerImpl,
								permissionManagerImpl, employee,
								employeePermissionsList);

						List<EmployeeDocuments> employeeDocumentsList = userManagerImpl
								.getSavedEmployeeDocuments(oldEmployee);
						if (employeeVO.getDocument() != null) {
							if (employeeDocumentsList == null) {
								employeeDocumentsList = new ArrayList<EmployeeDocuments>();
							}
							DashboardUtil.createEmployeeDocuments(employeeVO,
									employeeDocumentsManagerImpl, employee,
									employeeDocumentsList);
						} else {
							for (EmployeeDocuments employeeDocuments : employeeDocumentsList) {
								employeeDocumentsManagerImpl
										.delete(employeeDocuments);
							}
						}

						ProfessionalDetails professionalDetails = userManagerImpl
								.getSavedProfessionalDetails(oldEmployee);
						if (professionalDetails == null) {
							professionalDetails = new ProfessionalDetails();
						}
						DashboardUtil.createProfessionalDetails(employeeVO,
								employee, professionalDetails);
						WorkExperience workExperience = userManagerImpl
								.getSavedWorkExperience(oldEmployee);
						if (workExperience == null) {
							workExperience = new WorkExperience();
						}
						DashboardUtil.createWorkExperience(employeeVO,
								employee, workExperience);
						DashboardUtil.createActionHistory(
								DashboardConstants.activeUsers.get(
										employeeVO.getSessionId())
										.getUserName(),
								DashboardMappings.UPDATE_USER, employeeVO
										.getUsername());
						userManagerImpl.updateEmployee(employee,
								employeeDocumentsList, professionalDetails,
								workExperience, employeePermissionsList,
								actionHistory);
					} catch (DashboardException e) {
						throw e;
					} catch (Exception e) {

						throw new DashboardException(logger, "saveEmployee",
								DashboardConstants.REQUEST_NOT_PROCESSED, null,
								e);
					}

				} else {
					throw new DashboardException(logger, "addUser",
							DashboardConstants.NOT_ALLOWED_TO_UPDATE_USER, null);
				}
			}
		}

		return DashboardConstants.USER_UPDATED_SUCCESSFULLY;
	}

	/**
	 * Search user.
	 *
	 * @param searchFilterVO
	 *            the search filter vo
	 * @return the list
	 * @throws DashboardException
	 *             the dashboard exception
	 */
	
	@RequestMapping(method = RequestMethod.POST, value = DashboardMappings.LIST_SUBORDINATES)
	public @ResponseBody List<ViewResponseVO> listsubordinates(
			@RequestBody BaseVO baseVO) throws DashboardException {
		List<ViewResponseVO> viewResponseVOList = null;
		if (DashboardUtil.checkSession(baseVO.getSessionId())) {
			String managerUserName = DashboardConstants.activeUsers.get(
					baseVO.getSessionId()).getUserName();
			try {
				List<Employee> employeeList = userManagerImpl
						.listSubordinates(managerUserName);
				viewResponseVOList = DashboardUtil.createViewResponseVOList(
						employeeList, userManagerImpl);
			} catch (Exception e) {
				throw new DashboardException(logger, "listSubordinates",
						DashboardConstants.REQUEST_NOT_PROCESSED, null);
			}
		}
		return viewResponseVOList;

	}
	
	
	
	@RequestMapping(method = RequestMethod.POST, value = DashboardMappings.SEARCH_USER)
	public @ResponseBody List<ViewResponseVO> searchUser(
			@RequestBody SearchFilterVO searchFilterVO)
			throws DashboardException {
		List<ViewResponseVO> viewResponseVOList = null;
		if (DashboardUtil.checkSession(searchFilterVO.getSessionId())) {
			Department department = null;
			Designation designation = null;
			EmployeeType employeeType = null;
			Integer departmentId = searchFilterVO.getDepartmentId();
			Integer designationId = searchFilterVO.getDesignationId();
			Integer employeeTypeId = searchFilterVO.getEmployeeTypeId();
			try {
				if (departmentId != null) {
					department = departmentManagerImpl.getById(departmentId);
					if (department == null) {
						throw new DashboardException(logger, "searchUser",
								DashboardConstants.DEPARTMENT_ID_NOT_FOUND,
								null);
					}
				}
				if (designationId != null) {
					designation = designationManagerImpl.getById(designationId);
					if (designation == null) {
						throw new DashboardException(logger, "searchUser",
								DashboardConstants.DESIGNATION_NOT_FOUND, null);
					}
				}
				if (employeeTypeId != null) {
					employeeType = employeeTypeManagerImpl
							.getById(employeeTypeId);
					if (employeeType == null) {
						throw new DashboardException(logger, "searchUser",
								DashboardConstants.EMPLOYEE_TYPE_ID_NOT_FOUND,
								null);
					}
				}

				List<Employee> employeeList = userManagerImpl.searchUser(
						searchFilterVO, department, designation, employeeType);

				viewResponseVOList = DashboardUtil.createViewResponseVOList(
						employeeList, userManagerImpl);
			} catch (DashboardException e) {
				throw e;
			} catch (Exception e) {
				throw new DashboardException(logger, "searchUser",
						DashboardConstants.REQUEST_NOT_PROCESSED, null, e);
			}
		}
		return viewResponseVOList;
	}

	/**
	 * Download report.
	 *
	 * @param searchFilterVO
	 *            the search filter vo
	 * @param httpServletRequest
	 *            the http servlet request
	 * @param httpServletResponse
	 *            the http servlet response
	 * @throws DashboardException
	 *             the dashboard exception
	 */
	@RequestMapping(method = RequestMethod.POST, value = DashboardMappings.DOWNLOAD_REPORT)
	public @ResponseBody void downloadReport(
			@ModelAttribute SearchFilterVO searchFilterVO,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws DashboardException {
		// if (DashboardUtil.checkSession(searchFilterVO.getSessionId())) {
		List<Employee> employeeList = null;
		Department department = null;
		Designation designation = null;
		EmployeeType employeeType = null;
		Integer departmentId = searchFilterVO.getDepartmentId();
		Integer designationId = searchFilterVO.getDesignationId();
		Integer employeeTypeId = searchFilterVO.getEmployeeTypeId();
		try {
			if (departmentId != null) {
				department = departmentManagerImpl.getById(departmentId);
			}
			if (designationId != null) {
				designation = designationManagerImpl.getById(designationId);
			}
			if(employeeTypeId != null){
				employeeType = employeeTypeManagerImpl.getById(employeeTypeId);
			}
		
		employeeList = userManagerImpl.searchUser(
				searchFilterVO, department, designation, employeeType);
		} catch (Exception e) {
			throw new DashboardException(logger, "searchUser",
					DashboardConstants.REQUEST_NOT_PROCESSED, null, e);
		}
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("REPORT");
			Integer rowCount = 0;
			CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
			XSSFFont font = sheet.getWorkbook().createFont();
			font.setBold(true);
			font.setFontHeightInPoints((short) 12);
			cellStyle.setFont(font);
			Row row = sheet.createRow(++rowCount);
			Integer columnCount = 0;
			Cell cell = row.createCell(++columnCount);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(DashboardConstants.NAME);
			cell = row.createCell(++columnCount);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(DashboardConstants.EMPLOYEE_ID);
			cell = row.createCell(++columnCount);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(DashboardConstants.EMPLOYEE_CODE);
			cell = row.createCell(++columnCount);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(DashboardConstants.USERNAME);
			for (Employee employee : employeeList) {
				row = sheet.createRow(++rowCount);

				columnCount = 0;
				cell = row.createCell(++columnCount);
				String name = null;
				if (employee.getFirstname() != null) {
					name = employee.getFirstname();
				}
				if (employee.getMiddlename() != null) {
					name = name + " " + employee.getMiddlename();
				}
				if (employee.getLastname() != null) {
					name = name + " " + employee.getLastname();
				}
				cell.setCellValue((String) name);
				cell = row.createCell(++columnCount);
				cell.setCellValue((Long) employee.getId());
				cell = row.createCell(++columnCount);
				cell.setCellValue((Integer) employee.getEmpCode());
				cell = row.createCell(++columnCount);
				cell.setCellValue((String) employee.getUsername());
			}
			for (Integer index = 1; index <= columnCount; index++) {
				sheet.autoSizeColumn(index);
			}
			try {
				httpServletResponse.setContentType("application/vnd.ms-excel");
				httpServletResponse.setHeader("Content-Disposition",
						"attachment; filename=filename.xlsx");
				ServletOutputStream outputStream = httpServletResponse
						.getOutputStream();
				workbook.write(outputStream);// Write workbook to response.
				outputStream.close();
			} catch (Exception e) {
				throw new DashboardException(logger, "downloadReport",
						DashboardConstants.UNABLE_TO_WRITE, null, e);
			}
		

	}

	/**
	 * Gets the master objects by id.
	 *
	 * @param employeeVO
	 *            the employee vo
	 * @return the master objects by id
	 * @throws DashboardException
	 *             the dashboard exception
	 */
	private HashMap<String, Object> getMasterObjectsById(EmployeeVO employeeVO)
			throws DashboardException {
		HashMap<String, Object> objects = new HashMap<String, Object>();
		try {
			Department department = departmentManagerImpl.getById(employeeVO
					.getDepartmentId());
			if (department == null) {
				throw new DashboardException(logger, "getMasterObjectsById",
						DashboardConstants.DEPARTMENT_ID_NOT_FOUND, null);
			} else {
				objects.put(DashboardConstants.DEPARTMENT, department);
			}
			Designation designation = designationManagerImpl.getById(employeeVO
					.getDesignationId());
			if (designation == null) {
				throw new DashboardException(logger, "getMasterObjectsById",
						DashboardConstants.DESIGNATION_ID_NOT_FOUND, null);
			} else {
				objects.put(DashboardConstants.DESIGNATION, designation);
			}
			House house = houseManagerImpl.getById(employeeVO.getHouseId());
			if (house == null) {
				throw new DashboardException(logger, "getMasterObjectsById",
						DashboardConstants.HOUSE_ID_NOT_FOUND, null);
			} else {
				objects.put(DashboardConstants.HOUSE, house);
			}
			EmployeeType employeeType = employeeTypeManagerImpl
					.getById(employeeVO.getEmployeeTypeId());
			if (employeeType == null) {
				throw new DashboardException(logger, "getMasterObjectsById",
						DashboardConstants.EMPLOYEE_TYPE_ID_NOT_FOUND, null);
			} else {
				objects.put(DashboardConstants.EMPLOYEE_TYPE, employeeType);
			}
			CompanyDetails companyDetails = companyDetailsManagerImpl
					.getById(employeeVO.getCompanyDetailsId());
			if (companyDetails == null) {
				throw new DashboardException(logger, "getMasterObjectsById",
						DashboardConstants.COMPANY_DETAILS_ID_NOT_FOUND, null);
			} else {
				objects.put(DashboardConstants.COMPANY_DETAILS, companyDetails);
			}
			Role role = roleManagerImpl.getById(employeeVO.getRoleId());
			if (role == null) {
				throw new DashboardException(logger, "getMasterObjectsById",
						DashboardConstants.ROLE_ID_NOT_FOUND, null);
			} else {
				objects.put(DashboardConstants.ROLE, role);
			}
			City presentCity = cityManagerImpl.getById(employeeVO
					.getPresentCityId());
			if (presentCity == null) {
				throw new DashboardException(logger, "getMasterObjectsById",
						DashboardConstants.CITY_ID_NOT_FOUND, null);
			} else {
				objects.put(DashboardConstants.PRESENT_CITY, presentCity);
			}
			City permanentCity = cityManagerImpl.getById(employeeVO
					.getPermanentCityId());
			if (permanentCity == null) {
				throw new DashboardException(logger, "getMasterObjectsById",
						DashboardConstants.CITY_ID_NOT_FOUND, null);
			} else {
				objects.put(DashboardConstants.PERMANENT_CITY, permanentCity);
			}
			State presentState = stateManagerImpl.getById(employeeVO
					.getPresentStateId());
			if (presentState == null) {
				throw new DashboardException(logger, "getMasterObjectsById",
						DashboardConstants.STATE_ID_NOT_FOUND, null);
			} else {
				objects.put(DashboardConstants.PRESENT_STATE, presentState);
			}
			State permanentState = stateManagerImpl.getById(employeeVO
					.getPermanentStateId());
			if (permanentState == null) {
				throw new DashboardException(logger, "getMasterObjectsById",
						DashboardConstants.STATE_ID_NOT_FOUND, null);
			} else {
				objects.put(DashboardConstants.PERMANENT_STATE, permanentState);
			}
			Country presentCountry = countryManagerImpl.getById(employeeVO
					.getPresentCountryId());
			if (presentCountry == null) {
				throw new DashboardException(logger, "getMasterObjectsById",
						DashboardConstants.COUNTRY_ID_NOT_FOUND, null);
			} else {
				objects.put(DashboardConstants.PRESENT_COUNTRY, presentCountry);
			}
			Country permanentCountry = countryManagerImpl.getById(employeeVO
					.getPermanentCountryId());
			if (permanentCountry == null) {
				throw new DashboardException(logger, "getMasterObjectsById",
						DashboardConstants.COUNTRY_ID_NOT_FOUND, null);
			} else {
				objects.put(DashboardConstants.PERMANENT_COUNTRY,
						permanentCountry);
			}
		} catch (DashboardException e) {
			throw e;
		} catch (Exception e) {
			throw new DashboardException(logger, "getMasterObjectsById",
					DashboardConstants.REQUEST_NOT_PROCESSED, null);
		}
		return objects;

	}

	/**
	 * Check permission.
	 *
	 * @param updaterUsername
	 *            the updater username
	 * @param employeeVO
	 *            the employee vo
	 * @return true, if successful
	 * @throws DashboardException
	 *             the dashboard exception
	 */
	private boolean checkPermission(String updaterUsername,
			EmployeeVO employeeVO) throws DashboardException {
		try {
			return userManagerImpl.checkPermission(updaterUsername, employeeVO);
		} catch (Exception e) {
			throw new DashboardException(logger, "checkpermission",
					DashboardConstants.REQUEST_NOT_PROCESSED, null, e);
		}
	}
}
