package com.pojo.address;

import java.util.ArrayList;

/**
 * 
 * @author priya
 * @see purpose of this pojo class for to maintain GetUseraddress outputs
 * @since 02-06-2023
 */
public class GetUserAddress_Output_Pojo {
	
    private int status;
    private String message;
    private ArrayList<UserAddress> data;
    
	public int getStatus() {
		return status;
	}
	public String getMessage() {
		return message;
	}
	public ArrayList<UserAddress> getData() {
		return data;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setData(ArrayList<UserAddress> data) {
		this.data = data;
	}
    
    

}
