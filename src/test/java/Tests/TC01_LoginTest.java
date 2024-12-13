package Tests;

import Listeners.IInvokedMethodListenerClass;
import Listeners.ITestResultListenerClass;
import Pages.P01_LoginPage;
import Utilites.DataUtils;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static DriverFactory.DriverFactory.getDriver;

@Listeners({IInvokedMethodListenerClass.class, ITestResultListenerClass.class})
public class TC01_LoginTest extends TestBasic {
    private final String USERNAME = DataUtils.getJsonData("validLogin", "username");
    private final String PASSWORD = DataUtils.getJsonData("validLogin", "password");

    @Test
    public void validLoginTC() {
        new P01_LoginPage(getDriver()).Login(USERNAME, PASSWORD);
        Assert.assertEquals("https://www.saucedemo.com/inventory.html", getDriver().getCurrentUrl());
    }
}
