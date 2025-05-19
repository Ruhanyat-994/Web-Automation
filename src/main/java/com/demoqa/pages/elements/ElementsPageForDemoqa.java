package com.demoqa.pages.elements;

import com.demoqa.pages.HomePageForDemoqa;
import com.demoqa.pages.forms.FormsPageForDemoqa;
import com.saucedemo.pages.BasePage;
import org.openqa.selenium.By;

import static utilities.JavaScriptUtility.clickJS;
import static utilities.JavaScriptUtility.scrollToElementJS;

public class ElementsPageForDemoqa extends HomePageForDemoqa {

    private By webTablesMenu = By.xpath("/html/body/div[2]/div/div/div/div[1]/div/div/div[1]/div/ul/li[4]/span");
    public WebElementPage clickWebTable(){
        scrollToElementJS(webTablesMenu);
        clickJS(webTablesMenu);
        return new WebElementPage();
    }





}
