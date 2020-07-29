package test.java.springboot.cleanarq.api.cleanarq.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.java.springboot.cleanarq.api.cleanarq.domain.entities.AddressDomain;
import test.java.springboot.cleanarq.api.cleanarq.gateway.entities.Address;
import test.java.springboot.cleanarq.api.cleanarq.gateway.interfaces.AddressRepository;
import test.java.springboot.cleanarq.api.cleanarq.gateway.interfaces.AddressUpdateGateway;
import test.java.springboot.cleanarq.api.cleanarq.gateway.translate.AddressDomainToAddressGateway;

@Component
public class AddressUpdateGatewayRepository implements AddressUpdateGateway {
    @Autowired
    private AddressRepository repository;

    public AddressDomain execute(AddressDomain addressDomain) {
        Address addressGateway = AddressDomainToAddressGateway.Translate(addressDomain);

        repository.save(addressGateway);

        return addressDomain;
    }
}
