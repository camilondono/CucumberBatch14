package APIPackage;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import  static  org.hamcrest.Matchers.*; // import hamcrestMatchers all

//to change the order of execution we use fix method order since its executing in top to bottom
//which is not good right now
//this method sorters will execute my methods in ascending order/alphabetically
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedExamples {

    //one thing to remember
    //Base URI will be  Base URL over here
    // and then using when keyword we will send the endpoint

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";

    // we need to perform CRUD operations
    String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2NzQwODc5MzgsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY3NDEzMTEzOCwidXNlcklkIjoiNDc5OSJ9.2xYU8kY3RCZJtDMSq0GzNuzZHNBoChCGCz7ieYi08UQ";
    static  String employee_id;


    @Test   // once you write @test and import the junit will give the arrow to run
    public void bgetOneEmployee(){

        //prepare the request
        //to prepare the request, we use request specifications
        RequestSpecification request = given().header("Authorization",token)
                .header("Content-Type","application/json").queryParam("employee_id",employee_id);

       //to hit the endpoint/ to make the request which will return response
       Response response = request.when().get("/getOneEmployee.php");

        //System.out.println(response.asString());
        // instead of printing in console we use prettyPrint
        response.prettyPrint();

        // verifying the status code
        response.then().assertThat().statusCode(200);

        //using jsonpath method we are extracting the value form the response body
        String firstName = response.jsonPath().get("employee.emp_firstname");

        // the value of emp_firstname will be printed "camilo"
        System.out.println(firstName);
        Assert.assertEquals(firstName,"Leo");

        response.then().assertThat().body("employee.emp_firstname", equalTo("Leo"));

    }
    @Test
    public void acreateEmployee(){

        RequestSpecification request = given().header("Authorization",token)
                .header("Content-Type","application/json")
                .body("{\n" +
                        "  \"emp_firstname\": \"Leo\",\n" +
                        "  \"emp_lastname\": \"Messi\",\n" +
                        "  \"emp_middle_name\": \"ms\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"2023-01-14\",\n" +
                        "  \"emp_status\": \"confirmed\",\n" +
                        "  \"emp_job_title\": \"QA \"\n" +
                        "}");

        Response response = request.when().post("/createEmployee.php");
        response.prettyPrint();
        response.then().assertThat().statusCode(201);
        //getting the employee id from the response and use it as static one
       employee_id = response.jsonPath().getString("Employee.employee_id");
        System.out.println(employee_id);
        response.then().assertThat().body("Employee.emp_lastname", equalTo("Messi"));
        response.then().assertThat().body("Employee.emp_middle_name", equalTo("ms"));
        response.then().assertThat().header("server","Apache/2.4.39 (Win64) PHP/7.2.18");
    }

    @Test
    public void cupdateEmployee(){

        RequestSpecification request = given().header("Authorization", token)
                .header("Content-Type", "application/json").
                body("{\n" +
                        "  \"employee_id\": \""+ employee_id +"\",\n" +
                        "  \"emp_firstname\": \"Camilo\",\n" +
                        "  \"emp_lastname\": \"Londono\",\n" +
                        "  \"emp_middle_name\": \"E\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"1990-05-23\",\n" +
                        "  \"emp_status\": \"confirmed\",\n" +
                        "  \"emp_job_title\": \"QA engineer\"\n" +
                        "}");

        Response response = request.when().put("/updateEmployee.php");

        //verification
        response.then().assertThat().statusCode(200);
        response.then().assertThat().body("Message", equalTo("Employee record Updated"));

    }
    @Test
    public void dgetUpdatedEmployee(){
        RequestSpecification request = given().header("Authorization",token)
                .header("Content-Type","application/json").queryParam("employee_id",employee_id);

        //to hit the endpoint/ to make the request which will return response
        Response response = request.when().get("/getOneEmployee.php");

        //System.out.println(response.asString());
        // instead of printing in console we use prettyPrint
        response.prettyPrint();

        // verifying the status code
        response.then().assertThat().statusCode(200);
        response.then().assertThat().body("employee.emp_job_title", equalTo("QA Engineer"));

    }

}
