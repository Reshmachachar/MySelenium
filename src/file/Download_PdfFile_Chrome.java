package file;



import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Download_PdfFile_Chrome {

	public static void main(String[] args) {

		String location=System.getProperty("user.dir")+"\\Downloads\\";
		System.out.println(location);
		
		HashMap map=new HashMap();
		//plugins.always_open_pdf_externally
		map.put("plugins.always_open_pdf_externally", true);//always false..if it is false then pdf file open in new window then we need to download it manually
		map.put("download.default_directory", location);
		
		ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("prefs", map);
		
	
		 System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32 _vversion_99//chromedriver.exe"); 
		 WebDriver driver=new ChromeDriver(options);
		 
		 driver.manage().window().maximize();
		 driver.get("https://file-examples.com/index.php/sample-documents-download/sample-pdf-download/");
		 
		 driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click();
		 //Settings-->Advance-->Downloads-->Location
		  

	}

}
