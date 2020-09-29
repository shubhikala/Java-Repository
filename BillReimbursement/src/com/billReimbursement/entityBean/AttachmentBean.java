/**
 * 
 */
package com.billReimbursement.entityBean;

import java.sql.Date;

/**
 * @author shubhi
 *
 */
public class AttachmentBean {

	private int billId;
	private String fileName;
	private String description;
	private String requestHelp;
	private Date date;
	/**
	 * @return the billId
	 */
	public int getBillId() {
		return billId;
	}
	/**
	 * @param billId the billId to set
	 */
	public void setBillId(int billId) {
		this.billId = billId;
	}
	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the requestHelp
	 */
	public String getRequestHelp() {
		return requestHelp;
	}
	/**
	 * @param requestHelp the requestHelp to set
	 */
	public void setRequestHelp(String requestHelp) {
		this.requestHelp = requestHelp;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
}
