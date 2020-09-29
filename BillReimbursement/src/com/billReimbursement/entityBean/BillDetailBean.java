/**
 * 
 */
package com.billReimbursement.entityBean;

import java.math.BigDecimal;
import java.sql.*;
import java.util.List;

/**
 * @author shubhi
 *
 */
public class BillDetailBean {
	private int empId;
	private Date submissionDate;
	private int billTypeId;
	private BigDecimal totalAmount;
	private String details;
    private String requestHelp;
	
	/**
	 * @return the empId
	 */
	public int getEmpId() {
		return empId;
	}

	/**
	 * @param empId
	 *            the empId to set
	 */
	public void setEmpId(int empId) {
		this.empId = empId;
	}

	/**
	 * @return the submissionDate
	 */
	public Date getSubmissionDate() {
		return submissionDate;
	}

	/**
	 * @param submissionDate
	 *            the submissionDate to set
	 */
	public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
	}

	/**
	 * @return the billTypeId
	 */
	public int getBillTypeId() {
		return billTypeId;
	}

	/**
	 * @param billTypeId
	 *            the billTypeId to set
	 */
	public void setBillTypeId(int billTypeId) {
		this.billTypeId = billTypeId;
	}

	/**
	 * @return the totalAmount
	 */
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	/**
	 * @param totalAmount
	 *            the totalAmount to set
	 */
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	/**
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}

	/**
	 * @param details
	 *            the details to set
	 */
	public void setDetails(String details) {
		this.details = details;
	}

	/**
	 * @return the requestHelp
	 */
	public String getRequestHelp() {
		return requestHelp;
	}

	/**
	 * @param requestHelp
	 *            the requestHelp to set
	 */
	public void setRequestHelp(String requestHelp) {
		this.requestHelp = requestHelp;
	}
}
