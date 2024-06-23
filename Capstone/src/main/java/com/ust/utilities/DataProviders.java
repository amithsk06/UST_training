package com.ust.utilities;

import org.testng.annotations.DataProvider;

import com.ust.utilities.ExcelData;

public class DataProviders {


    
    @DataProvider(name = "Data")
	public String[][] getData() throws Exception{ // ---access excel data
		String[][] data = ExcelData.getExcelData(System.getProperty("user.dir") + "/data/data.xlsx",
				"Sheet1");
		return data;
}
 


	


































@DataProvider(name="product")
public Object getProducts() {
    
//	Object[] products= {"hair serum","skin care"};
//	
    return "hair serum";
}
}
