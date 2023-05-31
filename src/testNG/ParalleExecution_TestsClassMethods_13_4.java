package testNG;

/*Parallel execution is nothing but executing test cases side by side like multitasking.
 * 
 * Why We need of Parallel Execution?
 * Scenario:
 * 1.In big project,there are lot of test classes,its not good approach to go with
 *   by default sequential execution of testNG.
 * 2.Todays, "Time" is most important thing,so to save a time or 
 *   avoid time consumption, we use parallel execution approach.
 * 3.e.g there are 3 test cases and each test case taking 2 seconds to execute
 *   that means total 6 seconds required to whole execution but,
 *   if you use parallel approach then within 2sec,all test cases will be executed.
 * 4.Thread.currentThread().getId()-->return allocated current thread_id 
 * 4. With help of xml file we can achieve parallel execution.
 * 5. Twister : with xml file
 *    1. parallel="none" thread-count="2"
 *        --Even thread count is 2,but because of "none" parallel,TestNg follows the
 *          by default sequential execution.  
 *    2. parallel="false" thread-count="2"
 *         --sequential execution.    
 *    3. parallel="true" thread-count="1"
 *         --sequential execution.
 *         
 *  6. parallel="tests" thread-count="2" best control of tests at <Suite level>
 *        Now it follows the parallel execution of tests, 
 *        which is assigned value to parallel attribute.
 *        
 *  7. 1.parallel="classes" thread-count="2" best control of classes and methods at <test level>
 *     2.parallel="methods" thread-count="2"  
 *        Now it follows the parallel execution of classes or methods, 
 *        which is assigned value to parallel attribute.            
 *         
 *  8.In parallel execution,if assign two threads for 3 test cases then,
 *    two threads are allocated to two test cases and third one is waiting for   
 *    completion of one of the allocated test cases. 
 *    when thread become free then third test allocate to free thread.   
 * 
 */


import org.testng.annotations.Test;

public class ParalleExecution_TestsClassMethods_13_4 {
	
  @Test
  public void test10() {
	  System.out.println("Class4 " + " << "+"testMethod10"+ " << "+Thread.currentThread().getId());
  }
  
  @Test
  public void test11() {
	  System.out.println("Class4 " + " << "+"testMethod11"+ " << "+Thread.currentThread().getId());
	  
  }
  
  @Test
  public void test12() {
	  System.out.println("Class4 " + " << "+"testMethod12"+ " << "+Thread.currentThread().getId());
  }
  
  @Test
  public void test13() {
	  System.out.println("Class4 " + " << "+"testMethod13"+ " << "+Thread.currentThread().getId());
  }
 
}
