@SearchProduct
Feature: Search Product Module API automation

  @S1
  Scenario Outline: Verify search product in the application through API
    Given User add headers to search product
    When User add request body to search product "<text>"
    And User send "POST" request for search product endpoint
    Then User should verify the status code is 200
    And User should verify the search product response message matches "OK"

    Examples: 
      | text |
      | Nuts |
