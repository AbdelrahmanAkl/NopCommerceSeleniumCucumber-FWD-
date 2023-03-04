package stepDefin;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class StepDefinBase {
	public static WebDriver driver;
    @Before
    public void openBrowser() {
        WebDriverManager.firefoxdriver().setup();
        driver= new FirefoxDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("driverinside open browser" + driver);
        driver.navigate().to("https://demo.nopcommerce.com/");
    }
    @After
    public void closeBrowser()
    {
        driver.quit();
    }
}
