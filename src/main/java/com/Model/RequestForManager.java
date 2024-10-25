package com.Model;

public class RequestForManager {

	private int userid;
	private int reqid;
	private String employename;
	private String softwarename;
	private String Accestype;
	private String reason;
	
	
	public RequestForManager(int userid, int reqid, String employename, String softwarename, String accestype,
			String reason) {
		super();
		this.userid = userid;
		this.reqid = reqid;
		this.employename = employename;
		this.softwarename = softwarename;
		Accestype = accestype;
		this.reason = reason;
	}
	public RequestForManager() {}
	public String getEmployename() {
		return employename;
	}
	public void setEmployename(String employename) {
		this.employename = employename;
	}
	public String getSoftwarename() {
		return softwarename;
	}
	public void setSoftwarename(String softwarename) {
		this.softwarename = softwarename;
	}
	public String getAccestype() {
		return Accestype;
	}
	public void setAccestype(String accestype) {
		Accestype = accestype;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getReqid() {
		return reqid;
	}
	public void setReqid(int reqid) {
		this.reqid = reqid;
	}
	
}
