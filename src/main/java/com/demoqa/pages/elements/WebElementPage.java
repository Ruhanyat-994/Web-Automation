package com.demoqa.pages.elements;

import com.demoqa.pages.elements.ElementsPageForDemoqa;
import org.openqa.selenium.By;

import static utilities.JavaScriptUtility.clickJS;

public class WebElementPage extends ElementsPageForDemoqa {
    private By registrationAgeField = By.id("age");
    private By sumitButton = By.id("submit");


    public void clickEditButton(){

        By editButton = By.xpath("//*[@id=\"edit-record-2\"]");
        clickJS(editButton);
    }

    public void setAge(String age){
        set(registrationAgeField,age);
    }
    public  void clickSubmitButton(){
        clickJS(sumitButton);
    }
}