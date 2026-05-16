package HandleCompenent.handleDropDowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class DropDownHandlePrForDynamicDropDown {
    public static void main(String[] args) throws InterruptedException {


         // Now let's handle the dynamic dropdown for auto suggestions can't be handle through the Select
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.automationtesting.in/AutoComplete.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


        WebElement searchCity = driver.findElement(By.xpath("//input[@id='searchbox']"));
        Actions actions = new Actions(driver);
        actions.click(searchCity)
                .sendKeys("I")
                .pause(Duration.ofMillis(500))
                .sendKeys("N")
                .pause(Duration.ofMillis(500))
                .sendKeys("D")
                .perform();

        Thread.sleep(1000);
        ///Let's get the list of countries to select India properly
        List<WebElement> cntries = driver.findElements(By.xpath("//li[@class='ui-menu-item']//a"));
        for(WebElement cntrie : cntries) {
           if(cntrie.getText().equals("India")) {
               cntrie.click();
           }
        }
        Thread.sleep(1000);
        System.out.println("selected india successfully .. ");






        driver.quit();



    }
}
