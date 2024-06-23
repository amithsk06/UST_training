Feature: Login Validation
  @valid_login
  Scenario Outline: Valid login
    Given the user is on the Pharmeasy login page
    When the user enters "<username>" and "<password>"
    And the user clicks the login button
    Then the user should be logged in successfully
    And the user should be redirected to the homepage
    Examples:
      | username    | password    |
      | valid_user  | valid_pass  |
  @invalid_login
  Scenario Outline: Invalid login
    Given the user is on the Pharmeasy login page
    When the user enters "<username>" and "<password>"
    And the user clicks the login button
    Then the user should see an error message
    And the user should not be logged in
    Examples:
      | username       | password       |
      | invalid_user   | invalid_pass   |
      | special!@#     | special!@#     |
      | valid_user     |                |
      |                | valid_pass     |
      |                |                |
