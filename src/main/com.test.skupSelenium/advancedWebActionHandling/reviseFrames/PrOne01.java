package advancedWebActionHandling.reviseFrames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class PrOne01 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://practice-automation.com/iframes/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        // now we have a search box which is inside a frame which we can't locate directly, the only way is to switch to the respective frame
         //1) Always remember that even if we have the correct xpath, we are not able to locate, the reason must be due to
//            i) not in the current frame.
//              ii) may need some delay to be appeared.

          // to access the iframe
        //way -1 by index
        // first try to normally locate an element inside an iframe
//        driver.switchTo().frame(0);
        // way -1 for switching to iframe

        //way-2
        // by id or name of frame (if exists)
        driver.switchTo().frame("iframe-1"); // via id attribute
//        driver.switchTo().frame("top-iframe"); // via name attribute


        // way - 3 .. if id or name is not there pass the

        WebElement element = driver.findElement(By.xpath("//*[@class='hero__title heroTitle_ohkl']"));
        System.out.println(element.getText()); // although the wait is there still we can't locate it as inside another frame
    // so we need to switch to the iframe first


        Thread.sleep(2000);
        driver.quit();


    }
}
