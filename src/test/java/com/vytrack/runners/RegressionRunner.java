package com.vytrack.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/activities", "src/test/resources/features/activities"},
        glue = "com/vytrack/step_definition",
        dryRun = false,
        plugin = {"html:target/default-cucumber-reports",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt"
        })
// dryRun = true it will not make yourcode work. Is chekcin only code implementation

public class RegressionRunner {
}
