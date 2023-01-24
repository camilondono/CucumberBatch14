Feature: API workflow test

  Background: for generating the token before every request
    # to generate the token for all the request we kept it here in background
    Given a JWT is generated

  @api
  Scenario: API test case for creating the employee
    Given a request is prepared for creating an employee
    When a POST call is made to create an employee
    Then the status code for creating an employee is 201
    And the response body contains key "Message" and value "Employee Created"
    And the employee id "Employee.employee_id" is stored as global to be used for other request

  @api
  Scenario: Getting the created employee
    Given a request is prepared for getting a created employee
    When a GET call is made to get this employee
    Then the status code for this emp is 200
    And the employee id "employee.employee_id" should match with global emp id
    And the retrieved data at "employee" object should match with the data used for creating the employee
      |emp_firstname|emp_lastname|emp_middle_name|emp_gender|emp_birthday|emp_status|emp_job_title|
      |Camilo       |Londono     |E              |Male      |2023-01-14  |confirmed |QA           |

  @api
  Scenario: API test case for creating the employee using json body
    Given a request is prepared for creating an employee by passing json body
    When a POST call is made to create an employee
    Then the status code for creating an employee is 201
    And the response body contains key "Message" and value "Employee Created"
    And the employee id "Employee.employee_id" is stored as global to be used for other request

  @apidynamic
  Scenario: API test case for creating the employee using highly dynamic body
    Given a request is prepared for creating an employee with dynamic data "Camilo" , "Londono"  , "E" , "M" , "2023-01-14" , "confirmed" , "QA"
    When a POST call is made to create an employee
    Then the status code for creating an employee is 201
    And the response body contains key "Message" and value "Employee Created"
    And the employee id "Employee.employee_id" is stored as global to be used for other request

  @apiUpdate
  Scenario: API test case for updating an employee json body
    Given a request is prepared for updating an employee by passing json body
    When a PUT call is made to update an employee
    Then the status code for this emp is 200
    And the response body contains key "Message" and value "Employee Updated"

  @apiGetUpdate
  Scenario: API test case for getting the updated employee
    Given a request is prepared for getting an updated employee
    When a Get call is made to update an employee
    Then the status code for this emp is 200
    And the employee id "employee.employee_id" should match with global emp id
    And the retrieved data at "employee" object should match with the data used for updating the employee
      |emp_firstname|emp_lastname|emp_middle_name|emp_gender|emp_birthday|emp_status|emp_job_title|
      |Camilo       |Londono     |E              |Male      |2023-01-14  |confirmed |QA           |







