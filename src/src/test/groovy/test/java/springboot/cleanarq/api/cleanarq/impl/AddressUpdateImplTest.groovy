package test.java.springboot.cleanarq.api.cleanarq.impl

import test.java.springboot.cleanarq.api.cleanarq.domain.entities.AddressDomain
import test.java.springboot.cleanarq.api.cleanarq.domain.usecases.AddressUpdateUseCaseService
import test.java.springboot.cleanarq.api.cleanarq.gateway.integration.interfaces.GoogleGeocodingGetLatLngUseCase
import test.java.springboot.cleanarq.api.cleanarq.gateway.interfaces.AddressUpdateGateway

class AddressUpdateImplTest extends spock.lang.Specification {
    def addressUpdateGateway = Mock(AddressUpdateGateway)
    def googleGeocodingGetLatLngUseCase = Mock(GoogleGeocodingGetLatLngUseCase);
    def addressUpdateUseCase = new AddressUpdateUseCaseService(addressUpdateGateway, googleGeocodingGetLatLngUseCase)

    def "should be update an address, even without entering latitude and longitude"() {
        given:
        AddressDomain addressDomain = updateAddressDomainWithoutLatLng();

        when:
        1 * googleGeocodingGetLatLngUseCase.execute(_ as Integer, _ as String, _ as String, _ as String) >> getLatLng()
        1 * addressUpdateGateway.execute(addressDomain) >> updateAddressDomainWithoutLatLng()
        def result = addressUpdateUseCase.execute(addressDomain)

        then:
        result.getCity() == addressDomain.getCity()
        result.getState() == addressDomain.getState()
        result.getCountry() == addressDomain.getCountry()
        result.getNeighbourhood() == addressDomain.getNeighbourhood()
        result.getNumber() == addressDomain.getNumber()
        result.getComplement() == addressDomain.getComplement()
        result.getStreetName() == addressDomain.getStreetName()
        result.getZipCode() == addressDomain.getZipCode()
    }

    def "should be update an address"() {
        given:
        AddressDomain addressDomain = updateAddressDomainWithLatLng();

        when:
        0 * googleGeocodingGetLatLngUseCase.execute(_ as Integer, _ as String, _ as String, _ as String)
        1 * addressUpdateGateway.execute(addressDomain) >> updateAddressDomainWithLatLng()
        def result = addressUpdateUseCase.execute(addressDomain)

        then:
        result.getCity() == addressDomain.getCity()
        result.getState() == addressDomain.getState()
        result.getCountry() == addressDomain.getCountry()
        result.getNeighbourhood() == addressDomain.getNeighbourhood()
        result.getNumber() == addressDomain.getNumber()
        result.getComplement() == addressDomain.getComplement()
        result.getStreetName() == addressDomain.getStreetName()
        result.getZipCode() == addressDomain.getZipCode()
        result.getLatitude() == addressDomain.getLatitude()
        result.getLongitude() == addressDomain.getLongitude()
    }

    private AddressDomain updateAddressDomainWithoutLatLng() {
        return AddressDomain.builder()
                .streetName("Rua ternuar")
                .number(233)
                .complement("")
                .neighbourhood("Jardim boer 1")
                .city("Americana")
                .state("SP")
                .country("Brasil")
                .zipCode("13477706")
                .build();
    }

    private AddressDomain updateAddressDomainWithLatLng() {
        return AddressDomain.builder()
                .streetName("Rua ternuar")
                .number(233)
                .complement("")
                .neighbourhood("Jardim boer 1")
                .city("Americana")
                .state("SP")
                .country("Brasil")
                .zipCode("13477706")
                .latitude(-22.121)
                .longitude(-40.1231)
                .build();
    }

    private Map getLatLng() {
        Map response = new HashMap()

        response.put("lat", -22.4544)
        response.put("lng", -40.1213)

        return response
    }
}
