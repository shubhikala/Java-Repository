/**
 * 
 */
package com.billReimbursement.daoImpl;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.fileupload.FileItem;

import com.billReimbursement.dao.DbConnectionManager;
import com.billReimbursement.dao.IBillDetailDao;
import com.billReimbursement.entityBean.AttachmentBean;
import com.billReimbursement.entityBean.BillDetailBean;

/**
 * @author shubhi
 *
 */
public class BillDetailDao implements IBillDetailDao {

	DbConnectionManager db;

	public void SaveBill(DbConnectionManager db, BillDetailBean bean,
			String description, List<FileItem> fileItemsList, String fileDir)
			throws Exception {
		int status;
		PreparedStatement preparedStatement = null;
		String fileName;
		AttachmentBean attachmentBean;

		String saveBillSQL = "insert into bill_detail(emp_id,submission_date, bill_type_id, total_amount, request_help, emp_comments) values(?,?,?,?,?,?)";

		try {
			preparedStatement = db.getConnection()
					.prepareStatement(saveBillSQL);
			preparedStatement.setInt(1, bean.getEmpId());
			preparedStatement.setDate(2, bean.getSubmissionDate());
			preparedStatement.setInt(3, bean.getBillTypeId());
			preparedStatement.setBigDecimal(4, bean.getTotalAmount());
			preparedStatement.setBoolean(5,
					(Boolean.parseBoolean(bean.getRequestHelp())));
			preparedStatement.setString(6, bean.getDetails());
			status = preparedStatement.executeUpdate();

			// Get auto generated id of the saved record.
			ResultSet rs = preparedStatement.getGeneratedKeys();
			int generatedKey = 0;
			if (rs.next()) {
				generatedKey = rs.getInt(1);
			}

			if (status == 1) {
				attachmentBean = new AttachmentBean();
				Iterator<FileItem> fileItemsIterator = fileItemsList.iterator();
				while (fileItemsIterator.hasNext()) {
					FileItem fileItem = fileItemsIterator.next();
					System.out.println("FieldName=" + fileItem.getFieldName());
					System.out.println("FileName=" + fileItem.getName());
					System.out.println("ContentType="
							+ fileItem.getContentType());
					System.out.println("Size in bytes=" + fileItem.getSize());
					Path p = Paths.get(fileItem.getName());
					fileName = p.getFileName().toString();
					File file = new File(fileDir + File.separator + fileName);
					System.out.println("Absolute Path at server="
							+ file.getAbsolutePath());
					fileItem.write(file);

					attachmentBean.setBillId(generatedKey);
					attachmentBean.setDate(bean.getSubmissionDate());
					attachmentBean.setDescription(description);
					attachmentBean.setFileName(fileName);
					attachmentBean.setRequestHelp((bean.getRequestHelp()));

					saveAttachment(generatedKey, attachmentBean);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void saveAttachment(int billId, AttachmentBean bean) {
		String saveAttachmentSQL = "insert into attachment(bill_id,name,description,request_help) values(?,?,?,?)";
		PreparedStatement preparedStatement = null;
		int status;

		try {
			preparedStatement = db.getConnection().prepareStatement(
					saveAttachmentSQL);
			preparedStatement.setInt(1, billId);
			preparedStatement.setString(2, bean.getFileName());
			preparedStatement.setString(3, bean.getDescription());
			preparedStatement.setBoolean(4,
					(Boolean.parseBoolean(bean.getRequestHelp())));

			status = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// TODO Auto-generated method stub

}
