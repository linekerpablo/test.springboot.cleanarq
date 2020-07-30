package test.java.springboot.cleanarq.api.cleanarq.impl

import test.java.springboot.cleanarq.api.cleanarq.domain.entities.AddressDomain
import test.java.springboot.cleanarq.api.cleanarq.domain.usecases.AddressFindAllUseCaseService
import test.java.springboot.cleanarq.api.cleanarq.gateway.interfaces.AddressFindAllGateway

class AddressFindAllImplTest extends spock.lang.Specification {
    def addressFindAllGateway = Mock(AddressFindAllGateway)
    def addressFindAllUseCase = new AddressFindAllUseCaseService(addressFindAllGateway)

    def "should be update an address, even without entering latitude and longitude"() {
        when:
        1 * addressFindAllGateway.execute() >> findAll()
        def result = addressFindAllUseCase.execute()

        then:
        result.size() == 2
    }

    private List<AddressDomain> findAll() {
        List<AddressDomain> addressDomainList = new ArrayList<>();

        AddressDomain address1 = AddressDomain.builder()
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

        AddressDomain address2 = AddressDomain.builder()
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

        addressDomainList.add(address1);
        addressDomainList.add(address2);

        return addressDomainList;
    }
}
