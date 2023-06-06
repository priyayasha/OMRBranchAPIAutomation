package com.payload.address;
import com.pojo.address.AddAddress_Input_Pojo;
import com.pojo.address.Delete_UserAddress_Pojo;
import com.pojo.address.UpdateAddress_Input_Pojo;

/**
 * 
 * @author priya
 * @see purpose of this class get objects for address payload
 *@since 02-06-2023
 */
public class AddressPayload {

	/**
	 * 
	 * @author priya
	 * @see purpose of this method to create object for add address payload
	 *@since 02-06-2023
	 */
	public AddAddress_Input_Pojo addAddressPayload(String fName, String lName, String mobileNo, String apartment,
			int stateId, int cityId, int countryId, String zipCode, String address, String address_Type) {

		AddAddress_Input_Pojo addAddress_Input_Pojo = new AddAddress_Input_Pojo(fName, lName, mobileNo, apartment,
				stateId, cityId, countryId, zipCode, address, address_Type);
		return addAddress_Input_Pojo;

	}
	/**
	 * 
	 * @author priya
	 * @see purpose of this method to create object for update address payload
	 *@since 02-06-2023
	 */

	public UpdateAddress_Input_Pojo updateAddressPayload(String addressId, String fName, String lName, String mobileNo,
			String apartment, int stateId, int cityId, int countryId, String zipCode, String address,
			String address_Type) {

		UpdateAddress_Input_Pojo updateAddress_Input_Pojo = new UpdateAddress_Input_Pojo(addressId, fName, lName,
				mobileNo, apartment, stateId, cityId, countryId, zipCode, address, address_Type);

		return updateAddress_Input_Pojo;

	}
	
	/**
	 * 
	 * @author priya
	 * @see purpose of this method to create object for delete address payload
	 *@since 02-06-2023
	 */
	
	public Delete_UserAddress_Pojo detelePayload(String addressId) {
		
		Delete_UserAddress_Pojo delete_UserAdress_Pojo = new Delete_UserAddress_Pojo(addressId);
		return delete_UserAdress_Pojo;
		
	}
}