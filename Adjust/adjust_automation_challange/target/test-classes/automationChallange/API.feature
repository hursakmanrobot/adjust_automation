Feature: Check API Responses

  @api
  Scenario: Create Pet And Check
    Given  Create New Pet
    Then Check Pet Created

  @api
  Scenario: Update Pet And Check
    Given  Create New Pet
    And Update Pet And Check

  @api
  Scenario: Create Order
    Given  Create New Pet
    And Order Created Pet

  @api
  Scenario: Create New User And Check
    Given  Create New User And Check

  @api
  Scenario: Login With Existing User
    Given  Create New User
    Given  Login With Existing User And Check