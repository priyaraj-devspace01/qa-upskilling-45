package advancedWebActionHandling.ActionHandling.part1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

public class PracticeOne {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement accSection = driver.findElement(By.xpath("//div[@class='nav-div']/a[@class='nav-a nav-a-2   nav-progressive-attribute']"));

        // we can click on it but if we want to hover over there to get all the account details setting we need to hover over there as well
        Actions actions = new Actions(driver);
//        actions.moveToElement(accSection).perform();

        // get all the acc details settings and print
        List<WebElement> accDetails = driver.findElements(By.xpath("//span[@class='nav-text']"));
        System.out.println("the all account setting is there  : are below : ");
        for(WebElement accDetail : accDetails) {
            System.out.println(accDetail.getText());
        }


        // now perform group of operations together
        actions.moveToElement(accSection)
                        .moveToElement(driver.findElement(By.xpath("//span[@class='nav-text' and text()='Account']")))
                                .click()
                                        .build()
                                                .perform();
        // here, .build combine all the actions and perform execute all the actions.



        Thread.sleep(2000);
        driver.quit();


    }
}
