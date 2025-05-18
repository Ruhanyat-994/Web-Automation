package part3_4.com.demoqa.tests.part3.forms;

import com.base.base.BaseTest;
import com.demoqa.pages.forms.PracticeFormPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxTest extends BaseTest {

    @Test
    public void testCheckBox(){
        PracticeFormPage formPage = homePageForDemoqa.goToForms().clickPracticeForm();
        formPage.sportsCheckBoxClick();
        formPage.readingCheckBoxClick();
        formPage.musicCheckBoxClick();
        formPage.uncheckTheReadingCheckbox();
        boolean readingUnchecked= formPage.isReadinCheckBoxIsUnchecked();



        Assert.assertFalse(readingUnchecked,
                "\n Reading CheckBox is Selected \n");
    }
}
