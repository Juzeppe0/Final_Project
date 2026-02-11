package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountDeletedPage extends BasePage {

    private final By accountDeletedHeader =
            By.xpath("//h2[@data-qa='account-deleted']//b");

    private final By continueBtn =
            By.xpath("//a[@data-qa='continue-button' and contains(.,'Continue')]");

    public AccountDeletedPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAccountDeletedVisible() {
        return isVisible(accountDeletedHeader);
    }

    public void clickContinue() {
        click(continueBtn);
    }
}