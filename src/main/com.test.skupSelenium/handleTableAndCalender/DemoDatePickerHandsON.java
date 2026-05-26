package handleTableAndCalender;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DemoDatePickerHandsON {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

       driver.findElement(By.xpath("//table[@id='datepickers']//tr//td//input[@id='first_date_picker']")).click();
       // click on the calendar
        while(!driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText().contains("December"))
        {
            driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
            Thread.sleep(500);
        }

        System.out.println("December got selected . ");


        Thread.sleep(3000);
        driver.quit();



    }
}
