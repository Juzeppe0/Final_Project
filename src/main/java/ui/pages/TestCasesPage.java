package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCasesPage extends BasePage {

    private final By testCasesHeader =
            By.xpath("//h2[contains(@class,'title')]/b[normalize-space()='Test Cases']");

    public TestCasesPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTestCasesHeaderVisible() {
        return isVisible(testCasesHeader);
    }
}