#Author - Ramakrishnan (AC II-SE)
#Date - 09nd April 2024 Friday
#Discriptions - Salesforce home page details
Feature: Validate Lead conversion page features in Salesforce

  Scenario: Verify user can able to create new lead record
    Given user should be in salesforce lead list view page
    When user click New button
    Then New Lead popup should get open
    And user enters values in all required fields
    And clicks Save button
    Then new lead should be created
    When user click the conver button
    And Convert Lead popup should open
    And user clicks Convert button
    Then succes message diolouge box
    Then click Go To Leads
