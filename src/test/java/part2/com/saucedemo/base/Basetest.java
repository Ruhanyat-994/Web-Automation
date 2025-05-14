package part2.com.saucedemo.base;

import com.saucedemo.pages.BasePage;
import com.saucedemo.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Basetest {

    protected WebDriver driver;

    protected BasePage basePage;
    protected LoginPage loginPage;



    private String url = "https://www.saucedemo.com";

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromeDrover-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get(url);
        basePage = new BasePage();
        basePage.setDriver(driver);
        loginPage = new LoginPage();

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
