package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage extends BasePage {

    WebElement emailAddress;
    WebElement invalidDomainError;
    WebElement errorForInvalidEmailAddress;
    By elementUserName = By.xpath("//input[@id='user_email']");

    public LoginPage enterUserName(String userName) {
        try {
            Thread.sleep(5000);

            emailAddress = driver.findElement(elementUserName);
            emailAddress.clear();
            emailAddress.sendKeys(userName);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return this;
    }

    public LoginPage enterInvalidUserName(String InvalidUserName) {
        try {
            Thread.sleep(5000);

            emailAddress = driver.findElement(By.xpath("//input[@id='user_email']"));
            emailAddress.clear();
            emailAddress.sendKeys(InvalidUserName);

            errorForInvalidEmailAddress = driver.findElement(By.xpath(" //label[@id='email-warning']"));
            Assert.assertTrue(errorForInvalidEmailAddress.isDisplayed());

            String invalidEmailAddressError = errorForInvalidEmailAddress.getText();
            System.out.println(invalidEmailAddressError);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return this;
    }

    public LoginPage enterFullQualifiedPassword(String txtPassword) {
        try {
            Thread.sleep(2000);
            WebElement password = driver.findElement(By.xpath("//input[@id='user_password']"));
            password.clear();
            password.sendKeys(txtPassword);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return this;
    }

    public LoginPage enterPassword(String txtPassword) {
        try {
            Thread.sleep(2000);
            WebElement password = driver.findElement(By.xpath("//input[@id='user_password']"));
            password.clear();
            password.sendKeys(txtPassword);

            WebElement passwordValidations = driver.findElement(By.xpath("//div[@id='password-warning']"));
            Assert.assertTrue(passwordValidations.isDisplayed());

            String passwordValidationErrors = passwordValidations.getText();
            System.out.println(passwordValidationErrors);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return this;
    }

    public LoginPage enterCompany(String txtCompany) {
        try {
            Thread.sleep(2000);
            WebElement company = driver.findElement(By.xpath("//input[@id='user_company']"));
            company.clear();
            company.sendKeys(txtCompany);

            Thread.sleep(2000);
            WebElement greenCheck = driver.findElement(By.xpath("//i[@id='tick']"));
            Assert.assertTrue(greenCheck.isDisplayed());

            System.out.println("Domain validation is successful");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return this;
    }

    public LoginPage enterInvalidCompanyDomain(String txtCompany) {
        try {
            Thread.sleep(5000);
            WebElement company = driver.findElement(By.xpath("//input[@id='user_company']"));
            company.clear();
            company.sendKeys(txtCompany);

            Thread.sleep(2000);
            WebElement redCross = driver.findElement(By.xpath("//i[@id='cross']"));
            Assert.assertTrue(redCross.isDisplayed());
            invalidDomainError = driver.findElement(By.xpath("//label[@id='specialcharacter-warning']"));

            String printInvalidDomainErrorMessage = invalidDomainError.getText();
            System.out.println(printInvalidDomainErrorMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return this;
    }

    public LoginPage clickStartTrial() {
        try {
            Thread.sleep(5000);
            driver.findElement(By.id("btn-buynow")).click();

            Thread.sleep(3000);

            assert driver.findElement(By.xpath("//button[@id='btn-finish']")).isDisplayed();
            System.out.println("Successfully navigate to the next page");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return this;
    }

}
