package com.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class FileIO 
{
	private static Properties properties;
	
	public static Properties getProperties()
	{
		if(properties==null)
		{
			properties = new Properties();
			try 
			{
				//accessing the configuration.properties
				FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\objectrepository\\configuration.properties");
				properties.load(fis);
			} catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		return properties;

}
}
