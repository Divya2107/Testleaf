package week3.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.Collections;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ListAssignment {
	public static void main(String[] args)
	{

	System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
	
	ChromeDriver driver = new ChromeDriver();
//1)Load the site
driver.get("https://erail.in/trains-between-stations/mgr-chennai-ctr-MAS/ksr-bengaluru-SBC");

driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

//2)click on sort date
boolean selected = driver.findElementById("chkSelectDateOnly").isSelected();
if(selected==true)
	 driver.findElementById("chkSelectDateOnly").click();
//3) Get all the Train Names  
List<WebElement> trains = driver.findElementsByXPath("//div[@id='divTrainsList']//td[@class=''][2]");
int size = trains.size();

//4)Create another List using ArrayList (trainNames)  
List<String> trainNames =new ArrayList<String>();

//5)for each loop : List<WebElement>  
for (WebElement eachTrain : trains) {
	
//6)You will get each WebElement : get its text  	
	String train = eachTrain.getText();
	
//7)Add the text to your created list 
	trainNames.add(train);
}
// 8)Sorting the list
Collections.sort(trainNames);
// 9)Printing the list
for (int i = 0; i < trainNames.size(); i++)
{
	System.out.println(trainNames.get(i));

}
	}
    }
