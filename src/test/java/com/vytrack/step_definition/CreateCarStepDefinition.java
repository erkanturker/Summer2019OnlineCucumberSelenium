package com.vytrack.step_definition;

import com.vytrack.pages.CreateCarPAge;
import com.vytrack.pages.VehiclesPage;
import com.vytrack.utilities.BrowserUtils;
import io.cucumber.java.en.*;

import java.util.List;
import java.util.Map;

public class CreateCarStepDefinition {
    CreateCarPAge carPage;

    @Then("user clicks on {string} button")
    public void user_clicks_on_button (String string) {
        VehiclesPage vehiclesPage = new VehiclesPage ();
        vehiclesPage.waitUntilLoaderMaskDisappear ();
        BrowserUtils.waitForPageLoad ( 15 );
        vehiclesPage.clickToCreateCar ();


    }

    @Then("user adds new car information")
    public void user_adds_new_car_information (List< Map< String, String > > dataTable) {
        carPage = new CreateCarPAge ();
        BrowserUtils.wait ( 3 );
        int row=1; // we are starting with 1 because 0 is licence plate = licence plate
        //as many as we have data we can add like with followin

        for (Map<String,String> map:dataTable){
            carPage.licencePlateElement.sendKeys ( map.get ( "License Plate" ) );
            carPage.driveElement.sendKeys ( map.get ( "Driver" ) );
            carPage.locationElement.sendKeys ( map.get ( "Location" ) );
            carPage.modelYearElement.sendKeys ( map.get ( "Model Year" ) );
            carPage.colorElement.sendKeys ( map.get ( "Color" ) );
            BrowserUtils.wait ( 3 );
            if(row==dataTable.size ()){
                //if its last row - click save and close
                carPage.SaveandCloseToggle.click ();
                carPage.getSaveButtonElementFromMenu.click ();
            }
            else { //if its last row - click save and close
                carPage.SaveandCloseToggle.click ();
                carPage.saveAndNew.click ();}
            BrowserUtils.wait ( 3 );
            row++;
        }







        /*
        carPage.licencePlateElement.sendKeys ( dataTable.get ( 0 ).get ( "License Plate" ) );
        carPage.driveElement.sendKeys ( dataTable.get ( 0 ).get ( "Driver" ) );
        carPage.locationElement.sendKeys ( dataTable.get ( 0 ).get ( "Location" ) );
        carPage.modelYearElement.sendKeys ( dataTable.get ( 0 ).get ( "Model Year" ) );
        carPage.colorElement.sendKeys ( dataTable.get ( 0 ).get ( "Color" ) );
        carPage.saveButtonElement.click ();


         */


    }
}
