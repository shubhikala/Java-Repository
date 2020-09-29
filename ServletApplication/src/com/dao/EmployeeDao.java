package com.dao;

import java.util.*;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.sql.Date;

import org.apache.jasper.tagplugins.jstl.core.Catch;

import com.model.Employee;
import com.sun.org.apache.bcel.internal.generic.RETURN;

public class EmployeeDao {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/userdb", "root", "");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	public static int save(Employee e) {
		int status = 0;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con
					.prepareStatement("insert into user(name,password,email,country) values (?,?,?,?)");
			ps.setString(1, e.getName());
			ps.setString(2, e.getPassword());
			ps.setString(3, e.getEmail());
			ps.setString(4, e.getCountry());
			status = ps.executeUpdate();
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}

	public static int update(Employee e) {
		int status = 0;
		try {
			Connection con = EmployeeDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("update user set name=?,password=?,email=?,country=? where id=?");
			ps.setString(1, e.getName());
			ps.setString(2, e.getPassword());
			ps.setString(3, e.getEmail());
			ps.setString(4, e.getCountry());
			ps.setInt(5, e.getId());

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static int delete(int id) {
		int status = 0;
		try {
			Connection con = EmployeeDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("delete from user where id=?");
			ps.setInt(1, id);
			status = ps.executeUpdate();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	public static Employee getEmployeeById(int id) {
		Employee e = new Employee();

		try {
			Connection con = EmployeeDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("select * from user where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setCountry(rs.getString(5));
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return e;
	}

	public static List<Employee> getAllEmployees() {
		List<Employee> list = new ArrayList<Employee>();
			try
			{
				Connection con = EmployeeDao.getConnection();
				PreparedStatement ps = con.prepareStatement("select * from user");
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					Employee emp = new Employee();
					emp.setId(rs.getInt(1));
					emp.setName(rs.getString(2));
					emp.setPassword(rs.getString(3));
					emp.setEmail(rs.getString(4));
					emp.setCountry(rs.getString(5));	
					list.add(emp);
				}
				con.close();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return list;
		}
	}
	
