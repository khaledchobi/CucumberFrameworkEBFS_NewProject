Feature: Automated User Registration Tests
  Description: The purpose of this feature is to test User Registration

  Scenario Outline: Registration scenario with different set of data
    Given User is on Home Page
    And User is on the Login Page
    When User enters email address for Registration
    And User is on Registration Page
    And User fills "<customer>" details page to register


    Examples:
      |customer|
      |Leanne|