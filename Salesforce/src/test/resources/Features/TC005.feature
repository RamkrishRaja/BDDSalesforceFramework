#Author - Ramakrishnan (AC II-SE)
#Date - 10th April 2024 Friday
#Discriptions - Salesforce home page details
Feature: Validate Logout features in Salesforce

  Scenario: Verify user can logout from Salesforce
    Given user should login to salesforce
    When user clicks profile icon
    And user clicks logout hyper link
    Then salsforce should be logged out successfully
