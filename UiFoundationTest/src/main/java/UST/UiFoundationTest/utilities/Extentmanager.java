package UST.UiFoundationTest.utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extentmanager {

	 public static ExtentReports extent;
	    public static ExtentSparkReporter htmlReporter;
	    
	    public static ExtentReports createInstance() throws IOException {
	        String repname="Testreport-"+ getTimeStamp()+".html";
	        htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"//TestngReports//"+repname);
	        htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"\\src\\main\\java\\UST\\UiFoundationTest\\utilities\\extent-config.xml");
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        extent.setSystemInfo("OS", "Windows");
	        extent.setSystemInfo("Host Name", "localhost");
	        extent.setSystemInfo("Environment", "QA");
	        extent.setSystemInfo("User", "Amith");
	   
	        return extent;
	    }
	    
	  
	    public static String getTimeStamp() {
	        return new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	    }
}
