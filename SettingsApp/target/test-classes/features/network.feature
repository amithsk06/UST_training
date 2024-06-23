
Feature: NetWork and Internet 
@network
  Scenario Outline: Change airplane mode
    Given User opens the settings App
    When User clicks on nework and internet
    Then User moves to corresponding page
    When User change airoplane mode
   Then In calls & sms section "<message>" to be added

    Examples: 
      | message       |
      |T-Mobile (Temporarily unavailable)| 
        
