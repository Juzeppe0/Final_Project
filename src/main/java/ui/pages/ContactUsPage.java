package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage extends BasePage {

    private final By getInTouchHeader =
            By.xpath("//h2[contains(@class,'title') and normalize-space()='Get In Touch']");

    private final By nameInput =
            By.xpath("//input[@data-qa='name']");

    private final By emailInput =
            By.xpath("//input[@data-qa='email']");

    private final By subjectInput =
            By.xpath("//input[@data-qa='subject']");

    private final By messageTextArea =
            By.xpath("//textarea[@data-qa='message']");

    private final By submitBtn =
            By.xpath("//input[@data-qa='submit-button']");

    private final By successMsg =
            By.xpath("//div[contains(@class,'alert-success') and contains(.,'Success! Your details have been submitted successfully.')]");

    private final By homeBtn =
            By.xpath("//a[@href='/' and contains(.,'Home')]");

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isGetInTouchVisible() {
        return isVisible(getInTouchHeader);
    }

    public ContactUsPage enterName(String name) {
        type(nameInput, name);
        return this;
    }

    public ContactUsPage enterEmail(String email) {
        type(emailInput, email);
        return this;
    }

    public ContactUsPage enterSubject(String subject) {
        type(subjectInput, subject);
        return this;
    }

    public ContactUsPage enterMessage(String message) {
        type(messageTextArea, message);
        return this;
    }

    public ContactUsPage clickSubmit() {
        click(submitBtn);
        return this;
    }

    public ContactUsPage acceptOkAlert() {
        driver.switchTo().alert().accept();
        return this;
    }

    public boolean isSuccessMessageVisible() {
        return isVisible(successMsg);
    }

    public HomePage clickHome() {
        click(homeBtn);
        return new HomePage(driver);
    }
}