#Author - Ramakrishnan (AC II-SE)
#Date - 05nd April 2024 Friday
#Discriptions - Salesforce home page details

Feature: Validate Home page features in Salesforce

  Scenario: To verify that the user can able to navigate to the Leads object
    Given user should be in salesforce home page
    When user clicks the applauncher
    And user should enter leads object name in the applauncer search box
    And clicks object name or press Enter key
    Then system should navigate to the Lead records list view page
