
Feature: Choose Offer
  Scenario Outline: User Choose offer
    Given User is at Contract offer page
    When user choose contract <contractNumber>
    Then user navigates to sign up page

    Examples: 
      | contractNumber  |
      | 2 |
