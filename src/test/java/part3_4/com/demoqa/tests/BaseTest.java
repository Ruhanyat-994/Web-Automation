package part3_4.com.demoqa.tests;

import com.demoqa.pages.HomePage;
import com.saucedemo.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import part2.com.saucedemo.base.Basetest;

public class BaseTest {

    private WebDriver driver;

    protected BasePage basePage;

    protected HomePage homePage;

    private String DEMOQA_URL = "https://demoqa.com/";

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromeDrover-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }
    @BeforeMethod
    public void loadApplication(){
        driver.get(DEMOQA_URL);
        basePage = new BasePage();
        basePage.setDriver(driver);
        homePage = new HomePage();

    }

    @AfterClass
    public void tearDown(){

        driver.quit();
    }
}
