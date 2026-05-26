package advancedWebActionHandling.takeScreenShot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class PracticeDemoPr01 {

    public static void main(String[] args) throws IOException, InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(2000);
        // close login popup
        WebElement cross = driver.findElement(By.xpath("//*[@class='b3wTlE']"));

        // click cart
        WebElement cart = driver.findElement(By.xpath("//div[@class='H5bs2Y']/a[@title='Cart']"));

        Actions action =  new Actions(driver);
        action.moveToElement(cross)
                .pause(Duration.ofSeconds(1))
                .moveToElement(cart)
                .pause(Duration.ofSeconds(1))
                .click()
                .build()
                .perform();

        // take screenshot
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // destination path
        File dest = new File("./SC/screenshot1.png");

        // copy screenshot
        FileUtils.copyFile(src, dest);

        System.out.println("Screenshot taken successfully");

        driver.quit();
    }
}