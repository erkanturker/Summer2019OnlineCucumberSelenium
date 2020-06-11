package com.vytrack.step_definition;


import com.vytrack.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;





public class Hook {
    @Before
    public void setup ( ) {
        Driver.get ().manage ().window ().maximize ();
    }

    @After
    public void tearDown (Scenario scenario) {
        if (scenario.isFailed ()) {
            System.out.println ( "Test FAiled" );
            byte[] screenshot =((TakesScreenshot)Driver.get ()).getScreenshotAs ( OutputType.BYTES );
            scenario.embed (  screenshot,"image/png");

        } else System.out.println ( "Clean up" );
        System.out.println ("######################");
        System.out.println ();
        // After every test we will close browser
        Driver.close ();
    }

}
