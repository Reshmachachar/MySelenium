package testNG;

/*1.Test case failed then to take screenshot of it,we use two methods
 *   1.By using Listener              -   for this we use ITestListener interface
 *   2.By using dependency injection
 *   
 *1.2 what is exactly dependency injection?
 *     =>1.We do not send/pass any values,TestNG directly inject the value at the runtime.
 *       2.value means Internally created ITestResult result object passed by TestNG at the runtime
 *       3.We can use it directly in our test method.
 *       4.for this,you should add @After annotation for failed test method.
 *       
 * 1.Whenever your test case failed,
 *    your test name should be your screenshot's name .@Test(name="test name")
 *     
 *2.when the testNG triggering execution , internally creating the ITestResult object.
 *   1.ItestResult object proved the name of test or test method name
 *   
 *3.We can get test name or test method name by using ITestResult object
 *
 *4.How to avoid screenshot overriding?
 *   ->By using date and time format we can achieve this.   
   
 * */

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerForScreenShot_16_3 extends WebDriverSetupForTestClass_16_2 implements ITestListener{

	@Override
	public void onTestFailure(ITestResult result) {

		try {
			
			//test method name
			//captureScreenshot(result.getMethod().getMethodName());
			
			//xml test name
			String xmlTestCaseName=result.getTestContext().getName();
			captureScreenshot(xmlTestCaseName+"_"+result.getMethod().getMethodName());
			System.out.println(xmlTestCaseName+"_"+result.getMethod().getMethodName());

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
