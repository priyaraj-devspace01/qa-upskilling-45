# CSS Selector — Real-Time Important Syntax Notes

# What is CSS Selector?

CSS Selector is used to locate web elements in Selenium.

It is:
- faster than XPath
- cleaner
- heavily used in real projects

---

# CSS vs XPath Syntax

| Feature | XPath | CSS Selector |
|---|---|---|
| ID | `//*[@id='email']` | `#email` |
| Class | `//*[@class='input']` | `.input` |
| Tag + ID | `//input[@id='email']` | `input#email` |
| Tag + Class | `//button[@class='loginBtn']` | `button.loginBtn` |
| Attribute | `//input[@type='text']` | `input[type='text']` |
| contains | `contains(@id,'user')` | `[id*='user']` |
| starts-with | `starts-with(@id,'user')` | `[id^='user']` |
| ends-with | Not direct | `[id$='name']` |

---

# Important CSS Symbols

| Symbol | Meaning |
|---|---|
| `#` | id |
| `.` | class |
| `*=` | contains |
| `^=` | starts with |
| `$=` | ends with |
| `>` | direct child |
| ` ` (space) | descendant |

---

# AND Condition in CSS

```css
input#email.inputField[type='text']
```

All conditions must match.

---

# Most Used Real-Time CSS Syntax

# By ID

```css
#email
```

---

# By Class

```css
.inputField
```

---

# Tag + Class

```css
button.loginBtn
```

---

# Multiple Classes

```css
.btn.primary.active
```

---

# contains()

```css
input[id*='user']
```

---

# starts-with()

```css
input[id^='user']
```

---

# ends-with()

```css
input[id$='name']
```

---

# Direct Child

```css
div > input
```

---

# Descendant Element

```css
div input
```

---

# Following Element (Adjacent Sibling)

Select immediate next sibling.

```css
label + input
```

Equivalent XPath:

```xpath
//label/following-sibling::input
```

---

# All Following Siblings

```css
label ~ input
```

Selects all sibling inputs after label.

---

# Checked Elements

Mostly used for:
- checkbox
- radio button

```css
input:checked
```

---

# Enabled Elements

```css
button:enabled
```

---

# Disabled Elements

```css
button:disabled
```

---

# Selected Option

```css
option:checked
```

---

# First Child

```css
li:first-child
```

---

# Last Child

```css
li:last-child
```

---

# nth Child

```css
tr:nth-child(2)
```

Used heavily in tables.

---

# Important Real-Time Usage

## Find Checked Checkbox

```css
input[type='checkbox']:checked
```

---

## Find Enabled Button

```css
button:enabled
```

---

## Dynamic Button

```css
button[id*='login']
```

---

## Table Row

```css
table tr:nth-child(3)
```

---

# Important Limitations

CSS Selector CANNOT:
- use visible text
- use `text()`
- move backward to parent
- use XPath axes fully

For text-based locating, XPath is preferred.

---

# Important Interview Points

- CSS is faster than XPath
- `#` → id
- `.` → class
- `*=` → contains
- `^=` → starts with
- `$=` → ends with
- `+` → next sibling
- `~` → all following siblings
- `:checked` → selected checkbox/radio
- `:enabled` → enabled element
- `nth-child()` heavily used in tables