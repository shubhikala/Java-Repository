package in.com.psi.dashboard.manager.impl;

import in.com.psi.dashboard.dao.IBaseDao;
import in.com.psi.dashboard.dao.IEmployeeDocumentsDao;
import in.com.psi.dashboard.dao.IEmployeePermissionDao;
import in.com.psi.dashboard.dao.IProfessionalDetailsDao;
import in.com.psi.dashboard.dao.IUserDao;
import in.com.psi.dashboard.dao.IWorkExperienceDao;
import in.com.psi.dashboard.entity.ActionHistory;
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
import in.com.psi.dashboard.entity.VO.ViewUserVO;
import in.com.psi.dashboard.exception.DashboardException;
import in.com.psi.dashboard.manager.IActionHistoryManager;
import in.com.psi.dashboard.manager.IUserManager;
import in.com.psi.dashboard.util.DashboardUtil;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// TODO: Auto-generated Javadoc
/**
 * The Class UserManagerImpl.
 */
@Service
@Transactional
public class UserManagerImpl extends
		BaseManagerImpl<Employee, IBaseDao<Employee>> implements IUserManager {

	/** The user dao impl. */
	@Autowired
	IUserDao userDaoImpl;

	/** The employee documents dao impl. */
	@Autowired
	IEmployeeDocumentsDao employeeDocumentsDaoImpl;

	/** The work experience dao impl. */
	@Autowired
	IWorkExperienceDao workExperienceDaoImpl;

	/** The professional details dao impl. */
	@Autowired
	IProfessionalDetailsDao professionalDetailsDaoImpl;

	/** The employee permission dao impl. */
	@Autowired
	IEmployeePermissionDao employeePermissionDaoImpl;
	
	@Autowired
	IActionHistoryManager actionHistoryManagerImpl;

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.com.psi.mystay.manager.impl.BaseManagerImpl#getDao()
	 */
	@Override
	public IBaseDao<Employee> getDao() {
		return userDaoImpl;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.com.psi.dashboard.manager.IUserManager#login(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public boolean login(String userName, String password, ActionHistory actionHistory)
			throws DashboardException {
		boolean result = false;
		result = userDaoImpl.login(userName, password);
		if(result){
			actionHistoryManagerImpl.save(actionHistory);
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * in.com.psi.dashboard.manager.IUserManager#populatePermissions(java.lang
	 * .String)
	 */
	@Override
	public List<EmployeePermission> populatePermissions(String userName) {
		return userDaoImpl.populatePermissions(userName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * in.com.psi.dashboard.manager.IUserManager#saveEmployee(in.com.psi.dashboard
	 * .entity.Employee, java.util.List,
	 * in.com.psi.dashboard.entity.ProfessionalDetails,
	 * in.com.psi.dashboard.entity.WorkExperience, java.util.List)
	 */
	@Override
	public void saveEmployee(Employee employee,
			List<EmployeeDocuments> employeeDocumentsList,
			ProfessionalDetails professionalDetails,
			WorkExperience workExperience,
			List<EmployeePermission> employeePermissionList, ActionHistory actionHistory)
			 {

		userDaoImpl.save(employee);

		if (employeeDocumentsList != null) {
			for (EmployeeDocuments employeeDocuments : employeeDocumentsList) {
				if (employeeDocuments != null) {
					employeeDocumentsDaoImpl.save(employeeDocuments);
				}
			}
		}
		for (EmployeePermission employeePermission : employeePermissionList) {
			employeePermissionDaoImpl.save(employeePermission);
		}
		workExperienceDaoImpl.save(workExperience);
		if (professionalDetails.getCertifications() != null
				|| professionalDetails.getQualifications() != null
				|| professionalDetails.getSkillSet() != null) {
			professionalDetailsDaoImpl.save(professionalDetails);
		}

		actionHistoryManagerImpl.save(actionHistory);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.com.psi.dashboard.manager.IUserManager#viewUser(java.lang.String)
	 */
	@Override
	public ViewUserVO viewUser(String userName) {
		ViewUserVO viewUserVO = null;
		Employee employee = userDaoImpl.viewUser(userName);
		List<EmployeeDocuments> employeeDocumentsList = employeeDocumentsDaoImpl
				.viewUser(employee);
		WorkExperience workExperience = workExperienceDaoImpl
				.viewUser(employee);
		ProfessionalDetails professionalDetails = professionalDetailsDaoImpl
				.viewUser(employee);

		viewUserVO = DashboardUtil.createViewUserVO(employee,
				employeeDocumentsList, workExperience, professionalDetails);
		return viewUserVO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.com.psi.dashboard.manager.IUserManager#listProposedEmployeeCode()
	 */
	@Override
	public Integer listProposedEmployeeCode() {
		return userDaoImpl.listProposedEmployeeCode();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * in.com.psi.dashboard.manager.IUserManager#listByName(java.lang.String)
	 */
	@Override
	public List<Employee> listByName(String name) {
		return userDaoImpl.listByName(name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * in.com.psi.dashboard.manager.IUserManager#checkPermission(java.lang.String
	 * , in.com.psi.dashboard.entity.VO.EmployeeVO)
	 */
	@Override
	public boolean checkPermission(String updaterUsername, EmployeeVO employeeVO) {
		return userDaoImpl.checkPermission(updaterUsername, employeeVO);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * in.com.psi.dashboard.manager.IUserManager#updateEmployee(in.com.psi.dashboard
	 * .entity.Employee, java.util.List,
	 * in.com.psi.dashboard.entity.ProfessionalDetails,
	 * in.com.psi.dashboard.entity.WorkExperience, java.util.List)
	 */
	@Override
	public void updateEmployee(Employee employee,
			List<EmployeeDocuments> employeeDocumentsList,
			ProfessionalDetails professionalDetails,
			WorkExperience workExperience,
			List<EmployeePermission> employeePermissionList,
			ActionHistory actionHistory) {
		userDaoImpl.saveOrUpdate(employee);

		for (EmployeeDocuments employeeDocuments : employeeDocumentsList) {
			employeeDocumentsDaoImpl.saveOrUpdate(employeeDocuments);
		}
		for (EmployeePermission employeePermission : employeePermissionList) {
			employeePermissionDaoImpl.saveOrUpdate(employeePermission);
		}
		workExperienceDaoImpl.saveOrUpdate(workExperience);
		professionalDetailsDaoImpl.saveOrUpdate(professionalDetails);
		actionHistoryManagerImpl.save(actionHistory);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * in.com.psi.dashboard.manager.IUserManager#getSavedEmployeePermission(
	 * in.com.psi.dashboard.entity.Employee)
	 */
	@Override
	public List<EmployeePermission> getSavedEmployeePermission(Employee employee) {
		return userDaoImpl.getSavedEmployeePermission(employee);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * in.com.psi.dashboard.manager.IUserManager#getSavedEmployeeDocuments(in
	 * .com.psi.dashboard.entity.Employee)
	 */
	@Override
	public List<EmployeeDocuments> getSavedEmployeeDocuments(Employee employee) {
		return userDaoImpl.getSavedEmployeeDocuments(employee);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * in.com.psi.dashboard.manager.IUserManager#getSavedProfessionalDetails
	 * (in.com.psi.dashboard.entity.Employee)
	 */
	@Override
	public ProfessionalDetails getSavedProfessionalDetails(Employee employee) {
		return userDaoImpl.getSavedProfessionalDetails(employee);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * in.com.psi.dashboard.manager.IUserManager#getSavedWorkExperience(in.com
	 * .psi.dashboard.entity.Employee)
	 */
	@Override
	public WorkExperience getSavedWorkExperience(Employee employee) {
		return userDaoImpl.getSavedWorkExperience(employee);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * in.com.psi.dashboard.manager.IUserManager#searchUser(in.com.psi.dashboard
	 * .entity.VO.SearchFilterVO)
	 */
	@Override
	public List<Employee> searchUser(SearchFilterVO searchFilterVO,
			Department department, Designation designation, EmployeeType employeeType) {
		return userDaoImpl.searchUser(searchFilterVO, department, designation, employeeType);
	}

	@Override
	public List<Employee> listSubordinates(String managerUserName) {
		return userDaoImpl.listSubordinates(managerUserName);
	}

}
