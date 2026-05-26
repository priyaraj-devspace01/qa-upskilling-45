package HandleCompenent.handleAlerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Time;
import java.time.Duration;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

public class AlertHandleDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.automationtesting.in/Alerts.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
       // type- 1 (alert only having text)
//        driver.findElement(By.xpath("//a[@href='#OKTab']")).click();
//        driver.findElement(By.xpath("(//button[contains(concat(\" \", normalize-space(@class), \" \"), \" btn \")])[2]")).click();
//        Alert alert = driver.switchTo().alert();
//        alert.accept();
//        System.out.println(alert.getText());

        // type - 2
        // alert with accept and cancel button
//        driver.findElement(By.xpath("(//button[contains(concat(\" \", normalize-space(@class), \" \"), \" btn \")])[3]")).click();
//        Thread.sleep(3000);
//        Alert alert2 = driver.switchTo().alert();
//        String choice = "accept";
//        if(choice.equals("accept")) {
//            alert2.accept();
//        }
//        else {
//                alert2.dismiss();
//        }

        // Type- 3
        // alerts having input to give
        driver.findElement(By.xpath("(//button[contains(concat(\" \", normalize-space(@class), \" \"), \" btn \")])[4]")).click();
        Thread.sleep(3000);
        Alert alert3 = driver.switchTo().alert();
        alert3.sendKeys("apple");


        Thread.sleep(1000);
        alert3.accept();
        driver.quit();

    }
}
