package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class FileIO {

	private static Properties properties;

	public static Properties getProperties() {
		properties = new Properties();
		try {
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir")+"//src//test//resources//config.properties");
			properties.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return properties;
	}
}
