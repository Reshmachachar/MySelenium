package methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchMethodsInnerIframe2 {

	public static void main(String[] args) {
		// https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width
 
		System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_99//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");
		
		driver.switchTo().frame("iframeResult");//outerframe/parent..//if there is id or name for both frame and iframe use it directly..there is no need to use xpath.
	  
		//driver.switchTo().frame("//iframe[@title='Iframe Example']");
		driver.switchTo().frame(0);//only one frame present into outerframe
		
		String text = driver.findElement(By.xpath("//h1")).getText();
		
		System.out.println("text of inside inner frame : "+text);
       
		driver.switchTo().parentFrame(); ///go to parent frame or outer farme
		
		text=driver.findElement(By.xpath("//p[contains(text(),'You can use the height and width attributes to spe')]")).getText();
		System.out.println("text of outerframe inner frame : "+text);
		
		
		
		
		driver.close();

	}

}
