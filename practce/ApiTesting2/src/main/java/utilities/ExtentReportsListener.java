package utilities;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ExtentReportsListener implements ITestListener {
	public ExtentReports extent;
	public ExtentTest test;
	public void onStart(ITestContext context) {
		try {
			extent=ExtentManager.createInstance();
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
	}
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test case Failed");
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(),
				ExtentColor.RED));
	}
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Test case SKIPPED");
		test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(),
				ExtentColor.AMBER));
	}
	public void onFinish(ITestContext context) {
		extent.flush();
	}
	
}