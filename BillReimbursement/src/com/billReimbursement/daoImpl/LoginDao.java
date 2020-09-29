/**
 * 
 */
package com.billReimbursement.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import sun.security.pkcs11.Secmod.DbMode;

import com.billReimbursement.dao.DbConnectionManager;
import com.billReimbursement.dao.IEmployeeDao;
import com.billReimbursement.dao.ILoginDao;
import com.billReimbursement.entityBean.EmployeeBean;
import com.billReimbursement.entityBean.LoginBean;

/**
 * The Class LoginDao.
 *
 * @author shubhi
 */
public class LoginDao implements ILoginDao {

	private IEmployeeDao employeeDao = new EmployeeDao();
	DbConnectionManager db;
	/*
	 * @see com.billReimbursement.dao.ILoginDao#validate(javax.servlet.http.
	 * HttpServletRequest)
	 */
	public EmployeeBean validate(LoginBean obj, DbConnectionManager db)
			throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet;
		boolean status = false;
		String validateLoginSQL = "select * from login where mail_id=? and password=?";

		EmployeeBean employee = null;

		try {
			preparedStatement = db.getConnection().prepareStatement(
					validateLoginSQL);
			preparedStatement.setString(1, obj.getEmail());
			preparedStatement.setString(2, obj.getPassword());

			resultSet = preparedStatement.executeQuery();

			status = resultSet.next();
			if (status) {
				employee = employeeDao.getEmployeeByEmail(obj.getEmail(), db);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		return employee;
	}		
}
