@ShopByBreed
Feature: Purchase Dog Behaviour Consultation

	@positive
  Scenario: Purchase Dog Behaviour Consultation
    Given User navigate to the Supertails website
    When User select "Labrador" from Shop By Breed section
    Then User should validate the page
    And User select "Training"
    And User navigate to Consult Now page 
    And Click view details of Dog Behaviour Consultation
    And Click on Buy It Now
    Then User should validate the checkout page