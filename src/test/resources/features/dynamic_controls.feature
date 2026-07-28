Feature: Dynamic Controls
  Verify dynamic controls functionality on the-internet.herokuapp.com

  Scenario: Verify dynamic controls flow
    Given I am on the herokuapp homepage
    When I navigate to Dynamic Controls
    And I remove the checkbox
    And I add the checkbox back
    And I enable the input and type text
    And I disable the input
    Then the input should be disabled
