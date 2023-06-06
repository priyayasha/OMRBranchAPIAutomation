@State
Feature: State Module API Automation

  Scenario: Verify user get StateList theourgh API
    Given User add header for state
    When User send "GET" request for StateList endpoint
    Then User should verify the status code is 200
    And User should verify the StateList response message matches "Tamil Nadu" and save stateId
