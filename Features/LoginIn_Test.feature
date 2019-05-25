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
@tag
Feature: Test Facebook Smoke scenario

  ##  @tag1
  ##Scenario: Successful Login with Valid credentials
  ##Given User is on Home Page
  ##And some other precondition
  ##When I complete action
  ##And some other action
  ##And yet another action
  ##Then I validate the outcomes
  ##And check more outcomes
  @LoginSuccess
  Scenario: Successful Login with Valid credentials
    Given I Open Chrome and start application
    When User enter valid username and password
    And User click on Login
    Then Message displayed username

  @SuccessfulLogout
  Scenario: Successful Logout
    When User Logout
    Then User should see Login
  ##  Examples: 
  ##  | name  | value | status  |
##    | name1 |     5 | success |
##   | name2 |     7 | Fail    |
