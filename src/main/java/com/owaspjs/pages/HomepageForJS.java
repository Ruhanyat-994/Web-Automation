package com.owaspjs.pages;


import com.owaspjs.pages.lemon.LemonPage;
import com.saucedemo.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class HomepageForJS extends BasePage {

    private By dismissPopup = By.xpath("//*[@id=\"mat-mdc-dialog-0\"]/div/div/app-welcome-banner/div[2]/button[2]/span[2]/span");
    private By greenSmoothie = By.xpath("/html/body/app-root/mat-sidenav-container/mat-sidenav-content/app-search-result/div/div/div[2]/mat-grid-list/div/mat-grid-tile[7]/div/mat-card/div/div[1]");


    public LemonPage goToOwaspLemonJuice(){


        WebElement lemonImage = waitForElement(greenSmoothie);

        click(dismissPopup);
        scrollToElementJS(greenSmoothie);
        click(greenSmoothie);
        return new LemonPage();

    }



}
