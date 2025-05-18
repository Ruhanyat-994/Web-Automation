### BasePage

```java
package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public static WebDriver driver;

    public void setDriver(WebDriver driver){
        BasePage.driver = driver;

    }

    protected WebElement find(By locator){
        return driver.findElement(locator);
    }

    protected  void set(By locater, String text){
         find(locater).clear();
         find(locater).sendKeys(text);

    }

    protected void click(By locator){
        find(locator).click();
    }

    public static void delay(int milliseconeds){
        try{
            Thread.sleep(milliseconeds);
        }catch (InterruptedException exe){
            exe.printStackTrace();
        }
    }
    protected WebElement waitForElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

}

```
#### Some Thread Methods to Use
```txt
Thread.sleep(long millis)
Thread.currentThread()
Thread.setName(String name)
Thread.getName()
Thread.yield()
Thread.join()
Thread.activeCount()
```
**NOTE:Thread.sleep(long millis) is not recommended in production grade code rather use WebDriverWait**

```java
protected WebElement waitForElement(By locator) {
    WebDriverWait wait = new WebDriverWait(driver, 10);
    return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
}

```

### Explanation:

- **protected WebElement waitForElement(By locator)**:
    
    A method that waits for a web element (given by `locator`) and returns it.
    
- **WebDriverWait wait = new WebDriverWait(driver, 10);**
    
    Creates an explicit wait that checks for a condition for up to 10 seconds.
    
- **wait.until(ExpectedConditions.presenceOfElementLocated(locator))**:
    
    Waits until the element is present in the DOM (not necessarily visible), then returns it.
    

Ensures the element exists before interacting with it, avoiding timing issues.

# Scroll using JavaScriptExecutor

---

### 1. **`BaseTest.java`**

**Location:** `part3_4.com.demoqa.base`

**Purpose:** Set up and tear down the test environment (browser launch, URL load, etc.)

```java
public class BaseTest {
    private WebDriver driver;
    protected BasePage basePage;
    protected HomePage homePage;
    private String DEMOQA_URL = "https://demoqa.com/";

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chromeDrover-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void loadApplication() {
        driver.get(DEMOQA_URL);
        basePage = new BasePage();
        basePage.setDriver(driver);
        setUtilityDriver();
        homePage = new HomePage();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

```

```java
@BeforeClass
public void setUp() { ... }

```

- Sets ChromeDriver path.
- Launches Chrome and maximizes the window.

```java
@BeforeMethod
public void loadApplication() { ... }

```

- Opens the target URL.
- Initializes `BasePage` and `HomePage`.
- Sets WebDriver for utility classes.

```java
@AfterClass
public void tearDown() { ... }

```

- Quits the browser after tests complete.

### 2. **`HomePage.java`**

**Location:** `com.demoqa.pages`

**Purpose:** Page Object Model (POM) for the DemoQA homepage.

```java
public class HomePage extends BasePage {
    private By formsCard = By.xpath("//div[@id='app']//h5[text()='Forms']");

    public FormsPage goToForms() {
        scrollToElementJS(formsCard);
        click(formsCard);
        return new FormsPage();
    }
}

```

```java
private By formsCard = By.xpath("//div[@id='app']//h5[text()='Forms']");

```

- Locates the "Forms" card on the homepage.

```java
public FormsPage goToForms() { ... }

```

- Scrolls to the element using JS.
- Clicks on "Forms".
- Returns a new `FormsPage`.

### 3. **`Utility.java`**

**Location:** `utilities`

**Purpose:** Holds static WebDriver for utility classes to access.

```java
public class Utility {
    public static WebDriver driver;

    public static void setUtilityDriver() {
        driver = BasePage.driver;
    }
}

```

```java
public static WebDriver driver;
public static void setUtilityDriver() { ... }

```

- Stores WebDriver in a static field for global utility use.
- Links it from `BasePage`.

---

### 4. **`JavaScriptUtility.java`**

**Location:** `utilities`

**Purpose:** Provides JavaScript actions like scroll.

