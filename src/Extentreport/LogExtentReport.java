package Extentreport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.map.HashedMap;
import org.python.modules.thread.thread;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ibm.icu.text.IDNA.Info;



public class LogExtentReport {

	public static void main(String[] args) throws IOException, URISyntaxException, Exception
	{
         ExtentSparkReporter eSparkReporter=new ExtentSparkReporter(".//Extent_Reports//report1.html");
         ExtentReports extentReports=new ExtentReports();
         extentReports.attachReporter(eSparkReporter);
         
         
         //1.TextData
         //extentReports.createTest("Test1") returns the ExtentTest Object
         
         extentReports.createTest("Test1")
         .log(Status.INFO,"info1")
         .log(Status.INFO, "<b>info2</b>")
         .log(Status.INFO, "info3")
         .log(Status.INFO, "<i>info4</i>")
         .log(Status.INFO, "<b><i>info5</i></b>");
         
         //2.JSONData
         String jsonData="{\"menu\": {\n"
         		+ "  \"id\": \"file\",\n"
         		+ "  \"value\": \"File\",\n"
         		+ "  \"popup\": {\n"
         		+ "    \"menuitem\": [\n"
         		+ "      {\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},\n"
         		+ "      {\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},\n"
         		+ "      {\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}\n"
         		+ "    ]\n"
         		+ "  }\n"
         		+ "}}";
         
         //use MarkupHelper class bcoz Markup is interface
         extentReports.createTest("Test2_JsonData")
         .log(Status.INFO, MarkupHelper.createCodeBlock(jsonData,CodeLanguage.JSON));
         
         //3.XmlData
         
         String xmlData="<menu id=\"file\" value=\"File\">\n"
         		+ "  <popup>\n"
         		+ "    <menuitem value=\"New\" onclick=\"CreateNewDoc()\" />\n"
         		+ "    <menuitem value=\"Open\" onclick=\"OpenDoc()\" />\n"
         		+ "    <menuitem value=\"Close\" onclick=\"CloseDoc()\" />\n"
         		+ "  </popup>\n"
         		+ "</menu>";
   
         ExtentTest extentTestobj=extentReports.createTest("Test3_xmlData");
         extentTestobj.info(MarkupHelper.createCodeBlock(xmlData, CodeLanguage.XML));
         
         //4.Collection_Data
         
         //4.1 ListData
         List<String> listdata=new ArrayList<>();
         listdata.add("Aniket");
         listdata.add("Anu");
         listdata.add("Anya");
         
         extentReports.createTest("Test4_ListData")
         .info(MarkupHelper.createOrderedList(listdata))
         .info(MarkupHelper.createUnorderedList(listdata));
        
         //4.2 Map Data
         Map<Integer, String > mapData=new HashMap<>();
         mapData.put(101, "Aniket");
         mapData.put(102, "Anu");
         mapData.put(103, "Anya");
         
         extentReports.createTest("Test5_MapData")
         .info(MarkupHelper.createOrderedList(mapData))
         .info(MarkupHelper.createUnorderedList(mapData));
         
         //4.3 SetData
         Set<Integer> setData=mapData.keySet();
         
         extentReports.createTest("Test6_setData")
         .info(MarkupHelper.createOrderedList(setData))
         .info(MarkupHelper.createUnorderedList(setData));
         
         
         //5 Highlight the message [MarkupHelper.createLabel()]
         extentReports.createTest("Test7_Highlight Message")
         .info("This Is Not Highlighted..")
         .info(MarkupHelper.createLabel("This the Highlighted Message", ExtentColor.GREEN));
         
         
         //6.Exception -->How to log the exception info in your report
          
         try {
        	 int i=2/0;
         }catch (Exception e) {
			extentReports.createTest("Exception_Test_6.1")
			//.info(e);
			.fail(e);
			
		}
         
         //6.2 Custom Exception
         
         Throwable throwable=new RuntimeException("This Is Custom Exception");
         extentReports.createTest("CustomeException_Test_6.2")
         //.info(throwable)
         //.info(MarkupHelper.createLabel(throwable.toString(), ExtentColor.RED));
         .fail(throwable)
         .fail(MarkupHelper.createLabel(throwable.toString(), ExtentColor.RED));
         
         
         
         extentReports.flush();//after flushing,the report will be generate.
   
         //by default the current directory path is attached
         //like,  G:/Ecplise_workspace/MySelenium/-->G:/Ecplise_workspace/MySelenium/Extent_Reports//report1.html
          Desktop.getDesktop().browse(new File("Extent_Reports//report1.html").toURI());
         System.out.println("Done!!");
		
		
	}
}
