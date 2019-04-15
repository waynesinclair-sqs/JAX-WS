package com.expleo.webservice.steps;

import com.expleo.webservice.jaxws.GeoIPService;
import com.expleo.webservice.jaxws.GeoIPServiceSoap;
import net.thucydides.core.annotations.Step;

import static com.expleo.utils.getTagValue;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;;

public class GeoIPServiceSteps {

    GeoIPService ipService;
    GeoIPServiceSoap geoIPServiceSoap;
    String isoCode = "";
    String countryXML = "";

    public GeoIPServiceSteps(){
       geoIPServiceSoap = null;
        String isoCode = "";
    }

    @Step("Connect to GEOIPService")
    public void connectToGEOIPService(){

        System.out.println("In connectToGEOIPService");
        ipService = new GeoIPService(); // Create new instance of service
        geoIPServiceSoap = ipService.getGeoIPServiceSoap(); // Create Soap object
        //this.isoCode = countryCode;
    }

    @Step("Pass ISO code {0} to GEOIP Service")
    public void passISOCode(String countryCode) {
        countryXML = geoIPServiceSoap.getCountryNameByISO2(countryCode);
        System.out.println("Country is: " + countryXML);
    }

    @Step
    public void assertCountry(String countryName) {
         String receivedCountryName = getTagValue(countryXML, "Country");

        assertThat(countryName,is(equalTo(receivedCountryName)));
    }
}
