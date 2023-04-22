package blaze.springframework.actions;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class PageInfoTest {

    @Test
    public void getPageInfo() {

        BasicActionsTest basicActionsTest = new BasicActionsTest();
        WebDriver driver = basicActionsTest.getDriver("firefox");
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
    }
}
