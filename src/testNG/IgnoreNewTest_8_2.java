package testNG;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

@Ignore  //class level @Ignore
public class IgnoreNewTest_8_2 {
  
	@Test
	  public void test4() {
		  System.out.println("Test4");
	  }
	  @Test
	  public void test5() {
		  System.out.println("Test5");
	  }
	  @Test
	  public void test6() {
		  System.out.println("Test6");
	  }
}
