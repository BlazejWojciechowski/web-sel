package blaze.springframework.actions;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class UploadTest {

    @Test
    public void uploadFile() throws IOException {

        BasicActionsTest basicActionsTest = new BasicActionsTest();
        WebDriver driver = basicActionsTest.getDriver("firefox");
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/fileupload.html");

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File beforeUpload = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(beforeUpload, new File("src/test/resources/beforeUpload.png"));

        driver.findElement(By.id("myFile")).sendKeys("C:\\Users\\User\\Desktop\\sample.txt");
        File afterUpload = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(afterUpload, new File("src/test/resources/afterUpload.png"));
    }
}
