package com.demoqa.pages.widgets;

import org.openqa.selenium.By;

import static utilities.DropDownUtility.selectByVisibleText;

public class SelectDatePicker extends WidgetsPageForDemoqa{


    private By selectDateField = By.id("datePickerMonthYearInput");

    private By monthDropDown = By.className("react-datepicker__month-select"); // If I use without dot I have to use className
    private By yearDropDown = By.cssSelector(".react-datepicker__year-select"); // If I use Dot then I have to use cssSelector

    private By dayValue (String day){


        return By.xpath(
                "//div[contains(@class,'react-datepicker__day" +
                        " react-datepicker__day--')]" +
                        "[text()='"+day+"']");

    }


    public void clickSelectDate(){
        click(selectDateField);

    }
    public String getDate(){
        return find(selectDateField).getAttribute("value") ;
        // can not use the getText() method because the value attribute is in the input field;

    }

    public void selectMonth(String month){
        selectByVisibleText(monthDropDown,month);
    }

    public void selectYear(String year){
        selectByVisibleText(yearDropDown,year);
    }


    public void clickDay(String day){

        click(dayValue(day));

    }

    public boolean isDayInMonth(String day){ // By this method we can check if
        // the months are having 31 days or not.
        return find(dayValue(day)).isDisplayed();

    }




}
