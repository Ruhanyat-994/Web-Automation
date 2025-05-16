package com.demoqa.pages.forms;

import org.openqa.selenium.By;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class PracticeFormPage extends FormsPageForDemoqa{
    private By femaleRadioButton = By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[3]/div[2]/div[2]/label");

    public void clickFemaleRadioButton(){

        scrollToElementJS(femaleRadioButton);
        click(femaleRadioButton);
    }

}