package week2.day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWebElements {

	
	public static void main(String[] args) throws InterruptedException
	
	{
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Launch the url
		driver.get("http://www.leafground.com/pages/Link.html");
		
		//To find all Links
		List<WebElement> findAllLinks = driver.findElementsByTagName("a");
	int size = findAllLinks.size();
		System.out.println(findAllLinks.size());
		
		//1//Count of links i n the page
		//int size = driver.findElementsByTagName("a").size();
        //print for number of links
		 //System.out.println("Total Number of Links is "+ size);
		 
		//Click on the FirstLink
		findAllLinks.get(0).click();
		
		 
		//Click on the last 'Go to Home Page' Link
		List<WebElement> elements = driver.findElementsByLinkText("Go to Home Page");
		System.out.println(elements.size());
		elements.get(elements.size()-1).click();
		 
		 
		
		
	}
}
