package testNG;

/*Grouping-->
 * A.Grouping is nothing but categorization of multiple test case into multiple groups
 *   Need=>If you want to execute your test as part of categorization then you need grouping 
 * B.For Example,You have 100 test methods then those methods categorized into 
 * 1.Smoke testing - 10(identify among the 100 test cases)
 *    1.1 Put High level scenario,it will not include more than 20 test cases probably
 *    1.2 Smoke Testing ensure your build is proper(High level test cases)   
 * 2.functional Testing -90(identify among the 100 test cases)
 * 3.Regression Testing -95(identify among the 100 test cases)
 * 4.DailyBuild         -40 
 * 5.WeeklyBuild        -100
 * 6.windows/ios--os based  categorized.-50 
 * 
 * C.two Ways to maintain categorization :
 *   1.By xml file (smoketest.xml,functionaltest.xml,...)
 *   2.Grouping of test cases(SmokeGroup,FunctionalGroup,...)
 * 
 * D.Four Types of Group=>
 *   1.Test group       e.g <include name="sanity"/>
 *   2.exclusion groups e.g <exclude name="regression">
 *   3.meta groups      e.g <define name="DailyBuild">
 *                            <include name="sanity"/>
 *                            <include name="functional"/>
 *                        </define>
 *      in the above, meta group is group of group -->DailyBiuild(sanity,functional)
 *      DailyBuild is meta-group and sanity,functional are groups.
 * 4.Partial Group is class level group in which all the test methods are executed
 * 
 *E.Defining/specifying Grouping
 *  1.Test level
 *  2.Suite level                          
 */

import org.testng.annotations.Test;

@Test(groups={"all"})
public class GroupingTest1 {
	                        //groups is the parameter of @Test annotation
	@Test(groups={"smoke","sanity","windows.smoke"})   // And its always Single dimensional array of String Type(String[]) 
	  public void test1() {
		  System.out.println("Test1");
	  }
	
	  @Test(groups={"regression","sanity","windows.sanity","ios.sanity"})
	  public void test2() {
		  System.out.println("Test2");
	  }
	  @Test
	  public void test3() {
		  System.out.println("Test3");
	  }
}
