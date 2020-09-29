/**
 * 
 */
package com.billReimbursement.dao;

import java.util.List;

import com.billReimbursement.entityBean.BillTypeBean;

/**
 * @author shubhi
 *
 */
public interface IBillTypeDao {
public List<BillTypeBean> GetBillTypes(DbConnectionManager db);
}
