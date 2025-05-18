package com.demoqa.pages.elements;

import com.demoqa.pages.HomePageForDemoqa;
import com.demoqa.pages.forms.FormsPageForDemoqa;
import com.saucedemo.pages.BasePage;
import org.openqa.selenium.By;

import static utilities.JavaScriptUtility.clickJS;
import static utilities.JavaScriptUtility.scrollToElementJS;

public class ElementsPageForDemoqa extends HomePageForDemoqa {

    private By webTablesElement = By.xpath("/html/body/div[2]/div/div/div/div[1]/div/div/div[1]/div/ul/li[4]/span");
    public WebElementPage clickWebtablesElement(){
        scrollToElementJS(webTablesElement);
        clickJS(webTablesElement);
        return new WebElementPage();
    }




}
