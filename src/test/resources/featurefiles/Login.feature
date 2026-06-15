Feature: Login functionality

  Scenario: Valid login
    Given User launches the browser
    When User opens the login page
    And User enters username and password
    Then User should login successfully