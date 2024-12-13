package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P01_LoginPage {
    @FindBy(id = "user-name")
    WebElement username;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(id = "login-button")
    WebElement loginbtn;

    public P01_LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public void Login(String user, String pass) {
        username.sendKeys(user);
        password.sendKeys(pass);
        loginbtn.click();
    }
}
