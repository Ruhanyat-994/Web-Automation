package com.saucedemo.pages;

import org.openqa.selenium.By;

public class ProductsPage extends BasePage {

    private By productsHeader = By.xpath("//*[@id=\"header_container\"]/div[2]/span");

    public boolean isProductsHeaderDisplayed(){
        return find(productsHeader).isDisplayed();
    }

}