```java
public class JavaScriptUtility extends Utility {
    public static void scrollToElementJS(By locator) {
        WebElement element = driver.findElement(locator);
        String jsScript = "arguments[0].scrollIntoView();"; // typo here
        ((JavascriptExecutor)driver).executeScript(jsScript, element);
    }
}

```

```java
public static void scrollToElementJS(By locator) { ... }

```

- Finds the element.
- Scrolls to it using JavaScript.

```java
String jsScript = "arguments[0].scrollIntoView();";

```

This is a **JavaScript command** used to scroll a specific element into the visible area of the browser window.

- **`arguments[0]`**:
    
    Refers to the **first element passed** into the JavaScript function from Java via Selenium.
    
- **`.scrollIntoView();`**:
    
    A **JavaScript method** that scrolls the page so the target element becomes visible in the viewport
    
- **`(JavascriptExecutor) driver`**:
    
    Casts the WebDriver to `JavascriptExecutor` so JavaScript can be run in the browser.
    
- **`.executeScript(...)`**:
    
    Runs the provided JavaScript code.
    
- **`jsScript`**:
    
    A `String` containing the JavaScript code, like `"arguments[0].scrollIntoView();"`.
    
- **`element`**:
    
    The target `WebElement` to which the JavaScript will apply (this is `arguments[0]` in the script).
    

### 5. **`FormsPage.java`**

**Location:** `com.demoqa.pages.forms`

**Purpose:** Empty page class to represent the Forms page.

```java
public class FormsPage extends HomePage {
    // Inherits everything from HomePage (and BasePage)
}

```

```java
public class FormsPage extends HomePage { }

```

- Placeholder class to represent the forms page.
- Inherits from `HomePage`.

### 6. **`JavaScriptTest.java`**

**Location:** `part3_4.com.demoqa.tests.part3.javaScript`

**Purpose:** Test class that calls `goToForms()` to scroll and click the "Forms" card.

```java
public class JavaScriptTest extends BaseTest {
    @Test
    public void testScrollingToElement() {
        homePage.goToForms();
    }
}

```

```java
public void testScrollingToElement() {
    homePage.goToForms();
}

```

- Calls method to scroll and click "Forms".

# Working with Radio Buttons
### 1. **Home Page for DemoQA**

```java
package com.demoqa.pages;

import com.demoqa.pages.forms.FormsPageForDemoqa;
import com.saucedemo.pages.BasePage;
import org.openqa.selenium.By;

import static utilities.JavaScriptUtility.scrollToElementJS;

// This is another website but We will use the basepage that we made previously
public class HomePageForDemoqa extends BasePage {
    private By formsCard = By.xpath("/html/body/div[2]/div/div/div[2]/div/div[2]/div/div[3]/h5");

    public FormsPageForDemoqa goToForms(){
        scrollToElementJS(formsCard);

        click(formsCard);
        return new FormsPageForDemoqa();
    }

}
```

**Description:**

This class represents the homepage of the DemoQA site.

* Inherits from `BasePage`, so it can use its methods like `click()`.
* `formsCard` identifies the "Forms" section on the page using XPath.
* `goToForms()`:

  * Scrolls to the forms card using `scrollToElementJS()`.
  * Clicks it to navigate.
  * Returns a new `FormsPageForDemoqa` object, chaining the navigation process.


---

### 2. **Forms Page for DemoQA**

```java
package com.demoqa.pages.forms;

import com.demoqa.pages.HomePageForDemoqa;
import org.openqa.selenium.By;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class FormsPageForDemoqa extends HomePageForDemoqa {
    private By practiceFormManuItem = By.xpath("/html/body/div[2]/div/div/div/div[1]/div/div/div[2]/div/ul/li/span");

    public PracticeFormPage clickPracticeForm(){
        scrollToElementJS(practiceFormManuItem);
        click(practiceFormManuItem);
        return new PracticeFormPage();
    }
}
```

**Description:**

This class represents the Forms section after clicking “Forms” on the homepage.

