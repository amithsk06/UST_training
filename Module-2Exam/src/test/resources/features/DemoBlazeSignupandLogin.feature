@SignupandLogin
Feature: Signup and Login
   User wants to Signup and login with a new account

  @Signup
  Scenario: User wants to sign up with an account
    Given User is already on the demo blaze website
   	When User clicks Signup icon
   	Then User checks if signup Modal is displayed
    When User enter "Tex1" as username and "TexPyper" as password
    And User clicks signup button
    Then User checks is "Sign up successful." is displayed as alert
    
  @LoginPositive
  Scenario: User wants to Login with valid data
    Given User is already on the demo blaze website
   	When User clicks Login icon
   	Then User checks if login Modal is displayed
    When User enter "Tex1" as username and "TexPyper" as password in the login fields
    And User clicks login button
    Then User checks is "Welcome Tex1" is displayed on the site

  @LoginNegative
  Scenario Outline: User wants to Login with invalid data
    Given User is already on the demo blaze website
   	When User clicks Login icon
   	Then User checks if login Modal is displayed
    When User enter "<username>" as username and "<password>" as password in the login fields
    And User clicks login button
		Then User checks is "<message>" is displayed as alert
		And Take Screenshot
    Examples: 
      | 			username  			| 				password 				|											 message  											|
      | 		 Chandler       	|    		lastship  				| 									User does not exist.							|
      |												|    		notapassword			| 			Please fill out Username and Password. 			  |
      |			 Ravit     				|    											| 			Please fill out Username and Password. 			  |
