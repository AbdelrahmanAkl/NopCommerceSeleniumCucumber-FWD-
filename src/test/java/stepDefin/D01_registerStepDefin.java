package stepDefin;

import org.testng.asserts.SoftAssert;

import data.RegisterData;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.P01_register;

public class D01_registerStepDefin  {
	P01_register register;
    RegisterData registerData;
    StepDefinBase stepDefinBase;
             
    @BeforeStep
    public void init() {
    	stepDefinBase  = new StepDefinBase();
    	register = new P01_register(StepDefinBase.driver);
    	registerData = new RegisterData();
    }
    @Given("user go to register page")
    public void goToRegisterPage(){
        
        register.ClickOnRegisterButton();
    }
    @When("user select Gender Type")
    public  void selectGenderType(){
        register.selectGender();
    }
    @And("fill first name")
    public void fillUserNameField(){
        register.fillFirstName(registerData.firstName);
    }
    @And("fill Last name")
    public void fillLastNameField(){
        register.fillLastName(registerData.lastName);
    }
    @And("Select date of birth")
    public void selectDateOfBirth(){
        register.chooseBirthDay(registerData.birthDay);
        register.chooseBirthMonth(registerData.birthMonth);
        register.chooseBirthYear(registerData.birthYear);
    }
    @And("Enter a valid Email Address")
    public void fillEmailAddress(){
        register.fillEmail(registerData.RegEmail);
    }
    @And("Enter Company name")
    public void fillCompanyName(){
        register.fillCompanyName(registerData.companyName);
    }
    @And("Enter  a valid password")
    public void fillPassword(){
        register.fillPassword(registerData.password);
    }
    @And("enter the same password")
    public void fillConfirmPassword(){
        register.fillConfirmPassword(registerData.password);
    }
    @And("click on register button")
    public void clickOnRegisterButton(){
        register.clickOnRegoisterButon();
    }
    @Then("register success message is displayed success")
    public void AssertOnSuccessRegisteration(){
                SoftAssert assertion = new SoftAssert();
                assertion.assertEquals(StepDefinBase.driver.findElement(register.successMessage).getText(),register.message);
                assertion.assertEquals(StepDefinBase.driver.findElement(register.successMessage).getCssValue("color"),"rgba(76,177,124,11)");
    }

}
