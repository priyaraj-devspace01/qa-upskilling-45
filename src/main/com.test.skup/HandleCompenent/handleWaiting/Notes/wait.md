# Selenium Waits — Interview Quick Notes

## Why Waits are Used
Waits are used to handle synchronization issues in Selenium when elements load slowly or dynamically.

---

# Types of Waits

## 1. Implicit Wait
- Global wait
- Applied to all elements
- Waits until element is found

```java
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
```

### Limitation
- Cannot handle specific conditions

---

## 2. Explicit Wait
- Waits for a specific condition
- Most commonly used in real projects
- Uses `WebDriverWait` and `ExpectedConditions`

```java
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
```

### Common Conditions
- `visibilityOfElementLocated()`
- `elementToBeClickable()`
- `alertIsPresent()`

---

## 3. Fluent Wait
- Advanced version of Explicit Wait
- Supports polling frequency
- Can ignore exceptions

```java
.withTimeout()
.pollingEvery()
.ignoring()
```

---

# Important Interview Points

- Explicit Wait is preferred in frameworks
- Fluent Wait gives more control
- Avoid heavy mixing of Implicit and Explicit waits
- Waits help avoid synchronization issues

---

# Common Exceptions Solved
- `NoSuchElementException`
- `ElementNotInteractableException`
- `TimeoutException`

---

# Best Practice
- Use small Implicit Wait globally
- Use Explicit Wait for most scenarios
- Use Fluent Wait for highly dynamic elements


# to add a wait to handle where the expected element take to be present
## 1) 
edge case - suppose in case, we have an element requires 3 seconds to present after clicking on a button


## solution (java) 
``` 
Thread.sleep(1000);
```
### but if we use, 10 seconds remaining 7 seconds will be lost also vice versa.


## Solution (selenium) 
## Implicit wait = global wait-for all element it will wait for the specified time
``` 
driver.manage.timeout().implicitlyWait(Duration.ofSeconds(10);

```
here, even if we mentioned 10 seconds globally for every element when we try to locating, but 
any element which will be available before 10 seconds like, in 2 seconds it will not wait for remaining 8 seconds, it simply perform the action, once available.
