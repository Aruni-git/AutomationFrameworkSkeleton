package tests;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.BasePage;
import pages.HomePage;

public class BaseTest extends BasePage {
    protected HomePage homePage;

    @BeforeSuite
    public void setup() {
        Assert.assertTrue(goToHomepage(), "An error occurred while navigating to the the homepage");

        homePage = new HomePage();

    }

    @AfterSuite
    public void tearDown() {
        closeBrowser();
    }
}
