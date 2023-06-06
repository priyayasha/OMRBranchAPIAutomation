package com.base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
/**
 * 
 * @author priya
 * @see purpose of this class to create reusable methods
 * @since 02-06-2023
 */
public class UtilityClass {
	RequestSpecification reqSpec;
	public static Response response;
	/**
	 * 
	 * @author priya
	 * @see purpose of this method to add Header
	 * @since 02-06-2023
	 */
	// 1. Header
	public void addHeader(String key, String value) {
		reqSpec = RestAssured.given().header(key, value);
	}
	/**
	 * 
	 * @author priya
	 * @see purpose of this method to add path param
	 * @since 02-06-2023
	 */
	// 2. add pathParam
	public void addPathParam(String key, String value) {
	reqSpec = reqSpec.pathParam(key, value);
	}
	/**
	 * 
	 * @author priya
	 * @see purpose of this method to add Query param
	 * @since 02-06-2023
	 */
	// 3. add queryParam
	public void addQueryParam(String key, String value) {
		reqSpec = reqSpec.queryParam(key, value);
	}
	/**
	 * 
	 * @author priya
	 * @see purpose of this method to add request body
	 * @since 02-06-2023
	 */
	// 4. add body
	public void addBody(String body) {
		reqSpec = reqSpec.body(body);
	}
	/**
	 * 
	 * @author priya
	 * @see purpose of this method to add Response
	 * @since 02-06-2023
	 */
	// 5. add requesttype
	public Response addReqType(String type, String endpoint) {
		switch (type) {
		case "GET":
			response = reqSpec.log().all().get(endpoint);
			break;
		case "PUT":
			response = reqSpec.log().all().put(endpoint);
			break;
		case "POST":
			response = reqSpec.log().all().post(endpoint);
			break;
		case "PATCH":
			response = reqSpec.log().all().patch(endpoint);
			break;
		case "DELETE":
			response = reqSpec.log().all().delete(endpoint);
			break;

		default:
			break;
		}
		return response;
	}
	/**
	 * 
	 * @author priya
	 * @see purpose of this method to get the status code
	 * @since 02-06-2023
	 */
	// 6. get status code
	public int getStatusCode(Response response) {
		int statusCode = response.getStatusCode();
		return statusCode;
	}
	/**
	 * 
	 * @author priya
	 * @see purpose of this method to get body in pretty format
	 * @since 02-06-2023
	 */
	// 7. get as pretty string

	public String getBodyAsPrettyString(Response response) {
		String asPrettyString = response.asPrettyString();
		return asPrettyString;
	}
	/**
	 * 
	 * @author priya
	 * @see purpose of this method to get body as String
	 * @since 02-06-2023
	 */
	// 8. get as string
	public String getBodyAsString(Response response) {
		String asString = response.asString();
		return asString;
	}
	/**
	 * 
	 * @author priya
	 * @see purpose of this method to add basic authorization
	 * @since 02-06-2023
	 */
	// 9 . basic authentication
	public void addBasicAuth(String userName, String password) {
		reqSpec = reqSpec.auth().preemptive().basic(userName, password);
	}
	/**
	 * 
	 * @author priya
	 * @see purpose of this method to add headers
	 * @since 02-06-2023
	 */

	// 10. add headers
	public void addHeaders(Headers header) {
		reqSpec = RestAssured.given().headers(header);
	}
	/**
	 * 
	 * @author priya
	 * @see purpose of this method to add object as body
	 * @since 02-06-2023
	 */
	// 11. add object body
	public void addBody(Object body) {
		reqSpec = reqSpec.body(body);
	}
	/**
	 * 
	 * @author priya
	 * @see purpose of this method to get properties of file value
	 * @since 02-06-2023
	 */
	// 45 get File url
	public static String getPropertiesFileValue(String key) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(
				"C:\\Users\\AADHAN\\eclipse-workspace\\OMRBranchAPIAutomation\\Config\\Config.properties"));
		Object obj = properties.get(key);
		String value = (String) obj;
		return value;
	}
	/**
	 * 
	 * @author priya
	 * @see purpose of this method to get properties for projectpath
	 * @since 02-06-2023
	 */
	// 46 file path
	public static String getProjectPath() {
		String path = System.getProperty("user.dir");
		return path;
	}
}
