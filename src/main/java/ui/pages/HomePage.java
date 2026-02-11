package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final By logoImg = By.xpath("//img[@alt='Website for automation practice']");
    private final By signupLoginBtn = By.xpath("//a[@href='/login' and contains(.,'Signup / Login')]");
    private final By contactUsBtn = By.xpath("//a[@href='/contact_us']");
    private final By testCasesBtn = By.xpath("//a[@href='/test_cases']");
    private final By productsBtn = By.xpath("//a[@href='/products']");
    private final By subscriptionHeader = By.xpath("//h2[normalize-space()='Subscription']");
    private final By subscribeEmailInput = By.id("subscribe_email");
    private final By subscribeBtn = By.id("subscribe");
    private final By subscribeSuccessMsg = By.xpath("//div[@id='success-subscribe' and contains(.,'You have been successfully subscribed!')]");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isHomeVisible() {
        return isVisible(logoImg);
    }

    public SignupLoginPage clickSignupLogin() {
        click(signupLoginBtn);
        return new SignupLoginPage(driver);
    }

    public ContactUsPage clickContactUs() {
        click(contactUsBtn);
        return new ContactUsPage(driver);
    }

    public TestCasesPage clickTestCases() {
        click(testCasesBtn);
        return new TestCasesPage(driver);
    }

    public ProductsPage clickProducts() {
        click(productsBtn);
        return new ProductsPage(driver);
    }

    public boolean isSubscriptionVisible() {
        return isVisible(subscriptionHeader);
    }

    public HomePage scrollToSubscription() {
        scrollTo(subscriptionHeader);
        return this;
    }

    public HomePage subscribe(String email) {
        type(subscribeEmailInput, email);
        click(subscribeBtn);
        return this;
    }

    public boolean isSubscribeSuccessVisible() {
        return isVisible(subscribeSuccessMsg);
    }


}