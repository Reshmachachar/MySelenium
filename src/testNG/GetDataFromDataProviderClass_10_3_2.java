package testNG;



import org.testng.annotations.Test;

public class GetDataFromDataProviderClass_10_3_2 {

	
	@Test(dataProvider="testMethodData1",dataProviderClass = DataSuplier_10_3_1.class) 
	   public void test1(String username)
     {
		
		System.out.println(username);
   }
	
	@Test(dataProvider="testMethodData2",dataProviderClass = DataSuplier_10_3_1.class) 
	   public void test2(Object[] value)
       {
		
		System.out.println(value[0]+" "+value[1]);
        }
	

}
