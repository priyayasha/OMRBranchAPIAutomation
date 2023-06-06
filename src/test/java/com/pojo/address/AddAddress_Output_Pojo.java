package com.pojo.address;
/**
 * 
 * @author priya
 * @see purpose of this pojo class for to maintain AddAddress Output
 * @since 02-06-2023
 */


public class AddAddress_Output_Pojo {
	private int status;
	private String message;
	private int address_id;

	public int getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public int getAddress_id() {
		return address_id;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

}
