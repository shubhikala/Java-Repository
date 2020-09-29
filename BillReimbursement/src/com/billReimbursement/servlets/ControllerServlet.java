package com.billReimbursement.servlets;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.billReimbursement.dao.DbConnectionManager;
import com.billReimbursement.dao.IBillDetailDao;
import com.billReimbursement.daoImpl.BillDetailDao;
import com.billReimbursement.entityBean.BillDetailBean;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IBillDetailDao billDetailDao = new BillDetailDao();
	DbConnectionManager db;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	private ServletFileUpload uploader = null;

	@Override
	public void init() throws ServletException {
		DiskFileItemFactory fileFactory = new DiskFileItemFactory();
		File filesDir = (File) getServletContext().getAttribute(
				"FILES_DIR_FILE");
		fileFactory.setRepository(filesDir);
		this.uploader = new ServletFileUpload(fileFactory);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session;
		BillDetailBean billDetail;
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime()
				.getTime());
		String description;
		String empId;
		String billType;
		String amount;
		/*
		 * String str = request.getParameter("amount"); BigDecimal bd = new
		 * BigDecimal(str);
		 */

		try {
			/*empId = request.getParameter("empId");
			billType = request.getParameter("selectBillType");

			billDetail = new BillDetailBean();
			billDetail.setEmpId(Integer.parseInt(empId));		
			billDetail.setBillTypeId(Integer.parseInt(billType));
			billDetail.setDetails(request.getParameter("details"));
			billDetail
					.setEmpId(Integer.parseInt(request.getParameter("empId")));
			billDetail.setRequestHelp(request.getParameter("chkRequestHelp"));
			billDetail.setSubmissionDate(date);
			
			 * billDetail.setTotalAmount(bd);
			 description = request.getParameter("fileDescription");

			if (!ServletFileUpload.isMultipartContent(request)) {
				throw new ServletException(
						"Content type is not multipart/form-data");
			}

			List<FileItem> fileItemsList = uploader.parseRequest(request);
			String fileDir = (String) request.getServletContext().getAttribute(
					"FILES_DIR");
			
			 * out.write("File "+fileName+ " uploaded successfully.");
			 * out.write("<br>");
			 * out.write("<a href=\"UploadDownloadFileServlet?fileName="
			 * +fileName+"\">Download "+fileName+"</a>");
			 
			billDetailDao.SaveBill(db, billDetail, description, fileItemsList,
					fileDir);
*/
		 /*catch (FileUploadException e) {
			e.printStackTrace();*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
