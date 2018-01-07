@Angular @Regression @Smoke
Feature: Angular Examples
  As someone who does not want to learn javascript
  I want to be able to test angular with selenium
  So that I dont have to reskill in javascript

 Background:
    Angular calculator scenarios
    And I am on the calculator page
    
  @TestCaseId("abc-007") @Issue("geo-999") @severity=blocker
  Scenario: User can do multiplication
  	Multiplication description
    When I multiply 10 times 5
    Then I should get 50
    
  @TestCaseId("abc-007") @Issue("geo-999") @severity=critical
  Scenario: User can do addition
  	addition description
    When I add 10 plus 25
    Then I should get 35    
    
  @TestCaseId("abc-007") @Issue("geo-999") @tagged-hooks-example @severity=minor
  Scenario: User can do subtraction
  	subtraction description
    When I subtract 99 from 1000
    Then I should get 901