package com.pojo.address;

import java.util.ArrayList;
/**
 * 
 * @author priya
 * @see purpose of this pojo class for to maintain StateListOutputs
 * @since 02-06-2023
 */
public class StateList_Output_Pojo {
	private int status;
	private String message;
	private ArrayList<StateList> data;

	public int getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public ArrayList<StateList> getData() {
		return data;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setData(ArrayList<StateList> data) {
		this.data = data;
	}

}
