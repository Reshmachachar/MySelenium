package other;

import org.bouncycastle.util.encoders.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/* Objective=we do not want to show password into coding part so we have decoded part of password.
 *So we encode that password and send to password text box through sendkeys(). 
*/
public class PasswordAutomationDeToEN {

	public static void main(String[] args) {
		
		 System.setProperty("webdriver.gecko.driver", "G://Selenium_Driver//geckodriver-v0.30.0-win64//geckodriver.exe"); 
		 WebDriver driver=new FirefoxDriver();
		 driver.manage().window().maximize();
		 driver.get("https://demo.nopcommerce.com/login");
		
		 driver.findElement(By.id("Email")).sendKeys("ansh@gmail.com");
		 driver.findElement(By.id("Password")).sendKeys(decodepassword("YWRtaW4xMjM="));
		 driver.findElement(By.xpath("//button[@class='button-1 login-button']")).click();
		 
		 // System.out.println(new String(Base64.encode("admin123".getBytes())));
			 

	}
	
	public static String decodepassword(String decodedpasw)
	{
		return new String(Base64.decode(decodedpasw.getBytes()));
	}

}
