@ReviewFunctionality
Feature: Checking out reviews for an item
  
  Scenario Outline: Post a Review
    Given User already on Forest Essential India website and hover over Men Option 
    And  Selects Hair Care link
    Then Validate if the user is navigated to destined Hair Care page
    And User clicks the first item
    When User clicks review stars of the product it scrolls to review part
    Then Validate if each review stars are present
    And Apply filter directly
    And Check if filter is applied or not
    And Like the review posts and validate
    And Validate if clicking Clear All is working
    And Dislike the review posts and validate
    When User clicks Write a Review button 
    Then Validate if the Write a Review part is loaded
    When Gives a Rating to the product
    And Provide data to "<title>","<Review>","<name>","<email>"
    And Post the review
    Then Validate the post 
    
    Examples:
    | title                           | Review                   | name       | email                                |                  
    | Good to use the product               | I love the product    | Tom         | tomchandler@gmail.com       |
    
    #change the review messgae each time1

   
    
