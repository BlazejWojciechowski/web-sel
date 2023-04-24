package blaze.springframework.browser;

import blaze.springframework.actions.BasicActionsTest;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ElementExistTest {

    WebDriver driver;
    @Test
    public void getInfo() {

        BasicActionsTest basicActionsTest = new BasicActionsTest();
        WebDriver driver = basicActionsTest.getDriver("firefox");
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        //System.out.println(ifSecondExist(By.tagName("p")));
        //System.out.println(ifSecondExist(By.id("topSecret")));

        System.out.println(driver.findElement(By.tagName("p")).isDisplayed());
        System.out.println(driver.findElement(By.tagName("button")).isDisplayed());

        System.out.println(driver.findElement(By.tagName("button")).isEnabled());

        System.out.println("Checking checkbox...");
        WebElement checkbox = driver.findElement(By.cssSelector("[type='checkbox']"));
        System.out.println(checkbox.isSelected());
        checkbox.click();
        System.out.println(checkbox.isSelected());



    }
    public boolean ifExist(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public boolean ifSecondExist(By locator) {
        return driver.findElements(locator).size() > 0;
    }
}
