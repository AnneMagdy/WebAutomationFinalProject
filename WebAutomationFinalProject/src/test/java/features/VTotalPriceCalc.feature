Feature: Verify Total Price Calculation
  Scenario: Verify item total equals sum of product prices
    Given user is logged in
    When user has two products in the cart
    Then record prices of both products from the cart
