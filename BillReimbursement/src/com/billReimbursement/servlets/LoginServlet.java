package com.billReimbursement.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.billReimbursement.dao.DbConnectionManager;
import com.billReimbursement.dao.IBillTypeDao;
import com.billReimbursement.dao.IEmployeeDao;
import com.billReimbursement.dao.ILoginDao;
import com.billReimbursement.daoImpl.BillTypeDao;
import com.billReimbursement.daoImpl.EmployeeDao;
import com.billReimbursement.daoImpl.LoginDao;
import com.billReimbursement.entityBean.BillTypeBean;
import com.billReimbursement.entityBean.EmployeeBean;
import com.billReimbursement.entityBean.LoginBean;

import sun.security.pkcs11.Secmod.DbMode;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ILoginDao loginDao = new LoginDao();
	private IEmployeeDao employeeDao = new EmployeeDao();
    private IBillTypeDao billTypeDao = new BillTypeDao();
	DbConnectionManager db;
	
	static final Logger LOGGER = Logger.getLogger(LoginServlet.class);
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/*
	 * public LoginServlet(ILoginDao login) { this.loginDao = login; }
	 */
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session;
		LoginBean obj;
		EmployeeBean employee, manager;
		BillTypeBean billType;
		List<BillTypeBean> billTypeList = new ArrayList<BillTypeBean>();
		
		try {
			LOGGER.info("This is a logging statement from log4j");
			db = (DbConnectionManager) request.getServletContext()
					.getAttribute("db");
			obj = new LoginBean();
			obj.setEmail(request.getParameter("email"));
			obj.setPassword(request.getParameter("password"));

			employee = loginDao.validate(obj, db);			
			billTypeList = billTypeDao.GetBillTypes(db);
			
			session = request.getSession();
			
			session.setAttribute("billTypes",billTypeList );	
			
			if (employee != null) {
				manager = employeeDao.getEmployeeById(employee.getManagerId(), db);

				session.setAttribute("currentEmployee", employee);
				request.setAttribute("manager", manager);
				request.setAttribute("invalid", "Credentials correct");
				request.getRequestDispatcher("WEB-INF/jsp/billDetail.jsp")
						.forward(request, response);
			} else {
				request.setAttribute("invalid",
						"Sorry, email or password incorrect!!");
				request.getRequestDispatcher("WEB-INF/jsp/login.jsp").include(
						request, response);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
