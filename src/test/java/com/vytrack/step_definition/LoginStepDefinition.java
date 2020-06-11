package com.vytrack.step_definition;

import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.*;
import io.cucumber.java.en.*;
import org.junit.Assert;
import java.util.Map;

public class LoginStepDefinition {
    LoginPage loginPage = new LoginPage ();

    @Given("user is on the login page")
    public void user_is_on_the_login_page ( ) {
        Driver.get ().get ( ConfigurationReader.getProperty ( "url" ) );
    }

    @Then("user logs in as store manager")
    public void user_logs_in_as_store_manager ( ) {
        System.out.println ( "Login as a store manager" );
        String userName= ConfigurationReader.getProperty ( "user_name" );
        String password= ConfigurationReader.getProperty ( "password" );
        loginPage.login ( userName,password );
    }

    // any string in "word" will become a parameter check login feature
    @Then("user verifies that {string} page subtitle is displayed")
    public void user_verifies_that_page_subtitle_is_displayed (String string) {
        loginPage.waitUntilLoaderMaskDisappear ();
        BrowserUtils.wait ( 3 );
        Assert.assertEquals ( string,loginPage.getSubtitle () );
        System.out.println ( "Verifying page subtitle " + string );
    }

    @Then("user logs in as driver")
    public void user_logs_in_as_driver ( ) {
        System.out.println ( "Login as Driver" );
    }

    @Then("user logs in as sales manager")
    public void user_logs_in_as_sales_manager ( ) {
        System.out.println ( "Login as sales manager" );
    }

    //thenuser enters "storemanger username and wrong password
    @Then("users enters {string} username and {string} password")
    public void users_enters_username_and_password (String string, String string2) {
        System.out.println ( "login with " + string + " username and " + string2 + " password" );
        loginPage.login ( string,string2 );
    }

    @Then("user verifies that {string} message is displayed")
    public void user_verifies_that_message_is_displayed (String string) {
        System.out.println ( "Verifed that warning message is displayed " + string );

    }

    @Then("user logs in as driver with following credintals")
    public void user_logs_in_as_driver_with_following_credintals(Map<String,String> dataTable) {
        System.out.println (dataTable);
        loginPage.login ( dataTable.get ( "username" ),dataTable.get ( "password" ) );
    }

    @Then("user logs in as {string}")
    public void user_logs_in_as(String role) {
        loginPage.login ( role );
    }
    @Then("the page title should be {string}")
    public void the_page_title_should_be(String string) {
        BrowserUtils.waitForPageTitle ( string );
        Assert.assertEquals ( string,Driver.get ().getTitle () );
    }


}
