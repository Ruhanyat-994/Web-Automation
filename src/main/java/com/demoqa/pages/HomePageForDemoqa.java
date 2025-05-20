package com.demoqa.pages;

import com.demoqa.pages.elements.ElementsPageForDemoqa;
import com.demoqa.pages.forms.FormsPageForDemoqa;
import com.demoqa.pages.widgets.WidgetsPageForDemoqa;
import com.saucedemo.pages.BasePage;
import net.bytebuddy.implementation.MethodCall;
import org.openqa.selenium.By;

import static utilities.JavaScriptUtility.clickJS;
import static utilities.JavaScriptUtility.scrollToElementJS;

// This is another website but We will use the basepage that we made previously
public class HomePageForDemoqa extends BasePage {
    private By formsCard = By.xpath("/html/body/div[2]/div/div/div[2]/div/div[2]/div/div[3]/h5");
    private By elementsCard = By.xpath("/html/body/div[2]/div/div/div[2]/div/div[1]/div/div[3]/h5");
    private By widgetsCard = By.xpath("//h5[text()='Widgets']");



    public FormsPageForDemoqa goToForms(){
        scrollToElementJS(formsCard);

        click(formsCard);
        return new FormsPageForDemoqa();
    }
    public ElementsPageForDemoqa goToElements(){
        scrollToElementJS(elementsCard);
        clickJS(elementsCard);
        return new ElementsPageForDemoqa();
    }
    public WidgetsPageForDemoqa goToWidgets(){
        scrollToElementJS(widgetsCard);
        clickJS(widgetsCard);
        return new WidgetsPageForDemoqa();
    }

}
