package com.pojo.login;

/**
 * 
 * @author priya
 * @see purpose of this pojo class for to maintain user role
 * @since 02-06-2023
 */
public class UserRole {
	private int id;
	private String role;
	private String name;
	private String status;
	private String created_at;
	private String updated_at;
	private Pivot pivot;

	public int getId() {
		return id;
	}

	public String getRole() {
		return role;
	}

	public String getName() {
		return name;
	}

	public String getStatus() {
		return status;
	}

	public String getCreated_at() {
		return created_at;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public Pivot getPivot() {
		return pivot;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

	public void setPivot(Pivot pivot) {
		this.pivot = pivot;
	}

}
