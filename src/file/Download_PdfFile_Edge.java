package file;



import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;


public class Download_PdfFile_Edge {

	public static void main(String[] args) {

		String location=System.getProperty("user.dir")+"\\Downloads\\";
		System.out.println(location);
		
		HashMap map=new HashMap();
		map.put("plugins.always_open_pdf_externally", true);//always false..if it is false then pdf file open in new window then we need to download it manually
		map.put("download.default_directory", location);
		
		EdgeOptions options=new EdgeOptions();
		options.setExperimentalOption("prefs", map);
		
	
		System.setProperty("webdriver.edge.driver", "G://Selenium_Driver//edgedriver_win64_latest//msedgedriver.exe"); 
		WebDriver driver=new EdgeDriver(options);
		 
		 driver.manage().window().maximize();
		 driver.get("https://file-examples.com/index.php/sample-documents-download/sample-pdf-download/");
		 
		 driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click();
		 //Settings-->Advance-->Downloads-->Location
		 
		 

	}

}