* Inherits from `HomePageForDemoqa` to reuse navigation steps.
* `practiceFormManuItem` locates the Practice Form menu item.
* `clickPracticeForm()`:

  * Scrolls to the item.
  * Clicks it.
  * Returns a new `PracticeFormPage` object for further actions.

Useful for moving from the Forms section to the actual form.

**Deeper Description**
It will help me to ace the interview!

### Method Return Type in Java

In the following method declaration:

```java
public PracticeFormPage clickPracticeForm() {
    scrollToElementJS(practiceFormManuItem);
    click(practiceFormManuItem);
    return new PracticeFormPage();
}
```

**`PracticeFormPage`** is the **return type** of the method `clickPracticeForm`.

---

### Purpose of Using the `PracticeFormPage` Return Type

Returning an instance of `PracticeFormPage` allows:

* Method chaining, enabling test flows like `formsPage.clickPracticeForm().fillForm()`.
* A transition from one page object (`FormsPageForDemoqa`) to another (`PracticeFormPage`).
* Clear representation of navigation between different parts of the application, following the Page Object Model (POM) pattern.

---

### Example Usage

```java
PracticeFormPage formPage = formsPage.clickPracticeForm();
formPage.fillName("John", "Doe");
```

This is possible because `clickPracticeForm()` returns an instance of `PracticeFormPage`.

---

### Comparison

If the return type were `void`:

```java
public void clickPracticeForm() {
    // actions
}
```

Then the following would not work:

```java
formsPage.clickPracticeForm().fillName("John", "Doe"); // compile-time error
```

You would have to break the chain:

```java
formsPage.clickPracticeForm();
PracticeFormPage formPage = new PracticeFormPage();
formPage.fillName("John", "Doe");
```

---

### When to Return `new PracticeFormPage()` vs `this`

* `return new PracticeFormPage();` is appropriate when the method navigates to a new page.
* `return this;` would be used if the page remains the same after the action.

---

### 3. **Practice Form Page**

```java
package com.demoqa.pages.forms;

import org.openqa.selenium.By;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class PracticeFormPage extends FormsPageForDemoqa {
    private By femaleRadioButton = By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[3]/div[2]/div[2]/label");

    public void clickFemaleRadioButton(){
        scrollToElementJS(femaleRadioButton);
        click(femaleRadioButton);
    }
}
```

**Description:**

Represents the actual form page where a user fills details.

* Inherits from `FormsPageForDemoqa`.
* Locates the "Female" radio button using XPath.
* `clickFemaleRadioButton()`:

  * Scrolls to the button.
  * Clicks it.

Simple page-level action to simulate form filling during automation.

---

### 4. **Radio Button Test**

```java
package part3_4.com.demoqa.tests.part3.forms;

import com.base.base.BaseTest;
import com.demoqa.pages.forms.PracticeFormPage;
import org.testng.annotations.Test;

public class RadioButtonTest extends BaseTest {
    @Test
    public void testRadioButton(){
        PracticeFormPage formPage = homePageForDemoqa.goToForms().clickPracticeForm();
        formPage.clickFemaleRadioButton();
    }
}
```

**Description:**

This is the actual test class to verify clicking the Female radio button.

* Inherits from `BaseTest` to use setup and teardown logic.
* Uses the page objects:

  * Navigates: `HomePage → Forms → Practice Form`
  * Then clicks the radio button.
* Wrapped in a `@Test` method for TestNG execution.

Shows a full flow from landing on homepage to performing action.

---

### 5. **JavaScript Utility**

```java
package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtility extends Utility {
    public static void scrollToElementJS(By locator){
        WebElement element = driver.findElement(locator);
        String jsScript = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor)driver).executeScript(jsScript, element);
    }

    public static void clickJS(By locator){
        WebElement element = driver.findElement(locator);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }
}
```

**Description:**

Provides JavaScript-based actions to interact with web elements when normal WebDriver clicks/scrolls might fail.

* `scrollToElementJS(By locator)`:

  * Scrolls the browser to make the element visible using JS.
