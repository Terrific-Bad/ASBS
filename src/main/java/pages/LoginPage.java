package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Log;

public class LoginPage {
    private WebDriver driver;

    @FindBy(id = "Email")
    WebElement usernameTextBox;

    @FindBy(id = "Password")
    WebElement passTextBox;

    @FindBy(xpath = "//*[@id='main']/div/div/div/div[2]/div[1]/div/form/div[3]/button")
    WebElement loginButton;

//    private By usernameTextBox = By.id("Email");
//    private By passTextBox = By.id("Password");
//    private By loginButton = By.xpath("//*[@id='main']/div/div/div/div[2]/div[1]/div/form/div[3]/button");

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUserName(String username){
        usernameTextBox.clear();
        usernameTextBox.sendKeys(username);
//        driver.findElement(usernameTextBox).clear();
//        driver.findElement(usernameTextBox).sendKeys(username);
    }

    public void enterPass(String pass){
        passTextBox.clear();
        passTextBox.sendKeys(pass);
//        driver.findElement(passTextBox).clear();
//        driver.findElement(passTextBox).sendKeys(pass);
    }

    public void clickLogin(){
        Log.info("Clicking Login Button...");
        loginButton.click();
//        driver.findElement(loginButton).click();
    }

}
