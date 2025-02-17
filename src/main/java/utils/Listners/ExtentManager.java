package utils.Listners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

    private static ExtentReports extent;
    protected static ExtentTest test;

    /**
     * Create an instance of Extent Report. To be used in ExtentListeners
     * @param filename - String
     * @return ExtentReports
     */
    public static ExtentReports createInstance(String filename) {

        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("./extentReport/"+filename);

        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle("UI Automation Results");
        htmlReporter.config().setReportName("UI Automation Results");
        htmlReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        extent.setSystemInfo("Automation Tester", "Pallavi");
        extent.setSystemInfo("Org", "Org Name");

        return extent;
    }
}
