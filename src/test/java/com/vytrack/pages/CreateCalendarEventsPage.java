package com.vytrack.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vytrack.utilities.Driver;

public class CreateCalendarEventsPage extends BasePage {

    @FindBy(css = "[class='select2-chosen']")
    public WebElement owner;

    public CreateCalendarEventsPage(){
        PageFactory.initElements ( Driver.get (),this );
    }


}
