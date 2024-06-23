@alarmCheck
Feature: Check alarm functionality

  @alarm
  Scenario: Set new alarm functionality
    Given I am in the clock app
    And I click the alarm option
    And I click the plus button
    And I set the time
    When the user clicks OK
    Then the corresponding details should be displayed
