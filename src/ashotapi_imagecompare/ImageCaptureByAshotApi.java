package ashotapi_imagecompare;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

/*Ashot--.
 * 1.Ashot API is a freeware from Yandex. It is a utility for taking a screenshot in Selenium.
 *   It helps you to take a screenshot of an individual WebElement on different platforms 
 *   like desktop browsers, iOS Simulator Mobile Safari, Android Emulator Browser.
 * 2.Ashot() is a third party utility that is supported by the Selenium web driver to capture the screenshots. 
 *   Ashot() provides below operations in capturing screenshots: 
 *       Capturing the full page. 
 *       Capturing the web element. 
 *       Comparing images.  
 * 3.there are no classes in selenium to compare screenshot or images.
 * 4.we need to depend on third party api ashot.
 *   By using ashot Api we can capture the images and compare it 
 *   
 *   Steps-->
 *   1.Create object of AShot() class //ru.yandex.qatools.ashot.AShot
 *   2.by using object call method at.takeScreenshot(webelement)//at is object
 *   3.at.takeScreenshot(webelement) this method return the Screenshot object..
 *   4.ImageIO.write(screenshotobj.getImage,"image extension",file path(saved location))
 */


public class ImageCaptureByAshotApi {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_108//chromedriver.exe"); 
		WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://opensource-demo.orangehrmlive.com/");
         Thread.sleep(2000);
		 
		WebElement logohrm=driver.findElement(By.xpath("//div[@class='orangehrm-login-branding']/child::img"));
		File f=new File("G://Software/Ashotapi/captured_image/Orangehrmlogo.png");//path of file where it is saved.
		
		AShot at=new AShot();
		Screenshot screenshot_logo=at.takeScreenshot(driver, logohrm);//takeScreenshot method of AShot class
		
		ImageIO.write(screenshot_logo.getImage(), "png",f);
		
		//to check whether this file is saved or not...by using File object
		
		if(f.exists())
			System.out.println("Logo Captured Successfully..");
		else
			System.out.println("Logo Not Captured Successfully..");
		
		
		
		
		
		 
		

	}

}
