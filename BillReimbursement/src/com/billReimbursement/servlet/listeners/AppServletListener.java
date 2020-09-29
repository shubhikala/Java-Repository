package com.billReimbursement.servlet.listeners;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.PropertyConfigurator;

import com.billReimbursement.dao.DbConnectionManager;

/**
 * Application Lifecycle Listener implementation class AppServletListener
 *
 */
@WebListener
public class AppServletListener implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public AppServletListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent context) {
		try {
			
			//Database initialization
			DbConnectionManager db;
			ServletContext sc = context.getServletContext();

			String url = sc.getInitParameter("url");
			String username = sc.getInitParameter("username");
			String password = sc.getInitParameter("password");
			String drivername = sc.getInitParameter("drivername");
			db = new DbConnectionManager(url, username,
					password, drivername);
			// System.out.println("in the listener!!");
			sc.setAttribute("db", db);
			
			//Configure Log4j
			String log4jConfigFile = sc.getInitParameter("log4j-config-location");
	        String fullPath = sc.getRealPath("") + File.separator + log4jConfigFile;
	         
	        PropertyConfigurator.configure(fullPath);
	        
	        //file upload location initialization
	        String rootPath = System.getProperty("catalina.home");
	    	ServletContext ctx = context.getServletContext();
	    	String relativePath = ctx.getInitParameter("bill reimbursement files.dir");
	    	File file = new File(rootPath + File.separator + relativePath);
	    	if(!file.exists()) file.mkdirs();
	    	System.out.println("File Directory created to be used for storing files");
	    	ctx.setAttribute("FILES_DIR_FILE", file);
	    	ctx.setAttribute("FILES_DIR", rootPath + File.separator + relativePath);
	         
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
