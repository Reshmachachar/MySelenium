package checkbox;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleCheckBox {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_99//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://itera-qa.azurewebsites.net/home/automation");
       
		//1/Select Specific checkbox
		//driver.findElement(By.id("monday")).click();
		
		/*
		//2.Select All the checkboxes
		///input[@type='checkbox' and contains(@id,'day')]
		//List<WebElement> dayslist=driver.findElements(By.xpath("//label[contains(text(),'Which days of the week are best to start something')]//following-sibling::div//input"));
		List<WebElement> dayslist=driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
		System.out.println("days :"+dayslist);
		
		for(WebElement day :dayslist ) 
		{
		    	day.click();
		}
		*/
		
		/*//3.Selecting Multiple checkbo by Choice--Ex - monday and sunday
		
		List<WebElement> dayslist=driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
		System.out.println("days :"+dayslist);
		String text;
		for(WebElement day :dayslist ) 
		{
		    	text=day.getAttribute("id");
		    	if(text.equalsIgnoreCase("monday") || text.equalsIgnoreCase("sunday")) {
		    		day.click();
		    		
		    	}
		}*/
		
		/*//4.Selecting 2 or 3 last checkboxes  
		
				List<WebElement> dayslist=driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
				System.out.println("days :"+dayslist);
				String text;
				for(int i=(dayslist.size()-3);i<dayslist.size();i++) 
				{
					dayslist.get(i).click();
				}*/
		
		//4.Selecting first 2 checkboxes  
		
		List<WebElement> dayslist=driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
		System.out.println("days :"+dayslist);
		String text;
		for(int i=0;i<dayslist.size();i++) 
		{
			if(i<3)
			dayslist.get(i).click();
		}



	}

}
