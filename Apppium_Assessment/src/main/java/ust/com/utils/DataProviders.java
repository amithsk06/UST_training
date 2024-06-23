package ust.com.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;

import ust.com.base.ReusableFunctions;

public class DataProviders {

	@DataProvider(name = "Jsondata")
	public Object[] getData() throws IOException {
		List<HashMap<String, String>> list = ReusableFunctions
				.getJsonData(System.getProperty("user.dir") + "\\src\\test\\resources\\data\\details.json");
		System.out.println(list);
		return list.toArray();
	}
}
