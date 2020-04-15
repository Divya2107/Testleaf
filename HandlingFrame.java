package week3.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingFrame {
	
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();

	driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	
	driver.switchTo().frame("iframeResult");
	driver.findElementByXPath("//button[text()='Try it']").click();
	//driver.switchTo().defaultContent();
	
	

	Alert alert= driver.switchTo().alert();
	Thread.sleep(2000);
	String text1 = alert.getText();
	System.out.println(text1);
	alert.accept();

}
}
