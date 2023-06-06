package com.pojo.product;



/**
 * 
 * @author priya
 * @see purpose of this pojo class for to maintain Searchproduct
 * @since 02-06-2023
 */
public class SearchProduct_Input_Pojo {
	 private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public SearchProduct_Input_Pojo(String text) {
		super();
		this.text = text;
	}

}
