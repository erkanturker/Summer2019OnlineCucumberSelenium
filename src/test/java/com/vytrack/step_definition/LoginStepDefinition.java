package com.vytrack.step_definition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginStepDefinition {
    @Given("user is on the login page")
    public void user_is_on_the_login_page ( ) {
        System.out.println ( "I am on he login page" );
    }

    @Then("user logs in as store manager")
    public void user_logs_in_as_store_manager ( ) {
        System.out.println ( "Login as a store manager" );
    }

    // any string in "word" will become a parameter check login feature
    @Then("user verifies that {string} page subtitle is displayed")
    public void user_verifies_that_page_subtitle_is_displayed (String string) {
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
        System.out.println ("login with "+string+" username and "+ string2+" password");
    }

    @Then("user verifies that {string} message is displayed")
    public void user_verifies_that_message_is_displayed (String string) {
        System.out.println ("Verifed that warning message is displayed "+string);

    }


}
