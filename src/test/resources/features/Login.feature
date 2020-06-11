#Any step that was implemented before can be reused
# if test step has yellow backround,that means it does not have implementation yet
# By passing parameters/string in "some word we can reuse test steps

Feature: Login
  As user, I want to able to login into vytrack
  under different roles with username and password

  @store_manager
  Scenario: Login as store manager
    Given user is on the login page
    Then user logs in as "store manager"
    And user verifies that "Dashboard" page subtitle is displayed

  @driver
  Scenario: Login as Driver
    Given user is on the login page
    Then user logs in as "driver"
    And user verifies that "Quick Launchpad" page subtitle is displayed

  @sales_manager
  Scenario: Login as sales manager
    Given user is on the login page
    Then user logs in as "sales manager"
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

  @driver_with_data_table
  Scenario: Login as Driver(data table example)
    Given user is on the login page
    Then user logs in as driver with following credintals
      | username | user160     |
      | password | UserUser123 |
    And user verifies that "Quick Launchpad" page subtitle is displayed

  @login_with_role_ddt
  Scenario Outline: DDT Example , Login as <role>
    Given user is on the login page
    Then user logs in as "<role>"
    Examples: roles
      | roles         |
      | driver        |
      | sales manager |
      | store manager |

  @login_with_credentials_ddt
  Scenario Outline: Ddt example  with crededntial, Login as <username>
    Given user is on the login page
    Then users enters "<username>" username and "<password>" password
    Examples:
      | username        | passsword   |
      | user160         | UserUser123 |
      | storemanager85  | UserUser123 |
      | salesmanager110 | UserUser123 |

  @login_with_roles_verify_titles
  Scenario Outline: Login as <role> and verify <title>
    Given user is on the login page
    Then user logs in as "<role>"
    When user navigates to "<module>" then to "<submodule>"
    Then the page title should be "<title>"


    Examples: Driver
      | role   | module     | submodule       | title                                                        |
      | driver | Fleet      | Vehicles        | Car - Entities - System - Car - Entities - System            |
      | driver | Fleet      | Vehicles Model  | Vehicles Model - Entities - System - Car - Entities - System |
      | Driver | Customers  | Accounts        | Accounts - Customers                                         |
      | Driver | Customers  | Contacts        | Contacts - Customers                                         |
      | Driver | Activities | Calendar Events | Calendar Events - Activities                                 |
      | Driver | System     | Jobs            | Jobs - System                                                |

    Examples: sales manager
      | role          | module     | submodule       | title                                                        |
      | sales manager | Fleet      | Vehicles        | Car - Entities - System - Car - Entities - System            |
      | sales manager | Fleet      | Vehicles Model  | Vehicles Model - Entities - System - Car - Entities - System |
      | sales manager | Customers  | Accounts        | Accounts - Customers                                         |
      | sales manager | Customers  | Contacts        | Contacts - Customers                                         |
      | sales manager | Activities | Calendar Events | Calendar Events - Activities                                 |
      | sales manager | System     | Jobs            | Jobs - System                                                |


    Examples: store manager
      | role           | module     | submodule       | title                                                        |
      | store manager  | Fleet      | Vehicles        | Car - Entities - System - Car - Entities - System            |
      | store  manager | Fleet      | Vehicles Model  | Vehicles Model - Entities - System - Car - Entities - System |
      | store manager  | Customers  | Accounts        | Accounts - Customers                                         |
      | store manager  | Customers  | Contacts        | Contacts - Customers                                         |
      | store manager  | Activities | Calendar Events | Calendar Events - Activities                                 |
      | store manager  | System     | Jobs            | Jobs - System                                                |




