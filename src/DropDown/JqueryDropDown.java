package DropDown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class JqueryDropDown {

	public static void main(String[] args) {
		
     System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_99//chromedriver.exe");
		
     WebDriver driver=new ChromeDriver();
     driver.manage().window().maximize();
		
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");

		/*//MultiSelection
		driver.findElement(By.id("justAnInputBox")).click();	
		//selectchoicevalues(driver,"choice 1");//muultiselection or single selection(generic)
		selectchoicevalues(driver,"choice 1","choice 2","choice 2 1","choice 6","choice 6 2","choice 6 2 3");//multiselection		
		//selectchoicevalues(driver,"All");
		*/
		
		/*
		//Single Selection
		//driver.findElement(By.id("justAnotherInputBox")).click();//singleselection
		//selectchoicevalues(driver,"choice 1");//muultiselection or single selection(generic)
		*/
		
		
		//multiselection with cascading option
		driver.findElement(By.id("justAnInputBox1")).click();
		//multiselection with cascading option means if you select option 2 then its all sub-options also selected
		//selectchoicevalues(driver,"choice 1","choice 2","choice 6");
		selectchoicevalues(driver,"choice 1","choice 2","choice 6 2");
		//selectchoicevalues(driver,"choice 6 2");
		
	
      //driver.close();
		
	}
	public static void selectchoicevalues(WebDriver driver, String... value)
	{
		//span[@class='comboTreeItemTitle']
		List<WebElement> choiceslist=driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));
		//value[0].equalsIgnoreCase("All")...var agr is internally two diamentional array.
		System.out.println("choicfun enter");
		System.out.println("choicfun size"+choiceslist.size());
		
		if(value[0].equalsIgnoreCase("All"))
		{
			//System.out.println("If enter");
			for(WebElement choc : choiceslist)
			{
			
				choc.click();
			}
		}
		else
		{
			for(String val : value)
			{
				for(WebElement choc : choiceslist)
				{
					//get text of choc webelement and compare it by passing value_choice text
					if((choc.getText()).equalsIgnoreCase(val))
					{
						choc.click();
						break;
					}
				}
			}
		}
	}

}
