package com.demoqa.pages.elements;

import com.demoqa.pages.elements.ElementsPageForDemoqa;
import com.saucedemo.pages.BasePage;
import org.openqa.selenium.By;

import static utilities.JavaScriptUtility.clickJS;
import static utilities.JavaScriptUtility.scrollToElementJS;

public class WebElementPage extends ElementsPageForDemoqa {
    private By registrationAgeField = By.id("age");
    private By sumitButton = By.id("submit");

    public void clickWebtablesElement(String email){

        By editButton = By.xpath("//div[text()='"+email+"']//following::span[@id=\"edit-record-2\"]");
        scrollToElementJS(editButton);
        clickJS(editButton);

    }


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
    public String ageUpdateVerification(String age){
        By ageElement = By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[2]/div[2]/div/div[3]");
        return find(ageElement).getText();

    }

}