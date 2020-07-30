package test.java.springboot.cleanarq.api.cleanarq.domain.usecases;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import test.java.springboot.cleanarq.api.cleanarq.domain.entities.AddressDomain;
import test.java.springboot.cleanarq.api.cleanarq.domain.usecases.interfaces.AddressUpdateUseCase;
import test.java.springboot.cleanarq.api.cleanarq.gateway.integration.interfaces.GoogleGeocodingGetLatLngUseCase;
import test.java.springboot.cleanarq.api.cleanarq.gateway.interfaces.AddressUpdateGateway;

import java.math.BigDecimal;
import java.util.Map;

@Service
public class AddressUpdateUseCaseService implements AddressUpdateUseCase {
    private AddressUpdateGateway gateway;
    private GoogleGeocodingGetLatLngUseCase googleGeocodingGetLatLngUseCase;

    public AddressUpdateUseCaseService(AddressUpdateGateway gateway, GoogleGeocodingGetLatLngUseCase googleGeocodingGetLatLngUseCase) {
        this.gateway = gateway;
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

        gateway.execute(addressDomain);

        return addressDomain;
    }
}
