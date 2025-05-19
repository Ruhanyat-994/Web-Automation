package part3_4.com.demoqa.tests.part3.elements;

import com.base.base.BaseTest;
import com.demoqa.pages.elements.LinksPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import sun.awt.image.ImageWatched;

public class LinksTest extends BaseTest {
    @Test
    public void testLinks(){
        LinksPage linksPage = homePageForDemoqa.goToElements().clickLinksElements();
        linksPage.clickLink();
        String linksCheck = linksPage.getResponse();
        Assert.assertTrue(linksCheck.contains("403") && linksCheck.contains("Forbidden"),
                "\n Actual Response ("+linksCheck+
                        ")\n doesn't contains 403 and Forbidden String");

    }

}
