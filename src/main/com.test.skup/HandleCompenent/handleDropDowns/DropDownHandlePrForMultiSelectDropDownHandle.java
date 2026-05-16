package HandleCompenent.handleDropDowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class DropDownHandlePrForMultiSelectDropDownHandle {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://vinothqaacademy.com/drop-down/");
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // Need to handle the Multi Select dropDown
        WebDriverWait wait  =  new WebDriverWait(driver, Duration.ofSeconds(10));
       String gettext =  wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[text()='Multiple Select']")))).getText();
        Assert.assertEquals(gettext, "Multiple Select");


        WebElement multiSelect = driver.findElement(By.xpath("//select[@name='programming']"));
        Select select = new Select(multiSelect);

        boolean isMultiples = select.isMultiple();
        // it selects first three based on index

//        if(isMultiples)
//        {
//            for(int i = 1;i<=3;i++)
//            {
//                select.selectByIndex(i);
//            }
//        }


        /// 2) select based on visibleText as well
//        List<String> langs = new ArrayList<>(List.of("Java","Ruby", "JavaScript"));
//        if(isMultiples)
//        {
//            for(int i = 0;i<langs.size();i++)
//            {
//                select.selectByVisibleText(langs.get(i));
//            }
//        }



        /// 3) Similarly we can do for selectByValue as well if we have value as attribute their
        // but not for here





        System.out.println("SUCCESS .");

        Thread.sleep(2000);
        driver.quit();




        /*
        ALWAYS AS SIMILAR TO SELECTING WE HAVE THREE APPROACHES FOR DESELECT ALSO WE HAVE SAME WITH ONE EXTRAA AS
        /// note ---- select.deselectAll();
         */



    }
}
