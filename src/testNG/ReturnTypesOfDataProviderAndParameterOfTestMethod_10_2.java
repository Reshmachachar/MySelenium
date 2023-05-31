package testNG;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.testng.annotations.DataProvider;

/*A1.is it mandatory to return object[][] from the DataProvider? -Not mandatory
 *   1.Not mandatory; DataProvider supports the following four return type :=>
 *           1.1 Object[]            (single dimensional object array)
 *           1.2 Object[][]          (Two dimensional object array)
 *           1.3 Iterator<Object>    (Iterator of object)
 *           1.4 Iterator<Object[]>  (Iterator of single dimensional object array)
 *   2.Object is nothing but any type of data.(predefined + user-defined data type)
 *      2.1 predefined   =>String,Integer,Float,...
 *      2.2 user-defined =>You can create class and use it as data type like,
 *                          Employee[] - single dimensional array of employee
 *      2.3 Object is super class of all the java class(predefined + user-defined data type) 
 *          -All the java class are derived from object super class.
 *    
 *                                                       
 * A3.How do we specify the parameters in method signature of a test method?
 *   -->.Conclusion :1. You can send any type of data but in the form of single and
 *                    two dimensional array of data type or
 *                 2. In the form of iteration of data type or 
 *                 3. In the form of iteration of single dimensional array of data type   
 */


import org.testng.annotations.Test;

public class ReturnTypesOfDataProviderAndParameterOfTestMethod_10_2 {

	/*
	//1..Integer[] --Single dimensional Integer array 
			@Test(dataProvider="testMethodData") 
			   public void test(int number)
		        {
				
				System.out.println(number);
		   }
			@DataProvider
			@Test
			public Integer[] testMethodData()
			{
				
			 return new Integer[] {777,333};
					
			}
		*/	

	/*
	//2..String[] --Single dimensional string array 
		@Test(dataProvider="testMethodData") 
		   public void test(String username)
	        {
			
			System.out.println(username);
	   }
		@DataProvider
		@Test
		public String[] testMethodData()
		{
			
		 return new String[] {"Aniket","333"};
				
		}*/
		
		/*	
			//3..Object[] --For heterogeneous data 
			@Test(dataProvider="testMethodData") 
			   public void test(Object value)
		        {
				
				System.out.println(value);
		   }
			@DataProvider
			@Test
			public Object[] testMethodData()
			{
				
			 return new Object[] {777,"Aniket"};
					
			}		
		*/	

	/* 
	  //4..String[][] --Two dimensional string array 
	@Test(dataProvider="testMethodData") 
	  // public void test(String[] s)
	   public void test(String username,String password)
        {
		
		System.out.println(username+"  "+password);
   }
	@DataProvider
	@Test
	public String[][] testMethodData()
	{
		
	 return new String[][] {
		                      {"Aniket","333"},
		                      {"Anil","222"},
		                      {"Ankita","444"},
		                      {"MM","555"},
	                       };
			
	}
	*/
	
	/*//5..String[][] --columns of row are not fixed then
	@Test(dataProvider="testMethodData") 
	   public void test(String[] s)
        {
		for(int i=0;i<s.length;i++)
		{
			System.out.print(s[i]+"--");
		}
		System.out.println();
   }
	

	
	//if there are different columns in each rows then for this scenario, use single array as parameter in test methods
	@DataProvider
	@Test
	public String[][] testMethodData()
	{
		
	 return new String[][] {
		                      {"Aniket","333","asdd"},
		                      {"Anil","222"},
		                      {"Ankita","444","cccc","6666"},
		                      {"MM","555"},
	                       };
			
	}*/
	
 /*	
	//6..Iterator -- 
	@Test(dataProvider="testMethodData") 
	   public void test(String s)
        {
		
		System.out.println(s);
   }
	@DataProvider
	@Test           //we can not pass collection types..except iterator
	public Iterator<String> testMethodData()
	{
		
	 //List<String> data=new ArrayList<>();
		Set<String> data=new HashSet<>();
	 data.add("Ani");
	 data.add("ss");
	 return  data.iterator();
			
	}
 */
	
/*	
	//7..Iterator of single dimensional Array (homogeneous data)
		@Test(dataProvider="testMethodData") 
		   public void test(String[] s)
	        {
			
			System.out.println(s[0]+" << "+s[1]);
	   }
		@DataProvider
		@Test           //we can not pass collection types..except iterator
		public Iterator<String[]> testMethodData()
		{
			
		 //List<String[]> data=new ArrayList<>();
			Set<String[]> data=new HashSet<>();
		 data.add(new String[]{"aniket ","777"});
		 data.add(new String[]{"Vishal","666"});
		 return  data.iterator();
				
		}

  */
	
	
	//8..Iterator of single dimensional Array (heterogeneous data)
			@Test(dataProvider="testMethodData") 
			   public void test(Object[] value)
		        {
				
				System.out.println(value[0]+" << "+value[1]);
		   }
			@DataProvider
			@Test           //we can not pass collection types..except iterator
			public Iterator<Object[]> testMethodData()
			{
				
			 List<Object[]> data=new ArrayList<>();
				//Set<Object[]> data=new HashSet<>();
			 data.add(new Object[]{"aniket ",777});
			 data.add(new Object[]{"Vishal","666"});
			 return  data.iterator();
					
			}



}
