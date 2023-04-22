package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    @Before
    public void setUp() {
        openBrowser("https://www.saucedemo.com/");
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        sendTextToElement(By.xpath("//input[@id='user-name']"), "standard_user");// Find username field and enter username
        sendTextToElement(By.xpath("//input[@id='password']"), "secret_sauce");// Find password field and enter password
        clickOnElement(By.xpath("//input[@id='login-button']"));// Find login link and click on it
        String expectedText = "Products";
        String actualText = getActualText(By.xpath("//span[@class='title']"));// Find actual text on page and get it.
        Assert.assertEquals("Text is not displayed", expectedText, actualText);// Compare expected vs actual text
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        sendTextToElement(By.xpath("//input[@id='user-name']"), "standard_user");// Find username field and enter username
        sendTextToElement(By.xpath("//input[@id='password']"), "secret_sauce");// Find password field and enter password
        clickOnElement(By.xpath("//input[@id='login-button']"));// Find login link and click on it
        int expectedNumber = 6;
        int actualNumber = driver.findElements(By.className("inventory_item")).size();// Find actual number of elements on page
        Assert.assertEquals("Different number is displayed", actualNumber, expectedNumber);// Compare expected vs actual number of element
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}

