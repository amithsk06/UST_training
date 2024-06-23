package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import base.ReusableFunctions;

public class ExtentReportsListener implements ITestListener {
	
	
	public static WebDriver driver;
	public ExtentReports extent;
	public ExtentTest test;
	String timestamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	ReusableFunctions functions=new ReusableFunctions(driver);

	public void onStart(ITestContext context) {
		try {
			extent=ExtentManager.createInstance();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void onTestStart(ITestResult result) {
		test=extent.createTest(result.getName());
	}
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test case passed");
		test.log(Status.PASS, MarkupHelper.createLabel(result.getName(),
				ExtentColor.GREEN));
		String folderName=result.getInstanceName();
		String testName=result.getName();
		String filepath=System.getProperty("user.dir")+"//TestOutput//Screenshots"+folderName+"//"+
				testName+"//"+testName+timestamp+"_passed.png";
		try {
			test.log(Status.PASS, (Markup) test.addScreenCaptureFromPath(filepath));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test case Failed");
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(),
				ExtentColor.RED));
		String folderName=result.getInstanceName();
		String testName=result.getName();
		String filepath=System.getProperty("user.dir")+"//TestOutput//Screenshots"+folderName+"//"+
				testName+"//"+testName+timestamp+"_failed.png";
		try {
			
	
			test.log(Status.PASS, (Markup) test.addScreenCaptureFromPath(filepath));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Test case Skipped");
		test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(),
				ExtentColor.AMBER));
	}
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}