package HandleCompenent.handleFrames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HandlingFrameComponent {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver =  new ChromeDriver();
        driver.get("https://practice-automation.com/iframes/");
        driver.manage().window().maximize();



        //h1[@class='hero__title heroTitle_ohkl']  // supposw this is a h1 we need to directly locate it without switching to the iframe

       /// CASE -1
        // let's find using explicit wait
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='hero__title heroTitle_ohkl']")));
//        Assert.assertTrue(header.isDisplayed(), "header is not able to directly accessible as inside the iframe . ");


        // solution, first we need to switch to the frame inside which the header is present
///        CASE - 2

        /// case - 2.1
//        driver.switchTo().frame("iframe-1");

        // this is switched using the frame id or name attribute,
          // we can switch using index and webElement as well


///       case - 2.2
//        driver.switchTo().frame(0);  // always remember the index starts from '0' always when we try to access based on index

        /// case - 2.3
           // first find the iframe if the id or name value is not there,
        WebElement frame2 = driver.findElement(By.xpath("//iframe[contains(@id,'iframe-1') and contains(@title, 'Playwright')]"));
        driver.switchTo().frame(frame2);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='hero__title heroTitle_ohkl']")));
        Assert.assertTrue(header.isDisplayed(), "header is not able to directly accessible as inside the iframe . ");
        System.out.println("header is visible with text : "+ header.getText());



        /// at this point we are inside the child -1 frame, if we want to get the parent element we can't
         /// parent footer text - which is not allowed here

//        System.out.println(  driver.findElement(By.xpath("//div[@class='copyright-text text-center']")).getText());
        // but if we switch to parent then we can,

//       ......1)  driver.switchTo().parentFrame();
//        System.out.println(  driver.findElement(By.xpath("//div[@class='copyright-text text-center']")).getText());

//        ....2)  // or else since here only one level of parent child layer we can also use the 'defaultContent' switching to main page to get the footer text
        driver.switchTo().defaultContent();
        System.out.println(  driver.findElement(By.xpath("//div[@class='copyright-text text-center']")).getText());

        System.out.println("footer text got successfully . ");

        /// now two things to return back to the main page or to find any child frame parent frame


//        /// - to return back to the main page
//        driver.switchTo().defaultContent();

        /// - to go back to the parent frame
        driver.switchTo().parentFrame();



        Thread.sleep(2000);
        driver.quit();
    }
}
