package testNG;

import org.testng.annotations.Test;

public class GroupingTest2 {
	
	@Test(groups={"smoke"})
	  public void test4() {
		  System.out.println("Test4");
	  }
	  @Test(groups={"smoke","functional","sanity","ios.smoke"})
	  public void test5() {
		  System.out.println("Test5");
	  }
	  @Test(groups={"functional","regression","windows.functional","ios.functional"})
	  public void test6() {
		  System.out.println("Test6");
	  }
	  @Test
	  public void test7() {
		  System.out.println("Test7");
	  }
}
