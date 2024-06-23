
Feature: User Management API
 
  Background: 
  * url 'https://reqres.in/api'
  * configure ssl = true
  
Scenario: Retreive a User 
	Given path '/users/2'
	When method GET
	Then status 200
	And match response.data.id == 2
	And match response.data.email == 'janet.weaver@reqres.in'
	And match response.data.first_name == 'Janet'
	And match response.data.last_name == 'Weaver'