package in.com.psi.dashboard.util;

import in.com.psi.dashboard.entity.VO.UserVO;

import java.util.HashMap;

// TODO: Auto-generated Javadoc
/**
 * The Class DashboardConstants.
 */
public class DashboardConstants {

	/** The Constant INVALID_USERNAME_OR_PASSWORD. */
	public static final String INVALID_USERNAME_OR_PASSWORD = "INVALID_USERNAME_OR_PASSWORD";

	/** The Constant NO_SET_OF_VALID_CREDENTIALS. */
	public static final String NO_SET_OF_VALID_CREDENTIALS = "NO_SET_OF_VALID_CREDENTIALS";

	/** The Constant INVALID_CREDENTIALS. */
	public static final String INVALID_CREDENTIALS = "INVALID_CREDENTIALS";

	/** The Constant SESSION_ID_NOT_FOUND. */
	public static final String SESSION_ID_NOT_FOUND = "SESSION_ID_NOT_FOUND";

	/** The Constant USER_NOT_FOUND. */
	public static final String USER_NOT_FOUND = "USER_NOT_FOUND";

	/** The Constant SESSION_EXPIRED. */
	public static final String SESSION_EXPIRED = "SESSION_EXPIRED";

	/** The Constant LDAP_AUTHENTICATION_REQUIRED. */
	public static final String LDAP_AUTHENTICATION_REQUIRED = "LDAP Authentication Required.";

	/** The Constant ERROR_READING_THE_REQUEST_PAYLOAD. */
	public static final String ERROR_READING_THE_REQUEST_PAYLOAD = "ERROR_READING_THE_REQUEST_PAYLOAD";

	/** The Constant CONTENT_TYPE. */
	public static final String CONTENT_TYPE = "Content-Type";

	/** The Constant APPLICATIONJSON. */
	public static final String APPLICATIONJSON = "Application/Json";

	/** The Constant MESSAGE_KEY_NOT_FOUND. */
	public static final String MESSAGE_KEY_NOT_FOUND = "MESSAGE_KEY_NOT_FOUND";

	/** The Constant EMPTY_MESSAGE. */
	public static final String EMPTY_MESSAGE = "EMPTY_MESSAGE";

	/** The Constant ERROR. */
	public static final String ERROR = "ERROR";

	/** The Constant DUPLICATE. */
	public static final String DUPLICATE = "DUPLICATE";

	/** The Constant PROBLEM_CONNECTING_DIRECTORY. */
	public static final String PROBLEM_CONNECTING_DIRECTORY = "PROBLEM_CONNECTING_DIRECTORY";

	/** The Constant USER_NOT_EXISTS. */
	public static final String USER_NOT_EXISTS = "USER_NOT_EXISTS";

	/** The Constant NOT_ALLOWED_TO_ADD_NEW_USER. */
	public static final String NOT_ALLOWED_TO_ADD_NEW_USER = "NOT_ALLOWED_TO_ADD_NEW_USER";

	/** The Constant MESSAGE_KEY. */
	public static final String MESSAGE_KEY = "msgKey:";

	/** The Constant LDAP_URL. */
	public static final String LDAP_URL = "ldap://192.168.0.14:389";

	/** The Constant LDAP_CTX. */
	public static final String LDAP_CTX = "com.sun.jndi.ldap.LdapCtxFactory";

	/** The Constant AUTHENTICATION_FAILED. */
	public static final String AUTHENTICATION_FAILED = "AUTHENTICATION_FAILED";

	/** The Constant DEPARTMENT_ID_IS_NULL. */
	public static final String DEPARTMENT_ID_IS_NULL = "DEPARTMENT_ID_IS_NULL";

	/** The Constant DESIGNATION_ID_NOT_FOUND. */
	public static final String DESIGNATION_ID_NOT_FOUND = "DESIGNATION_ID_NOT_FOUND";

	/** The Constant HOUSE_ID_NOT_FOUND. */
	public static final String HOUSE_ID_NOT_FOUND = "HOUSE_ID_NOT_FOUND";

