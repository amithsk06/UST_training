package utilities;

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
    private static WebDriver driver;
    private ExtentReports extent;
    private ExtentTest test;

    public static void setDriver(WebDriver driverInstance) {
        driver = driverInstance;
    }

    @Override
    public void onStart(ITestContext context) {
        try {
            extent = ExtentManager.createInstance();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test case passed");
        test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
        String screenshotPath = takeScreenshot(result.getInstanceName(), result.getName(), "passed",driver);
        test.addScreenCaptureFromPath(screenshotPath);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, "Test case failed");
        test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
        test.log(Status.FAIL, result.getThrowable());
        String screenshotPath = takeScreenshot(result.getInstanceName(), result.getName(), "failed",driver);
        test.addScreenCaptureFromPath(screenshotPath);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, "Test case skipped");
        test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE));
        String screenshotPath = takeScreenshot(result.getInstanceName(), result.getName(), "skipped",driver);
        test.addScreenCaptureFromPath(screenshotPath);
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

    public static String takeScreenshot(String folderName, String testName, String status,WebDriver driver) {
        String dateName = new java.text.SimpleDateFormat("yyyyMMddhhmmss").format(new java.util.Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destinationDir = System.getProperty("user.dir") + "/TestOutput/Screenshots/" + folderName + "/" + testName;
        File destinationDirFile = new File(destinationDir);
        if (!destinationDirFile.exists()) {
            destinationDirFile.mkdirs(); // Create directories if they do not exist
        }
        String destination = destinationDir + "/" + testName + "_" + status + "_" + dateName + ".png";
        File finalDestination = new File(destination);
        try {
            FileUtils.copyFile(source, finalDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }
}
