package test.java.springboot.cleanarq.api.cleanarq.impl

import test.java.springboot.cleanarq.api.cleanarq.domain.entities.AddressDomain;
import test.java.springboot.cleanarq.api.cleanarq.domain.usecases.AddressCreateUseCaseService
import test.java.springboot.cleanarq.api.cleanarq.gateway.integration.interfaces.GoogleGeocodingGetLatLngUseCase
import test.java.springboot.cleanarq.api.cleanarq.gateway.interfaces.AddressCreateGateway

class AddressCreateImplTest extends spock.lang.Specification {
    def addressCreateGateway = Mock(AddressCreateGateway)
    def googleGeocodingGetLatLngUseCase = Mock(GoogleGeocodingGetLatLngUseCase);
    def addressCreateUseCase = new AddressCreateUseCaseService(addressCreateGateway, googleGeocodingGetLatLngUseCase)

    def "should be create an address, even without entering latitude and longitude"() {
        given:
        AddressDomain addressDomain = createAddressDomainWithoutLatLng();

        when:
        1 * googleGeocodingGetLatLngUseCase.execute(any(), any(), any(), any()) >> getLatLng();
        1 * addressCreateGateway.execute(addressDomain)
        def result = addressCreateUseCase.execute(addressDomain)

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

    private AddressDomain createAddressDomainWithoutLatLng()
    {
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

    private Map getLatLng() {
        Map response = new HashMap();

        response.put("lat", "-22.4544")
        response.put("lng", "-40.121331")

        return response
    }
}
