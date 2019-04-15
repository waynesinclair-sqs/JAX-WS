Feature:GEO IP Service

  As a flight booking agent
  I wish to make use of an online GEO IP Service
  So that I can provide correct ISO codes

  Scenario:Get country name from ISO code
    Given that the online GEOIP service is running
    When 	I pass the ISO code
    Then 	It returns the country