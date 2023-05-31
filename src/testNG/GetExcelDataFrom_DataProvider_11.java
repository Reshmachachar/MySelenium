package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetExcelDataFrom_DataProvider_11 {
	
	WebDriver driver;
		
	@Test(dataProvider="loginDataOfOrangeHRM",dataProviderClass = ExcelDataSupplier_11_1.class)
	public void loginOrangeHRMData(String userName,String password)
	{
		System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32_100//chromedriver.exe"); 
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.findElement(By.id("txtUsername")).sendKeys(userName);
        driver.findElement(By.id("txtPassword")).sendKeys(password);
        driver.findElement(By.id("btnLogin")).click();
        Assert.assertTrue(driver.findElement(By.id("welcome")).isDisplayed());
		driver.close();
	}

}
