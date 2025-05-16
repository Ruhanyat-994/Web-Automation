package com.base.base;

import com.demoqa.pages.HomePageForDemoqa;
import com.owaspjs.pages.HomepageForJS;
import com.saucedemo.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static com.saucedemo.pages.BasePage.delay;
import static utilities.Utility.setUtilityDriver;

public class BaseTest {

    private WebDriver driver;

    protected BasePage basePage;

    protected HomePageForDemoqa homePageForDemoqa;
    protected HomepageForJS homepageForJS;

    private String DEMOQA_URL = "https://demoqa.com/";
    private String OWASP_URL = "http://localhost:3000/#/search";

    @BeforeClass
    public void setUp(){

        System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chromeDrover-win64\\chromedriver-win64\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();


    }

    @BeforeMethod
    public void loadApplication(){
        driver.get(DEMOQA_URL);
        basePage = new BasePage();

        basePage.setDriver(driver);
        setUtilityDriver();

        homePageForDemoqa = new HomePageForDemoqa();
        homepageForJS =  new HomepageForJS();

    }


    @AfterClass
    public void tearDown(){
        delay(2000);
        driver.quit();
    }

}
