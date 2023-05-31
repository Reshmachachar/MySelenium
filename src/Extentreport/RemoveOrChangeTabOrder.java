package Extentreport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

public class RemoveOrChangeTabOrder {

	public static void main(String[] args) throws IOException, URISyntaxException {
		ExtentSparkReporter eSparkReporter=new ExtentSparkReporter(".//Extent_Reports//tab-order_report.html");
		
		
		
		//ViewName is enum (constant values are there)
		eSparkReporter.viewConfigurer().viewOrder().as(new ViewName[] {
				
			ViewName.DASHBOARD,
			ViewName.CATEGORY,
			ViewName.DEVICE,
			ViewName.TEST,
			ViewName.LOG
				
		}).apply(); //apply() is important to make custom changes permanent into spark reporter. 
		
        ExtentReports extentReports=new ExtentReports();
        extentReports.attachReporter(eSparkReporter);

        
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
        
        try {
       	 int i=2/0;
        }catch (Exception e) {
			extentReports.createTest("Exception_Test_7")
			//.info(e);
			.fail(e);
			
		}
        
        extentReports.flush();
        Desktop.getDesktop().browse(new File("Extent_Reports//tab-order_report.html").toURI());
        System.out.println("Done!!");

	}

}
