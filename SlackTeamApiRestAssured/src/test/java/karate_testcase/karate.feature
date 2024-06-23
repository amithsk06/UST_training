Feature: SlackTeamApi

  Background: 
    * url 'http://localhost:8080/trainee'

  Scenario: Get trainee information
    Given path '/all'
    When method get
    Then status 200
    
    

	Scenario Outline: Get trainee with ID
    Given path '/<trainee_id>'
    When method get
    Then status 200
    And match response.id == <trainee_id>
    And match response.name == "<name>"

Examples:
  | trainee_id   |   name       |
  | 6            |  anand       |
  | 102          |  nabil       |
  | 104          |  nabil       |
  
  
	Scenario: Post trainee with id
	 Given path '/trainees'
	 And request
	 """
	 {
    "name": "Tex",
    "lastName": "Pyper Mcgurk",
    "email": "texpyper123@gmail.com",
    "city": "texas"
   }
   """
   When method post
	 Then status 200
	 And match response.name == 'Tex'
   And match response.city == 'texas'
	 	 
	Scenario Outline: Put trainee with id
	 Given path '/trainees/<trainee_id>'
	 And request 
	 """
	 {
        "name": "nabil",
        "lastName": "sulthan",
        "email": "nb@gmail.com",
        "city": "varkala"
    }
   """
   When method put
   Then status 200
   And match response.name == 'nabil'
   And match response.city == 'varkala'
  
Examples:

  | trainee_id   |
  |153           |
   
   
    Scenario: Delete a trainee
    Given path '/trainees/156'
    When method DELETE
    Then status 200
