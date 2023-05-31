package DropDown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class Select_DropDownGenMethod {

	public static void main(String[] args) {
		
       System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_99//chromedriver.exe");
		
       WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.facebook.com/r.php?locale=en_GB&display=page");
		
		
		WebElement day_pointer=driver.findElement(By.id("day"));
		getElementByOption(day_pointer,"21");
		
		WebElement month_pointer=driver.findElement(By.id("month"));
		getElementByOption(month_pointer,"jul");
		
		WebElement year_pointer=driver.findElement(By.id("year"));
		getElementByOption(year_pointer,"1991");
		
	}
	
	public static void getElementByOption(WebElement Ele,String val) 
	   {
		
		Select point=new Select(Ele);
	List<WebElement> listop= point.getOptions();
		
		for(WebElement op:listop )
		{
			
			if(op.getText().equalsIgnoreCase(val))
			{
				op.click();
				break;
			}
		
		
	    }
	}

}
