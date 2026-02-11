//TestCase 9


package ui.tests;

import base.TestBase;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.HomePage;
import ui.pages.ProductsPage;
import utils.DriverFactory;

public class SearchProductTest extends TestBase {

    @Test
    public void searchProduct() {

        DriverFactory.getDriver().get("http://automationexercise.com");

        HomePage home = new HomePage(DriverFactory.getDriver());

        Allure.step("Verify home page is visible");
        Assert.assertTrue(home.isHomeVisible());

        Allure.step("Click Products");
        ProductsPage products = home.clickProducts();

        Allure.step("Verify ALL PRODUCTS page");
        Assert.assertTrue(products.isAllProductsHeaderVisible());

        Allure.step("Search product");
        products.searchProduct("Men Tshirt");

        Allure.step("Verify SEARCHED PRODUCTS is visible");
        Assert.assertTrue(products.isSearchedProductsHeaderVisible());

        Allure.step("Verify searched products list is visible");
        Assert.assertTrue(products.isProductsListVisible());
    }
}