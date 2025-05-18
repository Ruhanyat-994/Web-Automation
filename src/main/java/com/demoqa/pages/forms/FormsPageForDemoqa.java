package com.demoqa.pages.forms;

import com.demoqa.pages.HomePageForDemoqa;
import org.openqa.selenium.By;
import org.w3c.dom.css.CSS2Properties;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class FormsPageForDemoqa extends HomePageForDemoqa {
    private By practiceFormManuItem = By.xpath("/html/body/div[2]/div/div/div/div[1]/div/div/div[2]/div/ul/li/span");
    public PracticeFormPage clickPracticeForm(){
        scrollToElementJS(practiceFormManuItem);
        click(practiceFormManuItem);
        return new PracticeFormPage();
    }



}