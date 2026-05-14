# Selenium Dropdown Handling — Quick Notes

# What is Dropdown?

Dropdown is a UI element that allows users to select one or multiple options from a list.

---

# Types of Dropdowns

1. Static Dropdown
2. Dynamic Dropdown
3. Multi Select Dropdown

---

# 1. Static Dropdown

Handled using `Select` class.

## Important Methods

### selectByVisibleText()

```java
Select select = new Select(element);
select.selectByVisibleText("India");
```

---

### selectByValue()

```java
select.selectByValue("ind");
```

---

### selectByIndex()

```java
select.selectByIndex(2);
```

---

# 2. Multi Select Dropdown

Dropdown where multiple options can be selected.

## Check Multi Select

```java
select.isMultiple();
```

Returns:
- `true` → multi select
- `false` → single select

---

## Select Multiple Options

```java
select.selectByVisibleText("Java");
select.selectByVisibleText("Python");
```

---

## Deselect Methods

```java
select.deselectAll();

select.deselectByVisibleText("Java");

select.deselectByValue("python");

select.deselectByIndex(1);
```

---

# 3. Dynamic Dropdown

Dynamic dropdowns are NOT handled using `Select` class.

Handled using:
- click()
- findElements()
- loops
- XPath/CSS

Mostly used in:
- auto suggestions
- searchable dropdowns
- React/Angular dropdowns

---

# Dynamic Dropdown Example

```java
driver.findElement(By.id("search")).sendKeys("Ind");

List<WebElement> options =
driver.findElements(By.xpath("//li"));

for(WebElement option : options)
{
    if(option.getText().equals("India"))
    {
        option.click();
        break;
    }
}
```

---

# Important Interview Points

- `Select` class works only for `<select>` tag
- Dynamic dropdowns require custom handling
- `isMultiple()` checks multi select support
- Multi select dropdown supports deselect methods
- Dynamic dropdowns usually use loops + XPath