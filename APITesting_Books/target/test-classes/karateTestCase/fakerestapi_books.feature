Feature: FakeRestAPI Books

  Background: 
    * url 'https://fakerestapi.azurewebsites.net/'
     * def bookid = {id:'3'}

  Scenario: Get book information
    Given path '/api/v1/Books'
    When method get
    Then status 200
    And match response[0].title == 'Book 1'
    And match response[0].pageCount == 100
    
    Scenario: Get book information by ID
    Given path '/api/v1/Books/'
    And path  3
    When method get
    Then status 200
    And match response.title == 'Book 3'
    And match response.pageCount == 300
    * print response
    
    Scenario: Post book information
    Given path '/api/v1/Books'
    And request
      """
      {
          "id": 1,
          "title": "TexPyper",
          "description": "Lorem lorem lorem. Lorem lorem./n",
          "pageCount": 500,
          "excerpt": "Lorem lorem lorem. Lorem lorem lorem lorem lorem./n lorem lorem. Lorem lorem lorem. Lorem lorem lorem./nLorem lorem lorem. Lorem lorem lorem. Lorem lorem lorem./nLorem lorem lorem. Lorem lorem lorem. Lorem lorem lorem./nLorem lorem lorem. Lorem lorem lorem. Lorem lorem lorem.nn",
          "publishDate": "2024-04-30T18:16:44.2287979+00:00"
      }
      """
    When method post
    Then status 200
    And match response.title == 'TexPyper'
    And match response.pageCount == 500
    * def bookid = response.id
    
    Scenario Outline: Post Multiple books
    Given path '/api/v1/Books'
    And request {"id": <id>,"title": "<title>","description":"<description>","pageCount": <pageCount>,"excerpt": "<excerpt>","publishDate": "<publishdate>"}
    When method POST
    Then status 200
    And match response.id == <id>
    And match response.title == "<title>"
    And match response.publishDate contains "<publishdate>"

    Examples: 
      | id | title            | description            | pageCount | excerpt        | publishdate                                 |
      |  1 | The Twilight | lorem lorem lorem. |       300     | lorem lorem | 2024-04-30T18:16:44.2287979+00:00 |
      |  2 | New Moon   | lorem lorem lorem. |       250     | lorem lorem | 2024-04-30T18:16:44.2287979+00:00 |
      
    Scenario: Deletes an book
    Given path '/api/v1/Books/3'
    When method DELETE
    Then status 200