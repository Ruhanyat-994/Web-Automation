package com.demoqa.pages.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static utilities.DropDownUtility.*;
import static utilities.JavaScriptUtility.*;

public class SelectManuPage extends WidgetsPageForDemoqa{

    private By multiSelectDropDown = By.xpath("//div[text()='Select...']");

    private By standardMultiSelect = By.id("cars");

    public void clickMultiSelectDropDown(){
        scrollToElementJS(multiSelectDropDown);
        clickJS(multiSelectDropDown);
        find(multiSelectDropDown).sendKeys("Blue");
        new WidgetsPageForDemoqa();
    }
    public void selectStandardMulti(String text){
        scrollToElementJS(standardMultiSelect);

//        Select select = new Select(find(standardMultiSelect));
//        select.selectByVisibleText(text);
        // the commented lines work same as the selectByVisibleText() method

        selectByVisibleText(standardMultiSelect,text);
    }

    public void selectStandardMulti(int index){
        scrollToElementJS(standardMultiSelect);

        selectByIndex(standardMultiSelect,index);
    }

    public void deSelectStandardMulti(int index){
        scrollToElementJS(standardMultiSelect);
        deSelectByIndex(standardMultiSelect,index);

    }
    public List<String> getAllSelectedStandardMultiOptions(){

        return getAllSelectedOptions(standardMultiSelect);
    }



}
