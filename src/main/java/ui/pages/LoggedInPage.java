package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoggedInPage extends BasePage {

    private final By loggedInAsText = By.xpath("//a[contains(.,'Logged in as')]");
    private final By deleteAccountBtn = By.xpath("//a[@href='/delete_account']");
    private final By logoutBtn = By.xpath("//a[@href='/logout']");

    public LoggedInPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoggedInAsVisible() {
        return isVisible(loggedInAsText);
    }

    public AccountDeletedPage clickDeleteAccount() {
        click(deleteAccountBtn);
        return new AccountDeletedPage(driver);
    }

    public SignupLoginPage clickLogout() {
        click(logoutBtn);
        return new SignupLoginPage(driver);
    }

}