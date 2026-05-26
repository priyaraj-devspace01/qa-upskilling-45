# Selenium Scrolling — Complete Interview + Real-Time Notes

# Why Scrolling is Required

Sometimes elements are:
- outside viewport
- lazy loaded
- hidden below page
- dynamically rendered

Normal Selenium actions may fail with:
- `ElementNotInteractableException`
- `MoveTargetOutOfBoundsException`

So scrolling becomes necessary.

---

# Main Ways to Scroll in Selenium

1. JavaScriptExecutor
2. Actions Class
3. Keyboard Keys
4. Scroll Into View
5. Infinite Scroll Handling

---

# Most Used Approach

# JavaScriptExecutor

Package:

```java
import org.openqa.selenium.JavascriptExecutor;
```

---

# Basic Syntax

```java
JavascriptExecutor js =
(JavascriptExecutor) driver;
```

---

# 1. Scroll Down Entire Page

```java
js.executeScript(
    "window.scrollBy(0,500)"
);
```

---

# 2. Scroll Up

```java
js.executeScript(
    "window.scrollBy(0,-500)"
);
```

---

# Important Understanding

```text
window.scrollBy(x,y)
```

- x → horizontal
- y → vertical

Positive y:
- scroll down

Negative y:
- scroll up

---

# 3. Scroll To Bottom

```java
js.executeScript(
    "window.scrollTo(0, document.body.scrollHeight)"
);
```

Very commonly used.

---

# 4. Scroll To Top

```java
js.executeScript(
    "window.scrollTo(0,0)"
);
```

---

# 5. scrollIntoView() (MOST IMPORTANT)

Used to bring specific element into viewport.

## Syntax

```java
js.executeScript(
    "arguments[0].scrollIntoView();",
    element
);
```

---

# Smooth Center Scroll (Industry Preferred)

```java
js.executeScript(
"arguments[0].scrollIntoView({block:'center'});",
element
);
```

Better because:
- avoids sticky headers
- cleaner visibility
- more stable clicks

---

# 6. Scroll Horizontally

```java
js.executeScript(
    "window.scrollBy(500,0)"
);
```

---

# 7. Infinite Scroll Handling

Used in:
- Amazon
- LinkedIn
- Instagram
- lazy loaded sites

## Syntax

```java
while(true)
{
    js.executeScript(
    "window.scrollTo(0, document.body.scrollHeight)"
    );

    Thread.sleep(2000);
}
```

---

# Better Infinite Scroll Logic

```java
long oldHeight =
(Long) js.executeScript(
"return document.body.scrollHeight"
);

while(true)
{
    js.executeScript(
    "window.scrollTo(0, document.body.scrollHeight)"
    );

    Thread.sleep(2000);

    long newHeight =
    (Long) js.executeScript(
    "return document.body.scrollHeight"
    );

    if(oldHeight == newHeight)
    {
        break;
    }

    oldHeight = newHeight;
}
```

Very important real-world concept.

---

# 8. Scroll Using Actions Class

```java
Actions act = new Actions(driver);

act.scrollToElement(element).perform();
```

Selenium 4 feature.

---

# 9. Scroll Using Keyboard Keys

```java
act.sendKeys(Keys.PAGE_DOWN).perform();
```

---

# Common Keyboard Scroll Keys

| Key | Usage |
|---|---|
| `PAGE_DOWN` | Page down |
| `PAGE_UP` | Page up |
| `ARROW_DOWN` | Small scroll down |
| `ARROW_UP` | Small scroll up |
| `HOME` | Top |
| `END` | Bottom |

---

# 10. Scroll Nested Container

Sometimes page itself doesn't scroll.

A div/container scrolls.

## Syntax

```java
js.executeScript(
"arguments[0].scrollTop=arguments[0].scrollHeight",
element
);
```

Very important in modern React apps.

---

# Real-Time Scenarios

# Click Hidden Element

```java
js.executeScript(
"arguments[0].scrollIntoView()",
button
);

button.click();
```

---

# Lazy Loaded Products

Used heavily in ecommerce sites.

---

# Chat Applications

Scrollable div handling.

---

# Table Scrolling

Horizontal + vertical table scrolling.

---

# Common Exceptions

| Exception | Cause |
|---|---|
| `ElementClickInterceptedException` | Element not visible |
| `MoveTargetOutOfBoundsException` | Outside viewport |
| `ElementNotInteractableException` | Hidden element |

Scrolling often fixes these.

---

# Best Practices

- Prefer `scrollIntoView()` first
- Use center alignment when possible
- Avoid unnecessary hardcoded offsets
- Use Explicit Wait after scrolling
- Scroll containers separately if needed

---

# Important Interview Points

- `scrollIntoView()` is most used in frameworks
- JavaScriptExecutor is most reliable for scrolling
- Infinite scrolling commonly used in modern apps
- Selenium 4 supports `scrollToElement()`
- Nested containers require separate scrolling logic

---

# Most Important Real-Time Methods

| Method | Usage |
|---|---|
| `scrollIntoView()` | Bring element into view |
| `scrollTo()` | Absolute scroll |
| `scrollBy()` | Relative scroll |
| `scrollTop` | Container scrolling |
| `scrollHeight` | Total page height |

---

# Best Practice Order To Learn

1. scrollBy()
2. scrollTo()
3. scrollIntoView()
4. center scrolling
5. infinite scrolling
6. container scrolling
7. Actions scroll
8. keyboard scrolling

---

# Best Practice Websites

## Infinite Scroll
- :contentReference[oaicite:0]{index=0}

---

## Horizontal + Vertical Scroll
- :contentReference[oaicite:1]{index=1}

---

## Ecommerce Scroll Practice
- :contentReference[oaicite:2]{index=2}

---

# Final Core Understanding

Scrolling is mainly used to:
- bring elements into viewport
- handle lazy loading
- interact with hidden elements
- automate modern dynamic applications reliably