package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CalendarEventsPage extends BasePage {

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    public CalendarEventsPage(){
        PageFactory.initElements ( Driver.get (),this );
    }

    public void clikcToCreateCalendarEvent(){
        BrowserUtils.waitforVisibilty ( createCalendarEvent,10 );
        BrowserUtils.waitForClickable ( createCalendarEvent,10);
        createCalendarEvent.click ();


    }


}
