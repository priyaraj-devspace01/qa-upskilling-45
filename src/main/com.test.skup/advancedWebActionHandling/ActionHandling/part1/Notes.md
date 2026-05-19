# Selenium Actions Class — Complete Interview + Hands-On Notes

# What is Actions Class?

`Actions` class in Selenium is used to perform advanced user interactions that normal Selenium methods cannot handle properly.

Used for:
- mouse hover
- right click
- double click
- drag and drop
- keyboard actions
- slider handling
- composite actions

Package:

```java
import org.openqa.selenium.interactions.Actions;
```

---

# Why Actions Class is Required

Normal Selenium methods:

```java
click()
sendKeys()
```

work for simple interactions.

But modern applications use:
- dynamic menus
- hidden dropdowns
- hover-based UI
- drag/drop components
- keyboard shortcuts

For these advanced interactions, Actions class is used.

---

# Basic Syntax

```java
Actions act = new Actions(driver);
```

---

# Important Understanding

Actions class follows:
# Builder Pattern

Example:

```java
act.moveToElement(element)
   .click()
   .perform();
```

Actions are built step-by-step.

`perform()` executes them.

---

# Most Important Methods

| Method | Usage |
|---|---|
| `moveToElement()` | Mouse hover |
| `click()` | Mouse click |
| `doubleClick()` | Double click |
| `contextClick()` | Right click |
| `dragAndDrop()` | Drag and drop |
| `clickAndHold()` | Hold mouse |
| `release()` | Release mouse |
| `moveByOffset()` | Move using coordinates |
| `sendKeys()` | Keyboard typing |
| `keyDown()` | Hold keyboard key |
| `keyUp()` | Release keyboard key |
| `build()` | Combine actions |
| `perform()` | Execute actions |

---

# 1. Mouse Hover

Used for:
- hidden menus
- dropdowns
- tooltips

## Syntax

```java
Actions act = new Actions(driver);

act.moveToElement(element).perform();
```

---

# 2. Click Using Actions

Used when normal click fails.

```java
act.click(element).perform();
```

---

# 3. Double Click

```java
act.doubleClick(element).perform();
```

---

# 4. Right Click

## contextClick()

```java
act.contextClick(element).perform();
```

---

# 5. Drag and Drop

```java
act.dragAndDrop(source, target).perform();
```

---

# 6. clickAndHold() + release()

Advanced drag/drop handling.

```java
act.clickAndHold(source)
   .moveToElement(target)
   .release()
   .perform();
```

---

# 7. moveByOffset()

Moves mouse using x,y coordinates.

```java
act.moveByOffset(100, 0).perform();
```

Mostly used for:
- sliders
- canvas
- coordinate interactions

---

# Keyboard Actions

# sendKeys()

```java
act.sendKeys("Hello").perform();
```

---

# keyDown()

Used to hold keyboard key.

```java
act.keyDown(Keys.CONTROL).perform();
```

---

# keyUp()

Used to release held key.

```java
act.keyUp(Keys.CONTROL).perform();
```

---

# Keyboard Shortcut Example

## CTRL + A

```java
act.keyDown(Keys.CONTROL)
   .sendKeys("a")
   .keyUp(Keys.CONTROL)
   .perform();
```

---

# SHIFT Typing Example

```java
act.keyDown(Keys.SHIFT)
   .sendKeys("hello")
   .keyUp(Keys.SHIFT)
   .perform();
```

Output:

```text
HELLO
```

---

# Important Keys Class

Package:

```java
import org.openqa.selenium.Keys;
```

---

# Common Keys

| Key | Usage |
|---|---|
| `Keys.ENTER` | Enter |
| `Keys.TAB` | Tab |
| `Keys.SHIFT` | Shift |
| `Keys.CONTROL` | Ctrl |
| `Keys.ALT` | Alt |
| `Keys.BACK_SPACE` | Backspace |
| `Keys.DELETE` | Delete |
| `Keys.ESCAPE` | Escape |
| `Keys.ARROW_DOWN` | Down key |
| `Keys.ARROW_UP` | Up key |
| `Keys.SPACE` | Space |
| `Keys.PAGE_DOWN` | Page down |

---

# build() vs perform()

## perform()

Immediately executes actions.

```java
act.click().perform();
```

---

## build()

Combines multiple actions.

```java
act.keyDown(Keys.CONTROL)
   .sendKeys("a")
   .keyUp(Keys.CONTROL)
   .build()
   .perform();
```

---

# Real-Time Industry Scenarios

# Hover Menus

```java
act.moveToElement(menu).perform();
```

---

# Slider Handling

```java
act.dragAndDropBy(slider, 50, 0).perform();
```

---

# File Upload Workaround

Sometimes keyboard actions help.

---

# Table Selection

CTRL + click multiple rows.

---

# Canvas Drawing

Uses:
- clickAndHold()
- moveByOffset()
- release()

---

# Common Exceptions

| Exception | Cause |
|---|---|
| `MoveTargetOutOfBoundsException` | Invalid coordinates |
| `ElementNotInteractableException` | Element hidden |
| `TimeoutException` | Slow UI |
| `StaleElementReferenceException` | DOM refreshed |

---

# Best Practices

- Prefer normal click first
- Use Actions only when needed
- Use Explicit Wait before Actions
- Keep actions small and readable
- Re-locate stale elements

---

# Important Interview Points

- Actions class handles advanced mouse + keyboard interactions
- Follows Builder Pattern
- `perform()` executes action chain
- `moveToElement()` heavily used in frameworks
- `keyDown()` + `keyUp()` used for shortcuts
- `moveByOffset()` used for sliders/canvas

---

# Best Websites to Practice

## Mouse Hover
- :contentReference[oaicite:0]{index=0}

---

## Right Click
- :contentReference[oaicite:1]{index=1}

---

## Drag and Drop
- :contentReference[oaicite:2]{index=2}

---

## Slider Practice
- :contentReference[oaicite:3]{index=3}

---

## Keyboard Actions
- :contentReference[oaicite:4]{index=4}

---

# Best Hands-On Practice Order

1. moveToElement()
2. click()
3. doubleClick()
4. contextClick()
5. dragAndDrop()
6. clickAndHold()
7. moveByOffset()
8. keyDown() + keyUp()
9. keyboard shortcuts
10. slider handling
11. canvas interactions

---

# Final Core Understanding

Actions class is mainly used to simulate real human behavior on modern dynamic web applications.