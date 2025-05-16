package part3_4.com.demoqa.tests.part3.forms;


import com.base.base.BaseTest;
import com.demoqa.pages.forms.PracticeFormPage;
import org.testng.annotations.Test;

public class RadioButtonTest extends BaseTest {
    @Test
    public void testRadioButton(){
        PracticeFormPage formPage = homePageForDemoqa.goToForms().clickPracticeForm();
        formPage.clickFemaleRadioButton();
    }
}