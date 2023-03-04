package stepDefin;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.P03_homePage;

public class D08_WishlistStepDef {
    P03_homePage home;
    StepDefinBase stepDefinBase;
    Actions action ;
    
    @BeforeStep
    public void init() {
    	stepDefinBase = new StepDefinBase();
    	home = new P03_homePage(stepDefinBase.driver);
    	action = new Actions(stepDefinBase.driver);
    }
    @When("you press on heart button for product")
    public void selectProduct(){
        home.clickOnWishListButton();
    }
    @Then("^you will see success message \"(.*)\"$")
    public void addedSuccessfully(String expected){
        Assert.assertTrue(home.successMessage().contains(expected));
    }
    @And("Message color has green background")
    public void successMsgColor(){
        Assert.assertEquals(home.actualBackgroundColor(),home.expectedBackGroundColor());
    }
    @When("you hover on wishlist icon")
    public void wishList(){
        home.hoverOnWishList();
    }
    @Then("quantity value should be more than 0")
    public void wishListQuantity(){
      Assert.assertTrue(home.actualResNum() !="0");
    }
}
