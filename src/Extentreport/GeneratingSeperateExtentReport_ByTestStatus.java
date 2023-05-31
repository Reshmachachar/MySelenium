package Extentreport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

public class GeneratingSeperateExtentReport_ByTestStatus {

	public static void main(String[] args) throws IOException, URISyntaxException {
		
		//1.Report_1 for all test
		ExtentSparkReporter eSparkReporter=new ExtentSparkReporter(".//Extent_Reports//Alltest.html");
		
		/*2.Report_2 for failed test
		  2.1 eSparkReporter_failed.filter().statusFilter().as(new Status[])
		  2.2 used to filter the test cases before generating the report
		  2.3 Status is enum
		  */
		 
		ExtentSparkReporter eSparkReporter_failed=new ExtentSparkReporter(".//Extent_Reports//failedtest.html");
		eSparkReporter_failed.filter().statusFilter().as(new Status[] {Status.FAIL});
		
		//3.Report_3 for Skip and warning test cases
		ExtentSparkReporter eSparkReporter_skipandwaring=new ExtentSparkReporter(".//Extent_Reports//skipandwaringtest.html");
		eSparkReporter_skipandwaring.filter().statusFilter().as(new Status[] {
			
				Status.SKIP,
				Status.WARNING
		});

		ExtentReports extentReports=new ExtentReports();
		extentReports.attachReporter(eSparkReporter);
		extentReports.attachReporter(eSparkReporter_failed);
		extentReports.attachReporter(eSparkReporter_skipandwaring);


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
		.skip("This is skipped");


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
		.warning("This is Warning");


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
		Desktop.getDesktop().browse(new File("Extent_Reports//Alltest.html").toURI());
		Desktop.getDesktop().browse(new File("Extent_Reports//failedtest.html").toURI());
		Desktop.getDesktop().browse(new File("Extent_Reports//skipandwaringtest.html").toURI());
		System.out.println("Done!!");

	}

}
