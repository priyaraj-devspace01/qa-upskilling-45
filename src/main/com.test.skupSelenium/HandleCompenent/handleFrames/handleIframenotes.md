# Selenium iFrame Handling — Quick Notes

# What is iFrame?

An iFrame (Inline Frame) is a webpage inside another webpage.

Selenium cannot directly interact with elements inside an iFrame.

So we must switch control to the frame first.

---

# Why iFrame Handling is Required

Without switching to frame:
- Selenium throws `NoSuchElementException`
- Elements inside frame are not accessible

---

# Switch to iFrame

## By Index

```java
driver.switchTo().frame(0);
```

---

## By Name or ID

```java
driver.switchTo().frame("frameName");
```

---

## By WebElement

```java
WebElement frame =
driver.findElement(By.id("frame1"));

driver.switchTo().frame(frame);
```

---

# Switch Back to Main Page

## Parent Frame

```java
driver.switchTo().parentFrame();
```

Moves one level up.

---

## Default Content

```java
driver.switchTo().defaultContent();
```

Switches back to main webpage.

---

# Difference

## parentFrame()

- Returns to immediate parent frame

## defaultContent()

- Returns directly to main page

---

# Nested iFrames

For nested frames:

```java
driver.switchTo().frame("frame1");

driver.switchTo().frame("frame2");
```

---

# Important Interview Points

- Selenium must switch to frame before interacting
- `frame()` is used to switch into iframe
- `parentFrame()` → one level up
- `defaultContent()` → main webpage
- iFrames are handled using index, name/id, or WebElement