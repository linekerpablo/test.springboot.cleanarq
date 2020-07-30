package test.java.springboot.cleanarq.api.cleanarq.gateway.integration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import test.java.springboot.cleanarq.api.cleanarq.gateway.integration.interfaces.GoogleGeocodingGetLatLngUseCase;
import test.java.springboot.cleanarq.api.cleanarq.gateway.integration.models.GoogleAddress;
import test.java.springboot.cleanarq.api.cleanarq.gateway.integration.models.GoogleGeometry;
import test.java.springboot.cleanarq.api.cleanarq.gateway.integration.models.GoogleResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class GoogleGeocodingGetLatLngUseCaseService implements GoogleGeocodingGetLatLngUseCase {
    @Value("${googleGeocodingApi.url}")
    private String url;

    @Value("${googleGeocodingApi.key}")
    private String key;

    public Map execute(Integer number, String streetName, String city, String state) {
        Map response = new HashMap();

        RestTemplate restTemplate = new RestTemplate();

        String addressConcat =
                url.concat("?address=")
                .concat(number.toString())
                .concat("+")
                .concat(streetName)
                .concat("+")
                .concat(city)
                .concat("+")
                .concat(state)
                .concat("&key=")
                .concat(key);

        GoogleAddress googleAddress = (restTemplate.getForEntity(addressConcat, GoogleAddress.class)).getBody();
        GoogleResult googleResult = googleAddress.getResults().get(0);
        GoogleGeometry googleGeometry = googleResult.getGeometry();

        response.put("lat", googleGeometry.getLocation().getLat());
        response.put("lng", googleGeometry.getLocation().getLng());

        return response;
    }
}
