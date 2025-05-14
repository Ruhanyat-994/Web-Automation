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