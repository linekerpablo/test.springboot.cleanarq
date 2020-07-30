package test.java.springboot.cleanarq.api.cleanarq.impl

import test.java.springboot.cleanarq.api.cleanarq.domain.entities.AddressDomain
import test.java.springboot.cleanarq.api.cleanarq.domain.usecases.AddressFindAllUseCaseService
import test.java.springboot.cleanarq.api.cleanarq.domain.usecases.AddressFindByIdCreateUseCaseService
import test.java.springboot.cleanarq.api.cleanarq.gateway.interfaces.AddressFindAllGateway
import test.java.springboot.cleanarq.api.cleanarq.gateway.interfaces.AddressFindByIdGateway

class AddressFindByIdImplTest extends spock.lang.Specification {
    def addressFindByIdGateway = Mock(AddressFindByIdGateway)
    def addressFindByIdCreateUseCaseService = new AddressFindByIdCreateUseCaseService(addressFindByIdGateway)

    def "should be update an address, even without entering latitude and longitude"() {
        given:
        Long id = 1;
        AddressDomain addressDomain = getAddressDomain();

        when:
        1 * addressFindByIdGateway.execute(id) >> getAddressDomain()
        def result = addressFindByIdCreateUseCaseService.execute(id)

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

    private AddressDomain getAddressDomain() {
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
}
