package stepDefin;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import data.CurrenciesData;
import data.LoginData;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.P03_homePage;

public class D03_currenciesStepDef {
	P03_homePage homepage;
	CurrenciesData currenciesData;
	StepDefinBase stepDefinBase;
	
	@BeforeStep
	public void init() {
		stepDefinBase = new StepDefinBase();
		currenciesData = new CurrenciesData();
		homepage = new P03_homePage(StepDefinBase.driver);
	}
	@Given("change currency to euro")
	public void goToHomePage() {
		homepage.changeLanguageToEuro(currenciesData.currency);
	}
	@When("scroll down to products")
	public void scrollDownToProducts() {
		homepage.scrollDown();
	}
	@Then("check product in home page is diplayed with euro sign")
	public void checkProductInHomePageIsDiplayedWithEuroSign() {
		Assert.assertTrue(homepage.p1().contains(currenciesData.euroSign));
		Assert.assertTrue(homepage.p2().contains(currenciesData.euroSign));
		Assert.assertTrue(homepage.p3().contains(currenciesData.euroSign));
		Assert.assertTrue(homepage.p4().contains(currenciesData.euroSign));

	}
}
