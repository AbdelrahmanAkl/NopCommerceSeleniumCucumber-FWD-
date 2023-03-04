@smoke
Feature: Users can be register for a new accounts
  Scenario: user could be register with a valid data sccessfully
    Given  user go to register page
    When  user select Gender Type
    And  fill first name
    And  fill Last name
    And  Select date of birth
    And  Enter a valid Email Address
    And  Enter Company name
    And  Enter  a valid password
    And  enter the same password
    And  click on register button
    Then  register success message is displayed success

  