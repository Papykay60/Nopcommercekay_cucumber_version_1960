Feature: Login

@sanity
Scenario: Successful login with valid credentials
    Given User launch Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And user enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login button
    Then page Title should be "Dashboard / nopCommerce administration"
    When User click on log out link
    Then page Title should be "Your store. Login"
    And close browser

@regression
Scenario Outline: Login data driven
    Given User launch Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And user enters Email as "<email>" and Password as "<password>"
    And Click on Login button
    Then page Title should be "Dashboard / nopCommerce administration"
    When User click on log out link
    Then page Title should be "Your store. Login"
    And close browser
    
    Examples:
        | email | password |
        | admin@yourstore.com  |    admin  |
        | admin1@yourstore.com | admin123  |
    