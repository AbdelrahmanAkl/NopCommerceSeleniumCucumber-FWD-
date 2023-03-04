package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class P01_register extends PageBase{

	public P01_register(WebDriver driver) {
		super(driver);
	}

	By registerButton = By.xpath("//*[@class=\"ico-register\"]");
	By Gender = By.xpath("//span[@class=\"male\"]//input");
	By firstName = By.id("FirstName");
	By lastName = By.id("LastName");
	By birthDay = By.xpath("//*[@name=\"DateOfBirthDay\"]");
	By birthMonth = By.xpath("//*[@name=\"DateOfBirthMonth\"]");
	By birthYear = By.xpath("//*[@name=\"DateOfBirthYear\"]");
	By email = By.id("Email");
	By companyName = By.id("Company");
	By password = By.id("Password");
	By comfirmPassword = By.id("ConfirmPassword");
	By registerButon = By.id("register-button");
	public  By successMessage = By.xpath("//*[@class=\"result\"]");

	public String message = "Your registration completed";

	public void ClickOnRegisterButton(){
		clickElement(registerButton);
	}
	public void selectGender(){
		clickElement(Gender);
	}
	public void fillFirstName(String firstName){
		sendKey(this.firstName,firstName);
	}
	public void fillLastName(String lastName){
		sendKey(this.lastName,lastName);
	}
	public void chooseBirthDay(String option){
		Select birthday = new Select(driver.findElement(this.birthDay));
		birthday.selectByVisibleText(option);
	}
	public void chooseBirthMonth(String option){
		Select birtMonth = new Select(driver.findElement(this.birthMonth));
		birtMonth.selectByVisibleText(option);
	}
	public void chooseBirthYear(String option){
		Select birthYear = new Select(driver.findElement(this.birthYear));
		birthYear.selectByVisibleText(option);
	}
	public void fillEmail(String email){
		sendKey(this.email,email);
	}
	public void fillCompanyName(String companyName){
		sendKey(this.companyName,companyName);
	}
	public void fillPassword(String password){
		sendKey(this.password,password);
	}
	public void fillConfirmPassword(String comfirmPassword){
		sendKey(this.comfirmPassword,comfirmPassword);
	}
	public void clickOnRegoisterButon(){
		clickElement(registerButon);
	}

}
