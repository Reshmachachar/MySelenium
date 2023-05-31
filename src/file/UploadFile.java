package file;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/*
 * Upload file :
 * 1.sendkeys
 * 2.RobotClass
 */

public class UploadFile {

	public static void main(String[] args) throws AWTException {
		 System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_104//chromedriver.exe");
		 
		 ChromeOptions option=new ChromeOptions();
		 option.addArguments("--disable-notifications");
		 
		 WebDriver driver=new ChromeDriver(option);
		 driver.get("https://www.monsterindia.com/");
		 //click on upload resume
		 driver.findElement(By.xpath("//span[@class='block fs-11 mt10']")).click();
		 
		//By using sendkeys method
		 //but it is possible  only if element has @type=file attribute.(type attribute must be file)
		 
		// driver.findElement(By.xpath("//input[@id='file-upload']")).sendKeys("G:\\Selenium_Driver\\file-sample_150kB.pdf");

		 
		 //By using RobotClass methods		 
		WebElement ele= driver.findElement(By.xpath("//input[@id='file-upload']"));
		 JavascriptExecutor js=(JavascriptExecutor) driver;
		 js.executeScript("arguments[0].click()",ele);
		 
		 
		 Robot rb=new Robot();
		 rb.delay(2000);
		 
		 //put path to file in a clipboard
		 StringSelection ss=new StringSelection("G:\\Selenium_Driver\\file-sample_150kB.pdf");
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		 rb.delay(2000);
		 
		 //CTRL+V
		 rb.keyPress(KeyEvent.VK_CONTROL);
		 rb.keyPress(KeyEvent.VK_V);
		 rb.delay(2000);
		 
		 rb.keyRelease(KeyEvent.VK_CONTROL);
		 rb.keyRelease(KeyEvent.VK_V);
		 rb.delay(2000);
		 
		 rb.keyPress(KeyEvent.VK_ENTER);
		 rb.keyRelease(KeyEvent.VK_ENTER);

	}

}
