package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P02_login extends PageBase {

	

	public P02_login(WebDriver driver) {
		super(driver);
	}
	
	
	By loginButton = By.xpath("//*[@class=\"ico-login\"]");
	By email = By.id("Email");
	By password =  By.id("Password");
	By rememberMe = By.id("RememberMe");
	By loginButon = By.xpath("//button[@class=\"button-1 login-button\"]");
	By myAccountButton = By.xpath("//*[@class=\"ico-account\"]");
	public String  currentURL =driver.getCurrentUrl();

	public void clickOnLoginButton() {
		System.out.println("clickOnLoginButton :"+driver);
		clickElement(loginButton);
	}
	public void fillEmailAddress(String email) {
		sendKey(this.email, email);
	}
	public void fillPassword(String password) {
		sendKey(this.password, password);
	}
	public void clickOnLoginButon() {
		clickElement(loginButon);
	}
	public void clickOnRememberMe(){
		clickElement(rememberMe);
	}
	public boolean myAccountButtonAssert() {
		return driver.findElement(myAccountButton).isDisplayed();
	}
	
}
