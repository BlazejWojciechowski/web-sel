package blaze.springframework.wait;

import blaze.springframework.actions.BasicActionsTest;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class WaitTest {
    WebDriver driver;

    @Test
    public void waitTest() {

        BasicActionsTest basicActionsTest = new BasicActionsTest();
        WebDriver driver = basicActionsTest.getDriver("firefox");
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");

        driver.findElement(By.id("clickOnMe")).click();
        //Thread.sleep(5000); - not recommended

        Duration time = Duration.ofSeconds(10);
        //WebDriverWait wait = new WebDriverWait(driver,time);
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.ignoring(NoSuchElementException.class);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p")));


        driver.findElement(By.cssSelector("p"));

        waitForElementExist(By.cssSelector("p"));
    }

    public void waitForElementExist(By locator) {

        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.ignoring(NoSuchElementException.class);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));

        wait.until((driver -> {
                List<WebElement> elements = driver.findElements(locator);
                if (elements.size() > 0) {
                    System.out.println("Element jest na stronie.");
                    return true;
                } else {
                    System.out.println("Elementu nie znaleziono.");
                    return false;
                }
        }));
    }
}
