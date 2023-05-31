package file;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DownloadWordFile_Chrome {

	public static void main(String[] args) {
		
		String loaction=System.getProperty("user.dir")+"\\Downloads\\";
		System.out.println(loaction);
		
		//download file to your dir--> edge and chrome browser-->set HashMap-->set options(setExperimentalOptions) with map-->set options to Edge/chrome_driver
		
		HashMap preferences=new HashMap();
		preferences.put("download.default_directory", loaction);	
		ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("prefs", preferences);
		
		
		
		/*
		String location=System.getProperty("user.dir")+"\\Downloads\\";   //--> \\Downloads\\
		System.out.println(location);
		
		//chrome : 
		HashMap preferences=new HashMap();
		preferences.put("download.default_directory", location);
		////download.default_directory--> this key is imp.."download" word imp..its not just String..Its KeyName
		
		ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("prefs", preferences);
		//prefs keyname also imp..must be correct..otherwise w are getting error
		
		*/
		
		
		 System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_99//chromedriver.exe"); 
		 WebDriver driver=new ChromeDriver(options);
		 
		 driver.manage().window().maximize();
		 driver.get("https://file-examples.com/index.php/sample-documents-download/sample-doc-download/");
		 
		 driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click();
		 //Settings-->Advance-->Downloads-->Location
		 
		 

	}

}
