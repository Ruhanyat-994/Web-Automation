package com.demoqa.pages;

import com.demoqa.pages.forms.FormsPage;
import com.saucedemo.pages.BasePage;
import org.openqa.selenium.By;

import static utilities.JavaScriptUtility.scrollToElementJS;

// This is another website but We will use the basepage that we made previously
public class HomePage extends BasePage {
    private By formsCard = By.xpath("/html/body/div[2]/div/div/div[2]/div/div[2]/div/div[3]/h5");

    public FormsPage goToForms(){
        scrollToElementJS(formsCard);

        click(formsCard);
        return new FormsPage();
    }

}
