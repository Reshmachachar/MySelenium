package testNG;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/* //class level required this declaration above class definition
@Listeners({ListenerDemo_15.class})  //class level listener...we can the value in the form  of Class[]
public class ListenerFor_TestClass_15_2 {*/

/*At Suite Level, you do not need to declare Listeners annotation above the class definition*/
public class ListenerFor_TestClass_15_2 {
	@Test
	public void testMethod1() {
		System.out.println("I am inside testmethod1");
	}

	@Test
	public void testMethod2() {
		System.out.println("I am inside testMethod2");
		Assert.assertTrue(false);

	}

	@Test(timeOut = 1000)
	public void testMethod3() throws Exception {
		System.out.println("I am inside testMethod3");
		Thread.sleep(2000);
	}

	@Test(dependsOnMethods = "testMethod3")
	public void testMethod4() {
		System.out.println("I am inside testMethod4");
	}
}
