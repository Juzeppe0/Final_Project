package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupLoginPage extends BasePage {

    private final By newUserSignupHeader =
            By.xpath("//h2[normalize-space()='New User Signup!']");

    private final By signupNameInput =
            By.xpath("//input[@data-qa='signup-name']");

    private final By signupEmailInput =
            By.xpath("//input[@data-qa='signup-email']");

    private final By signupButton =
            By.xpath("//button[@data-qa='signup-button']");

    private final By loginHeader =
            By.xpath("//h2[normalize-space()='Login to your account']");

    private final By loginEmailInput =
            By.xpath("//input[@data-qa='login-email']");

    private final By loginPasswordInput =
            By.xpath("//input[@data-qa='login-password']");

    private final By loginButton =
            By.xpath("//button[@data-qa='login-button']");

    private final By loginErrorMsg =
            By.xpath("//p[normalize-space()='Your email or password is incorrect!']");

    private final By signupEmailExistsError =
            By.xpath("//p[normalize-space()='Email Address already exist!']");


    public SignupLoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isNewUserSignupVisible() {
        return isVisible(newUserSignupHeader);
    }

    public SignupLoginPage enterName(String name) {
        type(signupNameInput, name);
        return this;
    }

    public SignupLoginPage enterEmail(String email) {
        type(signupEmailInput, email);
        return this;
    }

    public AccountInfoPage clickSignup() {
        click(signupButton);
        return new AccountInfoPage(driver);
    }

    public boolean isLoginHeaderVisible() {
        return isVisible(loginHeader);
    }

    public SignupLoginPage enterLoginEmail(String email) {
        type(loginEmailInput, email);
        return this;
    }

    public SignupLoginPage enterLoginPassword(String password) {
        type(loginPasswordInput, password);
        return this;
    }

    public LoggedInPage clickLogin() {
        click(loginButton);
        return new LoggedInPage(driver);
    }

    public boolean isLoginErrorVisible() {
        return isVisible(loginErrorMsg);
    }

    public boolean isSignupEmailAlreadyExistsVisible() {
        return isVisible(signupEmailExistsError);
    }


}