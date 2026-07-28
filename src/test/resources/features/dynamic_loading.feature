Feature: Dynamic Loading
  Verify dynamic loading functionality on the-internet.herokuapp.com

  Scenario: Verify dynamic loading example 1 displays Hello World
    Given I am on the herokuapp homepage
    When I navigate to Dynamic Loading
    And I open Example 1
    And I click Start
    Then I should see "Hello World!"
