package file;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class DownloadWordFile_Edge {

	public static void main(String[] args) {
		
		String location=System.getProperty("user.dir")+"\\Downloads\\";
		System.out.println(location);
		
		//download file to your dir--> edge and chrome browser-->set HashMap-->set options(setExperimentalOptions) with map-->set options to Edge/chrome_driver
		
		HashMap map=new HashMap();
		map.put("plugins.always_open_pdf_externally", true);
		map.put("download.default_directory", location);
		EdgeOptions options=new EdgeOptions();
		options.setExperimentalOption("prefs", map);
				
		
		 System.setProperty("webdriver.edge.driver", "G://Selenium_Driver//edgedriver_win64_latest//msedgedriver.exe"); 
		 WebDriver driver=new EdgeDriver(options);
		 
		 driver.manage().window().maximize();
		 driver.get("https://file-examples.com/index.php/sample-documents-download/sample-doc-download/");
		// driver.get("edge://settings/downloads");
		
		 
		 driver.findElement(By.xpath("//tr[@class='even']//a[@class='btn btn-orange btn-outline btn-xl page-scroll download-button'][normalize-space()='Download sample DOC file']")).click();
		 //Settings-->Advance-->Downloads-->Location
		 
		 

	}

}
