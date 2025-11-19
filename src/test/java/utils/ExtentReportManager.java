package utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base.BaseTest;

public class ExtentReportManager implements ITestListener {
	
	
	public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;
    String repName;

    // 🔹 Start of Suite
    public void onStart(ITestContext testContext) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        repName = "OrangeHRM-TestReport-" + timeStamp + ".html";

        sparkReporter = new ExtentSparkReporter("./reports/" + repName);

        sparkReporter.config().setDocumentTitle("OrangeHRM Automation Report");
        sparkReporter.config().setReportName("OrangeHRM Functional Testing");
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // System Information
        extent.setSystemInfo("Application", "OrangeHRM");
        extent.setSystemInfo("Module", "Login");
        extent.setSystemInfo("Tester", System.getProperty("user.name"));
        extent.setSystemInfo("Environment", "QA");

        // Parameters from testng.xml
        String os = testContext.getCurrentXmlTest().getParameter("os");
        if (os != null) extent.setSystemInfo("Operating System", os);

        String browser = testContext.getCurrentXmlTest().getParameter("browser");
        if (browser != null) extent.setSystemInfo("Browser", browser);

        List<String> includeGroups = testContext.getCurrentXmlTest().getIncludedGroups();
        if (!includeGroups.isEmpty()) {
            extent.setSystemInfo("Groups", includeGroups.toString());
        }
    }

    // 🔹 Before each test
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getName()); // Test Method name
        test.assignCategory(result.getMethod().getGroups());
    }

    // 🔹 Test Passed
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, result.getName() + " executed successfully.");
    }

    // 🔹 Test Failed
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, result.getName() + " FAILED.");
        test.log(Status.INFO, result.getThrowable().getMessage());

        try {
            BaseTest base = (BaseTest) result.getInstance(); // get driver from BaseTest
            String impPath = base.captureScreen(result.getName());
            test.addScreenCaptureFromPath(impPath);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    // 🔹 Test Skipped
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, result.getName() + " SKIPPED.");
        if (result.getThrowable() != null) {
            test.log(Status.INFO, result.getThrowable().getMessage());
        }
    }

    // 🔹 End of Suite
    public void onFinish(ITestContext testContext) {
        extent.flush();
        System.out.println("Extent Report generated: ./reports/" + repName);
    }
}