* `clickJS(By locator)`:

  * Clicks an element using JS (used when Selenium click doesn't work properly).
* Uses `JavascriptExecutor` to execute JavaScript in the browser context.

This class depends on `Utility.driver`.

---

# Automating the Tables 

## `ElementsPageForDemoqa.java`

**Full Code:**

```java
package com.demoqa.pages.elements;

import com.demoqa.pages.HomePageForDemoqa;
import com.saucedemo.pages.BasePage;
import org.openqa.selenium.By;

import static utilities.JavaScriptUtility.clickJS;
import static utilities.JavaScriptUtility.scrollToElementJS;

public class ElementsPageForDemoqa extends HomePageForDemoqa {

    private By webTablesElement = By.xpath("/html/body/div[2]/div/div/div/div[1]/div/div/div[1]/div/ul/li[4]/span");

    public WebElementPage clickWebtablesElement() {
        scrollToElementJS(webTablesElement);
        clickJS(webTablesElement);
        return new WebElementPage();
    }

}
```

---

### 1. **`ElementsPageForDemoqa.java`**

**Location:** `com.demoqa.pages.elements`

**Purpose:**
Represents the "Elements" section of the DemoQA site. Navigates to **Web Tables**.

```java
private By webTablesElement = By.xpath("/html/body/div[2]/div/div/div/div[1]/div/div/div[1]/div/ul/li[4]/span");
```

* Locates the **Web Tables** menu item in the sidebar using absolute XPath.

```java
public WebElementPage clickWebtablesElement() { ... }
```

* Scrolls to **Web Tables** using JavaScript.
* Clicks it using JavaScript.
* Returns a new `WebElementPage` object to proceed.

---

## `WebElementPage.java`

**Full Code:**

```java
package com.demoqa.pages.elements;

import org.openqa.selenium.By;

import static utilities.JavaScriptUtility.clickJS;

public class WebElementPage extends ElementsPageForDemoqa {

    private By registrationAgeField = By.id("age");
    private By sumitButton = By.id("submit");

    public void clickEditButton() {
        By editButton = By.xpath("//*[@id=\"edit-record-2\"]");
        clickJS(editButton);
    }

    public void setAge(String age) {
        set(registrationAgeField, age);
    }

    public void clickSubmitButton() {
        clickJS(sumitButton);
    }
}
```

---

### 2. **`WebElementPage.java`**

**Location:** `com.demoqa.pages.elements`

**Purpose:**
Handles form interactions for the **Web Tables** section.

```java
private By registrationAgeField = By.id("age");
private By sumitButton = By.id("submit");
```

* Locates the **Age input field** and the **Submit button**.

```java
public void clickEditButton() { ... }
```

* Clicks the **Edit** button for the second row (`record-2`) using JavaScript.

```java
public void setAge(String age) { ... }
```

* Inputs the new age value into the form.

```java
public void clickSubmitButton() { ... }
```

* Clicks the **Submit** button using JavaScript.

---

## `TablesTest.java`

**Full Code:**

```java
package part3_4.com.demoqa.tests.part3.elements;

import com.base.base.BaseTest;
import com.demoqa.pages.elements.WebElementPage;
import org.testng.annotations.Test;

import static com.saucedemo.pages.BasePage.delay;

public class TablesTest extends BaseTest {

    @Test
    public void testTables() {

        String expectedAge = "99";

        WebElementPage webTablePage = homePageForDemoqa
                .goToElements()
                .clickWebtablesElement();

        webTablePage.clickEditButton();
        webTablePage.setAge(expectedAge);
        webTablePage.clickSubmitButton();

        delay(3000); // wait for 3 seconds after submitting
    }
}
```

---

### 3. **`TablesTest.java`**

**Location:** `part3_4.com.demoqa.tests.part3.elements`

**Purpose:**
Test to validate editing the **Age** field inside the Web Table.

```java
@Test
public void testTables() { ... }
```

* Sets a new **expected age** value (`"99"`).
* Navigates: `homePageForDemoqa → Elements → Web Tables`.
* Clicks **Edit** on record 2.
* Inputs new age.
* Clicks **Submit**.
* Waits 3 seconds using `delay(3000)` to let UI update.

---

Let me know when you want to move on to the next set of files.
