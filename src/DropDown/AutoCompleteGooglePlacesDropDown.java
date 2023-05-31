package DropDown;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoCompleteGooglePlacesDropDown {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_99//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.twoplugs.com/");
		driver.findElement(By.xpath("//a[text()='Live Posting']")).click();
		
		WebElement search=driver.findElement(By.id("autocomplete"));
		search.clear();
		search.sendKeys("Toronto");
       
		String text;
		do
		{
			search.sendKeys(Keys.ARROW_DOWN);
			
			text=search.getAttribute("value");
			if(text.equalsIgnoreCase("Toronto, OH, USA"))
			{
				search.sendKeys(Keys.ENTER);
				break;
			
			}
			Thread.sleep(3000);
		}while(!text.isEmpty());

	}

}
