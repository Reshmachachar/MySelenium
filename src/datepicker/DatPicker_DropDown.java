package datepicker;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DatPicker_DropDown {

	public static void main(String[] args) {
		
		 System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_99//chromedriver.exe"); 
		 WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
         driver.findElement(By.id("dob")).click();
         
         //user date-->21-july-1991
                  
         
         //Select Month and Year
         Select month_drp=new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
		 //only first element to point whole month drop down.
         month_drp.selectByVisibleText("Jul");
         
         Select year_drp=new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
         year_drp.selectByVisibleText("1991");
         
         //date-day
         String day="21";
         List<WebElement> daylist=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td"));
          
         for(WebElement ele : daylist)
         {
        	 if(ele.getText().equalsIgnoreCase(day))
        	 {
        		 ele.click();
        		 break;
        	 }
         }
         
         
         
	}

}
