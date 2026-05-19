package advancedWebActionHandling.ActionHandling.part1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.devtools.v145.debugger.Debugger.pause;

public class DragAndDropPr03 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // there are two ways we can perform the drag and drop operation
        //1) by using dragAndDrop(WebElement, src, target)
        //2) by using dragAndDropBy(WebElement, X-offset, y-offset)

       WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
       driver.switchTo().frame(frame);

        // Way - 1
//           using src and target

//        WebElement src = driver.findElement(By.xpath("//img[@alt='The peaks of High Tatras']"));
        WebElement trt = driver.findElement(By.xpath("//div[@class='ui-widget-content ui-state-default ui-droppable']"));
        Actions action = new Actions(driver);
//        action.dragAndDrop(src, trt).perform();
        // let's try to move all the src images to the destination
        List<WebElement> srcImgs = driver.findElements(By.xpath("//li[@class='ui-widget-content ui-corner-tr ui-draggable ui-draggable-handle']/img"));
        for(WebElement img : srcImgs){
            action.dragAndDrop(img, trt)
                    .pause(Duration.ofMillis(1000))
                    .build()
                    .perform();

        }

        System.out.println("successfully dragged and drop to the destination ..  ");


        Thread.sleep(2000);
        driver.quit();

    }
}
