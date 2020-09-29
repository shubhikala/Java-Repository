/**
 * 
 */
package com.billReimbursement.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.billReimbursement.dao.DbConnectionManager;
import com.billReimbursement.dao.IEmployeeDao;
import com.billReimbursement.entityBean.EmployeeBean;

/**
 * @author shubhi
 *
 */
public class EmployeeDao implements IEmployeeDao{
	
	public EmployeeBean getEmployeeByEmail(String email, DbConnectionManager db)
			throws SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet;
		String validateGetEmployeeSQL = "select * from employee where mail_id=?";

		EmployeeBean employee = null;

		try {
			preparedStatement = db.getConnection().prepareStatement(
					validateGetEmployeeSQL);
			preparedStatement.setString(1, email);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				employee = new EmployeeBean();
				employee.setEmpId(resultSet.getInt("emp_id"));
				employee.setDepartmentId(resultSet.getInt("department_id"));
				employee.setManagerId(resultSet.getInt("manager_id"));
				employee.setName(resultSet.getString("name"));
				employee.setEmail(resultSet.getString("mail_id"));
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
	
	public EmployeeBean getEmployeeById(int id, DbConnectionManager db)
			throws SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet;
		String validateGetEmployeeSQL = "select * from employee where id=?";

		EmployeeBean employee = null;

		try {
			preparedStatement = db.getConnection().prepareStatement(
					validateGetEmployeeSQL);
			preparedStatement.setInt(1, id);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				employee = new EmployeeBean();
				employee.setEmpId(resultSet.getInt("emp_id"));
				employee.setDepartmentId(resultSet.getInt("department_id"));
				employee.setManagerId(resultSet.getInt("manager_id"));
				employee.setName(resultSet.getString("name"));
				employee.setEmail(resultSet.getString("mail_id"));
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
