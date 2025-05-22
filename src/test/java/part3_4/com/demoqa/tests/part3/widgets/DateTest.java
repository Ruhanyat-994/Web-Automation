package part3_4.com.demoqa.tests.part3.widgets;

import com.base.base.BaseTest;
import com.demoqa.pages.widgets.SelectDatePicker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DateTest extends BaseTest {

    @Test
    public void testSelectingDate(){
        String month = "January";
        String monthNumber = "01";
        String year = "2010";
        String day = "31";
        SelectDatePicker datePicker = homePageForDemoqa.goToWidgets().clickSelectDatePicker();

        datePicker.clickSelectDate();
        datePicker.selectMonth(month);
        datePicker.selectYear(year);
        datePicker.clickDay(day);

        String actualDate = datePicker.getDate();
        String expectedDate = monthNumber + "/" + day + "/" + year;

        Assert.assertEquals(actualDate,expectedDate,"\nActual & Expected Don't Match" +
                "\nActual Date: "+actualDate+
                "\nExpected Date: "+expectedDate);
    }



}
