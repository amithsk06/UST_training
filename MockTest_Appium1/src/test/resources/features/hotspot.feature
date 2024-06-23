Feature: Tethering and Hotspot
validate the elements in hotspot

  Scenario Outline: Hotspot
    Given open Settings
    When Click Network and internet
    And Click Hotspot
    And Click WifiHotspot
    Then Switch on the hostpot