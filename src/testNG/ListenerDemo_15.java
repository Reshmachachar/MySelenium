package testNG;

/*1.Listener:
 *    1.It is interface which listened the event that are performed by testNG
 *2.Why do we need listener?
 *    1.If you want to perform any action during execution then we need listener.
 *    2.If you want alter the default behavior of testNG when event occurs or exception occurs.   
 *3.List of the most important listener.
 *    1.IAnnotationTransform  - work with annotation(modify attributes of annotation)
 *    2.IAnnotationTransform2 - work with DataProvider annotation
 *    3.IHookable             - if you want to hook anything during execution
 *    4.IInvokedMethodListener- if you want to method related information
 *    5.IMethodInterceptor    - whenever method being invoked,you want to intercept and performed some action. 
 *    6.IReporter             - At the end of testing,you are going to generate report;during this phase if you want to perform certain action or modification.
 *    7.ISuiteListnere        - if you want to perform any action at suite level like @BeforSuite and @AfterSuite   
 *    8.ITestListnere         - if you want to perform any action at test level like @Test,@BeforeTest,@AfterTest
 * 
 * 4.1.Before java_8 version,the interface does not provide the implementation of method
 *     so the class who implements that interface,his responsibility to provide implementation of method.
 *   2.But onwards Java_8 version,provides feature that interface can provide the
 *     implementation of method by using one of the keywords like private,static,default.
 *   3.1.If method is unimplemented in the interface then the class provides its implementation compulsory who implements that interface.
 *     2.if method is implemented in the interface then there is not compulsion to provide implementation into the class who implemented that interface.  
 *                         
 * 5.1.Before testNG_7 version, the java version_8 features are not provided into the TestNG.
 *   2.But onwards testNG_7 version,the java version_8 features are provided into the TestNG.
 *     hence the all listeners interface provides the implementation of all their methods.
 *     so there is not compulsory to provide implementation of every method of interface in the class who implement that Listener interface.
 *   3.To provide your own implementation and logic ,you can use the methods of interface which you actually wanted.  
 * 
 * 6.onTestFailure->we can use this ITestListener method,
 *                  to capture screenshot on test failure.
 * 
 * 7.Two Level of Listener :
 *    1.Class Level- for particular class, but IAnnotationTransform, this can not use class level                         
 *    2.Suite level- using xml file
 *  
 * 8.Difference between Annotation and Listeners:
 *    1.1 Annotation will be executed based on Test level or class level or suite level
 *    1.2 Listeners will be executed based on event.
 *    2.1 Annotation do not care about the status of test method,it will just execute the postcondition annotation.
 *    2.2 Listeners are listens the events and based on it, take care of the status of test methods.
 *    3.1 Using annotation we can do only limited things like preconditions @Test and postconditions annotations
 *    3.4 With Listeners, we have lot of varieties.
 *    
 * 9.1.In the TestNG there is no need to always implements the particular Listener interface.
 *   2.TestNG provides the by default class TestListenerAdapter which implements all the listeners.
 *   3.By extending that class,you just provide your logic by overriding method.   
 *     
 *     
 */


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Test;


//public class ListenerDemo_15 implements ITestListener {
	
public class ListenerDemo_15 extends TestListenerAdapter {
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped");
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("onTestFailedWithTimeout");
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("onStart");
	
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("onFinish");
	
	}
	
  
}
