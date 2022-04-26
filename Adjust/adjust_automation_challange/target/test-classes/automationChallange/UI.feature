@browser
Feature: Search Page

  Background: Navigate to Wikipedia Search Page
    Given Navigate to HomePage

  @logo_check
  Scenario: Wikipedia Logo Check
    Then Check Wikipedia Logo

  @check_search_result
  Scenario: Wikipedia Search Text And Check
    When I want to search "Opeth" text on Wikipedia search page and check

  @check_search_result
  Scenario: Search Any Text Which Is Does Not Exists And Check
    When I want to search "Asdasdwsxwsx" text on Wikipedia search page and check it is does not exists

  @check_search_result
  Scenario: Complex Regular Expression Message Check
    When I want to search Complex Regular Expression text on Wikipedia search page and check