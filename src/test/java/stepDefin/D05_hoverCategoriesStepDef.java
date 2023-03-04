package stepDefin;

import org.testng.Assert;

import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.P03_homePage;

public class D05_hoverCategoriesStepDef {
	P03_homePage home;
	StepDefinBase stepDefinBase;
	String exp=null;
	@BeforeStep
	public void init() {
		stepDefinBase = new StepDefinBase();
		home = new P03_homePage(stepDefinBase.driver);
	}
    
   
    @When("Select Random Category")
    public void selectCategory(){
       exp = home.selectCategories();
       exp.toLowerCase().trim();        
    }
    @Then("Assert On Actual Result")
    public void pageTitleAssert(){
        String act = home.actualResultElement().getText();
        act.toLowerCase().trim();
        Assert.assertEquals(act,exp);
    }
	
}
