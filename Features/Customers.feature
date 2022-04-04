Feature: Customers



Background:Below  are common steps to all Scenarios
   Given User launch Chrome browser
   When User opens URL "https://admin-demo.nopcommerce.com/login"
   And user enters Email as "admin@yourstore.com" and Password as "admin"
   And Click on Login button
   Then User view the Dashboard
   
   
@regression   
Scenario: Add a new Customer
    When User click on customers Menu
    And click on customers Menu item
    And click on Add new button
    Then User can view Add new customer page
    When User enter customer info
    And click on save button
    Then User can view confirmation message "The new customer has been added succesfully"
    And close browser
    
@sanity
Scenario: Search Customer By EmailID
    When User click on customers Menu
    And click on customers Menu item
    And Enter customer Email
    When Click on search button
    Then User should found Email in the Search table
    And close browser
@sanity   
Scenario: Search Customer by Name
    When User click on customers Menu
    And click on customers Menu item
    And  Enter customer FirstName
    And Enter by customer Lastname
    When Click on search button
    Then User should find Name in theSearch table
    And close browser
   