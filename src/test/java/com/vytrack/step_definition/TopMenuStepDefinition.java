package com.vytrack.step_definition;

import com.vytrack.pages.LoginPage;
import io.cucumber.java.en.*;

public class TopMenuStepDefinition {
    LoginPage loginPage = new LoginPage ();

    @When("user navigates to {string} then to {string}")
    public void user_navigates_to_then_to (String module, String subModule) {
        loginPage.navigateTo ( module, subModule );

    }

}