Day -0 
1) Manual Testing - testing wihthout using any tool.
2) Automation Testing - testing using automation tool/scrips on the behalf of tester.
3) How Automation works  - code -> provide to the automation tool -> execute the scrips


   Selenium - is a open source automation testing suite of tools which having mainly 4 components.
   i)  SE IDE
   ii) SE Webdriver.(major)
   iii) SE rc
   iv) SE gird(major)


-> Selenium is primarily used for web bases automation testing.
-> it primarily supports native browsers such as chrome, firefox, edge and works across multiple platform such as
linux, mac and windows.
-> it also supports languages like java, python, ruby etc.


LOCATORS:
selenium has the ability to perform the actions on the elements present on the ui but it doesn't has the
capability to uniquely locate the web element.  
    there it takes the help of locators to locate the web elements uniquely on web application and perform the corresponding operations

## Selenium WebDriver Archtiecture
<img width="1152" height="648" alt="image" src="https://github.com/user-attachments/assets/70fae179-b74a-443b-8a18-9985897da3c3" />
# Selenium WebDriver Architecture

## What is Selenium WebDriver?

Selenium WebDriver is a browser automation tool used to automate web applications.

It helps automate actions like:
- Opening browser
- Clicking buttons
- Entering text
- Selecting dropdowns
- Validating UI behavior

Example:

```java
driver.findElement(By.id("login")).click();
```

---

# Selenium WebDriver Architecture Flow

```text
Java Selenium Code
        ↓
Selenium Client Library
        ↓
W3C WebDriver Protocol (HTTP Request)
        ↓
Browser Driver (ChromeDriver/GeckoDriver)
        ↓
Real Browser
        ↓
Action Performed
        ↓
Response Returned Back
```

---

# Step-by-Step Working

## 1. Java Automation Code

We write Selenium automation code in Java.

Example:

```java
WebDriver driver = new ChromeDriver();

driver.get("https://google.com");
```

At this stage:
- Java understands the code
- Browser cannot understand Java directly

So Selenium converts the code into browser automation commands.

---

## 2. Selenium Client Library

The Selenium Java library acts as a translator.

It:
- Receives Java method calls
- Converts them into HTTP requests

Example methods:

```java
click()
sendKeys()
findElement()
```

These are internally converted into browser commands.

---

## 3. W3C WebDriver Protocol

Selenium communicates with browser drivers using the W3C WebDriver Protocol.

Communication happens through HTTP requests.

Example internal request:

```http
POST /session/{id}/element/{id}/click
```

This standard protocol allows Selenium to support multiple browsers.

---

## 4. Browser Driver

Browser drivers act as bridges between Selenium and browsers.

Examples:
- ChromeDriver → Chrome Browser
- GeckoDriver → Firefox Browser
- EdgeDriver → Edge Browser

Flow:

```text
Selenium → ChromeDriver → Chrome Browser
```

Important:
Selenium never directly controls the browser.

---

## 5. Browser Executes Action

Suppose code is:

```java
driver.findElement(By.id("username")).sendKeys("admin");
```

Browser will:
- Find the element
- Type the text
- Perform the requested action

---

## 6. Response Returns Back

After action execution:

```text
Browser
   ↓
Browser Driver
   ↓
Selenium
   ↓
Java Code Continues
```

If action succeeds:
- Execution continues

If action fails:
- Exception is thrown

Examples:
- NoSuchElementException
- TimeoutException
- StaleElementException

---

# Real Internal Flow

```text
Test Script
   ↓
Selenium WebDriver API
   ↓
W3C WebDriver Protocol
   ↓
Browser Driver
   ↓
Browser
   ↓
Web Application
```

---

# Example Internal Flow

## Code

```java
driver.findElement(By.id("login")).click();
```

## Internal Working

### Step 1
Selenium receives the click request.

### Step 2
Selenium sends HTTP request to ChromeDriver.

### Step 3
ChromeDriver tells Chrome browser:
- Find login element
- Perform click action

### Step 4
Browser performs the click.

### Step 5
Response is returned back to Selenium.

---

# Why Browser Driver is Required

Each browser behaves differently internally.

So Selenium uses different drivers:
- ChromeDriver
- GeckoDriver
- EdgeDriver

Browser drivers understand browser-specific behavior and convert Selenium requests into native browser actions.

---

# Local Execution

Everything runs in the same machine.

```text
Automation Code
ChromeDriver
Chrome Browser
```

Advantages:
- Faster execution
- Simple setup

---

# Remote Execution (Selenium Grid)

Execution happens on remote systems.

Used for:
- Parallel execution
- Cross-browser testing
- CI/CD pipelines

Flow:

```text
Test Script
   ↓
Selenium Grid
   ↓
Remote Machine
   ↓
Browser
```

---

# Common Selenium Exceptions

| Exception | Reason |
|---|---|
| NoSuchElementException | Element not found |
| TimeoutException | Wait time exceeded |
| StaleElementException | DOM refreshed |
| InvalidSelectorException | Invalid XPath/CSS |

---

# Important Points

- Selenium does not directly control browsers
- Browser Driver acts as a bridge
- Communication happens using W3C WebDriver Protocol
- Browser performs actual actions
- Response returns back to Selenium

---

# Simple Analogy

```text
You → Selenium → ChromeDriver → Browser
```

- You give instruction
- Selenium converts instruction
- Driver translates instruction
- Browser performs action

---

# Final Summary

```text
Java Selenium Code
        ↓
Selenium Client Library
        ↓
W3C WebDriver Protocol
        ↓
Browser Driver
        ↓
Browser
        ↓
Action Performed
        ↓
Response Returned
```

This is the complete Selenium WebDriver Architecture workflow.


# Why We Use `WebDriver` Reference

## Example

```java
WebDriver driver = new ChromeDriver();
```

Instead of:

```java
ChromeDriver driver = new ChromeDriver();
```

---

# Reason

`WebDriver` is an interface.

`ChromeDriver`, `EdgeDriver`, and `FirefoxDriver` are implementation classes.

```text
WebDriver
    ↑
-------------------------
↑          ↑           ↑
Chrome   Edge      Firefox
Driver   Driver     Driver
```

---

# Benefits

## 1. Cross-Browser Support

Easy to switch browsers.

```java
WebDriver driver = new EdgeDriver();
```

No framework code changes needed.

---

## 2. Loose Coupling

Framework depends on common browser behavior, not browser-specific classes.

Follows:
- Abstraction
- OOP principles

---

## 3. Runtime Polymorphism

```java
WebDriver driver = new ChromeDriver();
```

- Reference type → `WebDriver`
- Object type → `ChromeDriver`

Provides flexibility at runtime.

---

# Why Driver Path Was Required Earlier

Earlier Selenium required manual driver setup.

Example:

```java
System.setProperty(
"webdriver.chrome.driver",
"./drivers/chromedriver.exe"
);
```

Reason:
Selenium needed browser driver location to start browser.

---

# Problem with Old Approach

- Manual driver download
- Version mismatch issues
- Difficult maintenance

---

# Modern Selenium (4.6+)

Now Selenium uses **Selenium Manager**.

It automatically:
- downloads driver
- matches browser version
- manages driver internally

So now only this is enough:

```java
WebDriver driver = new ChromeDriver();
```

No manual path setup required.

---

# Final Summary

## Why Use `WebDriver`?

- Supports multiple browsers
- Provides abstraction
- Enables polymorphism
- Makes framework flexible

---

## Why Path Not Needed Now?

Because Selenium Manager automatically:
- downloads
- configures
- manages browser drivers
