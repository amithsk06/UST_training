Feature: User Management API

  Background: 
    * url 'https://dummy.restapiexample.com/'
    * configure ssl = true

  Scenario: Retrieve a User
    Given path 'api/v1/employee/1'
    When method GET
    Then status 200
    And match response.data.id == 1
    And match response.data.employee_name == 'Tiger Nixon'
    And match response.data.employee_salary == 320800
    And match response.data.employee_age == 61
