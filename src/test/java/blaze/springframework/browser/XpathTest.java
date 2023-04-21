package blaze.springframework.browser;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class XpathTest {

    @Test
    public void findElements() {
        WebDriver driver = getDriver("firefox");
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        /*
        By fullPath = By.xpath("/html/body/div/ul");
        driver.findElement(fullPath);
         */

        /*
        By shortPath = By.xpath("//ul");
        driver.findElements(shortPath);
         */

        /*
        By cssId = By.xpath("/html/body/button[@id='clickOnMe']");
        driver.findElement(cssId);
         */

        /*
        By cssName = By.xpath("//input[@name='fname']");
        driver.findElement(cssName);
         */

        /*
         By cssClass = By.xpath("//p[@class='topSecret']");
         driver.findElement(cssClass);
        */

        /*
        By inputLocator = By.xpath("//input");
        WebElement input = driver.findElement(inputLocator);
        input.sendKeys("Pierwszy");
        List<WebElement> inputs = driver.findElements(inputLocator);
        System.out.println(inputs.size());
         */

        /*
        By linkText = By.xpath("//a[text()='Visit W3Schools.com!']");
        driver.findElement(linkText);
         */

        /*
        By partialLink = By.xpath("//a[contains(text(),'Visit')]");
        driver.findElement(partialLink);
         */

        /*
        By allXpath = By.xpath("//*");
        driver.findElements(allXpath);
         */

        /*
        By lastElement = By.xpath("(//input)[last()]");
        driver.findElements(lastElement);
         */

        /*
        By secondElement = By.xpath("(//input)[2]");
        driver.findElements(secondElement);
         */

        /*
        By elementWithAttr = By.xpath("//*[@name]");
        driver.findElements(elementWithAttr);
         */

        /*
        By attrEq = By.xpath("//button[@id='clickOnMe']");
        driver.findElements(attrEq);
         */

        /*
        By attrNotEq = By.xpath("//button[@id!='clickOnMe']");
        driver.findElements(attrNotEq);
         */

        /*
        By attrCont = By.xpath("//*[contains(@name, 'ame')]");
        driver.findElements(attrCont);
         */

        /*
        By startsWith = By.xpath("//*[starts-with(@name, 'user')]");
        driver.findElements(startsWith);
         */

        /*
        By child = By.xpath("//div/child::ul");
        driver.findElements(child);
         */

        /*
        By desc = By.xpath("//div/descendant::ul");
        driver.findElements(desc);
         */

        /*
        By asc = By.xpath("//div/ancestor-or-self::*");
        driver.findElements(asc);
         */

        /*
        By foll = By.xpath("//img/following::*");
        driver.findElements(foll);
         */

        /*
        By follSib = By.xpath("//img/following-sibling::*");
        driver.findElements(follSib);
         */

        /*
        By prec = By.xpath("//img/preceding::*");
        driver.findElements(prec);
         */

        /*
        By precSib = By.xpath("//img/preceding-sibling::*");
        driver.findElements(precSib);
         */

        /*
        By divsAndLinks = By.xpath("//a | //div");
        driver.findElements(divsAndLinks);
         */

        /*
        By andOp= By.xpath("//input[@name='fname' and @id='fname']");
        driver.findElements(andOp);
         */

        /*
        By orOp= By.xpath("//input[@name='fname' or @id='fnam']");
        driver.findElements(orOp);
         */

        /*
        By test = By.xpath("//*[@id=\"clickOnMe\"]");
        driver.findElements(test);
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
