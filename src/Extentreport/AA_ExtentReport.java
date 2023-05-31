package Extentreport;

/***Extent Report integration with TestNg by the Two Ways:
 * 1.Annotation Level
 * 2.Listener Level
 * 
 *What is extent report?
   1. ExtentReports is an open-source reporting library useful for test automation. 
      1.1 Its third party library designed for produce reports for automated tests.
      1.2 It is available for only java and .Net language.
   2.It can be easily integrated with major testing frameworks like JUnit, NUnit, TestNG, etc. 
   3.These reports are HTML documents that depict results as pie charts.
      
 * What is spark extent report?
 *  1.ExtentSparkReporter is a rich-HTML reporter available from the standard ExtentReports library. 
 *  2.This section outlines a few unique features present. 
 *  3.ExtentReports extent = new ExtentReports(); 
 *  4.ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
 *  
 *Log Levels in Extent Reports:(Order followed by Test status)
 *  1.Fail
 *  2.Skip
 *  3.Warning
 *  4.Pass
 *  5.Info
 *  
 *   -unnecessarily don't use it,because in the the report,the test status will be followed by this order(test-> fails,skip,warning,pass,info)
 *  -from the version_5 of extent report, the other logs like Debug,Error,fatal are removed.
 *  -Also removed from testng and junit
 *  
 *Log Different Type of information to the extent reports:
 *  1.Text--e.g Bold Italic
 *  2.XML
 *  3.JSON
 *  4.Collection Data (List,Set,Map)
 *  5.Highlighting any messages
 *  6.Exception.
 *    
 * Different attributes available for the Test in the Extent Report:
 *  1.Author - who wrote the test script
 *  2.Device - Browser details (In cross browsing scenario)
 *  3.Category-> Used for maintain track of groups(it is part of which testing type.) 
 *      
 * Types of Reporter :
 *     1.ExtentSparkReporter - community(Open source)
 *     2.ExtentKlovReporter  - community(Open source)
 *     3.ExtentAventReporter - Professional
 *     4.ExtentEmailReporter - Professional
 *      
 */

import org.testng.annotations.Test;

public class AA_ExtentReport {
  @Test
  public void f() {
  }
}
