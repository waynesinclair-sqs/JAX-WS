package com.expleo.webservice.stepdefs;

import com.expleo.webservice.steps.GeoIPServiceSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class GEOIPServiceStepDefs {

    @Steps
    GeoIPServiceSteps steps;

    @Given("^that the online GEOIP service is running$")
    public void thatTheOnlineGEOIPServiceIsRunning() throws Throwable {

        System.out.println("In @Given");
        steps.connectToGEOIPService();
        //TODO Add try-catch here
    }

    @When("^I pass the ISO code$")
    public void iPassTheISOCode() throws Throwable {
        //geoIPServiceSoap.getCountryNameByISO2(isoCode1);
        steps.passISOCode("ZA");
    }

    @Then("^It returns the country: {0}$")
    public void itReturnsTheCountry() throws Throwable {
        steps.assertCountry("SOUTH AFRICA");
    }
}
