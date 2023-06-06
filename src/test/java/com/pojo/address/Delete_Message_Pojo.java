package com.pojo.address;
/**
 * 
 * @author priya
 * @see purpose of this pojo class for to maintain Delete Status and Message
 * @since 02-06-2023
 */
public class Delete_Message_Pojo {
    public int status;
    public String message;
	public int getStatus() {
		return status;
	}
	public String getMessage() {
		return message;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void setMessage(String message) {
		this.message = message;
	}
    

}
