//TestCase 1

package ui.tests;

import base.TestBase;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.*;
import utils.DriverFactory;

public class RegisterUserTest extends TestBase {

    @Test
    public void registerUser() {
        Allure.step("Navigate to automationexercise.com");
        DriverFactory.getDriver().get("http://automationexercise.com");

        HomePage home = new HomePage(DriverFactory.getDriver());

        Allure.step("Verify home page is visible");
        Assert.assertTrue(home.isHomeVisible());

        Allure.step("Click Signup / Login");
        SignupLoginPage signupLogin = home.clickSignupLogin();

        Allure.step("Verify New User Signup! is visible");
        Assert.assertTrue(signupLogin.isNewUserSignupVisible());

        Allure.step("Enter name and email and click Signup");
        AccountInfoPage info = signupLogin
                .enterName("Mate Odisharia")
                .enterEmail("23202197@ibsu.edu.ge")
                .clickSignup();

        Allure.step("Verify Enter Account Information is visible");
        Assert.assertTrue(info.isEnterAccountInfoVisible());

        Allure.step("Fill details and create account");
        AccountCreatedPage created = info
                .setPassword("Password123")
                .setDob("13", "oct", "2005")
                .checkNewsletter()
                .checkOffers()
                .fillAddress(
                        "Mate", "Odisharia", "IBSU",
                        "Tbilisi1", "Tbilisi2",
                        "United States", "Georgia", "Tbilisi", "0100", "123456789"
                )
                .clickCreateAccount();

        Allure.step("Verify ACCOUNT CREATED is visible");
        Assert.assertTrue(created.isAccountCreatedVisible());

        Allure.step("Click Continue");
        LoggedInPage loggedIn = created.clickContinue();

        Allure.step("Verify Logged in as is visible");
        Assert.assertTrue(loggedIn.isLoggedInAsVisible());

        Allure.step("Click Delete Account");
        AccountDeletedPage deleted = loggedIn.clickDeleteAccount();

        Allure.step("Verify ACCOUNT DELETED is visible");
        Assert.assertTrue(deleted.isAccountDeletedVisible());

        Allure.step("Click Continue");
        deleted.clickContinue();
    }
}