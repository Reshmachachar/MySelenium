package javascripexecutor_pkg;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptExecutorDemo {

	public static void main(String[] args) throws IOException, InterruptedException {
		
	System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_99//chromedriver.exe"); 
		WebDriver driver=new ChromeDriver();
		 //ChromeDriver cd_driver=new ChromeDriver();
		 driver.manage().window().maximize(); 
		 driver.get("https://demo.nopcommerce.com/");
		 
		 //JavascriptExecutor js=cd_driver;//no need to typecast due to hierarchy(Chromedriver extends RemoteWebDriver class which implemenets JavascriptExecutor interface)
		 
		 //Syntax->
		 //JavascriptExecutor js=(JavascriptExecutor) driver; //need typecasting	 
		 //js.executeScript(script, args);
		 
		 //Usage of JavascriptExecutor-->
		 /*
		  *1.flash->(Keep on hilighting the sepecific element)
		  *2.Drawing border & take screenshot
		  *3.Getting title of page
		  *4.To perform click action-->direct click() method for link,button,radion button not work that time we are using JavascriptExecutor method
		  *5.Generate alert
		  *6.refreshing the page
		  *7.at the time of lot of content ,to scroll down and scroll up page ..
		  *8.Zoome page
		  *  
		  */
		
		 //*1.flash->(Keep on hilighting the sepecific element)
		 WebElement logo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		 JavascriptUtil.flash(logo, driver);
		 
		
		 /*
		 //2.Drawing border & take screenshot
		 WebElement logo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		 JavascriptUtil.drawBoarder(logo, driver);
		 
		 TakesScreenshot ts=(TakesScreenshot) driver;
		 File pagescr=ts.getScreenshotAs(OutputType.FILE);
		 File tarloc=new File(".//Screenshot//drawboarder.png");
		 FileUtils.copyFile(pagescr, tarloc);
		 
		 */
		 
		 // *3.Getting title of page
		// System.out.println("Title Of the Page : "+JavascriptUtil.getTitleByJs(driver));
		 
		 
		 //*4.To perform click action
		// WebElement reg=driver.findElement(By.xpath("//a[normalize-space()='Register']"));
		 //JavascriptUtil.clickElementByJs(reg, driver);
				 
		//*5.Generate alert
		// JavascriptUtil.generateAlert(driver,"This is my alert....");
		 
		 // *6.refreshing the page
		 //JavascriptUtil.refreshBrowser(driver);
		 
		 /*
		 //*7  scroll down  
		 JavascriptUtil.scrollDown(driver);
		 
		 //*8  scroll up page
		 Thread.sleep(3000);
		 JavascriptUtil.scrollUp(driver);
		*/
		 
		 //*9 Zoom Page
		// Thread.sleep(3000);
		 //JavascriptUtil.zoomPageByJs(driver);

	}

}
