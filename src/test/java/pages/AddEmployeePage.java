package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AddEmployeePage extends CommonMethods {

    @FindBy(id = "firstName")
    public WebElement firstNameField;

    @FindBy(id = "lastName")
    public WebElement lastNameField;

    @FindBy(id = "middleName")
    public WebElement middleNameField;

    @FindBy(id = "photofile")
    public WebElement photograph;

    @FindBy(id = "chkLogin")
    public WebElement checkBox;

    @FindBy(id = "user_name")
    public WebElement createusernameField;

    @FindBy(id = "user_password")
    public WebElement createpasswordField;

    @FindBy(id = "re_password")
    public WebElement confirmpasswordField;

    @FindBy(id = "employeeId")
    public WebElement empIdLocator;

    @FindBy(id = "btnSave")
    public WebElement saveButton;

    public AddEmployeePage(){
        //page factory is a comment of selenium which we use to implement page
        //object model design pattern which is responsible to initialized all the objects
        // of the class. here when we say objects, we mean locators what also call object repository
        // if someone ask this to you in the interview you have to write the same thing lol
        PageFactory.initElements(driver, this);
    }



}
