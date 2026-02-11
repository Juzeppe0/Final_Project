//TestCase 3


package ui.tests;

import base.TestBase;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.HomePage;
import ui.pages.SignupLoginPage;
import utils.DriverFactory;

public class LoginUserIncorrectTest extends TestBase {

    @Test
    public void loginUserWithIncorrectCredentials() {

        Allure.step("Navigate to automationexercise.com");
        DriverFactory.getDriver().get("http://automationexercise.com");

        HomePage home = new HomePage(DriverFactory.getDriver());

        Allure.step("Verify home page is visible");
        Assert.assertTrue(home.isHomeVisible());

        Allure.step("Click Signup / Login");
        SignupLoginPage signupLogin = home.clickSignupLogin();

        Allure.step("Verify Login to your account is visible");
        Assert.assertTrue(signupLogin.isLoginHeaderVisible());

        Allure.step("Enter incorrect email and password");
        signupLogin
                .enterLoginEmail("1234@ibsu.edu.ge")
                .enterLoginPassword("123")
                .clickLogin();

        Allure.step("Verify error message is visible");
        Assert.assertTrue(signupLogin.isLoginErrorVisible());
    }
}