package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager {

    private static ExtentReports extent;
    private static ExtentTest test;

    public static ExtentReports getReportInstance(){
        if(extent==null){
            String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
            String reportPath = "reports/ExtentReport" + timeStamp + ".html";
            ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
            reporter.config().setDocumentTitle("Automation Test Report");
            reporter.config().setReportName("Test Execution Report");

            extent = new ExtentReports();
            extent.attachReporter(reporter);
        }

        return extent;
    }

    public static ExtentTest createTest(String testName){
        test = getReportInstance().createTest(testName);
        return test;
    }

    public static String captureScreenShot(WebDriver driver, String screenShotName){
        try{
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String path = "reports/screenshots/" + screenShotName + ".png";
            System.out.println("path1" + path);
            String newPath = path.replace("reports/", "");
            System.out.println("path2" + newPath);
            FileUtils.copyFile(src, new File(path));
            return newPath;

        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