	/** The Constant EMPLOYEE_TYPE_ID_NOT_FOUND. */
	public static final String EMPLOYEE_TYPE_ID_NOT_FOUND = "EMPLOYEE_TYPE_ID_NOT_FOUND";

	/** The Constant COMPANY_DETAILS_ID_NOT_FOUND. */
	public static final String COMPANY_DETAILS_ID_NOT_FOUND = "COMPANY_DETAILS_ID_NOT_FOUND";

	/** The Constant ROLE_ID_NOT_FOUND. */
	public static final String ROLE_ID_NOT_FOUND = "ROLE_ID_NOT_FOUND";

	/** The Constant DATE_OF_BIRTH_NOT_FOUND. */
	public static final String DATE_OF_BIRTH_NOT_FOUND = "DATE_OF_BIRTH_NOT_FOUND";

	/** The Constant DATE_OF_JOINING_NOT_FOUND. */
	public static final String DATE_OF_JOINING_NOT_FOUND = "DATE_OF_JOINING_NOT_FOUND";

	/** The Constant EMERGENCY_CONTACT_NEEDED. */
	public static final String EMERGENCY_CONTACT_NEEDED = "EMERGENCY_CONTACT_NAME_NEEDED";

	/** The Constant EMERGENCY_CONTACT_NO_NEEDED. */
	public static final String EMERGENCY_CONTACT_NO_NEEDED = "EMERGENCY_CONTACT_NO_NEEDED";

	/** The Constant RELATIONSHIP_WITH_EMERGENCY_CONTACT_NEEDED. */
	public static final String RELATIONSHIP_WITH_EMERGENCY_CONTACT_NEEDED = "RELATIONSHIP_WITH_EMERGENCY_CONTACT_NEEDED";

	/** The Constant EMPLOYEE_CODE_NEEDED. */
	public static final String EMPLOYEE_CODE_NEEDED = "EMPLOYEE_CODE_NEEDED";

	/** The Constant FIRST_NAME_NEEDED. */
	public static final String FIRST_NAME_NEEDED = "FIRST_NAME_NEEDED";

	/** The Constant FATHER_NAME_NEEDED. */
	public static final String FATHER_NAME_NEEDED = "FATHER_NAME_NEEDED";

	/** The Constant BLOOD_GROUP_NEEDED. */
	public static final String BLOOD_GROUP_NEEDED = "BLOOD_GROUP_NEEDED";

	/** The Constant GENDER_NEEDED. */
	public static final String GENDER_NEEDED = "GENDER_NEEDED";

	/** The Constant INSTANT_MESSANGER_ID_NEEDED. */
	public static final String INSTANT_MESSANGER_ID_NEEDED = "INSTANT_MESSANGER_ID_NEEDED";

	/** The Constant MANAGER_ID_NEEDED. */
	public static final String MANAGER_ID_NEEDED = "MANAGER_ID_NEEDED";

	/** The Constant MOBILE_NO_NEEDED. */
	public static final String MOBILE_NO_NEEDED = "MOBILE_NO_NEEDED";

	/** The Constant PANCARD_NO_NEEDED. */
	public static final String PANCARD_NO_NEEDED = "PANCARD_NO_NEEDED";

	/** The Constant PASSPORT_NO_NEEDED. */
	public static final String PASSPORT_NO_NEEDED = "PASSPORT_NO_NEEDED";

	/** The Constant PERMANENT_ADDRESS_NEEDED. */
	public static final String PERMANENT_ADDRESS_NEEDED = "PERMANENT_ADDRESS_NEEDED";

	/** The Constant PERMANENT_CITY_NEEDED. */
	public static final String PERMANENT_CITY_NEEDED = "PERMANENT_CITY_NEEDED";

	/** The Constant PERMANENT_COUNTRY_NEEDED. */
	public static final String PERMANENT_COUNTRY_NEEDED = "PERMANENT_COUNTRY_NEEDED";

	/** The Constant PERMANENT_STATE_NEEDED. */
	public static final String PERMANENT_STATE_NEEDED = "PERMANENT_STATE_NEEDED";

	/** The Constant PERMANENT_ZIPCODE_NEEDED. */
	public static final String PERMANENT_ZIPCODE_NEEDED = "PERMANENT_ZIPCODE_NEEDED";

