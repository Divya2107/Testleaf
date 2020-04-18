package week3.day5;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ProjectFrameWindow {
	
	public static void main(String[] args) throws InterruptedException{
		
		//1. Launch the ServiceNow application URL: https://dev92474.service-now.com/
			System.setProperty("webdriver.chrome.driver", "./drivers/Chromedriver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//open  url
	   driver.get("https://dev92474.service-now.com/");
	//add implicit wait
	 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	//maximize the window
	driver.manage().window().maximize();

	//2.Login with valid credentials username as admin and password as India@123
	
	WebElement frame1 = driver.findElementById("gsft_main");
	driver.switchTo().frame(frame1);
	driver.findElementById("user_name").sendKeys("admin");
	driver.findElementById("user_password").sendKeys("India@123");
	driver.findElementById("sysverb_login").click();

	// 3. Enter Incident in filter navigator and press enter
	driver.findElementByXPath("//input[@id='filter']").sendKeys("Incident",Keys.ENTER);

	// 4. Click on Create new option Under Incident

	driver.findElementByXPath("(//div[text()='Create New'])[1]").click();

	
	//5. Get the text of Number Field and Store it in a String
	
	//switch to the frame
	driver.switchTo().frame("gsft_main");
	Thread.sleep(4000);
	//get parent window reference id
	String parent = driver.getWindowHandle();
	
	String incidentNumber = driver.findElementById("incident.number").getAttribute("value");
	System.out.println(incidentNumber);
	
	// 6. Click on the Search Button Available in the Caller Field & Choose First Value Opened in the new Window
	
	driver.findElementByXPath("//button[@id='lookup.incident.caller_id']").click();
	Thread.sleep(5000);
	
	// Get all window handles
		List<String> list = new ArrayList<String>(driver.getWindowHandles());
			 driver.switchTo().window(list.get(1));
			
			//select the first value from the list
			driver.findElementByXPath("(//a[@class='glide_ref_item_link'])[1]").click();
			
			//switch to first window
			driver.switchTo().window(parent);
			
			// 7. Select the Value as Software in Category Field
			driver.switchTo().frame(0);
			
			WebElement dropdown1= driver.findElementByXPath("//select[@id='incident.category']");
			Select dd1 =  new Select(dropdown1);
			dd1.selectByVisibleText("Software");
			
			// 8. Select Internal Application in Sub Category Field
			
			WebElement dropdown2= driver.findElementByXPath("//select[@id='incident.subcategory']");
			Select dd2 =  new Select(dropdown2);
			dd2.selectByVisibleText("Email");
			
			 //9. Select Walk-in in Contact Type Field
			WebElement dropdown3= driver.findElementByXPath("//select[@id='incident.contact_type']");
			Select dd3 =  new Select(dropdown3);
			dd3.selectByVisibleText("Walk-in");
			
			//10. Select state as In-Progress 
			WebElement dropdown4= driver.findElementByXPath("//select[@id='incident.state']");
			Select dd4 =  new Select(dropdown4);
			dd4.selectByVisibleText("In Progress");
			
			//11. Select Urgency as High 
			
			WebElement dropdown5= driver.findElementByXPath("//select[@id='incident.urgency']");
			Select dd5 =  new Select(dropdown5);
			dd5.selectByVisibleText("1 - High");
			
			//12. Click on the Search Button Available in the Assignment Group & Choose Last Residing Value Opened in new Window
			driver.findElementByXPath("//button[@id='lookup.incident.assignment_group']").click();
			Thread.sleep(7000);
			List<String> list1 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(list1.get(1));
			//Choose Last Residing Value Opened in new Window
			List<WebElement> assignPopElements = driver.findElementsByClassName("glide_ref_item_link");
			int groupsize = assignPopElements.size();
			WebElement lastElement = assignPopElements.get(groupsize-1);
			lastElement.click();
			//Switch back to Parent window
			List<String> list2 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(list2.get(0));
			System.out.println(driver.getTitle());
			driver.switchTo().frame("gsft_main");
			
			//13. Enter Short Description as "Creating Incident For the Purpose of Management"
			
			driver.findElementByXPath("//input[@id='incident.short_description']").sendKeys("Creating Incident For the Purpose of Management");
			

	       //14. Click on the Submit Button

			driver.findElementById("sysverb_insert").click();
			
			//15. Enter The Incident Number Newly created in Search Field and Press Enter
			
			driver.findElementByXPath("(//input[@placeholder='Search'])[1]").sendKeys(incidentNumber,Keys.ENTER);
		
			//16. Click on the newly Created Incident Displayed
			
			String newIncident = driver.findElementByXPath("//a[@class='linked formlink']").getText();
			
			//17. Verify the Incident Number
			
			if(incidentNumber.equalsIgnoreCase(newIncident))
			{
				System.out.println("Both Incident Numbers are same");
			}
			//18. Update Impact as High
			
			//driver.findElementById("context_list_rowincident").click();
			driver.findElementByXPath("//a[@class='linked formlink']").click();
			//div[text()='Update Selected']
			
			WebElement dropdown6= driver.findElementById("incident.impact");
			Select dd6 =  new Select(dropdown6);
			dd6.selectByVisibleText("1 - High");
			
			//19. Update Description as "Successfully Created an incident"
			
			driver.findElementByXPath("//input[@id='incident.short_description']").sendKeys("Successfully Created an incident");
			//driver.findElementByXPath("//input[@id='incident.short_description']").sendKeys(Keys.TAB);
			
			//20. Enter Work Notes as "Done Right"
			//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			Thread.sleep(7000);
			driver.findElementById("activity-stream-textarea").sendKeys(Keys.SPACE,Keys.BACK_SPACE,"Done Right");
			//driver.findElementByXPath("//textarea[@id='activity-stream-textarea']").sendKeys("Done Right");
			
			//21. Click on the Update button.
			driver.findElementById("sysverb_update").click();
			
			//22. Logout and Close
			driver.switchTo().defaultContent();
			driver.findElementByXPath("//span[text()='System Administrator']").click();
			driver.findElementByXPath("//a[text()='Logout']").click();
			//close the browser
			driver.close();

			
		
			
			
	}
}
