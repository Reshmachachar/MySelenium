package testNG;

import org.testng.annotations.DataProvider;

/*Scenario->
 * 1.With help of DataProvider we can pass all the data to test method
 *   but,if we do not want to send all data to test method and want to send 
 *   only sets or part of all entire data.then we use indices.
 * 
 * 2.What is indices?
 *    1.Whatever data we want to pass,those data's indexes called indices.
 * 3.Why do we use indices?
 *    1.To pass the partial data of DataProvider to the test method
 *    2.Out of 100 test cases,if 2 are failed then to only monitor them closing
 *     and debug them, we need of indices.
 * 4.How to use indices?
 *    1.indices is single dimensional array of integer data type and
 *    2.it is parameter inside @DataProviedr annotation
 *    3.in the indices array,mention the  index numbers of data
 *      which you want pass to the test method          
 *    4.If you don't mention the indexes of data then
 *      default value of indexes is all.   
 */

import org.testng.annotations.Test;

public class PartiallyDataProvider_Indices_10_4 {

	@Test(dataProvider = "D1")
	public void Test1(String name )
	{
		System.out.println("My diff Nmaes :"+name);
	}
	
	@DataProvider(name="D1",indices = {1,3})
	@Test
	public String[] TestMethodData()
	{
		return new String[] { "Ani","Aniket","Anu","Anya"  };
	}
	
}
