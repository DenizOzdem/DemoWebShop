package testCase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utility.BaseDriver;

public class TC_0401_LoginWithInvalidCredentials extends BaseDriver {
    @Test
    public void loginWithInvalidCredentialsTest() {

        driver.get("https://demowebshop.tricentis.com/");

        Actions action = new Actions(driver);
        action.click(driver.findElement(By.cssSelector(".ico-login"))).perform();
        action.sendKeys(driver.findElement(By.cssSelector("#Email")), "deoztest@gmail.com");
        action.sendKeys(driver.findElement(By.cssSelector("#Password")), "Test.35%=");
        action.click(driver.findElement(By.xpath("//input[@type='submit'][@value='Log in']")));
        action.perform();

        String result = driver.findElement(By.xpath("(//div[@class='header-links']//a)[1]")).getText();
        Assert.assertEquals("deoztest@gmail.com", result);

        delayQuit();

    }
}
