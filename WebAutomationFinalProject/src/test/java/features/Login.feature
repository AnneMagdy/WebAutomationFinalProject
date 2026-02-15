Feature: Login feature
  Scenario: Login with valid data
    Given user is on the login page
    When  user enter with valid username and valid password
    Then  user should be directed to Products page


  Scenario: Login with invalid data
    Given user on the login page
    When  user enter with valid username and invalid password
    Then  An error message should be displayed


  Scenario: Login with locked_out_user
    Given user is on login page
    When  user enter with locked_out_user and valid password
    Then  An error message is displayed

