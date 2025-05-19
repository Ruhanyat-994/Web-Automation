package part3_4.com.demoqa.tests.part3.elements;

import com.base.base.BaseTest;
import com.demoqa.pages.elements.ElementsPageForDemoqa;
import com.demoqa.pages.elements.WebElementPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.saucedemo.pages.BasePage.delay;

public class TablesTest extends BaseTest {

    @Test
    public void testTables(){

        String email = "alden@example.com";

        String expectedAge = "99";

        WebElementPage webTablePage = homePageForDemoqa.goToElements().clickWebTable();
        webTablePage.clickEditButton();
        webTablePage.setAge(expectedAge);
        webTablePage.clickSubmitButton();
        String actualAge = webTablePage.ageUpdateVerification(email);
        Assert.assertEquals(expectedAge,actualAge,"Age do not match");

        delay(3000);


    }

}
