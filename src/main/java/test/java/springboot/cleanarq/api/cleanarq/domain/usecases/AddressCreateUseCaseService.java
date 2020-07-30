package test.java.springboot.cleanarq.api.cleanarq.domain.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import test.java.springboot.cleanarq.api.cleanarq.domain.entities.AddressDomain;
import test.java.springboot.cleanarq.api.cleanarq.domain.usecases.interfaces.AddressCreateUseCase;
import test.java.springboot.cleanarq.api.cleanarq.gateway.integration.interfaces.GoogleGeocodingGetLatLngUseCase;
import test.java.springboot.cleanarq.api.cleanarq.gateway.interfaces.AddressCreateGateway;

import java.math.BigDecimal;
import java.util.Map;

@Service
@Configuration
public class AddressCreateUseCaseService implements AddressCreateUseCase {
    private AddressCreateGateway addressCreateGateway;
    private GoogleGeocodingGetLatLngUseCase googleGeocodingGetLatLngUseCase;

    public AddressCreateUseCaseService(AddressCreateGateway addressCreateGateway, GoogleGeocodingGetLatLngUseCase googleGeocodingGetLatLngUseCase) {
        this.addressCreateGateway = addressCreateGateway;
        this.googleGeocodingGetLatLngUseCase = googleGeocodingGetLatLngUseCase;
    }

    public AddressDomain execute(AddressDomain addressDomain) {
        if (StringUtils.isEmpty(addressDomain.getLatitude()) || StringUtils.isEmpty(addressDomain.getLongitude())) {
            Map response = googleGeocodingGetLatLngUseCase.execute(
                    addressDomain.getNumber(),
                    addressDomain.getStreetName(),
                    addressDomain.getCity(),
                    addressDomain.getState()
            );

            addressDomain.setLatitude((BigDecimal) response.get("lat"));
            addressDomain.setLongitude((BigDecimal) response.get("lng"));
        }

        addressDomain = addressCreateGateway.execute(addressDomain);

        return addressDomain;
    }
}
