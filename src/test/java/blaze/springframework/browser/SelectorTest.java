package blaze.springframework.browser;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SelectorTest {

    @Test
    public void findElements() {
        WebDriver driver = getDriver("firefox");
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        /*
        By buttonId = By.id("clickOnMe");
        driver.findElement(buttonId).click();
                WebElement clickOnMeButton = driver.findElement(buttonId);
                clickOnMeButton.click();
         */

        /*
        By firstName = By.name("fname");
        driver.findElement(firstName);
        */

        /*
        By paraHidden = By.className("topSecret");
        driver.findElement(paraHidden);
         */

        /*
        By inputLocator = By.tagName("input");
        WebElement input = driver.findElement(inputLocator);
        input.sendKeys("Pierwszy");
        List<WebElement> inputs = driver.findElements(inputLocator);
        System.out.println(inputs.size());
         */

        /*
        By linkText = By.linkText("Visit W3Schools.com!");
        driver.findElement(linkText);
         */

        /*
        By partialLink = By.partialLinkText("Visit");
        driver.findElement(partialLink);
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
