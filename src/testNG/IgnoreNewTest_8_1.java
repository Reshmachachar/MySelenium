package testNG;
/*
 * Ignore Test Methods in 3 ways->
 * 1.specific test method
 * 2.Class level ignorance(all the test methods of that class)
 * 3.Package level ignorance(all the test methods of all the classes of that package)
 * 
 * 1.@Ignore and enabled="true", in this @Ignore has highest priority.
 *   but both are same enabled="true" used at <test> in xml file and inside @test annotation as
 *   parameter like @Test(enabled=true) ..no double quotation
 * 2.But it is only for test methods level. if we want to ignore all the methods of class and 
 *   package then we go with @Ignore  
 *      
 *   
 * 
 */

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class IgnoreNewTest_8_1 {
	
  @Ignore      //Specific test method level @Ignore 
  @Test(enabled=true)
  public void test1() {
	  System.out.println("Test1");
  }
  @Test
  public void test2() {
	  System.out.println("Test2");
  }
  @Test
  public void test3() {
	  System.out.println("Test3");
  }
}
