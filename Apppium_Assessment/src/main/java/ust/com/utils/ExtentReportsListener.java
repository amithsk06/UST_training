package ust.com.utils;

import java.io.File;
import java.io.IOException;

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
import com.aventstack.extentreports.markuputils.MarkupHelper;
public class ExtentReportsListener implements ITestListener {
	static WebDriver driver;
	public ExtentReports extent;
	public ExtentTest test;
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
				testName+"//"+testName+"_passed.png";
	}
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test case Failed");
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(),
				ExtentColor.RED));
		String folderName=result.getInstanceName();
		String testName=result.getName();
		String filepath=System.getProperty("user.dir")+"//TestOutput//Screenshots"+folderName+"//"+
				testName+"//"+testName+"_failed.png";
	}
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Test case SKIPPED");
		test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(),
				ExtentColor.AMBER));
	}
	public void onFinish(ITestContext context) {
		extent.flush();
	}
	public static void takeScreenshot(String filepath) {
		
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		File srcFile = takeScreenShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(filepath);
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}