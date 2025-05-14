package com.owaspjs.pages;

import com.saucedemo.pages.BasePage;
import org.openqa.selenium.By;

public class HomepageForJS extends BasePage {

    private By dismissPopup = By.xpath("//*[@id=\"mat-mdc-dialog-0\"]/div/div/app-welcome-banner/div[2]/button[2]/span[2]/span");
    private By greenSmoothie = By.xpath("/html/body/app-root/mat-sidenav-container/mat-sidenav-content/app-search-result/div/div/div[2]/mat-grid-list/div/mat-grid-tile[8]/div/mat-card/div/div[1]");



}
