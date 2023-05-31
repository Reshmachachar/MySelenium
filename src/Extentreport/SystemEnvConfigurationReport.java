package Extentreport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;




public class SystemEnvConfigurationReport {

	public static void main(String[] args) throws IOException, URISyntaxException, Exception
	{
		
		System.setProperty("webdriver.chrome.driver", "G://Selenium_Driver//chromedriver_win32_100//chromedriver.exe"); 
		WebDriver driver=new ChromeDriver();
		ExtentSparkReporter eSparkReporter=new ExtentSparkReporter(".//Extent_Reports//Sysconfig_report.html");
	
		//1.By using eSparkReporter.config() method
		
		eSparkReporter.config().setTheme(Theme.DARK);
		eSparkReporter.config().setReportName("report Name");
		eSparkReporter.config().setDocumentTitle("Doc Title");
		eSparkReporter.config().setTimeStampFormat("dd-MM-yyyy hh:mm:ss");
		eSparkReporter.config().setCss(".badge-primary {background-color: #c5101d}");
		eSparkReporter.config().setJs("document.getElementsByClassName('logo')[0].style.display=\"none\";");
						
        ExtentReports extentReports=new ExtentReports();
        extentReports.attachReporter(eSparkReporter);
        
        //add system environment info to extent report,so it is common to all reporter
        
        extentReports.setSystemInfo("OS", System.getProperty("os.name"));
        extentReports.setSystemInfo("Java Varsion", System.getProperty("java.version"));
        
        //to add browser info,we need Capabilities interface
        
        Capabilities capabilities=((RemoteWebDriver)driver).getCapabilities();
        
        extentReports.setSystemInfo("Browser Name", capabilities.getBrowserName());
        extentReports.setSystemInfo("Browser Varsion",capabilities.getBrowserVersion());
        extentReports.setSystemInfo("APP URL", "www.a_automationtesting.com");
        extentReports.setSystemInfo("User Name", "ansh@gmail.com");
        extentReports.setSystemInfo("Password", "ansh@2191");
        
        
        
        //Author-Device-Category
        
        extentReports.createTest("Test1","Test Description")
        .assignAuthor("Ram")
        .assignDevice("chrome99")
        .assignCategory("smoke")
        .pass("This is passed");
        
        extentReports.createTest("Test2","Test Description")
        .assignAuthor("Shyam")
        .assignDevice("chrome100")
        .assignCategory("sanity")
        .pass("This is passed");
        
        
        extentReports.createTest("Test3","Test Description")
        .assignDevice("firefox99")
        .assignCategory("sanity")
        .fail("This is failed");
        
        extentReports.createTest("Test4","Test Description")
        .assignAuthor("Anu")
        .assignAuthor("Mau")
        .assignDevice("firefox98")
        .assignDevice("chrome99")
        .assignCategory("sanity")
        .assignCategory("smoke")
        .pass("This is passed");
       
        
        extentReports.createTest("Test5","Test Description")
        .assignAuthor("Anu","Mau","Mani")        
        .assignDevice("firefox98","chrome99","chrome100")
        .assignCategory("sanity","smoke","regression")
        .fail("This is failed");

        
        extentReports.createTest("Test6","Test Description")
        .assignAuthor(new String[]{"M1","M2","M3"})        
        .assignDevice(new String[]{"firefox99","chrome100","chrome101"})
        .assignCategory(new String[]{"sanity","smoke","regression"})
        .fail("This is failed");
        
        extentReports.flush();
        driver.close();
        Desktop.getDesktop().browse(new File("Extent_Reports//Sysconfig_report.html").toURI());
        System.out.println("Done!!");

	}

}
