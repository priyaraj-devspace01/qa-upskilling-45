
# Xpath Finding : 
## Type of xpath expressions:
### 1) Absolute Xpath Expression
it tries to locate the element from the root element to the desired element i,e. complete path required.
/ - locate the entire HTML page

```java
// syntax - tag_name[@attribute='value']

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

WebElement ele = driver.findElement(By.xpath("html/body/h3[@id='login']"));
// suppose we have a condition find the paragraph tag on the page having id = "login" and class="menu"
WebElement ele2 = driver.findElement(By.xpath("html/body/p[@id='login'][@class='menu']"));


```

### But in real time most of the time we are using relative xpath:-
#### Reason - 
##### disadvantages(absolute) - 
when changes are going to be done the xpath may change significantly, to differentiate to handle, complex.



### Here we need to go for relative xpath----->

### 2) Relative Xpath Expression:
1) Unlike absolute xpath locating the element from the root element to the desired element, it directly locates the element from the dom
2) also the relative xpath is starting with the //.
note : 
Always remember the absolute xpath is slightly faster than relative xpath.
and also relative xpath is more reliable than absolute.
### Syntax:

```java
/// tageName[@attribute='value']

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

WebElement button = driver.findElement(By.xpath("//h1[@id = 'login']"));

/// when we want to locate more than one element of type differing we can use  |
//select[@id='drop1' | //button[@id='but2']
/// if all tag type are same we can use "or" instead of  | 
//button[@id='but1' or //button[@id='but2']

/// when we have given find xpath of any element having id = "login"
//syntax should be not tag dependent
WebElement login = driver.findElement(By.xpath("//*[@id='login']"));

// similarly find input tag having any attribute value as 'user_name'
WebElement login2 = driver.findelement(By.xpath("//input[@*='user_name'"));

// suppose in scenario where we need to find the input tags having name anything
WebElement randomEle = driver.findElement(By.xpath("//input[@name]")); // we don't need to mention the value here

// to locate elements with any tagName with any attribute with any value
// syntax = //*[@*]


/// find the xpath for the tags having id='radio' and name='geneder'
//syntax  - //*[@id='radio'][@name='gender']

/// find the input tag having id='radio' or name='gender'
// //input[@id='radio or @name='gender']

/// find the url for the link 'www.amigo.com'
// //a[@href='www.amigo.com']

/// to get the first link we can use the indexing by giving the [index]
// (//a[@href='www.amigo.com'])[1]

/// find the first child of HTML tag
// //html/*-> any child
// if we want first child we can use //html//*[1]



```


# Xpath Functions


# XPath Functions & Axes — Quick Interview Notes

# What is XPath?

XPath is used to locate web elements in Selenium when normal locators are not sufficient.

---

# Common XPath Functions

# 1. text()

Used to locate element using exact visible text.

```xpath
//button[text()='Login']
//button[.='Login'] //same
```

---

# 2. contains()

Used when attribute/text value changes dynamically.

```xpath
//input[contains(@id,'user')]
```

```xpath
//h2[contains(text(),'Welcome')]
```

---

# 3. starts-with()

Used when attribute starts with fixed value.

```xpath
//input[starts-with(@id,'user')]
```

---

# 4. normalize-space()

Ignores extra spaces in text.

```xpath
//button[normalize-space()='Submit']
```

---

# XPath Operators

# and

Both conditions must match.

```xpath
//input[@type='text' and @name='email']
```

---

# or

Any one condition can match.

```xpath
//input[@id='email' or @name='email']
```

---

# XPath Axes

Axes are used to navigate between related elements.

---

# 1. parent::

Select parent element.

```xpath
//input[@id='email']/parent::div
```

---

# 2. child::

Select child element.

```xpath
//div[@class='form']/child::input
```

---

# 3. following-sibling::

Select next sibling element.

```xpath
//label[text()='Email']/following-sibling::input
```

---

# 4. preceding-sibling::

Select previous sibling element.

```xpath
//input[@id='email']/preceding-sibling::label
```

---

# 5. ancestor::

Select all parent/grandparent elements.

```xpath
//input[@id='email']/ancestor::form
```

---

# 6. descendant::

Select child/grandchild elements.

```xpath
//form/descendant::input
```

---

# 7. following::

Select all elements after current element.

```xpath
//h2[text()='Login']/following::input
```

---

# 8. preceding::

Select all elements before current element.

```xpath
//button/preceding::input
```

---

# Important Interview Points

- `contains()` is most used for dynamic elements
- `text()` works for exact text match
- `normalize-space()` handles extra spaces
- Axes help locate related elements
- `following-sibling` is very common in forms/tables
- XPath is slower than CSS Selector but more powerful

