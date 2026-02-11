//TestCase 2


package ui.tests;

import base.TestBase;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.*;
import utils.DriverFactory;

public class LoginUserCorrectTest extends TestBase {

    @Test
    public void loginUserWithCorrectCredentials() {

        Allure.step("Navigate to automationexercise.com");
        DriverFactory.getDriver().get("http://automationexercise.com");

        HomePage home = new HomePage(DriverFactory.getDriver());

        Allure.step("Verify home page is visible");
        Assert.assertTrue(home.isHomeVisible());

        Allure.step("Click Signup / Login");
        SignupLoginPage signupLogin = home.clickSignupLogin();

        Allure.step("Verify Login to your account is visible");
        Assert.assertTrue(signupLogin.isLoginHeaderVisible());

        Allure.step("Enter correct email and password");
        LoggedInPage loggedIn = signupLogin
                .enterLoginEmail("23202197@ibsu.edu.ge")
                .enterLoginPassword("Password123")
                .clickLogin();

        Allure.step("Verify Logged in as username is visible");
        Assert.assertTrue(loggedIn.isLoggedInAsVisible());

        Allure.step("Click Delete Account");
        AccountDeletedPage deleted = loggedIn.clickDeleteAccount();

        Allure.step("Verify ACCOUNT DELETED is visible");
        Assert.assertTrue(deleted.isAccountDeletedVisible());

        Allure.step("Click Continue");
        deleted.clickContinue();
    }
}