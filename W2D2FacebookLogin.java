package week1.day2;

import org.openqa.selenium.chrome.ChromeDriver;


	public class FacebookLogin {

		public static void main(String[] args) 
		{
			System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
			
			ChromeDriver driver = new ChromeDriver();
			
			driver.get("https://www.facebook.com/");
			
			driver.findElementById("email").sendKeys("divya_elangovan@gmail.com");
			driver.findElementById("pass").sendKeys("readsasd");
			driver.findElementById("loginbutton").click();
			
			driver.close();
			
			}

	}
	
