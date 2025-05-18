package part3_4.com.demoqa.tests.part3.elements;

import com.base.base.BaseTest;
import com.demoqa.pages.elements.ElementsPageForDemoqa;
import com.demoqa.pages.elements.WebElementPage;
import org.testng.annotations.Test;

import static com.saucedemo.pages.BasePage.delay;

public class TablesTest extends BaseTest {

    @Test
    public void testTables(){

        String expectedAge = "99";

        WebElementPage webTablePage = homePageForDemoqa.goToElements().clickWebtablesElement();
        webTablePage.clickEditButton();
        webTablePage.setAge(expectedAge);
        webTablePage.clickSubmitButton();
        delay(3000);


    }

}
