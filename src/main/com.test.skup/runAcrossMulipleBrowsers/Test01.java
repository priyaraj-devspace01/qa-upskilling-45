package runAcrossMulipleBrowsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Scanner;

public class Test01 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter browser name (chrome/firefox): ");

        String choose = sc.nextLine().trim().toLowerCase();

        System.out.println("You entered: " + choose);

        WebDriver driver = null;

        switch (choose) {

            case "chrome":
                System.out.println("Launching Chrome...");
                driver = new ChromeDriver();
                break;

            case "firefox":
                System.out.println("Launching Firefox...");
                driver = new FirefoxDriver();
                break;

            default:
                System.out.println("Invalid browser selected");
                sc.close();
                return;
        }

        driver.manage().window().maximize();

        driver.get("https://www.google.com");

        System.out.println("Page Title: " + driver.getTitle());

        driver.quit();

        sc.close();
    }
}