	/** The Constant OFFICE_PHONE_NO_NEEDED. */
	public static final String OFFICE_PHONE_NO_NEEDED = "OFFICE_PHONE_NO_NEEDED";

	/** The Constant PRESENT_ADDRESS_NEEDED. */
	public static final String PRESENT_ADDRESS_NEEDED = "PRESENT_ADDRESS_NEEDED";

	/** The Constant PRESENT_COUNTRY_NEEDED. */
	public static final String PRESENT_COUNTRY_NEEDED = "PRESENT_COUNTRY_NEEDED";

	/** The Constant PRESENT_CITY_NEEDED. */
	public static final String PRESENT_CITY_NEEDED = "PRESENT_CITY_NEEDED";

	/** The Constant PRESENT_STATE_NEEDED. */
	public static final String PRESENT_STATE_NEEDED = "PRESENT_STATE_NEEDED";

	/** The Constant PRESENT_ZIPCODE_NEEDED. */
	public static final String PRESENT_ZIPCODE_NEEDED = "PRESENT_ZIPCODE_NEEDED";

	/** The Constant STATUS_NEEDED. */
	public static final String STATUS_NEEDED = "STATUS_NEEDED";

	/** The Constant USERNAME_NEEDED. */
	public static final String USERNAME_NEEDED = "USERNAME_NEEDED";

	/** The Constant WORK_EMAIL_NEEDED. */
	public static final String WORK_EMAIL_NEEDED = "WORK_EMAIL_NEEDED";

	/** The Constant PERSONAL_EMAIL_NEEDED. */
	public static final String PERSONAL_EMAIL_NEEDED = "PERSONAL_EMAIL_NEEDED";

	/** The Constant DOCUMENT_TYPE_NEEDED. */
	public static final String DOCUMENT_TYPE_NEEDED = "DOCUMENT_TYPE_NEEDED";

	/** The Constant PAST_EXPERIENCE_NEEDED. */
	public static final String PAST_EXPERIENCE_NEEDED = "PAST_EXPERIENCE_NEEDED";

	/** The Constant PS_EXPERIENCE_NEEDED. */
	public static final String PS_EXPERIENCE_NEEDED = "PS_EXPERIENCE_NEEDED";

	/** The Constant LOGIN. */
	public static final String LOGIN = "login";

	/** The Constant ADD_USER. */
	public static final String ADD_USER = "addUser";

	/** The Constant LDAPAUTHENTICATION. */
	public static final String LDAPAUTHENTICATION = "ldapAuthentication";

	/** The Constant RENEW. */
	public static final String RENEW = "renew";

	/** The Constant DEPARTMENT_ID_NOT_FOUND. */
	public static final String DEPARTMENT_ID_NOT_FOUND = "DEPARTMENT_ID_NOT_FOUND";

	/** The Constant VIEW_USER. */
	public static final String VIEW_USER = "viewUser";

	/** The Constant USER_ALREADY_EXISTS. */
	public static final String USER_ALREADY_EXISTS = "USER_ALREADY_EXISTS";

	/** The Constant USER_ADDED_SUCCESSFULLY. */
	public static final String USER_ADDED_SUCCESSFULLY = "USER_ADDED_SUCCESSFULLY";

	/** The Constant REQUEST_NOT_PROCESSED. */
	public static final String REQUEST_NOT_PROCESSED = "REQUEST_NOT_PROCESSED";

	/** The Constant DOMAIN_NAME. */
	public static final String DOMAIN_NAME = "@thepsi.com";

	/** The Constant EMPTY. */
	public static final String EMPTY = "EMPTY";

	/** The Constant SUCCESS. */
	public static final String SUCCESS = "SUCCESS";

	/** The Constant PERMISSIONS_NEEDED. */
	public static final String PERMISSIONS_NEEDED = "PERMISSIONS_NEEDED";

	/** The Constant PERMISSION_ID_NOT_FOUND. */
	public static final String PERMISSION_ID_NOT_FOUND = "PERMISSION_ID_NOT_FOUND";

	/** The Constant HR. */
	public static final String HR = "HR";

