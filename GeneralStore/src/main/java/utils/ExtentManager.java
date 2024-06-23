package utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class ExtentManager {
	public static ExtentReports extent;
	public static ExtentSparkReporter htmlReporter;
	
	/**
     * Method to create an instance of ExtentReports.
     * @return An ExtentReports object.
     * @throws IOException If an I/O error occurs.
     */
	public static ExtentReports createInstance() throws IOException {
		
		String repname="Founation Assessment TestReport-"+ getTimeStamp()+".html";
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"//Reports//"+repname);
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"\\src\\test\\resources\\extent-config.xml");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("Host Name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User Name", "Ebin");
		return extent;
	}
	
	/**
     * Method to get the current timestamp.
     * @return A string representing the current timestamp.
     */
	public static String getTimeStamp() {
		return new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	}
}