package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage {

    private final By productName =
            By.xpath("//div[contains(@class,'product-information')]//h2");

    private final By category =
            By.xpath("//div[contains(@class,'product-information')]//p[starts-with(normalize-space(),'Category:')]");

    private final By price =
            By.xpath("//div[contains(@class,'product-information')]//span[starts-with(normalize-space(),'Rs.')]");

    private final By availability =
            By.xpath("//div[contains(@class,'product-information')]//p[b[normalize-space()='Availability:']]");

    private final By condition =
            By.xpath("//div[contains(@class,'product-information')]//p[b[normalize-space()='Condition:']]");

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductNameVisible() {
        return isVisible(productName);
    }

    public boolean isCategoryVisible() {
        return isVisible(category);
    }

    public boolean isPriceVisible() {
        return isVisible(price);
    }

    public boolean isAvailabilityVisible() {
        return isVisible(availability);
    }

    public boolean isConditionVisible() {
        return isVisible(condition);
    }
}