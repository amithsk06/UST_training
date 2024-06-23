
@Cart
Feature: Add to Cart
   Adding pets to the cart

  @directly
  Scenario: Adding Cart directly
    Given User on the PetStore 
    When User clicks fish
 		Then User validates fish page
 		When User navigates to Angel Fish
 		Then User validates the page
 		When User clicks Add to Cart
 		Then User validates cart page
   	When User clicks home page
   	Then User validates home page
   	


  


