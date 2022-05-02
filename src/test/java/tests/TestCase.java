package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.*;

import java.util.HashMap;

public class TestCase extends BaseTest {

    WebDriver driver;

    LoginPage loginPage;

    @Test(priority = 1, description = "", dataProviderClass = DataProvider.class, dataProvider = "dp_tc_verifyLogin")
    public void verifyValidDomain(HashMap<String, String> hashMap) {
        loginPage = new LoginPage();
        loginPage.enterUserName(hashMap.get("userName"));
    }

    @Test(priority = 2)
    public void verifyInvalidCompanyDomain() {

        loginPage = new LoginPage();
        loginPage.enterUserName("aruni.gunapala@gmail.com");
        loginPage.enterFullQualifiedPassword("Aruni@123456789_234");
        loginPage.enterInvalidCompanyDomain("arunitestcompany.");
    }

    @AfterTest
    public void closeDriver() {
        driver.quit();
    }
}
