package week2.day3;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Createlead
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leaftaps.com/opentaps/contro.main");
		
		WebElement eleUserName = driver.findElementById("username");
		eleUserName.sendKeys("DemoSalesManager");
		driver.findElementByName("PASSWORD").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Leads").click();
		
		driver.findElementByLinkText("Create Lead").click();
		
		driver.findElementById("createLeadForm_companyName").sendKeys("Accenture");
		driver.findElementById("createLeadForm_firstName").sendKeys("Div");
		driver.findElementById("createLeadForm_lastName").sendKeys("Elan");
		//driver.findElementByClassName("smallSubmit").click();
		//String title = driver.getTitle();
		//System.out.println(title);
		//driver.close();
		
		
		WebElement dropdown1= driver.findElementById("createLeadForm_dataSourceId");
		Select dd1 =  new Select(dropdown1);
		
		dd1.selectByVisibleText("Cold Call");
		
		WebElement dropdown2= driver.findElementById("createLeadForm_industryEnumId");
		Select dd2 = new Select(dropdown2);
		
		 List<WebElement> options= dd2.getOptions();
		int count = options.size();
		dd2.selectByIndex(count-1);
		//String dropdown= dropdown2.getText();
		//System.out.println(dropdown);
				
		
	}
}

