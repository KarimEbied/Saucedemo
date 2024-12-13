package Tests;

import Pages.P01_LoginPage;
import Pages.P02_LandingPage;
import Pages.P03_CartPage;
import Utilites.DataUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static DriverFactory.DriverFactory.getDriver;

public class TC03_Checkout extends TestBasic {
    private final String USERNAME = DataUtils.getJsonData("validLogin", "username");
    private final String PASSWORD = DataUtils.getJsonData("validLogin", "password");
    private final String Fname = DataUtils.getJsonData("validLogin", "Fname");
    private final String Lname = DataUtils.getJsonData("validLogin", "Lname");
    private final String Zip = DataUtils.getJsonData("validLogin", "Zip");

    @Test
    public void checkProductsTC() {
        new P01_LoginPage(getDriver()).Login(USERNAME, PASSWORD);
        new P02_LandingPage(getDriver()).addAllProducts();
        Assert.assertEquals("6", getDriver().findElement(By.xpath("//span[@data-test='shopping-cart-badge']")).getText());
        new P03_CartPage(getDriver()).Checkout(Fname, Lname, Zip);
        new P03_CartPage(getDriver()).checkTotalCost();
        Assert.assertEquals(new P03_CartPage(getDriver()).checkTotalCost(), new P03_CartPage(getDriver()).checkPrice());
        new P03_CartPage(getDriver()).finish();
        Assert.assertEquals("Checkout: Complete!", new P03_CartPage(getDriver()).checkoutComplete());

    }
}
