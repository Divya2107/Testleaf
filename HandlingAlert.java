package week3.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAlert {
	
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();

	driver.get("http://www.leafground.com/pages/Alert.html");
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	//1)Alert Box
	driver.findElementByXPath("//button[text()='Alert Box']").click();
	
	Alert alert1 =  driver.switchTo().alert();
	
	String text1 = alert1.getText();
	System.out.println(text1);
	
	alert1.accept();
	
	//2)Confirm Box - Confirm Box (Cancel)  
	driver.findElementByXPath("//button[text()='Confirm Box']").click();
	
	Alert alert2 =  driver.switchTo().alert();
	
	String text2 = alert2.getText();
	System.out.println(text2);
	
	alert1.dismiss();
	
	
	//3)Prompt Box
	
driver.findElementByXPath("//button[text()='Prompt Box']").click();
	
	Alert alert3 =  driver.switchTo().alert();
	
	String text3 = alert3.getText();
	System.out.println(text3);
	
	alert3.sendKeys("Sogeti");
	alert3.accept();

	
	//4)Sweet Alert Click OK  
	
driver.findElementByXPath("//button[text()='Sweet Alert']").click();
	
	Alert alert4 =  driver.switchTo().alert();
	Thread.sleep(2000);
	driver.findElementByXPath("//button[text()='OK']").click();
	
}
}