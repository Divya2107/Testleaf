package week1.day5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Project1 {
	
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		//Enter the url
		driver.get("https://acme-test.uipath.com/account/login");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//enter email
		driver.findElementById("email").sendKeys("kumar.testleaf@gmail.com");
		//tab function
		driver.findElementById("email").sendKeys(Keys.TAB);
		//enter passwsord
		driver.findElementById("password").sendKeys("leaf@12");
		//login
		driver.findElementById("buttonLogin").click();
		
		//Mouseover Vendor
		WebElement ele = driver.findElementByXPath("//button[text()[normalize-space()='Vendors']]");  
		Actions builder = new Actions(driver);  
		builder.moveToElement(ele).perform();
		
		
		//Search the Vendor
		driver.findElementByLinkText("Search for Vendor").click();
		//Enter the Vendor Name
		driver.findElementById("vendorName").sendKeys("Blue Lagoon");
		driver.findElementById("buttonSearch").click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Verify the countryname
		String countryname = driver.findElementByXPath("//td[text()='France']").getText();
		System.out.println(countryname);
		
		// Logout
				driver.findElementByLinkText("Log Out").click();
						
		// CLose the browser
				driver.close();
		
		
		
	}
	

}
