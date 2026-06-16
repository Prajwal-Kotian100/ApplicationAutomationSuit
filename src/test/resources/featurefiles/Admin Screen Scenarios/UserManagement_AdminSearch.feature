Feature: Admin Search functionality in Orange HRM application

  @AdminSearch
  Scenario Outline: Search user with admin details
    Given User login and navigates to the admin module
    And User enters the following details "<Username>" "<UserRole>" "<EmployeeName>" and "<Status>"
    And User clicks on Search User
    Then User should be able to see the User details successfully

    Examples:
      | Username | UserRole | EmployeeName | Status  |
      | Admin    | Admin    |              | Enabled |

  @AdminReset
  Scenario Outline: User reset the entered data
    Given User login and navigates to the admin module
    And User enters the following details "<Username>" "<UserRole>" "<EmployeeName>" and "<Status>" and clicks on Reset
    Then User should be able to see the details removed successfully

    Examples:
      | Username | UserRole | EmployeeName | Status  |
      | Admin    | Admin    |              | Enabled |
