@Contacts
Feature: Test contacts CRED operations
  I want to use this template for testing contact application

  @create
  Scenario: Create a new user
    Given User already on contacts page
    When User adds a new contact
    Then I validate the outcomes
