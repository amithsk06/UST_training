package com.ust.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class FileIO {

private static Properties properties;
	
	public static Properties getProperties(){
		if(properties==null){
			properties = new Properties();
			try {
				FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Configuration.properties");
				properties.load(fis);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return properties;
	}
}
