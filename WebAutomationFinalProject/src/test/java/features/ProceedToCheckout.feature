Feature: Checkout Process and Verify Total Price
  Scenario: Complete purchase and verify total price
    Given user is logged in and has products in the cart
    When user clicks Checkout button
    Then total price should match the previous total on the cart page

  Scenario: User leaves First Name blank and tries to continue
    Given  user is on checkout page
    When user leaves the First Name field blank and clicks Continue button
    Then error message "Error: First Name is required." should be displayed


