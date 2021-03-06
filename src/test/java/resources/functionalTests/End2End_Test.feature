Feature: Automated End2End Tests
  Description: The purpose of this feature is to test End 2 End integration

  Scenario: Customer place an order by purchasing an item from search
    Given User is on Home Page
    When User search for "dress"
    And Choose to buy the first item
    And Moves to checkout from mini cart
    And Enter personal details on checkout page
    And Select delivery address
    And Select payment method as "check" payment
    And Place the order
    Then Verify the order details
