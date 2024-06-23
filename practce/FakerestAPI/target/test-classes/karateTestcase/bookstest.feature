Feature: fake rest book api

  Background: 
    * url 'https://fakerestapi.azurewebsites.net/'
    * def bookid = {id:'1'}

  Scenario: Get book information
    Given path '/api/v1/Books'
    When method get
    Then status 200
    And match response[0].title == 'Book 1'
    And match response[0].pageCount == 100

  Scenario: Post book information
    Given path '/api/v1/Books'
    And request
      """
      {
          "id": 1,
          "title": "anand",
          "description": "Lorem lorem lorem. Lorem lorem lorem. \n",
          "pageCount": 700,
          "excerpt": "Lorem lorem lorem. Lorem lorem lorem. Lorem lorem lorem.\nLorem lorem lorem. Lorem lorem lorem. Lorem lorem lorem.\nLorem lorem lorem. Lorem lorem lorem. Lorem lorem lorem.\nLorem lorem lorem. Lorem lorem lorem. Lorem lorem lorem.\nLorem lorem lorem. Lorem lorem lorem. Lorem lorem lorem.\n",
          "publishDate": "2024-04-30T18:16:44.2287979+00:00"
      }
      """
    When method post
    Then status 200
    And match response.title == 'anand'
    And match response.pageCount == 700
    * def bookid = response.id

  Scenario: Get book information by ID (using bookid)
    Given path '/api/v1/Books/1'
    #And param id = bookid
    When method get
    Then status 200
    And match response.title == 'Book 1'
    And match response.pageCount == 100
    * print response

  Scenario Outline: Post Multiple books
    Given path '/api/v1/Books'
    And request {"id": <id>,"title": "<title>","description":"<description>","pageCount": <pageCount>,"excerpt": "<excerpt>","publishDate": "<publishdate>"}
    When method POST
    Then status 200
    And match response.id == <id>
    And match response.title == "<title>"
    And match response.publishDate contains "<publishdate>"

    Examples: 
      | id | title  | description        | pageCount | excerpt     | publishdate                       |
      |  1 | Book 1 | lorem lorem lorem. |       100 | lorem lorem | 2024-04-30T18:16:44.2287979+00:00 |
      |  2 | Book 2 | lorem lorem lorem. |       200 | lorem lorem | 2024-04-30T18:16:44.2287979+00:00 |
      |  3 | Book 3 | lorem lorem lorem. |       300 | lorem lorem | 2024-04-30T18:16:44.2287979+00:00 |

  Scenario: Update book information
    Given path '/api/v1/Books/1'
    And request
      """
       {
          "id": 1,
          "title": "anand",
          "description": "Lorem lorem lorem. Lorem lorem lorem. ",
          "pageCount": 700,
          "excerpt": "Lorem lorem lorem. Lorem lorem lorem.",
          "publishDate": "2024-04-30T18:16:44.2287979+00:00"
       }
      """
    When method put
    Then status 200
    And match response.title == 'anand'
    And match response.pageCount == 700
    * print response

  Scenario: Deletes an book
    Given path '/api/v1/Books/1'
    When method DELETE
    Then status 200
