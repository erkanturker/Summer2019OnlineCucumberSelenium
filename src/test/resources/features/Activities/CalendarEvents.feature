@calandar_events
Feature: All Calendar Events

  Scenario: Verify Column Names
    Given user is on the login page
    And user logs in as store manager
    Then user navigates to "Activities" then to "Calendar Events"
    And user verifies that that column names are displayed
      | TITLE             |
      | CALENDAR          |
      | START             |
      | END               |
      | RECURRENT         |
      | RECURRENCE        |
      | INVITATION STATUS |

