package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountInfoPage extends BasePage {

    private final By enterAccountInfoHeader = By.xpath("//b[normalize-space()='Enter Account Information']");

    private final By passwordInput = By.id("password");

    private final By daysSelect = By.id("days");
    private final By monthsSelect = By.id("months");
    private final By yearsSelect = By.id("years");

    private final By newsletterCheckbox = By.id("newsletter");
    private final By offersCheckbox = By.id("optin");

    private final By firstNameInput = By.id("first_name");
    private final By lastNameInput = By.id("last_name");

    private final By companyInput = By.id("company");

    private final By address1Input = By.id("address1");
    private final By address2Input = By.id("address2");

    private final By countrySelect = By.id("country");
    private final By stateInput = By.id("state");
    private final By cityInput = By.id("city");
    private final By zipcodeInput = By.id("zipcode");
    private final By mobileNumberInput = By.id("mobile_number");

    private final By createAccountBtn = By.xpath("//button[@data-qa='create-account']");

    public AccountInfoPage(WebDriver driver) {
        super(driver);
    }

    public boolean isEnterAccountInfoVisible() {
        return isVisible(enterAccountInfoHeader);
    }

    public AccountInfoPage setPassword(String password) {
        type(passwordInput, password);
        return this;
    }

    public AccountInfoPage setDob(String day, String month, String year) {
        type(daysSelect, day);
        type(monthsSelect, month);
        type(yearsSelect, year);
        return this;
    }

    public AccountInfoPage checkNewsletter() {
        click(newsletterCheckbox);
        return this;
    }

    public AccountInfoPage checkOffers() {
        click(offersCheckbox);
        return this;
    }

    public AccountInfoPage fillAddress(
            String firstName, String lastName, String company, String address1, String address2,
            String country, String state, String city, String zipcode, String mobile
    ) {
        type(firstNameInput, firstName);
        type(lastNameInput, lastName);

        type(companyInput, company);

        type(address1Input, address1);
        type(address2Input, address2);

        type(countrySelect, country);

        type(stateInput, state);
        type(cityInput, city);
        type(zipcodeInput, zipcode);
        type(mobileNumberInput, mobile);

        return this;
    }

    public AccountCreatedPage clickCreateAccount() {
        click(createAccountBtn);
        return new AccountCreatedPage(driver);
    }
}