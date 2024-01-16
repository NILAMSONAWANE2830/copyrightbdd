Feature: sanity testing to validate Copyright.gov

  Scenario: registration page validation for copyright.gov
    Given user open "chrome" browser and nevigate to copyright.gov WebSite
    Then user enter general details like name,address,city,country
      | nilam | baramati | pune | India |

  Scenario Outline: 
    And user enter "<state>" "<nationality>" "<emailid>" "<mobno>"
    When user select que from Question dropdown and enter the answer
    Then user chooes user type
    And choose "nilam@gmail.com" "nilam@123" "nilam@123"

    Examples: 
      | state       | nationality | emailid         | mobno      |
      | MAHARASHTRA | Indian      | nilam@gmail.com | 9876444343 |
