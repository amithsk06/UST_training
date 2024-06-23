@PurchaseItemByCategory
Feature: Carting an item from category

  Scenario: Searching with Category
    Given User already on Forest Essential India website and hover over Men Option 
    And  Selects Hair Care link
    Then Validate if the user is navigated to destined Hair Care page
    When User apply sort(Lowest first)
    Then Validates if the items are sorted in ascending
    And User clicks the first item
    And User check for the delivery time
    Then Validate possibility of delivery
    When User Increse the size and number
    And User Carts the item
    Then Validate item has been added
    