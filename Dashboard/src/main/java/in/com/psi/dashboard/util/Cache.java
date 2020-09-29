package in.com.psi.dashboard.util;

import in.com.psi.dashboard.manager.ICityManager;
import in.com.psi.dashboard.manager.ICompanyDetailsManager;
import in.com.psi.dashboard.manager.ICountryManager;
import in.com.psi.dashboard.manager.IDepartmentManager;
import in.com.psi.dashboard.manager.IDesignationManager;
import in.com.psi.dashboard.manager.IEmployeeTypeManager;
import in.com.psi.dashboard.manager.IHouseManager;
import in.com.psi.dashboard.manager.IPermissionManager;
import in.com.psi.dashboard.manager.IRoleManager;
import in.com.psi.dashboard.manager.IStateManager;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// TODO: Auto-generated Javadoc
/**
 * The Class Cache.
 */
@Component
public class Cache {

	/** The department manager impl. */
	@Autowired
	IDepartmentManager departmentManagerImpl;

	/** The company details manager impl. */
	@Autowired
	ICompanyDetailsManager companyDetailsManagerImpl;

	/** The designation manager impl. */
	@Autowired
	IDesignationManager designationManagerImpl;

	/** The employee type manager impl. */
	@Autowired
	IEmployeeTypeManager employeeTypeManagerImpl;

	/** The house manager impl. */
	@Autowired
	IHouseManager houseManagerImpl;

	/** The role manager impl. */
	@Autowired
	IRoleManager roleManagerImpl;

	/** The permission manager impl. */
	@Autowired
	IPermissionManager permissionManagerImpl;

	/** The country manager impl. */
	@Autowired
	ICountryManager countryManagerImpl;

	/** The state manager impl. */
	@Autowired
	IStateManager stateManagerImpl;

	/** The city manager impl. */
	@Autowired
	ICityManager cityManagerImpl;

	/**
	 * Inits the it.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@PostConstruct
	public void initIt() throws Exception {
		// urlPermission is hashmap with url as key and permissions as value
		DashboardUtil.setPermissionsToUrls();
		/*
		 * DashboardUtil.cacheDepartments(departmentManagerImpl);
		 * DashboardUtil.cacheCompanyDetails(companyDetailsManagerImpl);
		 * DashboardUtil.cacheDesignations(designationManagerImpl);
		 * DashboardUtil.cacheEmployeeType(employeeTypeManagerImpl);
		 * DashboardUtil.cacheHouses(houseManagerImpl);
		 * DashboardUtil.cacheRoles(roleManagerImpl);
		 * DashboardUtil.cachePermissions(permissionManagerImpl);
		 * DashboardUtil.cacheCountries(countryManagerImpl);
		 * DashboardUtil.cacheStates(stateManagerImpl);
		 * DashboardUtil.cacheCities(cityManagerImpl);
		 */
	}
}
