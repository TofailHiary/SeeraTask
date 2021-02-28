Feature: Check Home page and Flight page

Scenario: Check system Language , search and prices sorting
    Given I want to open home page
    When Navigate to flights page and fill search criteria
    Then Check if price sortion and price filter value