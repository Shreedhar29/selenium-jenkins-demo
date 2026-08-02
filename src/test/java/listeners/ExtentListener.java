package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reports.ExtentManager;

public class ExtentListener implements ITestListener {

    private static final ExtentReports extent =
            ExtentManager.getInstance();

    private static final ThreadLocal<ExtentTest> test =
            new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {

        test.set(extent.createTest(result.getMethod().getMethodName()));
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.get().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.get().fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        test.get().skip("Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();
    }
}
