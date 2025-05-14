package part1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstSeleniumTest {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromeDrover-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }

    @AfterClass // for cleaning up we use this command
    public void turnDown(){
//        if(driver != null){
//            driver.quit();
//        }

    }

    @Test
    public void testLoginApplication() throws InterruptedException{

        Thread.sleep(2000);
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));

        // here is the code for Action

        username.sendKeys("Admin");

        password.sendKeys("admin123");

        driver.findElement(By.tagName("button")).click();

        Thread.sleep(2000);
        String actualResult = driver.findElement(By.tagName("h6")).getText();

        String expectedResult = "Dashboard";

        Assert.assertEquals(actualResult,expectedResult);

//        WebElement forgetPass = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[4]/p"));
//
//        forgetPass.click();

    }




}
