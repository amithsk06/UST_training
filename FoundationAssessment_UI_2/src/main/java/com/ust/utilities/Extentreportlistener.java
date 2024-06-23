package com.ust.utilities;

import java.io.IOException;

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

import ust.base.Reusablefunctions;


public class Extentreportlistener  implements ITestListener {

static WebDriver driver;
	
	// ExtentReports and ExtentTest objects
    public ExtentReports extent;
    public ExtentTest test;
    String filepath;
    // ReusableFunctions object
    Reusablefunctions functions = new Reusablefunctions(driver);

    // Method executed at the start of the test suite
    public void onStart(ITestContext context) {
        try {
            extent = Extentmanager.createInstance();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method executed before each test case starts
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getName());
    }

    // Method executed after a test case passes
    public void onTestSuccess(ITestResult result) {
        // Log test case as PASSED
        test.log(Status.PASS, "Test case PASSED");
        test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));

        // Capture screenshot on pass
        captureScreenshot(result, "_passsed.png", Status.PASS);
        test.log(Status.PASS, "Adding screenshot...");
        test.addScreenCaptureFromPath(filepath);
    }

    // Method executed after a test case fails
    public void onTestFailure(ITestResult result) {
        // Log test case as FAILED
        test.log(Status.FAIL, "Test case FAILED");
        test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));

        // Capture screenshot on fail
        captureScreenshot(result, "_failed.png", Status.FAIL);
        test.log(Status.FAIL, "Adding screenshot...");
        test.addScreenCaptureFromPath(filepath);
    }

    // Method executed after a test case is skipped
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, "Test case SKIPPED");
        test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.AMBER));
    }

    // Method executed after the entire test suite finishes
    public void onFinish(ITestContext context) {
        extent.flush();
    }

    // Method to capture screenshot and add to the report
    private void captureScreenshot(ITestResult result, String filenameSuffix, Status status) {
        String[] folderName = result.getInstanceName().split("\\.");
        String className = folderName[folderName.length - 1];
        String testName = result.getName();
        filepath = System.getProperty("user.dir") + "//ScreenShots/TestNG/" + className + "/" + testName + "//" + testName + filenameSuffix;
        try {
            functions.takeScreenShot(filepath);
            test.log(status, (Markup) test.addScreenCaptureFromPath(filepath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
