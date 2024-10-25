package com.Model;

public class RequestAccessModel {

	private int id;
	private int user_id;
	private int software_id;
	private String access_type;
	private String reason;
	private String status;
	private String softwarename;
	
	public RequestAccessModel() {}
	public RequestAccessModel(int id, String name, String accesstype, String reason) {
		super();
		this.id=id;
		this.softwarename=name;
		this.access_type=accesstype;
		this.reason=reason;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getSoftware_id() {
		return software_id;
	}
	public void setSoftware_id(int software_id) {
		this.software_id = software_id;
	}
	public String getAccess_type() {
		return access_type;
	}
	public void setAccess_type(String access_type) {
		this.access_type = access_type;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "RequestAccessModel [id=" + id + ", user_id=" + user_id + ", software_id=" + software_id
				+ ", access_type=" + access_type + ", reason=" + reason + ", status=" + status + "]";
	}
	public String getSoftwarename() {
		return softwarename;
	}
	public void setSoftwarename(String softwarename) {
		this.softwarename = softwarename;
	}
}
