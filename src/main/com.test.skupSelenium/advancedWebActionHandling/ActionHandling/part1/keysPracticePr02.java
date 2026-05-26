package advancedWebActionHandling.ActionHandling.part1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.time.Duration;

public class keysPracticePr02 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // find the search box to search for Apple MacBook pro in one by one key letter


        String item = "Apple MacBook M3 Pro";

        WebElement searchBox = driver.findElement(By.xpath("//*[@placeholder='Search Amazon']"));

        Actions action = new Actions(driver);
        Thread.sleep(2000);
        action.moveToElement(searchBox).click().perform();

         // first of all we need to break down the entire string into small words to pass one by one
        char[] chars = item.toCharArray();

        for(char c : chars){
            if(Character.isUpperCase(c))
            {
                action.keyDown(Keys.SHIFT).
                sendKeys(String.valueOf(c))
                        .keyUp(Keys.SHIFT)
                        .pause(Duration.ofMillis(500));
            }else {
                action.sendKeys(String.valueOf(c))
                        .pause(Duration.ofMillis(500));
            }
        }
        action.build().perform();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='s-suggestion s-suggestion-ellipsis-direction' and @aria-label='apple macbook m3 pro']")).click();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement resultStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='a-size-medium-plus a-spacing-none a-color-base a-text-bold']")));
        System.out.println("success : " + resultStatus.getText() + "found for searched item ...done ...");
        Assert.assertEquals(resultStatus.getText(), "Results");

        driver.quit();


    }
}
