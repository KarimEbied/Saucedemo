package Pages;

import Utilites.LogsUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class P03_CartPage extends BasePage {
    private static List<WebElement> productsCost;
    @FindBy(className = "shopping_cart_link")
    WebElement cartBtn;
    @FindBy(id = "checkout")
    WebElement checkoutBtn;
    @FindBy(id = "first-name")
    WebElement firstName;
    @FindBy(id = "last-name")
    WebElement lastName;
    @FindBy(id = "postal-code")
    WebElement zipCode;
    @FindBy(id = "continue")
    WebElement continueBtn;
    @FindBy(xpath = "//div[@class='inventory_item_price']")
    WebElement productCost;
    By price = By.xpath("//div[@class='inventory_item_price']");
    @FindBy(xpath = "//div[@class='summary_subtotal_label']")
    WebElement totalCost;
    @FindBy(id = "finish")
    WebElement finishBtn;
    @FindBy(xpath = "//span[@class='title']")
    WebElement verifyCheckout;
    @FindBy(className = "summary_subtotal_label")
    WebElement totalPrice;

    public P03_CartPage(WebDriver driver) {
        super(driver);
    }

    public void Checkout(String Fname, String Lname, String zip) {
        cartBtn.click();
        checkoutBtn.click();
        firstName.sendKeys(Fname);
        lastName.sendKeys(Lname);
        zipCode.sendKeys(zip);
        continueBtn.click();
    }

    public String checkTotalCost() {
        productsCost = driver.findElements(price);
        LogsUtils.info("number of all products" + productsCost.size());
        float sum = 0;
        for (int i = 1; i <= productsCost.size(); i++) {
            By Cost = By.xpath("(//div[@class='inventory_item_price'])[" + i + "]");
            String text = driver.findElement(Cost).getText();
            sum += Float.parseFloat(text.replace("$", "").trim());
        }


        return String.valueOf(sum);
    }

    public String checkPrice() {
        float Cost = Float.parseFloat(totalPrice.getText().replace("Item total: $", ""));
        return String.valueOf(Cost);
    }

    public P03_CartPage finish() {
        finishBtn.click();
        return this;
    }

    public String checkoutComplete() {
        return verifyCheckout.getText();
    }
}
