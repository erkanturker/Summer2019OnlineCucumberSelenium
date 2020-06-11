@Create_Car
Feature: Create a Car

  Scenario: Store manager should able to create a car
    Given user is on the login page
    And user logs in as store manager
    Then user navigates to "Fleet" then to "Vehicles"
    And user clicks on "Create Car" button
    And user adds new car information
      | License Plate | Driver      | Location | Model Year | Color |
      | ForzaFerrari  | Kimi        | Indiana  | 2020       | Red   |
      | Superman      | Cool Driver | Texas    | 2019       | Black |


