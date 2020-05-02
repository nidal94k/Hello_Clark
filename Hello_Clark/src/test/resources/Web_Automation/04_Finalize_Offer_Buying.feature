
Feature: Finalize Offer

  Scenario Outline: Add bank account
    Given users adds bank accuunt details <IBAN>
    And checks on agreement 
    When clicks on Tarif bestellen
    Given user checks buying agrement
    And clicks Jetzt verbindlich kaufen
    Then order is completed
    And clicks back to review
    And verify contract was added
    Examples: 
      | IBAN  | 
      | DE55500105174529223988 | 
      