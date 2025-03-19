package phantomjs;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;

public class PhantomJsTest {
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Run in headless mode
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://phantomjs.org/download.html");
        System.out.println(driver.getTitle());
        try {
            // Take a screenshot
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

            // Save the screenshot to the desired location
            FileUtils.copyFile(srcFile, new File("screenshot.png"));
            System.out.println("Screenshot taken: screenshot.png");
        } catch (IOException e) {
            System.err.println("Failed to take screenshot: " + e.getMessage());
        }
        driver.quit();
    }
}
