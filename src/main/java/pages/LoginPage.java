package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private By usernameTextBox = By.id("Email");
    private By passTextBox = By.id("Password");
    private By loginButton = By.xpath("//*[@id='main']/div/div/div/div[2]/div[1]/div/form/div[3]/button");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterUserName(String username){
        driver.findElement(usernameTextBox).clear();
        driver.findElement(usernameTextBox).sendKeys(username);
    }

    public void enterPass(String pass){
        driver.findElement(passTextBox).clear();
        driver.findElement(passTextBox).sendKeys(pass);
    }

    public void clickLogin(){
        driver.findElement(loginButton).click();
    }

}
