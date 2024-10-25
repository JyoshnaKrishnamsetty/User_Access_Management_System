package com.Model;

public class SoftwareModel {

	private int id;
	private String name;
	private String description;
	private String access_levels;
	
	public SoftwareModel() {}
	
	public SoftwareModel(int id, String name, String description, String access_levels) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.access_levels = access_levels;
	}

	public SoftwareModel(int id, String name) {
		this.id=id;
		this.name=name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAccess_levels() {
		return access_levels;
	}
	public void setAccess_levels(String access_levels) {
		this.access_levels = access_levels;
	}
	@Override
	public String toString() {
		return "SoftwareModel [id=" + id + ", name=" + name + ", description=" + description + ", access_levels="
				+ access_levels + "]";
	}
}
