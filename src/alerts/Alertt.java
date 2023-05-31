package alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alertt {

	public static void main(String[] args) throws InterruptedException {
		
	//	 System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32_100//chromedriver.exe"); 
		 WebDriver driver=new ChromeDriver();
		 driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		 
		 //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 
		 //alert window with only OK Button
		/* driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
		 Thread.sleep(3000);
		 driver.switchTo().alert().accept();//driver.switchTo().alert()--return alert obj.//closing window by using OK Button
		*/
		 
		 /*
		 //Alert window with OK and Cancel
		 driver.findElement(By.xpath("//button[@onClick='jsConfirm()']")).click();
		 Thread.sleep(3000);
		// driver.switchTo().alert().accept();//closing by OK Button
		 driver.switchTo().alert().dismiss();//closing window by Cancel Button
		 */
		 
		 //Alert window with Textbox, Capturing text
		 driver.findElement(By.xpath("//button[@onClick='jsPrompt()']")).click();
		 //driver.switchTo().alert().sendKeys("Welcome");
		 
		 Alert alertwindow=driver.switchTo().alert();
		 alertwindow.sendKeys("Welcome");
		 Thread.sleep(3000);
		 alertwindow.accept();
		// alertwindow.dismiss();

		 
	}

}
