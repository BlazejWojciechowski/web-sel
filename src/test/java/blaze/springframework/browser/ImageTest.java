package blaze.springframework.browser;

import blaze.springframework.actions.BasicActionsTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ImageTest {
    @Test
    public void getInfo() {

        BasicActionsTest basicActionsTest = new BasicActionsTest();
        WebDriver driver = basicActionsTest.getDriver("firefox");
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/image.html");

        WebElement image = driver.findElement(By.tagName("img"));
        String height = image.getAttribute("naturalHeight");

        Assert.assertEquals("0", height);
    }
}