	/** The Constant USER_UPDATED_SUCCESSFULLY. */
	public static final String USER_UPDATED_SUCCESSFULLY = "USER_UPDATED_SUCCESSFULLY";

	/** The Constant NOT_ALLOWED_TO_UPDATE_USER. */
	public static final String NOT_ALLOWED_TO_UPDATE_USER = "NOT_ALLOWED_TO_UPDATE_USER";

	/** The Constant EMPLOYEE_ID_TO_BE_UPDATED_NOT_FOUND. */
	public static final String EMPLOYEE_ID_TO_BE_UPDATED_NOT_FOUND = "EMPLOYEE_ID_TO_BE_UPDATED_NOT_FOUND";

	/** The Constant CITY_ID_NOT_FOUND. */
	public static final String CITY_ID_NOT_FOUND = "CITY_ID_NOT_FOUND";

	/** The Constant STATE_ID_NOT_FOUND. */
	public static final String STATE_ID_NOT_FOUND = "STATE_ID_NOT_FOUND";

	/** The Constant COUNTRY_ID_NOT_FOUND. */
	public static final String COUNTRY_ID_NOT_FOUND = "COUNTRY_ID_NOT_FOUND";

	/** The Constant UPDATE_USER. */
	public static final String UPDATE_USER = "updateUser";

	/** The Constant EXCEL_FILE_PATH. */
	public static final String EXCEL_FILE_PATH = "EXCEL_FILE_PATH";

	/** The Constant UNABLE_TO_WRITE. */
	public static final String UNABLE_TO_WRITE = "UNABLE_TO_WRITE";

	/** The Constant PAGE_SIZE. */
	public static final Integer PAGE_SIZE = 20;

	/** The Constant DEPARTMENT. */
	public static final String DEPARTMENT = "department";

	/** The Constant DESIGNATION. */
	public static final String DESIGNATION = "designation";

	/** The Constant HOUSE. */
	public static final String HOUSE = "house";

	/** The Constant EMPLOYEE_TYPE. */
	public static final String EMPLOYEE_TYPE = "employeeType";

	/** The Constant COMPANY_DETAILS. */
	public static final String COMPANY_DETAILS = "companyDetails";

	/** The Constant ROLE. */
	public static final String ROLE = "role";

	/** The Constant PRESENT_CITY. */
	public static final String PRESENT_CITY = "presentCity";

	/** The Constant PERMANENT_CITY. */
	public static final String PERMANENT_CITY = "permanentCity";

	/** The Constant PRESENT_STATE. */
	public static final String PRESENT_STATE = "presentState";

	/** The Constant PERMANENT_STATE. */
	public static final String PERMANENT_STATE = "permanentState";

	/** The Constant PRESENT_COUNTRY. */
	public static final String PRESENT_COUNTRY = "presentCountry";

	/** The Constant PERMANENT_COUNTRY. */
	public static final String PERMANENT_COUNTRY = "permanentCountry";

	/** The Constant SPACE. */
	public static final String SPACE = " ";

	public static final String NAME = "Name";

	public static final String EMPLOYEE_ID = "Employee Id";

	public static final String EMPLOYEE_CODE = "Employee Code";

	public static final String USERNAME = "Username";

	public static final Integer YEAR_TO_DAYS = 365;

	static final Integer MONTH_TO_DAYS = 30;

	public static final long SESSION_TIMEOUT = 300000;

	public static final String CITY_NOT_FOUND = "CITY_NOT_FOUND";

	public static final String COUNTRY_NOT_FOUND = "COUNTRY_NOT_FOUND";

	public static final String DESIGNATION_NOT_FOUND = "DESIGNATION_NOT_FOUND";

	public static final String STATE_NOT_FOUND = "STATE_NOT_FOUND";

	public static final String MANAGER_NOT_FOUND = "MANAGER_NOT_FOUND";

	/** The users. */
	// hashmap storing uuid as key and userVO as value
	public static HashMap<String, UserVO> activeUsers = new HashMap<String, UserVO>();

	/** The url permission. */
	public static HashMap<String, String> urlPermission = new HashMap<String, String>();


}
