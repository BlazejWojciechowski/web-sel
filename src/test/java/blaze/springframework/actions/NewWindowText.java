package blaze.springframework.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class NewWindowText {
    @Test
    public void testNewWindow() {

        BasicActionsTest basicActionsTest = new BasicActionsTest();
        WebDriver driver = basicActionsTest.getDriver("firefox");
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
        String currentWindow = driver.getWindowHandle();
        driver.findElement(By.id("newPage")).click();
        Set<String> windowNames = driver.getWindowHandles();

        for (String window : windowNames) {
            if (!window.equals(currentWindow)) {
                driver.switchTo().window(window);
            }
        }
        driver.findElement(By.name("q")).sendKeys("Selenium");
    }
}
