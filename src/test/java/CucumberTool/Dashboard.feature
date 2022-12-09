Feature:
  Scenario: Verify dashboard
    Given user is navigated to HRMS application
    When user enters valid username and valid password
    And user clicks on log in button
    Then user is successfully logged in
    Then user verify dashboard page
