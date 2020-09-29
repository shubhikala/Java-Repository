package com.servlet;

import java.sql.*;

public class FetchRecord {
	public static void main(String args[]) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/userdb", "root", "");
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from user");
rs.absolute(1);
		System.out.println(rs.getString(2) + " "
				+ rs.getString(3));

		con.close();
	}
}
