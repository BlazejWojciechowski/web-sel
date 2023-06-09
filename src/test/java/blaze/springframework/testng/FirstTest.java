package blaze.springframework.testng;

import blaze.springframework.actions.BasicActionsTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
@Listeners(value = {SampleTestListener.class})

public class FirstTest extends BaseTest {
    @Test
    public void firstTest() {

        BasicActionsTest basicActionsTest = new BasicActionsTest();
        WebDriver driver = basicActionsTest.getDriver("firefox");
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");

        driver.findElement(By.id("clickOnMe")).click();

        Duration time = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p")));
        driver.findElement(By.cssSelector("p"));

        SoftAssert softAssert = new SoftAssert();

        String paraText = driver.findElement(By.cssSelector("p")).getText();
        softAssert.assertEquals(paraText, "Elo.");
        Assert.assertEquals(paraText, "Dopiero się pojawiłem!");
        softAssert.assertTrue(true, "Dopiero się pojawiłem!");

        driver.quit();
    }
    @Test @Ignore
    public void secondTest() {

        BasicActionsTest basicActionsTest = new BasicActionsTest();
        WebDriver driver = basicActionsTest.getDriver("firefox");
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");

        driver.findElement(By.id("clickOnMe")).click();

        Duration time = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p")));


        driver.findElement(By.cssSelector("p"));

        driver.quit();
    }
}