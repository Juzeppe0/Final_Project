//TestCase 4


package ui.tests;

import base.TestBase;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.HomePage;
import ui.pages.LoggedInPage;
import ui.pages.SignupLoginPage;
import utils.DriverFactory;

public class LogoutUserTest extends TestBase {

    @Test
    public void logoutUser() {

        Allure.step("Navigate to automationexercise.com");
        DriverFactory.getDriver().get("http://automationexercise.com");

        HomePage home = new HomePage(DriverFactory.getDriver());

        Allure.step("Verify home page is visible");
        Assert.assertTrue(home.isHomeVisible());

        Allure.step("Click Signup / Login");
        SignupLoginPage signupLogin = home.clickSignupLogin();

        Allure.step("Verify Login to your account is visible");
        Assert.assertTrue(signupLogin.isLoginHeaderVisible());

        Allure.step("Enter correct email and password and click Login");
        LoggedInPage loggedIn = signupLogin
                .enterLoginEmail("23202197@ibsu.edu.ge")
                .enterLoginPassword("Password123")
                .clickLogin();

        Allure.step("Verify Logged in as username is visible");
        Assert.assertTrue(loggedIn.isLoggedInAsVisible());

        Allure.step("Click Logout button");
        SignupLoginPage backToLogin = loggedIn.clickLogout();

        Allure.step("Verify user is navigated to login page");
        Assert.assertTrue(backToLogin.isLoginHeaderVisible());
    }
}