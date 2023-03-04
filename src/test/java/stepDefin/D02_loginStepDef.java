package stepDefin;

import data.RegisterData;
import org.testng.asserts.SoftAssert;

import data.LoginData;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.P02_login;

public class D02_loginStepDef {
	P02_login login;
	LoginData loginData;
	StepDefinBase stepDefinBase;
	RegisterData registerData;
	
	@BeforeStep
	public void init() {
		stepDefinBase = new StepDefinBase();
		login = new P02_login(StepDefinBase.driver);
		loginData = new LoginData();
		registerData = new RegisterData();
	}
	
	@Given("user go to login page")
	public void clickOnloginButtonOnHomePage() {
		System.out.println("clickOnloginButtonOnHomePage: "+StepDefinBase.driver);
		login.clickOnLoginButton();
	}
	@When("user login with \"valid\" \"test@example.com\" and \"P@ssw0rd\"")
	public void enteringEmailAndPassword() {
		login.fillEmailAddress(registerData.RegEmail);
		login.fillPassword(registerData.password);
	}
	@And("user press on login button")
	public void clickOnLoginButton() {
		login.clickOnRememberMe();
		login.clickOnLoginButon();
		
	}
	@Then("user login to the system successfully")
	public void checkLoginSuccess() {
		SoftAssert Assertion = new SoftAssert();
		Assertion.assertTrue(login.myAccountButtonAssert());
		Assertion.assertAll();
	}
	

}
