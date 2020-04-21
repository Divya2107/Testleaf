package week1.day4;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DuplicateLead {
	
	public static void main(String[] args) throws InterruptedException {
		
		//Launch the browser
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		//Launch the url
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Find Lead").click();
		driver.findElementById("Email").click();
		driver.findElementByName("emailAddress").sendKeys("babu@testleaf.com");
		driver.findElementByXPath("(//button[text()='Find Leads'])").click();
		WebElement Firstname = driver.findElementByXPath(("//div[@id='ext-gen918']"));
		String Fname = Firstname.getText();
		System.out.println(Fname);
		driver.findElementByXPath(("//div[@id='ext-gen918']"));
		driver.findElementByLinkText("Duplicate Lead").click();
		System.out.println(driver.getTitle());
		
	}
	
	}
