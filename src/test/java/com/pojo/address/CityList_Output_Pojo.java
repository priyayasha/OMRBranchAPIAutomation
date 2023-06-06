package com.pojo.address;

import java.util.ArrayList;
/**
 * 
 * @author priya
 * @see purpose of this pojo class for to maintain CityList Output
 * @since 02-06-2023
 */

public class CityList_Output_Pojo {

	private int status;
	private String message;
	private ArrayList<CityList> data;
	public int getStatus() {
		return status;
	}
	public String getMessage() {
		return message;
	}
	public ArrayList<CityList> getData() {
		return data;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setData(ArrayList<CityList> data) {
		this.data = data;
	}
	

}
