package test.java.springboot.cleanarq.api.cleanarq.gateway.translate;

import test.java.springboot.cleanarq.api.cleanarq.domain.entities.AddressDomain;
import test.java.springboot.cleanarq.api.cleanarq.gateway.entities.Address;

public class AddressGatewayToAddressDomain {
    public static AddressDomain Translate(Address request) {
        return AddressDomain.builder()
                .id(request.getId())
                .streetName(request.getStreetName())
                .number(request.getNumber())
                .complement(request.getComplement())
                .neighbourhood(request.getNeighbourhood())
                .city(request.getCity())
                .state(request.getState())
                .country(request.getCountry())
                .zipCode(request.getZipCode())
                .latitude(request.getLatitude())
                .longitude(request.getLongitude())
                .build();
    }
}
