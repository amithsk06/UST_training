@Search
Feature: Search
  A user should be able to search for a contact

  @searchContact
  Scenario Outline: Searching a contact
    Given User opens the contact App
    When User clicks on search bar
    And User enters "<name>" in the search box
    And User clicks on the search result
    Then User get the contact details of "<name>"

    Examples: 
      | name        |
      | Tex Pyper | 
      | K    |     
