package com.ust.utilities;

import org.testng.annotations.DataProvider;

import ust.base.Fetchingexceldata;



public class Dataproviders {


	    
	    @DataProvider(name = "Data")
		public String[][] getData() throws Exception{ // ---access excel data
			String[][] data = Fetchingexceldata.excelHandling(System.getProperty("user.dir") + "/data/data.xlsx",
					"Sheet1");
			return data;
	}

}
