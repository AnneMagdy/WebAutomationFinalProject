Feature: Logout Functionality
  Scenario: User logs out successfully
    Given user logged in
    When user clicks on the Menu button and selects Logout
    Then user should be redirected to Login page


