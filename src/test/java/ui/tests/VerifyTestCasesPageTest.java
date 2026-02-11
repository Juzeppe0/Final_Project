//TestCase 7


package ui.tests;

import base.TestBase;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.HomePage;
import ui.pages.TestCasesPage;
import utils.DriverFactory;

public class VerifyTestCasesPageTest extends TestBase {

    @Test
    public void verifyTestCasesPage() {

        Allure.step("Navigate to automationexercise.com");
        DriverFactory.getDriver().get("http://automationexercise.com");

        HomePage home = new HomePage(DriverFactory.getDriver());

        Allure.step("Verify home page is visible");
        Assert.assertTrue(home.isHomeVisible());

        Allure.step("Click Test Cases");
        TestCasesPage testCases = home.clickTestCases();

        Allure.step("Verify user is navigated to Test Cases page successfully");
        Assert.assertTrue(testCases.isTestCasesHeaderVisible());
    }
}