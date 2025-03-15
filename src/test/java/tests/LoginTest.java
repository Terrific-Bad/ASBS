package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void testValidLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUserName("admin@yourstore.com");
        loginPage.enterPass("admin");
        loginPage.clickLogin();
        System.out.println("Title : " + driver.getTitle());
    }

}
