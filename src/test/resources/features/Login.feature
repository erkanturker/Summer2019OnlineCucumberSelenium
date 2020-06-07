Feature: Login
  As user, I want to able to login into vytrack
  under different roles with username and password

  Scenario: Login as store manager
    Given user is on the login page
    Then user logs in as store maneger
    And user verifies that "Dashboard" page subtitle is displayed
