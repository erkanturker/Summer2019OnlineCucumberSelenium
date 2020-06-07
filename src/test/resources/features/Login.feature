#Any step that was implemented before can be reused
# if test step has yellow backround,that means it does not have implementation yet
# By passing parameters/string in "some word we can reuse test steps

Feature: Login
  As user, I want to able to login into vytrack
  under different roles with username and password

  @store_manager
  Scenario: Login as store manager
    Given user is on the login page
    Then user logs in as store manager
    And user verifies that "Dashboard" page subtitle is displayed

  @driver
  Scenario: Login as Driver
    Given user is on the login page
    Then user logs in as driver
    And user verifies that "Dasboard" page subtitle is displayed

  @sales_manager
  Scenario: Login as sales manager
    Given user is on the login page
    Then user logs in as sales manager
    And user verifies that "Dashboard" page subtitle is displayed

  @negative_test
  Scenario: Verify that waning message is display when password is not correct
    Given user is on the login page
    Then users enters "storemanager85" username and "wrong" password
    And user verifies that "Invalid user name or password" message is displayed

  @negative_test
  Scenario: Verify that waning message is display when password is not correct
    Given user is on the login page
    Then users enters "wrong_username" username and "UserUser123" password
    And user verifies that "Invalid user name or password" message is displayed

