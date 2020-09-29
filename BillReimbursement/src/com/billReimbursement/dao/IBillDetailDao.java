/**
 * 
 */
package com.billReimbursement.dao;

import java.util.List;

import org.apache.commons.fileupload.FileItem;

import com.billReimbursement.entityBean.BillDetailBean;

/**
 * @author shubhi
 *
 */
public interface IBillDetailDao {
	void SaveBill(DbConnectionManager db, BillDetailBean bean, String description,
			List<FileItem> fileItemsList, String fileDir) throws Exception;
  
}
