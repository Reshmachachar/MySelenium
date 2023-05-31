package DropDown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BootstrpDropDown {

	public static void main(String[] args) {
System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_99//chromedriver.exe");
		
        ChromeOptions option=new ChromeOptions();
        option.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(option);
		
		driver.get("https://www.hdfcbank.com/");
		
		//Alert alertwindow=driver.switchTo().alert();
		//alertwindow.dismiss();
		driver.findElement(By.xpath("//img[@class='closeSummer']")).click();
		
		
		//driver.findElement(By.xpath("//div[@class='drp1']//div[@class='dropdown']")).click();
		//driver.findElement(By.xpath("//a[normalize-space()='Select Product Type']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Select Product Type')]")).click();
		//a[contains(text(),'Select Product Type')]
		//a[normalize-space()='Select Product Type']
		List<WebElement> prod_type =driver.findElements(By.xpath("//ul[@class='dropdown1 dropdown-menu']//li"));		
		prodSelection(prod_type,"Accounts");
		
		/*
		driver.findElement(By.xpath("//a[text()='Select Product']")).click();
		//a[normalize-space()='Select Product'][1]
		List<WebElement> prod =driver.findElements(By.xpath("//ul[@class='dropdown2 dropdown-menu']//li"));
        prodSelection(prod,"Savings Accounts");
		*/
		driver.findElement(By.xpath("//a[text()='Select Product']")).click();
		//a[normalize-space()='Select Product'][1]
		List<WebElement> prod =driver.findElements(By.xpath("//ul[@class='dropdown2 dropdown-menu']//li"));
        prodSelection(prod,"Salary Accounts");
        
        
		System.out.println(prod.size());
		
		
		
	}
	
	public static void prodSelection(List<WebElement> listop,String val)
	{
	 
	 	
		for(WebElement ele:listop)
		{
			System.out.println(ele.getText());
			
			if(ele.getText().equalsIgnoreCase(val))
			{
				System.out.println(ele.getText());
				ele.click();
				break;
			}
		}
	  
	}

}
