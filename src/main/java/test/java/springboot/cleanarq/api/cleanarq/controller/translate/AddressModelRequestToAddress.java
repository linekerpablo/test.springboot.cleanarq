package test.java.springboot.cleanarq.api.cleanarq.controller.translate;

import org.springframework.lang.Nullable;
import test.java.springboot.cleanarq.api.cleanarq.domain.entities.AddressDomain;
import test.java.springboot.cleanarq.api.cleanarq.controller.models.AddressModelRequest;

public class AddressModelRequestToAddress {
    public static AddressDomain Translate(AddressModelRequest request, @Nullable Long id) {
        return AddressDomain.builder()
                .id(id)
                .streetName(request.getStreetName())
                .number(request.getNumber())
                .complement(request.getComplement())
                .neighbourhood(request.getNeighbourhood())
                .city(request.getCity())
                .state(request.getState())
                .country(request.country)
                .zipCode(request.getZipCode())
                .latitude(request.getLatitude())
                .longitude(request.getLongitude())
                .build();
    }
}
