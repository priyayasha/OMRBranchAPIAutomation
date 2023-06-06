package com.stepdefinition;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import com.base.UtilityClass;
import com.endpoints.Endpoints;
import com.globals.GlobalData;
import com.payload.product.SearchProductPayload;
import com.pojo.product.SearchProduct_Input_Pojo;
import com.pojo.product.SearchProduct_Output_Pojo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
/**
 * 
 * @author priya
 * @see purpose of this class is for search product functionality
 * @since 02-06-2023
 */
public class TC5_SearchProductStep extends UtilityClass {
	static SearchProductPayload searchProductPayload = new SearchProductPayload();
	static GlobalData globalData = new GlobalData();
	/**
	 * 
	 * @author priya
	 * @see purpose of this method  for add Header
	 * @since 02-06-2023
	 */
	@Given("User add headers to search product")
	public void user_add_headers_to_search_product() {
		List<Header> listHeader = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h3 = new Header("Content-Type", "application/json");
		listHeader.add(h1);
		listHeader.add(h3);
		Headers headers = new Headers(listHeader);
		addHeaders(headers);
	}
	/**
	 * 
	 * @author priya
	 * @see purpose of this method to add request body 
	 * @since 02-06-2023
	 */

	@When("User add request body to search product {string}")
	public void user_add_request_body_to_search_product(String text) {
		SearchProduct_Input_Pojo searchProduct = searchProductPayload.searchProduct(text);
		System.out.println(text);
		addBody(searchProduct);
	}
	/**
	 * 
	 * @author priya
	 * @see purpose of this method user sending request for search product endpoint
	 * @since 02-06-2023
	 */

	@When("User send {string} request for search product endpoint")
	public void user_send_request_for_search_product_endpoint(String reqType) {
		Response response = addReqType(reqType, Endpoints.SEARCHPRODUCT);
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globalData.setStatusCode(statusCode);

	}
	/**
	 * 
	 * @author priya
	 * @see purpose of this method Verifying product reponse message matching with expected message by using assert
	 * @since 02-06-2023
	 */

	@Then("User should verify the search product response message matches {string}")
	public void user_should_verify_the_search_product_response_message_matches(String expSearchProductMsg) {
		SearchProduct_Output_Pojo searchProduct_Output_Pojo = response.as(SearchProduct_Output_Pojo.class);
		String actSearchProductMsg = searchProduct_Output_Pojo.getMessage();
		Assert.assertEquals("Verify SearchProduct", expSearchProductMsg, actSearchProductMsg);

	}

}
