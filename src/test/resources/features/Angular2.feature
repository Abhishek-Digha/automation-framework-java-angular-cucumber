@Angular
Feature: Displaying NGWebDriver for Angular
  As someone who does not want to learn javascript
  I want to be able to test angular with selenium
  So that I dont have to reskill in javascript

 Background:
    Angular calculator scenarios
    Given The user "angular" exists
    And I am on the calculator page
    
  @SeverityLevel.CRITICAL @TestCaseId("abc-007") @Issue("geo-999")
  Scenario: User can use multiplication
  	Multiplication description
    When I multiply 10 times 5
    Then I should get 50
    
  @SeverityLevel.CRITICAL @TestCaseId("abc-007") @Issue("geo-999")
  Scenario: User can use addition
  	addition description
    When I add 10 plus 25
    Then I should get 35    
    
  @SeverityLevel.CRITICAL @TestCaseId("abc-007") @Issue("geo-999")
  Scenario: User can use subtraction
  	subtraction description
    When I subtract 99 from 1000
    Then I should get 901