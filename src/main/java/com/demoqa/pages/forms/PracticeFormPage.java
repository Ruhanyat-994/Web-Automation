package com.demoqa.pages.forms;

import org.openqa.selenium.By;

import static utilities.JavaScriptUtility.clickJS;
import static utilities.JavaScriptUtility.scrollToElementJS;

public class PracticeFormPage extends FormsPageForDemoqa{
    private By femaleRadioButton = By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[3]/div[2]/div[2]/label");

    public void clickFemaleRadioButton(){

        scrollToElementJS(femaleRadioButton);
        click(femaleRadioButton);
    }
    private By sportsCheckBox = By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[7]/div[2]/div[1]/label");
    private By readingCheckBox = By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[7]/div[2]/div[2]/label");
    private By musicCheckBox = By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[7]/div[2]/div[3]/label");

    public void sportsCheckBoxClick(){
        if (!find(sportsCheckBox).isSelected()){
            scrollToElementJS(sportsCheckBox);
            clickJS(sportsCheckBox);
        }
    }

    public void readingCheckBoxClick(){
        if(!find(readingCheckBox).isSelected()){
            scrollToElementJS(readingCheckBox);
            clickJS(readingCheckBox);
        }
    }

    public void musicCheckBoxClick(){
        if(!find(musicCheckBox).isSelected()){
            scrollToElementJS(musicCheckBox);
            clickJS(musicCheckBox);
        }
    }

    public void uncheckTheReadingCheckbox(){
        if(find(readingCheckBox).isSelected()){
            scrollToElementJS(readingCheckBox);
            clickJS(readingCheckBox);
        }
    }

    public boolean isReadinCheckBoxIsUnchecked(){
        return find(readingCheckBox).isSelected();
    }

}