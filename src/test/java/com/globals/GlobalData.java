package com.globals;



/**
 * 
 * @author priya
 * @see purpose of this class for to maintain Global data
 * @since 02-06-2023
 */


public class GlobalData {
	private int statusCode;
	private String stateIdNum;
	private String logToken;
	private String addressIdNum;
	private String token;
	
	public int getStatusCode() {
		return statusCode;
	}

	public  void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getStateIdNum() {
		return stateIdNum;
	}

	public void setStateIdNum(String stateIdNum) {
		this.stateIdNum = stateIdNum;
	}

	public String getLogToken() {
		return logToken;
	}

	public void setLogToken(String logToken) {
		this.logToken = logToken;
	}

	public String getAddressIdNum() {
		return addressIdNum;
	}

	public void setAddressIdNum(String addressIdNum) {
		this.addressIdNum = addressIdNum;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	

}
