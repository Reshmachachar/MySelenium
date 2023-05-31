package testNG;
/*
 * Priority
 * 1.what is Priority->
 * Answer->1.@Test(priority=1) priority is parameter inside the Test annotation 
 *         2.Priority it is integer number which given to test methods to decide the flow of execution of test
 *         methods.
 * 2.Need of Priority-.
 * Answer->The test methods inside program executed by ASCII order(alphabetically manner),So we can not
 *         maintain the flow of program even we put methods in sequentially manner(logical order) in the
 *         xml file but it is very tedious task if there is lot of test methods hence we give the
 *         priority at the time of test methods definition.
 * 3.Default value of Priority is Zero(0).
 * 4.We can Pass also negative (-ve) value to the priority then the test methods execute first which has
 *   lowest priority.
 * 5.we can also give same priority to the test methods but only those test methods executed by ASCII order/
 *   alphabetic order                    
 * 
 */


import org.testng.annotations.Test;

public class PriorityDemo_7_1 {
	
	
	@Test(priority=-1) //assign negative number to priority  
    void signUp()
    {
		System.out.println("SignUp");
		
    }
	@Test            //here we don't assign any value to priority hence default value of priority is 0
    void login()
    {
		System.out.println("Login");
		
    }
	
	@Test(priority=3)
	void searchForTheFlight()
	{
	    System.out.println("SearchForTheFlight");	
	}
	@Test(priority=4)
	void bookTheFlight()
	{
	    System.out.println("BookTheFlight");	
	}
	
	@Test(priority=5)  
	void saveTheTicket()
	{
		System.out.println("saveFlightTicket");
	}
	@Test(priority=6)
	void logout()
	{
		System.out.println("Logout");	
	}
}
