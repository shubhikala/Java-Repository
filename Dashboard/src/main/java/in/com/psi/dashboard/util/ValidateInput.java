package in.com.psi.dashboard.util;

import in.com.psi.dashboard.entity.VO.AuthenticationVO;
import in.com.psi.dashboard.entity.VO.BaseVO;
import in.com.psi.dashboard.entity.VO.EmployeeVO;
import in.com.psi.dashboard.exception.DashboardException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class ValidateInput.
 */
public class ValidateInput {

	/** The Constant logger. */
	private final static Logger logger = LoggerFactory
			.getLogger(ValidateInput.class);

	/**
	 * Validate login input.
	 *
	 * @param authenticationVO
	 *            the authentication vo
	 * @return true, if successful
	 */
	public static boolean validateLoginInput(AuthenticationVO authenticationVO) {
		boolean result = false;
		if ((authenticationVO.getHostUsername() != null
				&& authenticationVO.getHostPassword() != null && authenticationVO
				.getUserName() != null)
				|| (authenticationVO.getUserName() != null && authenticationVO
						.getPassword() != null)) {
			result = true;
		}
		return result;
	}

	/**
	 * Validate renew input.
	 *
	 * @param baseVO
	 *            the base vo
	 * @return true, if successful
	 */
	public static boolean validateRenewInput(BaseVO baseVO) {
		boolean result = false;
		if (baseVO.getSessionId() != null) {
			result = true;
		}
		return result;
	}

	/**
	 * Validate ldap input.
	 *
	 * @param authenticationVO
	 *            the authentication vo
	 * @return true, if successful
	 */
	public static boolean validateLdapInput(AuthenticationVO authenticationVO) {
		boolean result = false;
		if (authenticationVO.getSessionId() != null
				&& authenticationVO.getUserName() != null
				&& authenticationVO.getPassword() != null) {
			result = true;
		}
		return result;
	}

