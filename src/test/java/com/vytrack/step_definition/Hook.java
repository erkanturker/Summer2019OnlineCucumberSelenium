package com.vytrack.step_definition;

import com.google.gson.internal.bind.util.ISO8601Utils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hook {
    @Before
    public void setup ( ) {
        System.out.println ("#####################");
        System.out.println ( "Test setup!" );
    }

    @After
    public void tearDown (Scenario scenario) {
        if (scenario.isFailed ()) {
            System.out.println ( "Test FAiled" );
        } else System.out.println ( "Clean up" );
        System.out.println ("######################");
        System.out.println ();
    }

}
