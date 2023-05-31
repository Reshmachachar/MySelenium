package testNG;

import org.testng.annotations.Test;

public class ParalleExecution_TestsClassMethods_13_3 {
	
  @Test
  public void test8() {
	  System.out.println("Class3 " + " << "+"testMethod8"+ " << "+Thread.currentThread().getId());
  }
  
  @Test
  public void test9() {
	  System.out.println("Class3 " + " << "+"testMethod9"+ " << "+Thread.currentThread().getId());
	  
  }
  
}
