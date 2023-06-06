@City
Feature: City Module API Automation

  @C1
  Scenario: Verify user get CityList theourgh API
    Given User add headers for city
    When User send "POST" request for CityList endpoint
    Then User should verify the status code is 200
    And User should verify the CityList response message matches "Yercaud" and save cityId
