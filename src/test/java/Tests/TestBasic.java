package Tests;

import Utilites.DataUtils;
import Utilites.LogsUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.time.Duration;

import static DriverFactory.DriverFactory.*;

public class TestBasic {


    @BeforeMethod
    public void setup() throws IOException {
        setupDriver(DataUtils.getPropertyValue("environment", "browser"));
        LogsUtils.info("Edge driver is opened");
        getDriver().navigate().to("https://www.saucedemo.com/");
        LogsUtils.info("Page is redirected to the url");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod
    public void quit() {
        quitDriver();
    }

}
