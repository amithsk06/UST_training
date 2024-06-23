Feature: FakeRestAPI Books

  Background: 
    * url 'https://freefakeapi.io'
    * configure ssl = true

  Scenario: Get comment information
    Given path '/api/comments'
    When method GET
    Then status 200
    And match response[0].id == '1'
    And match response[0].content == "I'm so happy with the quality of this post !"

  Scenario: Get comment by ID
    Given path '/api/comments/2'
    When method get
    Then status 200
    And match response.id == '2'
    

  Scenario: Post comment
    Given path '/api/comments'
    And request
      """
      {
      "content": "This is the 100th comment content",
      "user": 1,
      "post": 5
      }
      """
    When method post
    Then status 200
    And match response.user == '1'
    And match response.content == 'This is the 100th comment content'
