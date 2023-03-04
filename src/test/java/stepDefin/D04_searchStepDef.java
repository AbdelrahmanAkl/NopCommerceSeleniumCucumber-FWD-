package stepDefin;

import java.util.List;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.P03_homePage;

public class D04_searchStepDef {
	P03_homePage home;
	StepDefinBase stepDefinBase;
	
	@BeforeStep
	public void init() {
		stepDefinBase = new StepDefinBase();
		home = new P03_homePage(StepDefinBase.driver);	
	}
	
	@When("^Entering product name in search box as \"([^\"]*)\"$")
    public void searchBoxName(String product){
        home.fillSearchBox(product);;
    }
    @When("^Entering product sku in search box as \"([^\"]*)\"$")
    public void searchBoxSku(String sku) {
    	home.fillSearchBox(sku);
    }
    @And("press on search")
    public void search() throws InterruptedException {
        home.clickOnSearchButton();
    }
    @Then("^sku shown in page must be the same as one used for search \"([^\"]*)\"$")
    public void sku (String expected){
       home.skuItem().click();
       String actual = home.skuName().getText();
       Assert.assertEquals(actual,expected);
    }
    @Then("^search shows relevant results as inserted word \"([^\"]*)\"$")
    public void products(String insertedName){
    List<String>productNames = home.productName();
       SoftAssert soft = new SoftAssert();
    for(int i=0;i<productNames.size();i++){
        String actual = insertedName.toLowerCase();
        String expected = productNames.get(i).toLowerCase();
        soft.assertTrue(expected.contains(actual));
    }
    }
    @And("navigate to correct URL")
    public void correctURL(){
        String expectedURL="https://demo.nopcommerce.com/search?";
        Assert.assertTrue(stepDefinBase.driver.getCurrentUrl().contains(expectedURL));
    }
}
