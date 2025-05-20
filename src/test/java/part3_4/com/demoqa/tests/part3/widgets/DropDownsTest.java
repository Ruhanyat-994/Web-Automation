package part3_4.com.demoqa.tests.part3.widgets;

import com.base.base.BaseTest;
import com.demoqa.pages.widgets.SelectManuPage;
import com.demoqa.pages.widgets.WidgetsPageForDemoqa;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DropDownsTest extends BaseTest {
    @Test
    public void testingDropDowns(){
        SelectManuPage dropdownTesting = homePageForDemoqa.goToWidgets().clickSelectMenuButton();
        //dropdownTesting.clickMultiSelectDropDown();
        dropdownTesting.selectStandardMulti("Volvo");
        dropdownTesting.selectStandardMulti(1);
        dropdownTesting.selectStandardMulti(3);
        dropdownTesting.selectStandardMulti(2);
        dropdownTesting.deSelectStandardMulti(3);
        List<String> actualSelectedOptions =
                dropdownTesting.getAllSelectedStandardMultiOptions();
        Assert.assertTrue(actualSelectedOptions.contains("Volvo"));
        Assert.assertTrue(actualSelectedOptions.contains("Opel"));
        Assert.assertTrue(actualSelectedOptions.contains("Saab"));
        Assert.assertTrue(actualSelectedOptions.contains("Audi"),"\n" +
                "Audi is selected as an Option\n");
    }

}
