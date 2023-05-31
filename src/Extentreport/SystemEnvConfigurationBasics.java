package Extentreport;

/* 1.System environment details are mentioned in the report 
 *   for better understanding of test script execution for the other tester or developer or 
 *   management people.
 * 2.This report shows that which system environment resources are used to execute the 
 *   test script.    
 * 
 */

import java.io.IOException;
import java.net.URISyntaxException;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;



public class SystemEnvConfigurationBasics {

	public static void main(String[] args) throws IOException, URISyntaxException {
		
		System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32_100//chromedriver.exe"); 
		WebDriver driver=new ChromeDriver();
		
		
		    
        /*1.to get capabilities or system environment details,
            we need to type cast driver into RemoteWebDriver.
          2.After type casting, we can get the Capabilities class.
          3.add this info at extent report level that means those are common to all
            reporter. 
        */
        
		// 4.Get Browser info=>we need Capabilities  interface
		
      Capabilities capabilities=((RemoteWebDriver)driver).getCapabilities();
      System.out.println(capabilities.getBrowserName());
      System.out.println(capabilities.getBrowserVersion());
      
       //5.To get system and java info we need to use system properties.
      
       // System.getProperties().list(System.out);//list all properties of system
         String os_name= System.getProperty("os.name");
         String os_version=System.getProperty("os.version");
         String java_version=System.getProperty("java.version");
         System.out.println(os_name+"/ "+os_version+" / "+java_version);
        
        
        
        
       
        
        driver.close();
	}

}
