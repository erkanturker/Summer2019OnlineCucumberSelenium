package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;


public class CalendarEventsPage extends BasePage {

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    @FindBy(css = "span[class='grid-header-cell__label']")
    public List< WebElement > tableColumnName;

    @FindBy(css = "div[class*='btn-group'] >ul[class='dropdown-menu pull-right']>li")
    public List<WebElement> viewPerPAgeOption;

    @FindBy(css="button[data-toggle='dropdown'][class='btn dropdown-toggle ']")
    public WebElement viewPerPageToggle;


    public CalendarEventsPage ( ) {
        PageFactory.initElements ( Driver.get (), this );
    }


    public void clikcToCreateCalendarEvent ( ) {
        BrowserUtils.waitforVisibilty ( createCalendarEvent, 10 );
        BrowserUtils.waitForClickable ( createCalendarEvent, 10 );
        createCalendarEvent.click ();


    }

    public List< String > getColumnNames ( ) {
        List< String > stringList = BrowserUtils.getListofString ( tableColumnName );
        return stringList;
    }

    public List<String>getListperViewItem(){
        BrowserUtils.waitforVisibilty ( viewPerPageToggle,10 );
        BrowserUtils.waitForClickable ( viewPerPageToggle,10 );
        viewPerPageToggle.click ();
        List<String> stringList = BrowserUtils.getListofString ( viewPerPAgeOption );
        return stringList;
    }






}
