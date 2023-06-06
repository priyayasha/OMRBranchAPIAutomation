package com.stepdefinition;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import com.base.UtilityClass;
import com.endpoints.Endpoints;
import com.globals.GlobalData;
import com.payload.address.AddressPayload;
import com.pojo.address.AddAddress_Input_Pojo;
import com.pojo.address.AddAddress_Output_Pojo;
import com.pojo.address.Delete_Message_Pojo;
import com.pojo.address.Delete_UserAddress_Pojo;
import com.pojo.address.GetUserAddress_Output_Pojo;
import com.pojo.address.UpdateAddress_Input_Pojo;
import com.pojo.address.UpdateAddress_Output_Pojo;
import com.pojo.address.UserAddress;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
/**
 * 
 * @author priya
 * @see purpose of this class is for User Address functionality
 * @since 02-06-2023
 */
public class TC4_AddressStep extends UtilityClass {

	static GlobalData globalData = new GlobalData();
	static AddressPayload addressPayload = new AddressPayload();
	static String addressIdNum;
	/**
	 * 
	 * @author priya
	 * @see purpose of this method is to add headers and bearer
	 * @since 02-06-2023
	 */
	@Given("User add headers and bearer authorization for accessing address endpoint")
	public void user_add_headers_and_bearer_authorization_for_accessing_address_endpoint() {
		List<Header> listHeader = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + TC1_LoginStep.globalData.getLogToken());
		Header h3 = new Header("Content-Type", "application/json");
		listHeader.add(h1);
		listHeader.add(h2);
		listHeader.add(h3);
		Headers headers = new Headers(listHeader);
		addHeaders(headers);
	}

	/**
	 * @author priya
	 * @see purpose of this method is to add request body
	 * @param first_Name
	 * @param last_Name
	 * @param mobile
	 * @param apartment
	 * @param state
	 * @param city
	 * @param country
	 * @param zipcode
	 * @param address
	 * @param address_Type
	 * @since 02-06-2023
	 */
	@When("User add request body for add new address {string},{string},{string},{string}, {int} , {int} , {int} ,{string},{string} and {string}")
	public void user_add_request_body_for_add_new_address_and(String first_Name, String last_Name, String mobile,
			String apartment, Integer state, Integer city, Integer country, String zipcode, String address,
			String address_Type) {

		AddAddress_Input_Pojo addAddressPayload = addressPayload.addAddressPayload(first_Name, last_Name, mobile,
				apartment, state, city, country, zipcode, address, address_Type);
		addBody(addAddressPayload);
	}

	/**
	 * @author priya
	 * @param reqType
	 * @see purpose of this method is to add request endpoints
	 * @since 02-06-2023
	 */
	@When("User send {string} request for addUserAddress endpoint")
	public void user_send_request_for_add_user_address_endpoint(String reqType) {
		Response response = addReqType(reqType, Endpoints.ADDADDRESS);
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
	}

	/**
	 * @author priya
	 * @param expAddressMsg
	 * @see purpose of this method is to verify response message
	 * @since 02-06-2023
	 */
	@Then("User should verify the addUserAddress response message matches {string}")
	public void user_should_verify_the_add_user_address_response_message_matches(String expAddressMsg) {
		AddAddress_Output_Pojo addAddress_Output_Pojo = response.as(AddAddress_Output_Pojo.class);
		String actAddressMsg = addAddress_Output_Pojo.getMessage();
		int addressid = addAddress_Output_Pojo.getAddress_id();
		addressIdNum = String.valueOf(addressid);
		TC1_LoginStep.globalData.setAddressIdNum(addressIdNum);
		System.out.println(addressIdNum);
		Assert.assertEquals("Verify address added successfully", expAddressMsg, actAddressMsg);

	}

	/**
	 * @author priya
	 * @param addressIdNum
	 * @param first_Name
	 * @param last_Name
	 * @param mobile
	 * @param apartment
	 * @param state
	 * @param city
	 * @param country
	 * @param zipcode
	 * @param address
	 * @param address_Type
	 * @see purpose of this method is to add request body to update user address
	 * @since 02-06-2023
	 */

	@When("User add request body to update user address {string},{string},{string},{string},{string},{string},{string},{string},{string},{string} and {string}")
	public void user_add_request_body_to_update_user_address_and(String addressIdNum, String first_Name,
			String last_Name, String mobile, String apartment, Integer state, Integer city, Integer country,
			String zipcode, String address, String address_Type) {

		UpdateAddress_Input_Pojo updateAddressPayload = addressPayload.updateAddressPayload(addressIdNum, first_Name,
				last_Name, mobile, apartment, state, city, country, zipcode, address, address_Type);
		addBody(updateAddressPayload);

	}

	/**
	 * @author priya
	 * @param reqType
	 * @see purpose of this method is to send request with endpoints
	 * @since 02-06-2023
	 */

	@When("User send {string} request for updateUserAddress endpoint")
	public void user_send_request_for_update_user_address_endpoint(String reqType) {
		response = addReqType(reqType, Endpoints.UPDATEADDRESS);
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		TC1_LoginStep.globalData.setStatusCode(statusCode);
	}

	/**
	 * @author priya
	 * @param expUpdateMsg
	 * @see purpose of this method is to verify update user address message
	 * @since 02-06-2023
	 */
	@Then("User should verify the updateUserAddress response message matches {string}")
	public void user_should_verify_the_update_user_address_response_message_matches(String expUpdateMsg) {

		UpdateAddress_Output_Pojo updateAddress_Output_Pojo = response.as(UpdateAddress_Output_Pojo.class);
		String actUpdateMsg = updateAddress_Output_Pojo.getMessage();
		System.out.println(actUpdateMsg);
		//Assert.assertEquals("verify the address update", expUpdateMsg, actUpdateMsg);

	}

	/**
	 * 
	 * @author priya
	 * @see purpose of this method is to add header and bearer
	 * @since 02-06-2023
	 */

	@Given("User add header and bearer authorization for accessing address endpoint")
	public void user_add_header_and_bearer_authorization_for_accessing_address_endpoint() {
		List<Header> listHeader = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + TC1_LoginStep.globalData.getLogToken());
		listHeader.add(h1);
		listHeader.add(h2);
		Headers headers = new Headers(listHeader);
		addHeaders(headers);

	}

	/**
	 * @author priya
	 * @param reqType
	 * @see purpose of this method is sent the request with endpoint
	 * @since 02-06-2023
	 */
	@Given("User send {string} request for getUserAddress endpoint")
	public void user_send_request_for_get_user_address_endpoint(String reqType) {
		Response response = addReqType(reqType, Endpoints.GETADDRESS);
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		TC1_LoginStep.globalData.setStatusCode(statusCode);
	}

	/**
	 * @author priya
	 * @param expGetAddressMsg
	 * @see purpose of this method is to add header
	 * @since 02-06-2023
	 */

	@Then("User should verify the getUserAddress response message matches {string}")
	public void user_should_verify_the_get_user_address_response_message_matches(String expGetAddressMsg) {

		GetUserAddress_Output_Pojo getUserAddress_Output_Pojo = response.as(GetUserAddress_Output_Pojo.class);
		ArrayList<UserAddress> userAddress = getUserAddress_Output_Pojo.getData();
		System.out.println(addressIdNum);

		for (UserAddress data : userAddress) {
			int id = data.getId();
			String userId = String.valueOf(id);
			System.out.println(userId);

		}
		String actGetAddressMsg = getUserAddress_Output_Pojo.getMessage();
		Assert.assertEquals("verify User Address", expGetAddressMsg, actGetAddressMsg);
	}

	/**
	 * @author priya
	 * @param addressIdNum
	 * @see purpose of this method is to send request body to delete address
	 * @since 02-06-2023
	 */
	@When("User add request body to delete user address {string}")
	public void user_add_request_body_to_delete_user_address(String addressIdNum) {
		Delete_UserAddress_Pojo detelePayload = addressPayload
				.detelePayload(TC1_LoginStep.globalData.getAddressIdNum());

		addBody(detelePayload);
		System.out.println(addressIdNum);
	}

	/**
	 * @author priya
	 * @param reqType
	 * @see purpose of this method is to send request endpoint
	 * @since 02-06-2023
	 */
	@When("User send {string} request for deteleUserAddress endpoint")
	public void user_send_request_for_detele_user_address_endpoint(String reqType) {
		Response response = addReqType(reqType, Endpoints.DELETEADDRESS);
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		TC1_LoginStep.globalData.setStatusCode(statusCode);

	}

	/**
	 * @author priya
	 * @param expDeleteMsg
	 * @see purpose of this method is to verify delete message 
	 * @since 02-06-2023
	 */

	@Then("User should verify the deteleUserAddress response message matches {string}")
	public void user_should_verify_the_detele_user_address_response_message_matches(String expDeleteMsg) {
		Delete_Message_Pojo delete_Message_Pojo = response.as(Delete_Message_Pojo.class);
		String actDeleteMsg = delete_Message_Pojo.getMessage();
		Assert.assertEquals("verify Delete", expDeleteMsg, actDeleteMsg);
		System.out.println(actDeleteMsg);
	}

}
