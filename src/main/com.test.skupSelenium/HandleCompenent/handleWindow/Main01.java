package HandleCompenent.handleWindow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.image.CropImageFilter;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Main01 {
    public static void main(String[] args) throws InterruptedException {
        /*
   // ==============================
// WINDOW HANDLING IN SELENIUM
// ==============================

// Definition:
// Window Handling is used to switch control between multiple browser windows/tabs.


// ==============================
// MAIN METHODS
// ==============================


// getWindowHandle()
// Returns current window ID.
// Used for parent window handling.

String parentWindow = driver.getWindowHandle();

System.out.println(parentWindow);



// getWindowHandles()
// Returns IDs of all opened windows/tabs.

Set<String> allWindows = driver.getWindowHandles();

System.out.println(allWindows);



// switchTo()
// Used to switch control to another window, frame, or alert.

driver.switchTo().window(windowID);



// ==============================
// BASIC WINDOW HANDLING FLOW
// ==============================

// Step 1 -> Store parent window
String parent = driver.getWindowHandle();


// Step 2 -> Open new window/tab
driver.findElement(By.linkText("Open")).click();


// Step 3 -> Get all windows
Set<String> windows = driver.getWindowHandles();


// Step 4 -> Switch to child window
for(String win : windows)
{
    if(!win.equals(parent))
    {
        driver.switchTo().window(win);
    }
}


// ==============================
// IMPORTANT INTERVIEW POINTS
// ==============================

// getWindowHandle()  -> Single window ID
// getWindowHandles() -> Multiple window IDs
// switchTo().window() -> Switch control between windows
// close() -> Closes current window
// quit() -> Closes all browser windows
         */


        // Practical Implementation
        WebDriver driver =  new ChromeDriver();
        driver.get("https://omayo.blogspot.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // click to open a new window
        WebElement ele = driver.findElement(By.linkText("Open a popup window"));
        System.out.println(ele.isDisplayed());
        ele.click();

        // as all tabs opened in browser having some id first capture them all by using the getWindowhandle METHOD
        Set<String> windowIds = driver.getWindowHandles();

        // now Iterate to get any specific window to perform any operation except from parent window
        // approach -1
        //     using iterator
        Iterator<String> itr = windowIds.iterator();
        String parentWindowId = itr.next();
//        System.out.println("parent id: "+ parentWindowId);
//        String childWindowId = itr.next();
//        System.out.println("child id : "+ childWindowId);

        /// now we can easily switch using method (switchTo().window(windowid));
//        driver.switchTo().window(childWindowId);
//        System.out.println("Successfully reached to child window . ");

        /// fetch the content from child window
//        String text = driver.findElement(By.xpath("//h3[text()='New Window']")).getText();
//        System.out.println("Fetched : - "+ text);

        /// switch again to parent window and quit from browser by closing all tabs
//        Thread.sleep(1000);
//        driver.switchTo().window(parentWindowId);
//        Thread.sleep(3000);
//        driver.quit();

        // Approach -2 (using for each loop) if our case having only one child window .
        for(String id : windowIds)
        {
            if(id != parentWindowId)
            {
                driver.switchTo().window(id);
            }
        }

        // then the same operation
        // fetch the content from child window
        String text = driver.findElement(By.xpath("//h3[text()='New Window']")).getText();
        System.out.println("Fetched text from child window  : - "+ text);

        // switch again to parent window and quit from browser by closing all tabs
        Thread.sleep(1000);
        driver.switchTo().window(parentWindowId);
        System.out.println("successfully landed to parent window agan , now quiting ... ");
        Thread.sleep(3000);
        driver.quit();


        // in case of more than two windows we can iterate while moving to itr.next()
        /*
        //// SOLUTION -------------
        // ============================================================
// Problem Statement:
// Multiple browser windows/tabs are opened.
// Need to switch to the correct window based on page title
// and fetch required data from that window.
// ============================================================



// ============================================================
// APPROACH 1 : Using Enhanced For Loop
// ============================================================

Set<String> windows = driver.getWindowHandles();

for(String win : windows)
{
    // Switch to next window
    driver.switchTo().window(win);

    // Verify correct window using title
    if(driver.getTitle().contains("Expected Title"))
    {
        // Fetch required data
        String data = driver.findElement(By.id("demo")).getText();

        System.out.println(data);

        break;
    }
}



// ============================================================
// APPROACH 2 : Using Iterator + While Loop
// ============================================================

Set<String> allWindows = driver.getWindowHandles();

Iterator<String> itr = allWindows.iterator();

while(itr.hasNext())
{
    String win = itr.next();

    // Switch to next window
    driver.switchTo().window(win);

    // Verify correct window using title
    if(driver.getTitle().contains("Expected Title"))
    {
        // Fetch required data
        String data = driver.findElement(By.id("demo")).getText();

        System.out.println(data);

        break;
    }
}
         */




    }
}
