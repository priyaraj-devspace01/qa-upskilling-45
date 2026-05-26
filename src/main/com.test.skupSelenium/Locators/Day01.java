package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day01 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://omayo.blogspot.com/");

      // Locate the web-element by id
        WebElement btn = driver.findElement(By.id("timerButton"));
        btn.click();

//         By name
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("hello");
        Thread.sleep(2000);
        searchBox.clear();


        // By className
        WebElement searchTop = driver.findElement(By.className("ENqPLc"));
        searchTop.sendKeys("apple");
        driver.findElement(By.className("m3Blcf")).click();

        // By xpath
        driver.findElement(By.xpath("//input[@id='timerButton']")).getText();

        // By link text
        driver.findElement(By.linkText("Gmail")).click();

        // By partial link text
        driver.findElement(By.partialLinkText("Gma")).click();






    }
}
