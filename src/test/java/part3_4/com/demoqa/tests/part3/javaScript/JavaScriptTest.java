package part3_4.com.demoqa.tests.part3.javaScript;

import org.testng.annotations.Test;
import com.base.base.BaseTest;

public class JavaScriptTest extends BaseTest {

    @Test
    public void testScrollingToElement(){
        homePage.goToForms();
    }
}
