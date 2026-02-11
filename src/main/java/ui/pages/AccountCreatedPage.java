package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreatedPage extends BasePage {

    private final By accountCreatedHeader = By.xpath("//h2[@data-qa='account-created']//b");
    private final By continueBtn = By.xpath("//a[@data-qa='continue-button' and contains(.,'Continue')]");

    public AccountCreatedPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAccountCreatedVisible() {
        return isVisible(accountCreatedHeader);
    }

    public LoggedInPage clickContinue() {
        click(continueBtn);
        return new LoggedInPage(driver);
    }
}