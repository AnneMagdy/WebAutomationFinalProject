Feature: Remove Product from Cart
  Scenario: User removes a product from the cart successfully
    Given user is on products page
    When user adds a product to the cart and clicks Remove button
    Then product should be removed from the cart
    