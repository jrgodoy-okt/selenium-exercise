Feature: Login User
  Background:
    Given user navigates to https://www.saucedemo.com/
    And login as standard user
    And go to about page
    And go back to inventory page

  Scenario: user buy 4 expensive products
    Given 4 most expensive products added to cart
    And user check shopping cart badge
    When user go to cart page
    And complete checkout step one
    And check order on checkout step two
    And finish order
    Then success message is displayed
