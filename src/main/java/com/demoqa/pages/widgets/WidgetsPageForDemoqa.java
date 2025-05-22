package com.demoqa.pages.widgets;

import com.demoqa.pages.HomePageForDemoqa;
import com.demoqa.pages.elements.ElementsPageForDemoqa;
import org.openqa.selenium.By;

import static utilities.JavaScriptUtility.clickJS;
import static utilities.JavaScriptUtility.scrollToElementJS;

public class WidgetsPageForDemoqa extends HomePageForDemoqa {

   private By selectMenu = By.xpath("//span[text()='Select Menu']");


    public SelectManuPage clickSelectMenuButton(){
        scrollToElementJS(selectMenu);
        clickJS(selectMenu);
        return new SelectManuPage();

    }

    private By selectDatePicker = By.xpath("//span[text()='Date Picker']");

    public SelectDatePicker clickSelectDatePicker(){
        scrollToElementJS(selectDatePicker);
        clickJS(selectDatePicker);
        return new SelectDatePicker();
    }

}







