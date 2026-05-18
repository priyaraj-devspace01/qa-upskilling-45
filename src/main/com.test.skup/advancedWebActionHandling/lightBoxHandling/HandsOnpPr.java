package advancedWebActionHandling.lightBoxHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;

public class HandsOnpPr {
    public static void main(String[] args) throws InterruptedException {
        // switching to the light box is not required always
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://selenium-by-arun.blogspot.com/2017/05/handling-lightbox-using-selenium.html");

        WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement lghtBoxImg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='separator']")));
        lghtBoxImg.click();

        Thread.sleep(2000);
        System.out.println("Successfully opened the light box image . ");


        // click on cross to close
        driver.findElement(By.xpath("//div[@class='CSS_LIGHTBOX_BTN_CLOSE CSS_LIGHTBOX_BTN_CLOSE_POS']")).click();
        Thread.sleep(2000);
        System.out.println("Successfully closed the light box image by using cross button .. ");

        driver.quit();


    }
}
