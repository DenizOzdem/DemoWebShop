package testCase;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utility.BaseDriver;
import org.junit.Assert;

public class TC_0201_RegisterExistingUser extends BaseDriver {
    @Test
    public void registerExistingUserTest() {

        driver.get("https://demowebshop.tricentis.com/");

        Actions action = new Actions(driver);
        action.click(driver.findElement(By.cssSelector(".ico-register"))).perform();
        action.click(driver.findElement(By.cssSelector("#gender-female")));
        action.sendKeys(driver.findElement(By.cssSelector("#FirstName")), "Deniz");
        action.sendKeys(driver.findElement(By.cssSelector("#LastName")), "Zm");
        action.sendKeys(driver.findElement(By.cssSelector("#Email")), "deoztest@gmail.com");
        action.sendKeys(driver.findElement(By.cssSelector("#Password")), "Test.35%=");
        action.sendKeys(driver.findElement(By.cssSelector("#ConfirmPassword")), "Test.35%=");
        action.click(driver.findElement(By.cssSelector("#register-button")));
        action.perform();

        String result = driver.findElement(By.cssSelector(".validation-summary-errors > ul > li")).getText();
        Assert.assertEquals("The specified email already exists", result);

        delayQuit();
    }
}
