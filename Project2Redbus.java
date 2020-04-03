package week1.day5;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class Project2Redbus {
	
	public static void main(String[] args) throws InterruptedException
	{

	System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
			ChromeDriver driver = new ChromeDriver();
	
	//Enter the url
			driver.get("https://www.redbus.in");
			
			//Source 
			driver.findElementById("src").sendKeys("Chennai");
			
			Thread.sleep(5000);
			
			driver.findElementById("src").sendKeys(Keys.TAB);
			
			//select an option in the list
			driver.findElementByXPath("//li[text()='Chennai (All Locations)']").click();
			
			//Destination
			driver.findElementById("dest").sendKeys("Banglore");
			
			//select the an option  in the list
			driver.findElementByXPath("//li[text()='Bangalore (All Locations)']").click();
			
			//select the date
			driver.findElementByXPath("//td[text()='30'])[2]").click();
			
			//click on search buses
			driver.findElementById("search_btn").click();
			
			//Check "After 6pm checkbox"
			
			driver.findElementByXPath("//label[@class='custom-checkbox'])[4]").click();
			
			//Bus type-Sleeper
			driver.findElementByXPath("//label[@for='bt_SLEEPER'])[1]").click();
			
			//Click on the seats available
			
			driver.findElementByXPath("//div[contains(@class,'w-15 fl')]//a)[2]").click();
	}
			
			
			
}