	/**
	 * Validate add or update user input.
	 *
	 * @param employeeVO
	 *            the employee vo
	 * @param url 
	 * @throws DashboardException
	 *             the dashboard exception
	 */
	public static void validateAddOrUpdateUserInput(EmployeeVO employeeVO,
			String url) throws DashboardException {
		if (url == DashboardMappings.UPDATE_USER && employeeVO.getId() == null) {
			throw new DashboardException(logger,
					"validateAddOrUpdateUserInput",
					DashboardConstants.EMPLOYEE_ID_TO_BE_UPDATED_NOT_FOUND,
					null);
		} else if (employeeVO.getDepartmentId() == null) {
			throw new DashboardException(logger,
					"validateAddOrUpdateUserInput",
					DashboardConstants.DEPARTMENT_ID_IS_NULL, null);
		} else if (employeeVO.getDesignationId() == null) {
			throw new DashboardException(logger,
					"validateAddOrUpdateUserInput",
					DashboardConstants.DESIGNATION_ID_NOT_FOUND, null);
		} else if (employeeVO.getHouseId() == null) {
			throw new DashboardException(logger,
					"validateAddOrUpdateUserInput",
					DashboardConstants.HOUSE_ID_NOT_FOUND, null);
		} else if (employeeVO.getEmployeeTypeId() == null) {
			throw new DashboardException(logger,
					"validateAddOrUpdateUserInput",
					DashboardConstants.EMPLOYEE_TYPE_ID_NOT_FOUND, null);
		} else if (employeeVO.getCompanyDetailsId() == null) {
			throw new DashboardException(logger,
					"validateAddOrUpdateUserInput",
					DashboardConstants.COMPANY_DETAILS_ID_NOT_FOUND, null);
		} else if (employeeVO.getRoleId() == null) {
			throw new DashboardException(logger,
					"validateAddOrUpdateUserInput",
					DashboardConstants.ROLE_ID_NOT_FOUND, null);
		} else if (employeeVO.getDateOfBirth() == null) {
			throw new DashboardException(logger,
					"validateAddOrUpdateUserInput",
					DashboardConstants.DATE_OF_BIRTH_NOT_FOUND, null);
		} else if (employeeVO.getDateOfJoining() == null) {
			throw new DashboardException(logger,
					"validateAddOrUpdateUserInput",
					DashboardConstants.DATE_OF_JOINING_NOT_FOUND, null);
		} else if (employeeVO.getEmergencyContactName() == null) {
			throw new DashboardException(logger,
					"validateAddOrUpdateUserInput",
					DashboardConstants.EMERGENCY_CONTACT_NEEDED, null);
		} else if (employeeVO.getEmergencyContactNo() == null) {
			throw new DashboardException(logger,
					"validateAddOrUpdateUserInput",
					DashboardConstants.EMERGENCY_CONTACT_NO_NEEDED, null);
		} else if (employeeVO.getRelationshipWithEmergencyContact() == null) {
			throw new DashboardException(
					logger,
					"validateAddOrUpdateUserInput",
					DashboardConstants.RELATIONSHIP_WITH_EMERGENCY_CONTACT_NEEDED,
					null);
		} else if (employeeVO.getEmpCode() == null) {
			throw new DashboardException(logger,
					"validateAddOrUpdateUserInput",
					DashboardConstants.EMPLOYEE_CODE_NEEDED, null);
		} else if (employeeVO.getFirstname() == null) {
			throw new DashboardException(logger,
					"validateAddOrUpdateUserInput",
					DashboardConstants.FIRST_NAME_NEEDED, null);
		} else if (employeeVO.getFatherName() == null) {
			throw new DashboardException(logger,
					"validateAddOrUpdateUserInput",
					DashboardConstants.FATHER_NAME_NEEDED, null);
		} else if (employeeVO.getBloodGroup() == null) {
			throw new DashboardException(logger,
					"validateAddOrUpdateUserInput",
					DashboardConstants.BLOOD_GROUP_NEEDED, null);
		} else if (employeeVO.getGender() == null) {
			throw new DashboardException(logger,
					"validateAddOrUpdateUserInput",
					DashboardConstants.GENDER_NEEDED, null);
		} else if (employeeVO.getInstantMessangerId() == null) {
			throw new DashboardException(logger,
					"validateAddOrUpdateUserInput",
					DashboardConstants.INSTANT_MESSANGER_ID_NEEDED, null);
		} else if (employeeVO.getManagerId() == null) {
			throw new DashboardException(logger,
					"validateAddOrUpdateUserInput",
					DashboardConstants.MANAGER_ID_NEEDED, null);
		} else if (employeeVO.getMobileNo() == null) {
			throw new DashboardException(logger,
					"validateAddOrUpdateUserInput",
					DashboardConstants.MOBILE_NO_NEEDED, null);
		} else if (employeeVO.getPancardNo() == null) {
			throw new DashboardException(logger,
					"validateAddOrUpdateUserInput",
					DashboardConstants.PANCARD_NO_NEEDED, null);
		} else if (employeeVO.getPassportNo() == null) {
			throw new DashboardException(logger,
					"validateAddOrUpdateUserInput",
					DashboardConstants.PASSPORT_NO_NEEDED, null);
		} else if (employeeVO.getPermanentAddressStreet1() == null) {
			throw new DashboardException(logger,
					"validateAddOrUpdateUserInput",
					DashboardConstants.PERMANENT_ADDRESS_NEEDED, null);
		} else if (employeeVO.getPermanentCountryId() == null) {
			throw new DashboardException(logger,
					"validateAddOrUpdateUserInput",
					DashboardConstants.PERMANENT_COUNTRY_NEEDED, null);
		} else if (employeeVO.getPermanentCityId() == null) {
			throw new DashboardException(logger,
					"validateAddOrUpdateUserInput",
					DashboardConstants.PERMANENT_CITY_NEEDED, null);
		} else if (employeeVO.getPermanentStateId() == null) {
			throw new DashboardException(logger,
					"validateAddOrUpdateUserInput",
					DashboardConstants.PERMANENT_STATE_NEEDED, null);
		} else if (employeeVO.getPermanentZipcode() == null) {
			throw new DashboardException(logger,
					"validateAddOrUpdateUserInput",
					DashboardConstants.PERMANENT_ZIPCODE_NEEDED, null);
		} else if (employeeVO.getPermanentOfficePhoneNoWithExtension() == null) {
			throw new DashboardException(logger,
					"validateAddOrUpdateUserInput",
					DashboardConstants.OFFICE_PHONE_NO_NEEDED, null);
		} else if (employeeVO.getPresentAddressStreet1() == null) {
			throw new DashboardException(logger,
					"validateAddOrUpdateUserInput",
					DashboardConstants.PRESENT_ADDRESS_NEEDED, null);
		} else if (employeeVO.getPresentCountryId() == null) {
			throw new DashboardException(logger,
					"validateAddOrUpdateUserInput",
					DashboardConstants.PRESENT_COUNTRY_NEEDED, null);
		} else if (employeeVO.getPresentStateId() == null) {
			throw new DashboardException(logger,
					"validateAddOrUpdateUserInput",
					DashboardConstants.PRESENT_STATE_NEEDED, null);
		} else if (employeeVO.getPresentCityId() == null) {
			throw new DashboardException(logger,
					"validateAddOrUpdateUserInput",
					DashboardConstants.PRESENT_CITY_NEEDED, null);
		} else if (employeeVO.getPresentZipcode() == null) {
			throw new DashboardException(logger,
					"validateAddOrUpdateUserInput",
					DashboardConstants.PRESENT_ZIPCODE_NEEDED, null);
		} else if (employeeVO.getStatus() == null) {
			throw new DashboardException(logger,
					"validateAddOrUpdateUserInput",
					DashboardConstants.STATUS_NEEDED, null);
		} else if (employeeVO.getUsername() == null) {
			throw new DashboardException(logger,
					"validateAddOrUpdateUserInput",
					DashboardConstants.USERNAME_NEEDED, null);
		} else if (employeeVO.getWorkEmail() == null) {
			throw new DashboardException(logger,
					"validateAddOrUpdateUserInput",
					DashboardConstants.WORK_EMAIL_NEEDED, null);
		} else if (employeeVO.getPersonalEmail() == null) {
			throw new DashboardException(logger,
					"validateAddOrUpdateUserInput",
					DashboardConstants.PERSONAL_EMAIL_NEEDED, null);
		} else if (employeeVO.getDocument() != null
				&& employeeVO.getDocumentType() == null) {
			throw new DashboardException(logger,
					"validateAddOrUpdateUserInput",
					DashboardConstants.DOCUMENT_TYPE_NEEDED, null);
		} else if (employeeVO.getPastYearExperience() == null) {
			throw new DashboardException(logger,
					"validateAddOrUpdateUserInput",
					DashboardConstants.PAST_EXPERIENCE_NEEDED, null);
		} else if (employeeVO.getPastMonthExperience() == null) {
			throw new DashboardException(logger,
					"validateAddOrUpdateUserInput",
					DashboardConstants.PAST_EXPERIENCE_NEEDED, null);
		} else if (employeeVO.getPastDayExperience() == null) {
			throw new DashboardException(logger,
					"validateAddOrUpdateUserInput",
					DashboardConstants.PAST_EXPERIENCE_NEEDED, null);
		} else if (employeeVO.getPsYearExperience() == null) {
			throw new DashboardException(logger,
					"validateAddOrUpdateUserInput",
					DashboardConstants.PS_EXPERIENCE_NEEDED, null);
		} else if (employeeVO.getPsMonthExperience() == null) {
			throw new DashboardException(logger,
					"validateAddOrUpdateUserInput",
					DashboardConstants.PS_EXPERIENCE_NEEDED, null);
		} else if (employeeVO.getPsDayExperience() == null) {
			throw new DashboardException(logger,
					"validateAddOrUpdateUserInput",
					DashboardConstants.PS_EXPERIENCE_NEEDED, null);
		} else if (employeeVO.getPermission() == null) {
			throw new DashboardException(logger,
					"validateAddOrUpdateUserInput",
					DashboardConstants.PERMISSIONS_NEEDED, null);
		}
	}

}
