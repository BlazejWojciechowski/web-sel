package blaze.springframework.browser;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CssSelectorTest {
    @Test
    public void findElements() {
        WebDriver driver = getDriver("firefox");
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        /*
        By cssId = By.cssSelector("#clickOnMe");
        driver.findElement(cssId);
        */

        /*
        By cssClass = By.cssSelector(".topSecret");
        driver.findElement(cssClass);

        /*
        By cssTagName = By.tagName("input");
        driver.findElement(cssTagName).sendKeys("Pierwszy");
        */

        /*
        By cssName = By.cssSelector("[name ='fname']");
        driver.findElement(cssName);
         */

        /*
        By all = By.cssSelector("*");
        driver.findElements(all);
         */

        /*
        By ulInsideDiv = By.cssSelector("div ul");
        driver.findElement(ulInsideDiv);
         */

        /*
        By trInTable = By.cssSelector("table tr");
        driver.findElement(trInTable);
         */

        /*
        By trInBody = By.cssSelector("tbody tr");
        driver.findElement(trInBody);
         */

        /*
        By firstFormFromLabel = By.cssSelector("label + form");
        driver.findElement(firstFormFromLabel);
         */

        /*
        By allFormFromLabel = By.cssSelector("label ~ form");
        driver.findElement(allFormFromLabel);
         */

        /*
        By attrTag = By.cssSelector("input[name='fname']");
        driver.findElement(attrTag);
         */

        /*
        By firstChild = By.cssSelector("li:first-child");
        driver.findElement(firstChild);
         */

        /*
        By lastChild = By.cssSelector("li:last-child");
        driver.findElement(lastChild);
         */

        /*
        By thirdChild = By.cssSelector("li:nth-child(3)");
        driver.findElement(thirdChild);
         */


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
