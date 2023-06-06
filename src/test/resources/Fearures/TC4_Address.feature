@Address
Feature: Address Module API Automation

  @A1
  Scenario Outline: Verify addUserAddress to the application through API
    Given User add headers and bearer authorization for accessing address endpoint
    When User add request body for add new address "<first_Name>","<last_Name>","<mobile>","<apartment>", <state> , <city> , <country> ,"<zipcode>","<address>" and "<address_Type>"
    And User send "POST" request for addUserAddress endpoint
    Then User should verify the status code is 200
    And User should verify the addUserAddress response message matches "Address added successfully"

    Examples: 
      | first_Name | last_Name | mobile     | apartment | state | city | country | zipcode | address | address_Type |
      | priya      | yasha     | 9176252515 | kkFlats   |    35 | 3659 |     101 |  600118 | chennai | home         |

  @A2
  Scenario Outline: Verify updateUserAddress to the application through API
    Given User add headers and bearer authorization for accessing address endpoint
    When User add request body for add new address "<first_Name>","<last_Name>","<mobile>","<apartment>", <state> , <city> , <country> ,"<zipcode>","<address>" and "<address_Type>"
    And User send "PUT" request for updateUserAddress endpoint
    Then User should verify the status code is 200
    And User should verify the updateUserAddress response message matches "Address updated successfully"

    Examples: 
      | address_Id | first_Name | last_Name | mobile     | apartment    | state | city | country | zipcode | address | address_Type |
      |            | priya      | yasha     | 9176252515 | Prince Flats |    35 | 3659 |     101 |  600118 | chennai | home         |

  @A3
  Scenario: Verify getUserAddress from the application through API
    Given User add header and bearer authorization for accessing address endpoint
    And User send "GET" request for getUserAddress endpoint
    Then User should verify the status code is 200
    And User should verify the getUserAddress response message matches "OK"

  @A4
  Scenario Outline: Verify deteleUserAddress in the application through API
    Given User add headers and bearer authorization for accessing address endpoint
    When User add request body to delete user address "<addressId>"
    And User send "DELETE" request for deteleUserAddress endpoint
    Then User should verify the status code is 200
    And User should verify the deteleUserAddress response message matches "Address deleted successfully"

    Examples: 
      | address_Id |
      |      56028 |
