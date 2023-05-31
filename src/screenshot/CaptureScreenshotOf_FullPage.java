package screenshot;
/*
 * Tekescreenshot interface-->used To take screenshot of full page.
 * 
 */


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureScreenshotOf_FullPage {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_99//chromedriver.exe"); 
		 WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize(); 
		 driver.get("https://demo.nopcommerce.com/");
		
		 /*
		 TakesScreenshot ts=(TakesScreenshot) driver; 
		 //both are different interface.
		 //RomoteWebDriver class implements the WebDriver ,TakesScreeenshot,JavaScriptExecutor
		 //but TakesScreenshot interface instance can not hold the WebDriver instance which is in high in hierarchy
		 
		File fsc= ts.getScreenshotAs(OutputType.FILE);
		File targloc=new File(".//Screenshot//homepage1.png");
		//Path->  .//Screenshot//homepage.png--> '.' ->represent current directory..Screenshot->Foldername..homepage.png->filename 

		 FileUtils.copyFile(fsc, targloc);
		 */
		 
		 //ScreenShot of  Section/portion of page
		 /*
		 WebElement section=driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
		 File section_fl=section.getScreenshotAs(OutputType.FILE);
		 File tarloc=new File(".//Screenshot//Productgrid.png");
		 FileUtils.copyFile(section_fl, tarloc);
		 */
		 
		 WebElement logo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		 File logo_fl=logo.getScreenshotAs(OutputType.FILE);
		 File tarloc=new File(".//Screenshot//logo.png");
		 FileUtils.copyFile(logo_fl, tarloc);
		 
		 
		 driver.close();
		
	}

}
