package advancedWebActionHandling.scrollIntoViewTo;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ScrollIntoViewPr04 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver  =  new ChromeDriver();
        driver.get("https://www.amazon.com");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

       // way -1
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,1000)");



        // way -2
//
        WebElement backToTop = driver.findElement(By.xpath("//div[@class='navFooterBackToTop']"));
//        Actions action = new Actions(driver);
//        action.scrollToElement(backToTop).perform();



        //way-3
        //  even smoother
        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].scrollIntoView({behavior:'smooth', block:'center'});",
                backToTop
        );

        // always do these using gpt, for smooth animation

        Thread.sleep(2000);
        driver.quit();



    }
}
