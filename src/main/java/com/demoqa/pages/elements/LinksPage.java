package com.demoqa.pages.elements;

import org.openqa.selenium.By;

import static utilities.JavaScriptUtility.clickJS;
import static utilities.JavaScriptUtility.scrollToElementJS;

public class LinksPage extends ElementsPageForDemoqa{

    private  By forbiddenLinksPath = By.xpath("//a[@id='forbidden']");
    private By responseMessage = By.xpath("//p[@id='linkResponse']");
    public void clickLink(){

        scrollToElementJS(forbiddenLinksPath);
        clickJS(forbiddenLinksPath);
    }
    public String getResponse(){

        delay(2000);
        scrollToElementJS(responseMessage);
        return find(responseMessage).getText();
    }


}
