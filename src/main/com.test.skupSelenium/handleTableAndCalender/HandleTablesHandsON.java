package handleTableAndCalender;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HandleTablesHandsON
{
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/webtables");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // let's suppose we want to print all the table headers
        List<WebElement> headers = driver.findElements(By.xpath("//table[@class=\"-striped -highlight table table-striped table-bordered table-hover\"]//thead//tr//th"));
        System.out.println(headers.size());
        for(WebElement header  :headers)
        {
            System.out.print(header.getText()+  " | ");

        }
        System.out.println();

       // NOW IF WE ALREADY KNOW THE ROW NUMBER AND COLUMN NUMBER WE CAN EASILY GET THE DATA
        // LET
         int row = 2;
        int column = 3;

        String xpath = "//table[contains(@class,'table-striped')]//tbody//tr["
                + row + "]//td[" + column + "]";

        WebElement value = driver.findElement(By.xpath(xpath));

        System.out.println("the value at required index is : " + value.getText());
        System.out.println();
        Thread.sleep(2000);
        driver.quit();
    }
}
