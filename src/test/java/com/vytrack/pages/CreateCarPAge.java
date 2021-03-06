package com.vytrack.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;

public class CreateCarPAge extends BasePage {

    @FindBy(css = "[id^='custom_entity_type_LicensePlate']")
    public WebElement licencePlateElement;

    @FindBy(name = "custom_entity_type[Driver]")
    public WebElement driveElement;

    @FindBy(name = "custom_entity_type[Location]")
    public WebElement locationElement;

    @FindBy(name = "custom_entity_type[ModelYear]")
    public WebElement modelYearElement;

    @FindBy(name = "custom_entity_type[Color]")
    public WebElement colorElement;

    @FindBy(css = "div[id*=FuelType]")
    public WebElement fuelTypeElement;

    @FindBy(name = "custom_entity_type[Logo][file]")
    public WebElement logoElement;

    @FindBy(xpath = "//button[@type='submit'][contains(text(),'Save and Close')]")
    public WebElement getSaveButtonElementFromMenu;

    @FindBy(css = "[class='btn btn-success action-button']")
    public WebElement saveButtonElement;

    @FindBy(xpath = "//li//button[contains(text(),'Save and New')]")
    public WebElement saveAndNew;

    @FindBy(css = "a[class='btn-success btn dropdown-toggle']")
    public WebElement SaveandCloseToggle;



/*
This method stands for selecting tags
provide tagname to select
if checkbox already selected it will not do anyting
@param tagName
@return webelemnt of the checkbox that was selected
 */

    public WebElement selectTags (String TagName) {
        //locator for checkbox is based on label name
        //label and checkbox are siblings

        String locator = "//label[text()='" + TagName + "']/preceding-sibling::input[@type='checkbox']";
        WebElement checkBox = Driver.get ().findElement ( By.xpath ( locator ) );
        BrowserUtils.waitforVisibilty ( checkBox, 10 );
        BrowserUtils.waitForClickable ( checkBox, 10 );
        if (!checkBox.isSelected ()) {
            checkBox.click ();
        }
        return checkBox;
    }


    /*
    Select fuel type by visible Text
    @parem fuelType - Diesel,Electric, Hybrid
    usage: CreateCarPage createCarPage= new CreateCarPage();
    to select to gasaloine type
    createCarPage.selectFuelType(Diesel) if you want to select Diesel
     */
    public void selectFuelType (String fuelType) {
        String locator = "//div[@class='select2-result-label' and text()='" + fuelType + "']";
        BrowserUtils.waitForClickable ( fuelTypeElement, 10 );
        fuelTypeElement.click ();
        WebElement fuelTyoeSelectionElement = Driver.get ().findElement ( By.xpath ( locator ) );
        BrowserUtils.waitForClickable ( fuelTyoeSelectionElement, 15 );
        fuelTyoeSelectionElement.click ();
    }

    /*
    This method will upload a file
    File from your computer
    @param pathtoTheFile that you want to upload

     */
    public void uploadLoga (String pathToTheFile) {
        BrowserUtils.waitforVisibilty ( logoElement, 10 );
        logoElement.sendKeys ( pathToTheFile );
    }

    public void clickSaveAndNew ( ) {
        waitUntilLoaderMaskDisappear ();
       BrowserUtils.clickWithWait ( SaveandCloseToggle );
        BrowserUtils.wait ( 4 );
        BrowserUtils.waitforVisibilty ( saveAndNew, 5 );
        BrowserUtils.clickWithWait ( saveAndNew );
    }

    public void saveAndClose ( ) {
        waitUntilLoaderMaskDisappear ();
        BrowserUtils.clickWithWait ( SaveandCloseToggle );
        BrowserUtils.waitforVisibilty ( getSaveButtonElementFromMenu, 5 );
        BrowserUtils.clickWithWait ( getSaveButtonElementFromMenu );
    }


}
