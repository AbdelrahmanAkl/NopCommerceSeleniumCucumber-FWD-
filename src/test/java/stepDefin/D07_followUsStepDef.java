package stepDefin;

import java.util.ArrayList;

import org.testng.Assert;

import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.P03_homePage;

public class D07_followUsStepDef {
	P03_homePage home;
	StepDefinBase stepDefinBase;
	
	@BeforeStep
	public void init() {
		stepDefinBase = new StepDefinBase();
		home = new P03_homePage(stepDefinBase.driver);
	}
   
	@When("user opens facebook link")
	public void openFaceBookLink() {
		home.clickOnFaceBookLink();
	}
	@When("user opens twitter link")
	public void openTwitterLink() {
		home.clickOnTwitterLink();
	}
	@When("user opens rss link")
	 public void openRssLink() {
		home.clickOnRssLink();
	}
	@When("user opens youtube link")
	public void openYoutubeLink() {
		home.clickOnYoutubeLink();
	}
	@Then("^\"(.*)\" is opened in new tab$")
	public void AssertOnOpenTab(String exp) throws InterruptedException {
		  String oldTab = stepDefinBase.driver.getWindowHandle();
	        ArrayList<String> newTab = new ArrayList<String>(stepDefinBase.driver.getWindowHandles());
	        newTab.remove(oldTab);
	        stepDefinBase.driver.switchTo().window(newTab.get(0));
	        Thread.sleep(2000);
	        String actual = stepDefinBase.driver.getCurrentUrl();
	        Assert.assertEquals(actual,exp);
	        stepDefinBase.driver.close();
	        stepDefinBase.driver.switchTo().window(oldTab);
	}
}
