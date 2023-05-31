package DropDown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutosuggestDropDown_GoogleSearch {

	public static void main(String[] args) throws InterruptedException {
      
		System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_99//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.bing.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("sb_form_q")).sendKeys("selenium");
		//Thread.sleep(3000);
		//li[@class='sa_sg']//span
		//li[@class='sa_sg']//ancestor::span
		List<WebElement> suggestlist=driver.findElements(By.xpath("//li[@class='sa_sg']//span"));
		
		System.out.println("size :"+ suggestlist.size()+" "+ suggestlist);
		
		for(WebElement ele:suggestlist)
		{
			if(ele.getText().contains("download"))
				{
				ele.click();
				break;
				}
			
		}

	}

}
