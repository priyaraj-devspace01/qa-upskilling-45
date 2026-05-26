# Lightbox Handling in Selenium — Quick Interview Notes

# What is a Lightbox?

A Lightbox is a popup/modal window displayed on top of the current webpage without opening a new browser window or alert.

Mostly used for:
- image previews
- login popups
- advertisements
- forms
- galleries

---

# Important Understanding

Lightbox is:
- NOT an alert
- NOT a new window/tab
- NOT an iframe (sometimes it may contain iframe)

It is usually a normal HTML popup.

So Selenium handles it like normal web elements.

---

# How to Handle Lightbox

## Step 1
Trigger/Open the lightbox.

```java
driver.findElement(By.id("openBtn")).click();
```

---

## Step 2
Locate elements inside popup.

```java
driver.findElement(By.id("email")).sendKeys("admin");
```

---

## Step 3
Close popup if needed.

```java
driver.findElement(By.xpath("//button[text()='Close']")).click();
```

---

# Common Real-Time Handling

# Wait for Lightbox Visibility

```java
WebDriverWait wait =
new WebDriverWait(driver, Duration.ofSeconds(10));

wait.until(
ExpectedConditions.visibilityOfElementLocated(By.id("popup"))
);
```

---

# Close Using X Button

```java
driver.findElement(By.cssSelector(".close")).click();
```

---

# Handle Overlay Issues

Sometimes background overlay blocks clicks.

Use:
- Explicit Wait
- JavaScriptExecutor
- Actions class

if normal click fails.

---

# If Lightbox Uses iFrame

First switch to iframe.

```java
driver.switchTo().frame(0);
```

After completion:

```java
driver.switchTo().defaultContent();
```

---

# Important Interview Points

- Lightbox is usually normal HTML popup
- No `switchTo().alert()` required
- Mostly handled like normal elements
- Explicit Wait commonly used
- Some lightboxes internally use iframe
- `defaultContent()` used only if iframe involved