package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day011 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        // other additional webdriver api commands need to remember
        // get the page title
        System.out.println("title "+ driver.getTitle());
        // get the current page url
        System.out.println(driver.getCurrentUrl());

        // close vs quit
//        webDriver.Close() - Close the browser window that the driver has focus of
//        webDriver.Quit() - Calls Dispose()
//        webDriver.Dispose() Closes all browser windows and safely ends the session
//        Thread.sleep(2000);

       driver.findElement(By.partialLinkText("Posts ")).click();
//       driver.close();
//        driver.quit();

        // getText vs getAttribute
        // getText - is used to get the test value inside the HTML tag start and end
        // getAttribute - is used to get the attribute their values

        String attribute = driver.findElement(By.id("field1")).getAttribute("value");
        System.out.println("attribute value is  : "+ attribute);

        driver.quit();

        // isDisplayed
        WebDriver driver2 = new ChromeDriver();
        driver2.get("https://omayo.blogspot.com/");
        boolean isBtnDisplayed = driver.findElement(By.xpath("(//*[@name='samename'])[2]")).isDisplayed();
        System.out.println(isBtnDisplayed);

        // isEnabled
        boolean isEnabled = driver.findElement(By.id("but1")).isEnabled();
        if(isEnabled)
        {
            driver.findElement(By.id("but1")).click();
            System.out.println("success . ");
        }

        /*
        // ==============================
// SELENIUM WEBDRIVER METHODS NOTES
// ==============================

// isSelected()
// Used to check whether a Radio Button or Checkbox is selected or not.

WebElement checkbox = driver.findElement(By.id("remember"));
System.out.println(checkbox.isSelected());


// navigate()
// Used for browser navigation operations.

driver.navigate().to("https://google.com"); // Open URL
driver.navigate().back();                   // Back
driver.navigate().forward();                // Forward
driver.navigate().refresh();                // Refresh page


// getPageSource()
// Returns complete HTML source code of current page.

String source = driver.getPageSource();
System.out.println(source);


// submit()
// Used to submit a form.

driver.findElement(By.name("q")).submit();


// getTagName()
// Returns HTML tag name of element.

WebElement searchBox = driver.findElement(By.name("q"));
System.out.println(searchBox.getTagName()); // input


// getCssValue()
// Returns CSS property value of element.

String color = driver.findElement(By.id("home"))
                     .getCssValue("line-height");

System.out.println(color);


// getSize()
// Returns height and width of element.

Dimension d = driver.findElement(By.id("but2")).getSize();

System.out.println("Height = " + d.height);
System.out.println("Width = " + d.width);


// getLocation()
// Returns x and y coordinate position of element.

Point p = driver.findElement(By.id("but2")).getLocation();

System.out.println("X Coordinate = " + p.x);
System.out.println("Y Coordinate = " + p.y);


// fullscreen()
// Opens browser in full screen mode.

driver.manage().window().fullscreen();


// findElements()
// Returns multiple matching WebElements in List form.

List<WebElement> links = driver.findElements(By.tagName("a"));

for(WebElement link : links)
{
    System.out.println(link.getText());
}


// ==============================
// IMPORTANT DIFFERENCE
// ==============================

// findElement()
// Returns single WebElement.
// Throws NoSuchElementException if not found.

driver.findElement(By.id("email"));


// findElements()
// Returns List<WebElement>.
// Returns empty list if elements not found.

driver.findElements(By.tagName("a"));


// ==============================
// QUICK INTERVIEW POINTS
// ==============================

// getText()       -> Fetch visible text
// getAttribute()  -> Fetch attribute value
// isDisplayed()   -> Check visibility
// isEnabled()     -> Check enabled/disabled state
// isSelected()    -> Check checkbox/radio selection
         */






    }
}
