package utils.Listners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;
import java.util.Date;

public class ExtentListeners implements ITestListener {

    static Date d = new Date();
    static String fileName = "Extent_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";

    //private static ExtentReports extent = ExtentManager.createInstance(System.getProperty("user.dir")+"\\reports\\"+fileName);
    private static ExtentReports extent = ExtentManager.createInstance(fileName);

    public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest test = extent.createTest(result.getTestClass().getName())
                .info("**** @Test Description: "+result.getMethod().getDescription()+" ****")
                .assignCategory(result.getMethod().getGroups())
                .assignAuthor(result.getMethod().getAttributes()[0].name());
        testReport.set(test);

    }

    @Override
    public void onTestSuccess(ITestResult result) {

        String methodName=result.getMethod().getMethodName();
        String logText="<b>"+"TEST CASE:- "+ methodName.toUpperCase()+ " PASSED"+"</b>";
        Markup m= MarkupHelper.createLabel(logText, ExtentColor.GREEN);
        testReport.get().pass(m);

    }

    @Override
    public void onTestFailure(ITestResult result) {

        testReport.get().fail(result.getThrowable().getMessage());

        String excepionMessage= Arrays.toString(result.getThrowable().getStackTrace());

        testReport.get().fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured:Click to see"
                + "</font>" + "</b >" + "</summary>" +excepionMessage.replaceAll(",", "<br>")+"</details>"+" \n");

        Object obj =  result.getTestContext().getAttribute("driver");
        TakesScreenshot screenShot = (TakesScreenshot) obj;
        String base64Image = screenShot.getScreenshotAs(OutputType.BASE64);

        testReport.get().fail("<b>" + "<font color=" + "red>" +"Screenshot of failure" + "</font>" + "</b>",
                MediaEntityBuilder.createScreenCaptureFromBase64String(base64Image).build());

        String failureLogg="TEST CASE FAILED";
        Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
        testReport.get().log(Status.FAIL, m);

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String methodName=result.getMethod().getMethodName();
        String logText="<b>"+"Test Case:- "+ methodName+ " Skipped"+"</b>";
        Markup m=MarkupHelper.createLabel(logText, ExtentColor.ORANGE);
        testReport.get().skip(m);
    }

    @Override
    public void onFinish(ITestContext context) {

        if (extent != null) {

            extent.flush();
        }

    }
}
