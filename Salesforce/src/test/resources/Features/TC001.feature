#Author - Ramakrishnan(AC II-SE)
#Date - 02nd April 2024 Tuesday
#Discriptions - Salesforce login page details
Feature: Login feature for Salesforce

  Background: The User opens login Page
    Given Chrome or any desier brower should be launched
    When Salesforce login page opend "https://login.salesforce.com/"
    Then User should see the text box to enter login credentials "Login | Salesforce"

  #Whenever we want to do parameterization<> and want ot ran multiple set of values create scenario outline and examples with an set of data
  Scenario Outline: Validating the Login functionality
    When enter Username as "<username>" and Password as "<password>"
    Then clicks on Login button with expected status as "<status>"
    Then User should see the Salesforce Home page on successful login status "<status>"

    Examples: 
      | username            | password           | status           |
      | ramkrish@mastek.com |                    | Missing Password |
      | ramkrish@mastek.com | Welcome@124567890  | Both Fail        |
      | ramkrish@mastek.com | Welcome@1234567890 | Pass             |