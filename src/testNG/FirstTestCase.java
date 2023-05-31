package testNG;

import org.testng.annotations.Test;

/*TestNG
 * 1.TestNG does not have main method.
 * 2.suite---->TestCases->TestCase->testCaseSteps(Each TestCaseStep there is method)
 * 3.packages->Classes--->Class---->Methods(Each method there is annotation--like @Test)
 * 
 *Q #6) What are the advantages of TestNG?

        Answer: The advantages of TestNG are as follows:

     1.It is an open-source framework, hence it is easy to configure.
     2.Using TestNG we can systematically create the test cases.
     3.It gives lots of annotations which in turn makes the test case creation easy.
     4.Using TestNG, priorities of the tests and the sequence of execution can be defined.
     5.Grouping is possible using TestNG.
     6.It generates HTML reports (Selenium Webdriver cannot generate the test reports alone, it helps SW to achieve this).
     7.Data parameterization is possible using TestNG.
     8.In addition to all the functionalities of JUnit, TestNG has its functionalities, which in turn makes it more powerful. 
 * 
 */


public class FirstTestCase {

	@Test(priority=1)
	void setup()
	{
		System.out.println("Opeing Browser");
	}

	@Test(priority=2)
	void login()
	{
		System.out.println("LoginTest");
	}

	@Test(priority=3)
	void turnDown()
	{
		System.out.println("Closing Browser");
	}

}
