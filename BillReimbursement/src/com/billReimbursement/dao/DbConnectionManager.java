/**
 * 
 */
package com.billReimbursement.dao;

import java.sql.*;

/**
 * @author shubhi
 *
 */
public class DbConnectionManager {
	/** The connection. */
	private Connection connection;

	public DbConnectionManager(String url, String username, String password,
			String drivername) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			this.connection = DriverManager.getConnection(url, username,
					password);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return this.connection;
	}

	public ResultSet runSql(String sql) throws SQLException {
		PreparedStatement sta = connection.prepareStatement(sql);
		return sta.executeQuery();
	}
}