package test.java.springboot.cleanarq.api.cleanarq.gateway.integration.interfaces;

import java.util.Map;

public interface GoogleGeocodingGetLatLngUseCase {
    Map execute(Integer number, String streetName, String city, String state);
}
