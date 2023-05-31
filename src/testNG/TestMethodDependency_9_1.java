package testNG;

/*AA.Test Dependency==>
 * 1.Test Dependency in TestNG is one of the useful feature in TestNG framework. 
 * 2.It allows a test method to depend on some other method or methods. 
 * 3.Test Dependency allows us to make one test method dependent on one or 
 *   multiple other test methods.
 *
 *BB.Need Of Test Dependency
 *1.For Example, one or multiple test methods depend on single test method.
 *2.And if that test method failed then there is no need to execution of dependent test methods.
 *  so we need to avoid or skip the those dependent test methods hence we need dependency  
 *3.like that,we can save the time consumption and achieve memory optimization 
 *
 *CC.What happens when priority is set to the test methods?
 *Answer>its simply ignored or will not be considered.Only Test dependency considered
 *
 *DD.What happen when main method(dependency method) failed?
 *==>All dependent methods are skipped from their execution.
 *
 *FF=> alwaysRun = true (default value is false)
 *   1.it is test annotations's parameter 
 *   2.assign to such method which we want to always run 
 *     even it depends on test method that failed.
 *      
 *EE.Main test Method(Dependency method)
 *==>1.If we ignored/skipped/deleted the main dependency method then
 *     there is not any test methods executed which depends on it.
 *   2.ignoreMissingDependencies = true (default value is false)
 *       if main test method is missing or ignored or skipped, 
 *       And we want to execute dependent test methods then use this as @Test's parameter
 *           
 */

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestMethodDependency_9_1 {

	static String trackingNumber=null; 
	
	@Ignore
	@Test(priority=2)
	public void createShipment() {
		
       // System.out.println(5/0);
		System.out.println("Shipment Created.. ");
		trackingNumber="ABC12HY";
	}

	//@Test(priority=1,dependsOnMethods = {"createShipment"},alwaysRun = true)
	@Test(priority=1,dependsOnMethods = {"createShipment"},ignoreMissingDependencies = true) //single dimensional String[] array
	public void trackShipment() throws Exception {

		if(trackingNumber !=null)
			System.out.println("Track a Shipment.. ");
		else
			throw new Exception("invalid tracking Number...");

	}
	@Test(priority=3,dependsOnMethods = {"createShipment","trackShipment"},ignoreMissingDependencies = true)
	public void cancelShipment() throws Exception {
	
	if(trackingNumber !=null)
		System.out.println("Cancel Shipment.. ");
	else
		throw new Exception("invalid tracking Number...");
	}
	
	
}
