package Pages;

import Utilites.LogsUtils;
import Utilites.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class P02_LandingPage extends BasePage {
    private static List<WebElement> allProducts;

    private final By products = By.xpath("//button[@data-test]");
    @FindBy(className = "shopping_cart_badge")
    WebDriver numberOfProducts;

    public P02_LandingPage(WebDriver driver) {
        super(driver);
    }

    public P02_LandingPage addAllProducts() {
        allProducts = driver.findElements(products);
        LogsUtils.info("number of all products" + allProducts.size());
        for (int i = 1; i <= allProducts.size(); i++) {
            By products = By.xpath("(//button[@data-test])[" + i + "]");
            Utility.ClickingOnElement(driver, products);
        }
        return this;
    }


}
