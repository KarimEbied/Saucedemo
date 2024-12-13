package Tests;

import Listeners.IInvokedMethodListenerClass;
import Listeners.ITestResultListenerClass;
import Pages.P01_LoginPage;
import Pages.P02_LandingPage;
import Utilites.DataUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static DriverFactory.DriverFactory.getDriver;

@Listeners({IInvokedMethodListenerClass.class, ITestResultListenerClass.class})
public class TC02_CheckProductsAddToCart extends TestBasic {
    private final String USERNAME = DataUtils.getJsonData("validLogin", "username");
    private final String PASSWORD = DataUtils.getJsonData("validLogin", "password");

    @Test
    public void checkProductsTC() {
        new P01_LoginPage(getDriver()).Login(USERNAME, PASSWORD);
        new P02_LandingPage(getDriver()).addAllProducts();
        Assert.assertEquals("6", getDriver().findElement(By.xpath("//span[@data-test='shopping-cart-badge']")).getText());
    }
}
