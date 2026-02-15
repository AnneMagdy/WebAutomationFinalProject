Feature: Add products to cart
  Scenario: Add Sauce Labs Backpack to cart and verify it appears correctly
    Given user is on the products page
    When  user adds to cart for Sauce Labs Backpack
    Then  Product Sauce Labs Backpack appears in the cart

  Scenario: Add Sauce Labs Bolt T-Shirt to cart and verify it appears correctly
    Given user on the products page
    When  user adds to cart for Sauce Labs Bolt T-Shirt
    Then  Product Sauce Labs Backpack and Sauce Labs Bolt T-Shirt appears in the cart