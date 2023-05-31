package testNG;

import org.testng.annotations.Test;

public class ParalleExecution_TestsClassMethods_13_2 {
	
  @Test
  public void test5() {
	  System.out.println("Class2 " + " << "+"testMethod5"+ " << "+Thread.currentThread().getId());
  }
  
  @Test
  public void test6() {
	  System.out.println("Class2 " + " << "+"testMethod6"+ " << "+Thread.currentThread().getId());
	  
  }
  
  @Test
  public void test7() {
	  System.out.println("Class2 " + " << "+"testMethod7"+ " << "+Thread.currentThread().getId());
  }
  
  
}
