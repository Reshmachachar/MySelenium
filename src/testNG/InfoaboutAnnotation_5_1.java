package testNG;
/*
 * 1.TestNG Annotation is a piece of code which is inserted inside a program or business logic 
 *   used to control the flow of execution of test methods.
 * 2.annotation is a form of metadata that can be added to the java source code.
 *   -JavaSourceCodeis nothing but (package,class,variables,Methods,Parameters)
 * 3.introduced into 1.5 java version.(@override)  
 * 4.List Of Annotation:
 *   1.@BeforeSuite - 2.AfterSuite
 *   3.@BeforeTest  - 4.AfterTest
 *   5.@BeforeClass - 6.AfterClass
 *   7.@BeforeMethod- 8.@AfterMethod
 *   9.@BeforeGroup -10.@AfterGroup
 *  11.@Test
 *  12.@DataProvider- 13.@Parameters
 *  14.@Fatory      - 15.Listeners
 *  16.@Ignore      - 17.@FindBy
 */

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InfoaboutAnnotation_5_1 {
	
  @FindBy(id="userName") WebElement usernm;
  	
}
