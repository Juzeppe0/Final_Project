//TestCase 6


package ui.tests;

import base.TestBase;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.ContactUsPage;
import ui.pages.HomePage;
import utils.DriverFactory;

public class ContactUsTest extends TestBase {

    @Test
    public void contactUsForm() {

        Allure.step("Navigate to automationexercise.com");
        DriverFactory.getDriver().get("http://automationexercise.com");

        HomePage home = new HomePage(DriverFactory.getDriver());

        Allure.step("Verify home page is visible");
        Assert.assertTrue(home.isHomeVisible());

        Allure.step("Click Contact Us");
        ContactUsPage contact = home.clickContactUs();

        Allure.step("Verify Get In Touch is visible");
        Assert.assertTrue(contact.isGetInTouchVisible());

        Allure.step("Enter contact details");
        contact.enterName("Mate")
                .enterEmail("23202197@ibsu.edu.ge")
                .enterSubject("contact")
                .enterMessage("hello");

        Allure.step("Click Submit");
        contact.clickSubmit();

        Allure.step("Click OK on alert");
        contact.acceptOkAlert();

        Allure.step("Verify success message is visible");
        Assert.assertTrue(contact.isSuccessMessageVisible());

        Allure.step("Click Home button");
        HomePage homePage = contact.clickHome();

        Allure.step("Verify landed to home page successfully");
        Assert.assertTrue(homePage.isHomeVisible());
    }
}