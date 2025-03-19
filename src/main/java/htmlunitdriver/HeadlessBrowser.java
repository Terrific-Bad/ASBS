package htmlunitdriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.lang.reflect.Field;


public class HeadlessBrowser {
    public static void main(String[] args) throws Exception {
        HtmlUnitDriver driver = new HtmlUnitDriver(BrowserVersion.CHROME);

        driver.get("https://mvnrepository.com/");
        System.out.println(driver.getTitle());
        driver.quit();
    }


}
