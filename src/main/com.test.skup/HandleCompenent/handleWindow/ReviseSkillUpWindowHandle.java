package HandleCompenent.handleWindow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class ReviseSkillUpWindowHandle {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        driver.manage().window().maximize();


        // click two child window and get the required window extracted data
        driver.findElement(By.id("newWindowBtn")).click();
        // click another child window
        driver.findElement(By.id("newTabBtn")).click();


       Set<String> windows =  driver.getWindowHandles();

       // i want the window contains basic controls
        Iterator<String> itr  =  windows.iterator();
        String msg = "";
        while(itr.hasNext())
        {
           String wid  =  itr.next();
            driver.switchTo().window(wid);
            if(driver.getCurrentUrl().contains("/basic-controls")){
               msg =  driver.findElement(By.xpath("//h1[text()='Basic Controls in HTML']")).getText();


            }
        }
        System.out.println("extracted data is : "+ msg);
        driver.quit();



    }
}
