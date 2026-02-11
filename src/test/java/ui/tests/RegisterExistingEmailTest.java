//TestCase 5


package ui.tests;

import base.TestBase;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.HomePage;
import ui.pages.SignupLoginPage;
import utils.DriverFactory;

public class RegisterExistingEmailTest extends TestBase {

    @Test
    public void registerUserWithExistingEmail() {

        Allure.step("Navigate to automationexercise.com");
        DriverFactory.getDriver().get("http://automationexercise.com");

        HomePage home = new HomePage(DriverFactory.getDriver());

        Allure.step("Verify home page is visible");
        Assert.assertTrue(home.isHomeVisible());

        Allure.step("Click Signup / Login");
        SignupLoginPage signupLogin = home.clickSignupLogin();

        Allure.step("Verify New User Signup is visible");
        Assert.assertTrue(signupLogin.isNewUserSignupVisible());

        Allure.step("Enter name and existing email and click Signup");
        signupLogin
                .enterName("Mate")
                .enterEmail("23202197@ibsu.edu.ge")
                .clickSignup();

        Allure.step("Verify Email Address already exist error is visible");
        Assert.assertTrue(signupLogin.isSignupEmailAlreadyExistsVisible());
    }
}