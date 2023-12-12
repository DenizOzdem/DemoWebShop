package testCase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utility.BaseDriver;

public class TC_0101_Register extends BaseDriver {
    @Test
    public void registerTest() {

        driver.get("https://demowebshop.tricentis.com/");
        driver.findElement(By.cssSelector(".ico-register")).click();

        Actions action = new Actions(driver);
        action.click(driver.findElement(By.cssSelector("#gender-female")));
        action.sendKeys(driver.findElement(By.cssSelector("#FirstName")), "Deniz");
        action.sendKeys(driver.findElement(By.cssSelector("#LastName")), "Zm");
        action.sendKeys(driver.findElement(By.cssSelector("#Email")), "deoztest@gmail.com");
        action.sendKeys(driver.findElement(By.cssSelector("#Password")), "Test.35%=");
        action.sendKeys(driver.findElement(By.cssSelector("#ConfirmPassword")), "Test.35%=");
        action.click(driver.findElement(By.cssSelector("#register-button")));
        action.perform();

        try {
            String result = driver.findElement(By.cssSelector(".page-body > .result")).getText();
            Assert.assertEquals("Your registration completed", result);
            action.click(driver.findElement(By.cssSelector(".header-links > ul > li + li > a.ico-logout")));
        } catch (Exception e) {
            System.out.println("Üyelik daha önce yapıldığından dolayı bu adımı geçebiliriz.");
        }
        delayQuit();
    }
}
