@Login
Feature: Login Module API Automation

  Scenario Outline: Get user logtoken from login endpoint
    Given User add header
    When User add basic authentication for login "<user_Name>" and "<password>"
    And User send "POST" request for login endpoint
    Then User should verify the status code is 200
    And User should verify the login response body firstName present as "Shanmuga priya" and get the logtoken

    Examples: 
      | user_Name             | password     |
      | priya.yasha@gmail.com | 25Yasha$1990 |
