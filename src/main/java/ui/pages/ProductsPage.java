package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    private final By allProductsHeader =
            By.xpath("//h2[contains(@class,'title') and normalize-space()='All Products']");

    private final By productsList =
            By.xpath("//div[contains(@class,'features_items')]");

    private final By firstProductViewBtn =
            By.xpath("(//a[contains(@href,'/product_details/') and normalize-space()='View Product'])[1]");

    private final By searchInput =
            By.id("search_product");

    private final By searchButton =
            By.id("submit_search");

    private final By searchedProductsHeader =
            By.xpath("//h2[normalize-space()='Searched Products']");


    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAllProductsHeaderVisible() {
        return isVisible(allProductsHeader);
    }

    public boolean isProductsListVisible() {
        return isVisible(productsList);
    }

    public ProductDetailsPage clickFirstViewProduct() {
        click(firstProductViewBtn);
        return new ProductDetailsPage(driver);
    }

    public ProductsPage searchProduct(String productName) {
        type(searchInput, productName);
        click(searchButton);
        return this;
    }

    public boolean isSearchedProductsHeaderVisible() {
        return isVisible(searchedProductsHeader);
    }

}