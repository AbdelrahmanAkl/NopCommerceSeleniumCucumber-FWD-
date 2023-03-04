package pages;

import java.awt.Desktop.Action;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class P03_homePage extends PageBase {

	public P03_homePage(WebDriver driver) {
		super(driver);
	}
	Random random = new Random();
	By changeLanguage = By.id("customerCurrency");
	By priceOfElement = By.xpath("//*[@class=\"price actual-price\"]");
	By elementToScroll = By.xpath("(//*[@class=\"price actual-price\"])[1]");
	By searchBox = By.id("small-searchterms");
	By SearchButton = By.xpath("//button[@class=\"button-1 search-box-button\"]");
	By products = By.xpath("//*[@class=\"item-grid\"]/div");
	By productTitle = By.xpath("//*[@class=\"item-grid\"]//div[@class=\"details\"]/h2");
	By sku = By.xpath("//div[@class=\"sku\"]//span[@class=\"value\"]");
	By itemTitle = By.xpath("//h2[@class=\"product-title\"]");
	By mainCat = By.xpath("//*[@class=\"top-menu notmobile\"]");
    By pageTitle = By.xpath("//*[@class=\"page-title\"]/h1");    
    By iphoneElement = By.cssSelector("a[rel=\"0\"]");
    By nivoSliderElement = By.id("nivo-slider");
    By galaxyElement = By.cssSelector("a[rel=\"1\"]");
    By facebookLink = By.xpath("//*[@class=\"facebook\"]/a");
    By twitterLink  = By.xpath("//*[@class=\"twitter\"]/a");
    By rssLink  = By.xpath("//*[@class=\"rss\"]/a");
    By youtubeLink  = By.xpath("//*[@class=\"youtube\"]/a");
    By wishListButton = By.xpath("(//button[@class=\"button-2 add-to-wishlist-button\"])[2]");
    By addToWishListSuccess = By.xpath("//*[@class=\"content\"]");
    By sucessMessageBackGroundColor = By.xpath("//div[@class=\"bar-notification success\"]");
    By Wishlist = By.cssSelector("span[class=\"wishlist-qty\"]");
    
    
	ArrayList<String> list = new ArrayList<String>();
	

	public List<WebElement> currencyList() {
		return  driver.findElements(priceOfElement);
	}
	public String p1() {
		String Prod1 = currencyList().get(0).getText();
		return Prod1;
	}
	public String p2() {
		String Prod2 = currencyList().get(1).getText();
		return Prod2;
	}
	public String p3() {
		String Prod3 = currencyList().get(2).getText();
		return Prod3;
	}
	public String p4() {
		String Prod4 = currencyList().get(3).getText();
		return Prod4;
	}



	public List<String> productName() {
		int size = 0;
		int size2 = 0;
		WebElement productName = driver.findElement(products);
		List<WebElement> products = productName.findElements(By.xpath("*"));
		int size1 = products.size();
		List<String> names1 = new ArrayList<String>();
		for (int i = 1; i <= size1; i++) {
			names1.add(driver.findElement(productTitle).getText());
		}
		try {
			if (driver.findElement(By.className("next-page")).isDisplayed()) {
				driver.findElement(By.xpath("//a[@data-page=\"2\"]")).click();
				Thread.sleep(1000);
				WebElement productName2 = driver.findElement(By.xpath("//div[@class=\"item-grid\"]"));
				List<WebElement> products2 = productName2.findElements(By.xpath("*"));
				size2 = products2.size();
				size = size1 + size2;
				for (int i = 1; i <= size2; i++) {
					names1.add(driver.findElement(productTitle).getText());
				}
			}
		} catch (Exception e) {
			size = size1;
		}
		return names1;
	}
	public void changeLanguageToEuro(String option) {
		Select  changeToEuro = new Select(driver.findElement(changeLanguage));
		changeToEuro.selectByVisibleText(option);
	}
	public void fillSearchBox(String Product) {
		sendKey(searchBox, Product);
	}
	public void clickOnSearchButton() {
		clickElement(SearchButton);
	}
	public WebElement skuItem() {
		WebElement item = driver.findElement(itemTitle);
		return item.findElement(By.xpath("*"));
	}

	public WebElement skuName() {
		return driver.findElement(sku);
	}
	public WebElement actualResultElement() {
        return driver.findElement(By.xpath("//div[@class=\"page-title\"]"));
    }
	
	public String selectCategories() {
        WebElement main = driver.findElement(By.cssSelector("ul[class=\"top-menu notmobile\"]"));
        List<WebElement> i = main.findElements(By.xpath("*"));
        int size = i.size();
        int randCatIndex = ThreadLocalRandom.current().nextInt(0, size);
        WebElement i1 = i.get(randCatIndex);
        String selectedElement = i1.getText();
        Actions action = new Actions(driver);
        action.moveToElement(i1).click().build().perform();
        if (randCatIndex < 3) {
            int sizeSub = 3;
            int randNum2 = ThreadLocalRandom.current().nextInt(0, sizeSub);
            switch (randNum2) {
                case 1: {
                    WebElement subCat = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[1]/div/div[1]/div/h2/a"));
                    selectedElement = subCat.getText();
                    action.moveToElement(subCat).click().build().perform();

                    break;
                }
                case 2: {
                    WebElement subICat = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[1]/div/div[2]/div/h2/a"));
                    selectedElement = subICat.getText();
                    action.moveToElement(subICat).click().build().perform();
                    break;
                }
                case 3: {
                    WebElement subCat = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[1]/div/div[3]/div/h2/a"));
                    selectedElement = subCat.getText();
                    action.moveToElement(subCat).click().build().perform();

                    break;
                }
            }
        } else {
            action.click().build().perform();
        }
        return selectedElement;
    }
 
	  public List<WebElement> iphoneSliderBar(){
	        List<WebElement> iphoneSlider = new ArrayList<WebElement>();
	        iphoneSlider.add(driver.findElement(iphoneElement));
	        iphoneSlider.add(driver.findElement(nivoSliderElement));
	        return iphoneSlider;
	    }
	  public String iphonePageExpectedResult(){
		  String act = "https://demo.nopcommerce.com/iphone-14";
	        return act ;
	    }
	  public List<WebElement> galaxySliderBar(){
	        List<WebElement> galaxySlider = new ArrayList<WebElement>();
	        galaxySlider.add(driver.findElement(galaxyElement));
	        galaxySlider.add(driver.findElement(nivoSliderElement));
	        return galaxySlider;
	    }
	    public String galaxyPageExpectedResult(){
	        return "https://demo.nopcommerce.com/nokia-lumia-1020";
	    }
	    
	    public void clickOnFaceBookLink() {
	    	clickElement(facebookLink);
	    }
	    public void clickOnTwitterLink() {
	    	clickElement(twitterLink);
	    }
	    public void clickOnRssLink() {
	    	String newTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
	    	driver.findElement(rssLink).sendKeys(newTab);
	    }
	    public void clickOnYoutubeLink() {
	    	clickElement(youtubeLink);
	    }
	    public void clickOnWishListButton() {
	    	clickElement(wishListButton);
	    }
	    public String successMessage() {
	    	return driver.findElement(addToWishListSuccess).getText();
	    }
	    public String actualBackgroundColor() {
	    	return driver.findElement(sucessMessageBackGroundColor).getCssValue("background-color");
	    }
	    public String expectedBackGroundColor() {
	    	return "rgba(75, 176, 122, 1)";
	    }
	    public void hoverOnWishList() {
	    	Actions action = new Actions(driver);
	    	action.moveToElement(driver.findElement(Wishlist)).perform();
	    }
	    public String actualResNum() {
	    	return driver.findElement(Wishlist).getText();
	    }
	   

}




	    