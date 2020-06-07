package com.vytrack.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/Login.feature",
        glue = "com/vytrack/step_definition",
        dryRun = false,
        tags = "",
        plugin = {"html:target/default-cucumber-reports"})
// dryRun = true it will not make yourcode work. Is chekcin only code implementation

public class CucumberRunner {
}
