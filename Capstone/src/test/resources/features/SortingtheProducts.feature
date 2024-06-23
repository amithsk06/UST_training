@Sort
Feature: To sort products
 
 @asc
 Scenario: Sorting Low To High Price
 Given I am in home page
 And I click on the search icon
 And I fill in the search field with "scrub"
 When I click on the search button
 And Select sort by price low to high
 Then Product displayed in ascending order of price

@desc
 Scenario: Sorting High To Low Price
 Given I am in home page
 And I click on the search icon
 And I fill in the search field with "scrub"
 When I click on the search button
 And Select sort by price high to low
 Then Product displayed in descending order of price