Feature: Add to Cart
  @cart
  Scenario Outline: Carting
    Given the user is on home page
    When User searches for "Cargo"
    Then Cargo search page is loaded
    When User edits the filter options
    Then new search page is loaded
    When User clicks the first item
    Then Item page is loaded
    When User add the item to cart
    Then User validates the item if its is carted
    
   
  

