package blaze.springframework;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest {
    @Test
    public void openGooglePage() {
        WebDriver driver = getDriver("firefox");

        //Zmiana wielkości okna
        driver.manage().window().maximize();
        //Dimension windowSize = new Dimension(200, 200);
        //driver.manage().window().setSize(windowSize);

        driver.get("https://www.google.pl/");

        //Rzutowanie na JS
        //JavascriptExecutor executor = (JavascriptExecutor) driver;
        //executor.executeScript("window.open('https://google.com','blank','height=200, width=200')");

        WebElement agreeButton = driver.findElement(
                                By.xpath("//div[text()='Zaakceptuj wszystko']"));
        agreeButton.click();

        WebElement searchField = driver.findElement(
                                By.name("q"));
        searchField.sendKeys("Selenium");
        searchField.sendKeys(Keys.ENTER);

        WebElement result = driver.findElement(
                            By.xpath("//a[contains(@href, 'selenium.dev')]//h3"));
        Assert.assertTrue(result.isDisplayed());

        //driver.quit();
    }
    public WebDriver getDriver(String browser) {
        switch (browser) {
            case "chrome":
                String chromePath = "C:\\Users\\User\\chromedriver_win32\\chromedriver.exe";
                System.setProperty("webdriver.chrome.driver", chromePath);
                return new ChromeDriver();
            case "firefox":
                String firefoxPath = "C:\\Users\\User\\Downloads\\geckodriver-v0.33.0-win64\\geckodriver.exe";
                System.setProperty("webdriver.gecko.driver", firefoxPath);
                return new FirefoxDriver();
            default:
                throw new InvalidArgumentException("Invalid browser name");
        }
    }
}
