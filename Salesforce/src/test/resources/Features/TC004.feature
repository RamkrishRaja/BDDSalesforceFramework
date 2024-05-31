Feature: Account Contact Opportunity

  Scenario: Verify Accont, Contact, Opportunity created after Lead get converted
    Given lead should be created and converted
    Then open newly created Account and update the filed
    Then Open contact and upload file
    Then Open Opportunity and update the field
