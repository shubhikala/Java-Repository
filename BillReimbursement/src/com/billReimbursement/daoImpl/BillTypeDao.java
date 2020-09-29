/**
 * 
 */
package com.billReimbursement.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.billReimbursement.dao.DbConnectionManager;
import com.billReimbursement.dao.IBillTypeDao;
import com.billReimbursement.entityBean.BillTypeBean;

/**
 * @author shubhi
 *
 */
public class BillTypeDao implements IBillTypeDao {

	DbConnectionManager db;

	/*
	 * @see com.billReimbursement.dao.ILoginDao#validate(javax.servlet.http.
	 * HttpServletRequest)
	 */
	public List<BillTypeBean> GetBillTypes(DbConnectionManager db){
		
		ResultSet resultSet;
		List<BillTypeBean> billTypeList = new ArrayList<BillTypeBean>();
		String getBillTypesSQL = "select * from bill_type";
		BillTypeBean bean;
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		
		try {	
			preparedStatement = db.getConnection().prepareStatement(
					getBillTypesSQL);

			resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				bean = new BillTypeBean();
				bean.setId(resultSet.getInt("id"));
				bean.setName(resultSet.getString("name"));
				billTypeList.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return billTypeList;
	}
}
