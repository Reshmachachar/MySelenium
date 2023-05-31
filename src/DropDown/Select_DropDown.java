package DropDown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;





public class Select_DropDown {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_99//chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.opencart.com/index.php?route=account/register");
		
		//1.identify the select html tag (webelement) and then sendt it to Select class
		
	   WebElement selecttag_opt=driver.findElement(By.id("input-country"));
	   
	       //import org.openqa.selenium.support.ui.Select;
	   Select selpoint=new Select(selecttag_opt);
	   
	   //SelectClass Methods---
	   //1. selectByVisibleText("name of the option")
	   //selpoint.selectByVisibleText("Aruba");
	   
	    //2.selectByValue("option value as string")
	    //selpoint.selectByValue("21"); //Belgium
	   
	   //3.selectByIndex
	   // selpoint.selectByIndex(7); //Anguilla
	   
	   //4.getOptions--
	   List<WebElement> alloptions=selpoint.getOptions();
	   gen_option(alloptions,"austria"); 
	   
	}

	public static void gen_option(List<WebElement> alloptions,String val)
	{
		for(WebElement element:alloptions)
		   {
			   if(element.getText().equalsIgnoreCase(val))
			   {
				   element.click();
				   break;
			   }
		   }
		
	}
	
}
