package file;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class DownloadWordFile_FireFox {

	public static void main(String[] args) {
		
		
		String location=System.getProperty("user.dir")+"\\Downloads\\";
		System.out.println(location);
	
		//download file to your dir--> ff browser-->set ff_profile-->set options with profile-->set options to ff_driver
		
		FirefoxProfile pf=new FirefoxProfile();
		pf.setPreference("browser.download.folderList", 2);
		//0->desktop
		//1->downloads folder
		//2->your desire location-->need to give path
		
		pf.setPreference("browser.download.dir", location);
		
		FirefoxOptions options=new FirefoxOptions();
		options.setProfile(pf);
		
	
		 System.setProperty("webdriver.gecko.driver", "G://Selenium_Driver//geckodriver-v0.30.0-win64//geckodriver.exe"); 
		 WebDriver driver=new FirefoxDriver(options);
		 
		 driver.manage().window().maximize();
		 driver.get("https://file-examples.com/index.php/sample-documents-download/sample-doc-download/");
		 
		 driver.findElement(By.xpath("//tr[@class='even']//a[@class='btn btn-orange btn-outline btn-xl page-scroll download-button'][normalize-space()='Download sample DOC file']")).click();
		 //Settings-->Advance-->Downloads-->Location
		 
		 

	}

}
