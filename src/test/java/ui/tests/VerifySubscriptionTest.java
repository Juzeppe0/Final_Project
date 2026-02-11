//TestCase 10


package ui.tests;

import base.TestBase;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.HomePage;
import utils.DriverFactory;

public class VerifySubscriptionTest extends TestBase {

    @Test
    public void verifySubscriptionInHomePage() {

        DriverFactory.getDriver().get("http://automationexercise.com");

        HomePage home = new HomePage(DriverFactory.getDriver());

        Allure.step("Verify home page is visible");
        Assert.assertTrue(home.isHomeVisible());

        Allure.step("Scroll down to footer");
        home.scrollToSubscription();

        Allure.step("Verify SUBSCRIPTION is visible");
        Assert.assertTrue(home.isSubscriptionVisible());

        Allure.step("Enter email and click subscribe");
        home.subscribe("23202197@ibsu.edu.ge");

        Allure.step("Verify success message is visible");
        Assert.assertTrue(home.isSubscribeSuccessVisible());
    }
}