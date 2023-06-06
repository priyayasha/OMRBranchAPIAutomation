package com.payload.product;


import com.pojo.product.SearchProduct_Input_Pojo;

/**
 * 
 * @author priya
 * @see purpose of this class get objects for SearchProductPayload
 *@since 02-06-2023
 */
public class SearchProductPayload {

	public SearchProduct_Input_Pojo searchProduct(String text)
	{
		SearchProduct_Input_Pojo searchProduct_Input_Pojo = new SearchProduct_Input_Pojo(text);
		return searchProduct_Input_Pojo;
		
	}

}
