package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.ExtentReportManager;
import utils.Log;
import utils.PropertiesFileConfig;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class BaseTest {
    public static String driverName;
    protected WebDriver driver;
    protected static ExtentReports extent;
    protected ExtentTest test;
    static String currentDirectory;
    



    @BeforeMethod
    public void setUp(){
        Log.info("Starting the driver...");
        driverName = PropertiesFileConfig.readConfigFile();
        if(driverName == null) {
            System.out.println("Please give browser name in config.property file");
        } else if (driverName.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (driverName.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else if (driverName.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        Log.info("Navigating to URL...");
        driver.get("https://admin-demo.nopcommerce.com/login");
    }

    @AfterMethod
    public void tearDown(ITestResult result){

        if (result.getStatus() == ITestResult.FAILURE) {
            int randomNum = (int)(Math.random() * 100001); // 0 to 100
            String screenShotPath = ExtentReportManager.captureScreenShot(driver,
                    "LoginFailure" + randomNum);
            test.fail("Test failed, check screenshot",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());

        }

        if (driver != null) {
            Log.info("Closing browser...");
            driver.quit();
        }
    }

    @BeforeSuite
    public void setUpReport(){
        extent = ExtentReportManager.getReportInstance();
    }

    @AfterSuite
    public void tearDownReport(){
        extent.flush();
    }

}
