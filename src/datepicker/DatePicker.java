package datepicker;
/*
 * its a customized web element beocz its not same for every application
 * it will be having different type of designs
 */

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_104//chromedriver.exe"); 
		WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://www.redbus.in/");
		 
		 //for example-21/7/2022
		 String year="2022";
		 String month="Dec ";
		 String day="21";
		
		 //Apr 2022
		 
		 driver.findElement(By.xpath("//span[@class='fl icon-calendar_icon-new icon-onward-calendar icon']")).click();//open the datepicker
         
		 String user_monthtitle=month+year;
		 String monthtitle;
		 List<WebElement> daylist;
		 int checker;
		
		while(true) 
		{
			checker=0;
			 monthtitle= driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();
			 System.out.println(monthtitle);
			 daylist= driver.findElements(By.xpath("//table[@class='rb-monthTable first last']//tbody//tr//td"));
		    //monthtitle= driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();
		    if(monthtitle.equalsIgnoreCase(user_monthtitle)) 
		    {
		    	for(WebElement ele : daylist)
		    	{
		    		if(ele.getText().equalsIgnoreCase(day))
		    		{
		    			ele.click();
		    			checker=1;
		    			break;
		    		}
		    	}
		    	
		    }
		    if(checker==1)
		    	break;
		    else
		    driver.findElement(By.xpath("//td[@class='next']//button")).click();
		    
		}
		
		 
	}

}
