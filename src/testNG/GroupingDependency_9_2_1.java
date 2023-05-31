package testNG;

/*GroupingDependency=>PackageScope
 * 1.test0 is test method which depend on smoke1 group which contain test1 and test2 test methods
 * 2.So when we will run the program,the testNG control goes to test0 method 
 *   and checks the test0 method has dependency if it has then 
 *   testNG executes all the test method of that dependency group first then
 *   executes the dependent group.
 * 3.If one of the test method of group is failed then 
 *   1.All other remaining test methods of group executed successfully,
 *   2.the dependent test0 method will be skipped.
 * 4.with help of alwaysRun=true parameter of @Test annotation,
 *   we can always run the dependent method even the one of the test method of group
 *   is failed.  
 *       
 * 5.with help of .java file we can achieve dependencies like
 *   1.Test methods-test methods
 *   2.Test methods-test groups
 *  but 
 *    3.test groups-test groups this will be achieve by only xml file 
 * 
 */

import org.testng.annotations.Test;

public class GroupingDependency_9_2_1 {
	
  @Test(groups="smoke1")
  public void test1() {
	  System.out.println("smoke1");
  }
  @Test(groups="smoke1")
  public void test2() {
	  System.out.println(5/0);
	  System.out.println("smoke1");
  }
  @Test(groups="smoke1")
  public void test3() {
	  System.out.println("smoke1");
  }
  
  @Test(groups="sanity1")
  public void test4() {
	  System.out.println("sanity1");
  }
  @Test(groups="sanity1")
  public void test5() {
	  System.out.println("sanity1");
  }
  
  @Test(groups="regression1")
  public void test6() {
	 // System.out.println(5/0);
	  System.out.println("regression1");
  }
  @Test(groups="regression1")
  public void test7() {
	  System.out.println("regression1");
  }
  
  /*//executing GroupingDependency_9_2_1.xml file
  @Test(dependsOnGroups ={"smoke1","sanity1","regression1"},alwaysRun = true)
  public void test0() {
	  System.out.println("DependentMethod");
  }
  */
  
}
