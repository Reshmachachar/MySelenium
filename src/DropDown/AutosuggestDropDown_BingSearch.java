package DropDown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutosuggestDropDown_BingSearch {

	public static void main(String[] args) throws InterruptedException {
      
		System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_99//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.name("q")).sendKeys("sele");
		//driver.findElement(By.name("q")).sendKeys("selenium");
		Thread.sleep(3000);
	
		
		
		List<WebElement> suggestlist=driver.findElements(By.xpath("//li[@class='sbct sbre']//span"));//search sele
		//List<WebElement> suggestlist=driver.findElements(By.xpath("//li[@class='sbct']//div[@role='option']//div[1]//span"));//search selenium
		
		System.out.println("size :"+ suggestlist.size()+" "+ suggestlist);
		
		for(WebElement ele:suggestlist)
		{
			if(ele.getText().equalsIgnoreCase("Selena Gomez"))//Selena Gomez
			//if(ele.getText().contains(" interview questions"))//webdriver or interview questions
				{
				ele.click();
				break;
				}
			
		}

	}

}
