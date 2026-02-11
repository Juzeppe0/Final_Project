//TestCase 8


package ui.tests;

import base.TestBase;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.HomePage;
import ui.pages.ProductDetailsPage;
import ui.pages.ProductsPage;
import utils.DriverFactory;

public class VerifyProductsTest extends TestBase {

    @Test
    public void verifyAllProductsAndProductDetailPage() {

        Allure.step("Navigate to automationexercise.com");
        DriverFactory.getDriver().get("http://automationexercise.com");

        HomePage home = new HomePage(DriverFactory.getDriver());

        Allure.step("Verify home page is visible");
        Assert.assertTrue(home.isHomeVisible());

        Allure.step("Click Products");
        ProductsPage products = home.clickProducts();

        Allure.step("Verify user is navigated to ALL PRODUCTS page successfully");
        Assert.assertTrue(products.isAllProductsHeaderVisible());

        Allure.step("Verify products list is visible");
        Assert.assertTrue(products.isProductsListVisible());

        Allure.step("Click View Product of first product");
        ProductDetailsPage details = products.clickFirstViewProduct();

        Allure.step("Verify product name is visible");
        Assert.assertTrue(details.isProductNameVisible());

        Allure.step("Verify category is visible");
        Assert.assertTrue(details.isCategoryVisible());

        Allure.step("Verify price is visible");
        Assert.assertTrue(details.isPriceVisible());

        Allure.step("Verify availability is visible");
        Assert.assertTrue(details.isAvailabilityVisible());

        Allure.step("Verify condition is visible");
        Assert.assertTrue(details.isConditionVisible());
    }
}