package com.vytrack.step_definition;

import com.vytrack.pages.CalendarEventsPage;
import com.vytrack.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class CalendarEventsStepDefinition {
    CalendarEventsPage calendarEventsPage = new CalendarEventsPage ();

    @Then("user verifies that that column names are displayed")
    public void user_verifies_that_that_column_names_are_displayed (List< String > dataTable) {
        System.out.println ( dataTable );
        calendarEventsPage.waitUntilLoaderMaskDisappear ();
        //This will be wait until the item visible on the page
        BrowserUtils.waitforVisibilty ( calendarEventsPage.viewPerPageToggle, 10 );
        calendarEventsPage.getColumnNames ();

        Assert.assertEquals ( dataTable, calendarEventsPage.getColumnNames () );
    }

}
