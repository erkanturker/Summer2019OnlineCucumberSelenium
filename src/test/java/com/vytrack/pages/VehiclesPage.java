package com.vytrack.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.vytrack.utilities.BrowserUtils;

public class VehiclesPage extends BasePage {

    @FindBy(css = "[title='Create Car']")
    public WebElement createCarElement;
    //use this method to click on Create a Car button
    public void clickToCreateCar ( ) {
       // p-BrowserUtils.waitforVisibilty ( createCarElement, 10 );
     //   BrowserUtils.waitForClickable ( createCarElement, 10 );
        BrowserUtils.clickWithWait ( createCarElement);
       // createCarElement.click ();

// i updated the codes
    }


}
