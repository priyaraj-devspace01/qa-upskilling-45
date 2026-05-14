package HandleCompenent.handleWaiting;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class Handson01 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/waits-demo.html");
        driver.manage().window().maximize();

        /// WAY-2 USING IMPLICIT WAIT AS GLOBAL WAIT WHICH IS WORKABLE BUT NOT SUITABLE WHEN AN OTHER ELEMENT IS NOT THERE , IT WILL WAIT FOR UNNECESSARY WAIT TO FAIL
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));


        // scenario - Textbox1 will be displayed after 5 seconds
        WebElement txtBoxOne = driver.findElement(By.xpath("//button[@id='btn1']"));
        txtBoxOne.click();

        // after clicking on the button to get the text area it will take 5 seconds to appear
        // so if we try to get it, we can't without wait

        // like
//        Thread.sleep(5000); ///-----WAY-1 - but insufficient as waiting for unnecessary time.
//        boolean isDisplayed = driver.findElement(By.xpath("(//input[@id='txt1'])[1]")).isDisplayed();
        // without wait, it tries to fetch it immediately which is not there
        // we can wait using,
        //1) Thread.sleep(5000);
//        System.out.println("isDisplayed : "+isDisplayed);



        /// finally we have explicit wait where instead of setting one global wait we can set the waiting time for individual element
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//       WebElement textboxget =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='txt1'])[1]")));
//       textboxget.sendKeys("Apple");

// Fluent Wait -> waits with polling frequency and ignores exceptions

        Wait<WebDriver> wait2 = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        WebElement textboxget2 = wait2.until(driver2 -> driver2.findElement(By.xpath("(//input[@id='txt1'])[1]")));

        textboxget2.sendKeys("Apple");
        Thread.sleep(2000);
        driver.quit();

    }
}
