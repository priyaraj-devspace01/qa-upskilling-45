package HandleCompenent.handleDropDowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class DropDownHandlePrForStaticDropDownHandle {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://practice.expandtesting.com/dropdown");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // First we need to handle the static dropDown
        // step - 1
        // get the locator for select dropdown
        WebElement dropDown1 = driver.findElement(By.xpath("//select[@id='dropdown']"));


        // step -2
        // create the object of Select class, by passing the locator as the constructor value
        Select select = new Select(dropDown1);


        // Now we can select the value based on three conditions
        /*
            i) select.selectByVisibleText("string value");
            ii) select.selectByIndex(int index).
            iii)select.selectByValue("string value")

         */

        //i)
//        select.selectByVisibleText("Option 1");
        //ii)
//        select.selectByValue("2"); // if the value is existing
//        iii)
        select.selectByIndex(2);


        System.out.println("Clicked successfully . all three ");


        Thread.sleep(2000);
        driver.quit();



    }
}
