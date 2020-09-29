/**
 * 
 */
package com.billReimbursement.dao;

import java.sql.SQLException;

import com.billReimbursement.entityBean.EmployeeBean;
import com.billReimbursement.entityBean.LoginBean;

/**
 * @author shubhi
 *
 */
public interface IEmployeeDao {
	public EmployeeBean getEmployeeByEmail(String email, DbConnectionManager db)
			throws SQLException;
	public EmployeeBean getEmployeeById(int id, DbConnectionManager db)
			throws SQLException ;
}
