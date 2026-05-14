# Selenium Alerts — Quick Interview Notes

## What are Alerts?

Alerts are popup messages displayed by the browser to:
- show warning messages
- confirmation messages
- input requests

Selenium cannot directly interact with elements behind an alert.

So we must switch control to the alert first.

---

# Why Alert Handling is Required

Without handling alerts:
- Selenium throws `UnhandledAlertException`
- User actions get blocked

---

# Switch Control to Alert

```java
driver.switchTo().alert();
```

---

# Important Alert Methods

## accept()
Used to click OK button.

```java
alert.accept();
```

---

## dismiss()
Used to click Cancel button.

```java
alert.dismiss();
```

---

## getText()
Used to capture alert message text.

```java
alert.getText();
```

---

## sendKeys()
Used to enter text into prompt alert.

```java
alert.sendKeys("Admin");
```

---

# Types of Alerts

1. Simple Alert
2. Confirmation Alert
3. Prompt Alert

---

# Important Point About Switching Back

After handling the alert using:
- `accept()`
- `dismiss()`

Selenium automatically switches back to the main page.

No need to use:

```java
driver.switchTo().defaultContent();
```

`defaultContent()` is mainly used for:
- frames
- iframes

NOT for alerts.

---

# Important Interview Points

- Selenium must switch to alert before handling it
- `accept()` → clicks OK
- `dismiss()` → clicks Cancel
- `getText()` → fetches alert message
- `sendKeys()` works only for prompt alerts
- `defaultContent()` is used for frames/iframes, not alerts