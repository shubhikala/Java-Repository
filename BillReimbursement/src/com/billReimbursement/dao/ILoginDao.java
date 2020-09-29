/**
 * 
 */
package com.billReimbursement.dao;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.billReimbursement.entityBean.EmployeeBean;
import com.billReimbursement.entityBean.LoginBean;

/**
 * The Interface ILoginDao.
 *
 * @author shubhi
 */
public interface ILoginDao {
   
   /**
    * Validate.
    *
    * @param request the request
    * @return true, if successful
    * @throws SQLException the SQL exception
    */
   public EmployeeBean validate(LoginBean bean, DbConnectionManager db)throws SQLException;
}
