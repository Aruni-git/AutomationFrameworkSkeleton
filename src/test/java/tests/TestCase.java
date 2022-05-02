package tests;

import org.testng.annotations.Test;

import pages.*;
import utils.DataProviders;

import java.util.HashMap;

public class TestCase extends BaseTest {

    LoginPage loginPage;

    @Test(priority = 1, description = "verifyValidCompany domain", dataProviderClass = DataProviders.class, dataProvider = "dp_tc_verifyLogin")
    public void verifyValidDomain(HashMap<String, String> hashMap) {
        loginPage = new LoginPage();
        loginPage.enterUserName(hashMap.get("userName"));

    }

}
