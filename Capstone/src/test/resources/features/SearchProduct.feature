@Search
Feature: search functionality

 @NoLists
 Scenario: No list found 
 Given I am in home page
 And I click on the search icon
 And I fill in the search field with "hee"
 When I click on the search button
 Then I should see "Your search returned no results." message
 
  @add
 Scenario Outline: To get list of valid search list
 Given I am in home page
 When I click on the search icon
 And I fill in the search field with "<products>"
 And I click on the search button
 Then I should see the list of valid search list with "<products>"
 
 Examples:
 | products  |
 | Spray     |
 

 

 

 
 



