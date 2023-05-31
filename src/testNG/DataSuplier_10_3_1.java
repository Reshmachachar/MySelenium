package testNG;

/*
 * 1. Can we separate the dataProvider from test class,Yes we can.
 * 2.What is DataProviderClass
 *    1.DataProviderClass is parameter of the @Test annotation
 *    2.DataProviderClass in which we maintain only data which we will want to
 *      pass the test class methods
 *    3.the DataProviderClass as parameter at @test annotation tell us actually
 *      where is our data resides.
 * 3.why do we use the C?
 *   1.To specify where our dataProvider is present,we use the DataProviderClass?
 * 4.How to use the DataProviderClass?
 *   1.By using as parameter (dataProviderClass=DataSupplier.class) of @Test annotation
 * 5.we can use multiple dataProvider into DataProvider class
 * 6.we can use multiple DataProvider class into project           
 *      
 */


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.testng.annotations.DataProvider;


import org.testng.annotations.Test;

public class DataSuplier_10_3_1 {

	//2..String[] --Single dimensional string array 

	@DataProvider
	@Test
	public String[] testMethodData1()
	{

		return new String[] {"Aniket","333"};

	}

	@DataProvider
	@Test           //we can not pass collection types..except iterator
	public Iterator<Object[]> testMethodData2()
	{

		//List<Object[]> data=new ArrayList<>();
		Set<Object[]> data=new HashSet<>();
		data.add(new Object[]{"aniket ",777});
		data.add(new Object[]{"Vishal","666"});
		return  data.iterator();

	}



}
