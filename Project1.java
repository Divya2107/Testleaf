package week2.day5;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Project1 {
	
	

	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
	//	1) Open https://www.myntra.com/
	driver.get("https://www.myntra.com/");
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	//2) Mouse over on WOMEN (Actions -> moveToElement		
    WebElement Women = driver.findElementByXPath("(//a[@class='desktop-main'])[2]");
	Actions builder =new Actions(driver);
	builder.moveToElement(Women).perform();
	
	//3) Click Jackets & Coats
	 driver.findElementByLinkText("Jackets & Coats").click();
	 
	 
	   //driver.findElementByXPath(//h1[text()='Coats & Jackets For Women']);
	 
	//4) Find the total count of item (top) ->  
    String totalCount = driver.findElementByXPath("//span[@class='title-count']").getText();
    String totalCountOnTopinNumber = totalCount.replaceAll("\\D","");
	int totalCountOnTop = Integer.parseInt(totalCountOnTopinNumber);
    System.out.println("Total Count On Top" + totalCountOnTop);
	
	
	   				
	//5)Validate the sum of categories count matches
	 String jacketsCount = driver.findElementByXPath("(//input[@type='checkbox']/following-sibling::span)[1]").getText();  
	String jacketsCountInNumber = jacketsCount.replaceAll("\\D","");
	int noOfJackets = Integer.parseInt(jacketsCountInNumber);
	System.out.println(noOfJackets);
	 
	 String coatsCount = driver.findElementByXPath("(//span[@class='categories-num'])[2]").getText();
	 String coatsCountInNumber = coatsCount.replaceAll("\\D","");
		int noOfCoats = Integer.parseInt(coatsCountInNumber);
	 System.out.println(noOfCoats);
	   				
	 int	totalCountOnLeft =  noOfJackets + noOfCoats;
	   					
	   					System.out.println (totalCountOnLeft);
	   
	   						if (totalCountOnTop==totalCountOnLeft)
	   						{
	   							System.out.println("Total Count On Top matches Total Count On Left");
	   						}
	   							else
	   							{
	   								System.out.println("Count Mismatches");
	   								
	   					}
	
	  //6) Check Coats
	   driver.findElementByXPath("(//div[@class='common-checkboxIndicator'])[2]").click();
	   				
	 //7) Click + More option under BRAND
	   	driver.findElementByXPath("//span[text()='Brand']/following-sibling::div[2]").click();
	   				
	//8) Type MANGO and click checkbox
	   	driver.findElementByClassName("FilterDirectory-searchInput").sendKeys("Mango");
	   	driver.findElementByXPath("//span[@class='FilterDirectory-count']/following-sibling::div").click();
	   		
	//9) Close the pop-up x
	   	driver.findElementByXPath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']").click();
	   	
	   	Thread.sleep(5000);
	   				
//10)Confirm all the Coats are of brand MANGO
	   
	  
List<WebElement> brandName = driver.findElementsByXPath("//h3[text()='MANGO']");
int countOfMango = brandName.size();
System.out.println("Mango Branded Coats are:" + countOfMango);


for(WebElement verifyMango : brandName)
	
{
	
	String brandNameisMyntra = verifyMango.getText();
	
	
	if(brandNameisMyntra.equals("MANGO"))
	{
		System.out.println("Brand is verified as MANGO for all items displayed");
		
		break;
	}
	}
	
	//11) Sort by Better Discount
driver.findElementByClassName("sort-sortBy").click();
driver.findElementByXPath("//label[text()='Better Discount']").click();

//12)Find the price of first displayed item
List<WebElement> productPrice = driver.findElementsByClassName("product-discountedPrice");
String firstpriceofTheDisplayedItem = productPrice.get(0).getText();
System.out.println("Top discounted Coat costs:" + firstpriceofTheDisplayedItem);

//13) Mouse over on size of the first item

WebElement sizeOftheFirstDisplayedCoat = driver.findElementByXPath("(//h4[@class='product-sizes'])[1]");
Actions builder2 =new Actions(driver);
builder2.moveToElement(sizeOftheFirstDisplayedCoat).perform();

//14)click on wishlist
		driver.findElementByXPath("(//span[text()='wishlist now'])[1]").click();
		//close browser
	//15)close the driver
		driver.close();		


}
}