package stepDefin;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Duration;
import pages.P03_homePage;

public class D06_homeSlidersStepDef {
	P03_homePage home;
	StepDefinBase stepDefinBase;
	
	@BeforeStep
	public void init() {
		stepDefinBase = new StepDefinBase();
		home = new P03_homePage(stepDefinBase.driver);
	}
	
	@When("you select slider image of iphone 14 pro and press on it")
    public void iphoneSlider() throws InterruptedException {
//		home.scrollDown();
        home.iphoneSliderBar().get(0).click();
        home.iphoneSliderBar().get(1).click();
    }
    @When("you select slider image of Galaxy S22 ultra and press on it")
    public void galaxySlider() throws InterruptedException {
//    	home.scrollDown();
        home.galaxySliderBar().get(0).click();
        home.galaxySliderBar().get(1).click();
    }
    @Then("you should navigate to iphone 14 pro product page")
    public void iphonePage(){
        String exp = home.iphonePageExpectedResult();
        String actual = stepDefinBase.driver.getCurrentUrl();
//        home.waitTimeUrl(exp);
        Assert.assertTrue(actual.contains(exp),"URL isn't correct");
    }
    @Then("you should navigate to Galaxy S22 ultra product page")
    public void galaxyPage(){
        String exp = home.galaxyPageExpectedResult();
        String act = stepDefinBase.driver.getCurrentUrl();
//        home.waitTimeUrl(exp);
        Assert.assertTrue(act.contains(exp),"URL isn't correct");
    }
}
