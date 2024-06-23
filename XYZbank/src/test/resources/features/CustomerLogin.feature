#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@CustomerLogin
Feature: Login
  As a customer i want to login to XYZ Bank site

  @deposit
  Scenario: Login with manager created account
    Given User already open the XYZ Bank site and goes to login page
    When User input customer name to login 
    Then User navigates to accounts page
    When User deposits money 
    Then Check whether the money has been credited 
  