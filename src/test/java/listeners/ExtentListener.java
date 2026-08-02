package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reports.ExtentManager;
import utils.ScreenshotUtil;

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
        String screenshot =
                ScreenshotUtil.captureScreenshot(result.getMethod().getMethodName());

        test.get().fail(result.getThrowable());

        if (screenshot != null) {

            try {

                test.get().addScreenCaptureFromPath(screenshot);

            } catch (Exception e) {

                e.printStackTrace();

            }
        }
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
