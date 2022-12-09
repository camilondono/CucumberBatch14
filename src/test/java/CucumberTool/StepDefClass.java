/*package CucumberTool;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class StepDefClass {

    WebDriver driver;
    @Given("user is navigated to HRMS application")
    public void user_is_navigated_to_HRMS_application() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @When("user enters valid username and valid password")
    public void user_enters_valid_username_and_valid_password() {
        WebElement userName = driver.findElement(By.xpath("//input[@name='txtUsername']"));
        userName.sendKeys("admin");
        WebElement password = driver.findElement(By.xpath("//input[@id = 'txtPassword']"));
        password.sendKeys("Hum@nhrm123");
    }

    @When("user clicks on log in button")
    public void user_clicks_on_log_in_button() {
        WebElement logIn = driver.findElement(By.xpath("//*[@id='btnLogin']"));
        logIn.click();

    }

    @Then("user is successfully logged in")
    public void user_is_successfully_logged_in() {
        WebElement welcomeMessage = driver.findElement(By.id("welcome"));
        if(welcomeMessage.isDisplayed()){
            System.out.println("test case is passed");
        }else{
            System.out.println("Test case is failed");
        }

    }
    @Then("user verify dashboard page")
    public void user_verify_dashboard_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}

 */
