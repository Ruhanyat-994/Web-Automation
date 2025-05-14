package part2.com.saucedemo.tests.products;

import com.saucedemo.pages.ProductsPage;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import part2.com.saucedemo.base.Basetest;

public class Productstest extends Basetest {
    @Test
    public void testProductHeaderDisplayed(){
        ProductsPage productsPage = loginPage.
                loginIntoApplication("standard_user","secret_sauce");

       assertTrue(productsPage.isProductsHeaderDisplayed(),"\n Products Header is Not Displayed \n");

    }

}
