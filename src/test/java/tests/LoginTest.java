package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ExtentReportManager;
import utils.Log;

public class LoginTest extends BaseTest {

    @Test
    public void testValidLogin(){
        Log.info("Starting LoginTest...");
        test = ExtentReportManager.createTest("Login Test");

        test.info("Navigatin to URL");
        LoginPage loginPage = new LoginPage(driver);

        Log.info("Adding credentials...");
        test.info("Adding credentials");
        loginPage.enterUserName("admin@yourstore.com");
        loginPage.enterPass("admin");

        test.info("Clicking on Login Button");
        loginPage.clickLogin();

        test.info("Verifying Page Title");
        System.out.println("Title : " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Just a moment...yyy");
        test.pass("Login Succefull");
    }

    @Test
    public void loginWithInvalidCredentials(){
        Log.info("Starting LoginTest...");
        test = ExtentReportManager.createTest("Login Test with invalid credentials");

        test.info("Navigatin to URL");
        LoginPage loginPage = new LoginPage(driver);

        Assert.assertEquals(driver.getTitle(), "Just a moment...123");

        Log.info("Adding credentials...");
        test.info("Adding credentials");
        loginPage.enterUserName("admin1234@yourstore.com");
        loginPage.enterPass("admin1234");

        test.info("Clicking on Login Button");
        loginPage.clickLogin();

        test.info("Verifying Page Title");
        System.out.println("Title : " + driver.getTitle());
        test.pass("Login Succefull");
    }


}
