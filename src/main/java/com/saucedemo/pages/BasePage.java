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
