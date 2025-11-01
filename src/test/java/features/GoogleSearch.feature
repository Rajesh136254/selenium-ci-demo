Feature: Google Search Feature

  @search1
  Scenario: Search for HI
    Given User is on Google Home Page
    When User Searches for "Hi"
    Then Page title should contain "Hi"

  @search2
    Scenario: Search for Hello
    Given User is on Google Home Page
    When User Searches for "Hello"
    Then Page title should contain "Hello"


  @search3
  Scenario: Search for Bye
    Given User is on Google Home Page
    When User Searches for "Bye"
    Then Page title should contain "Bye"