package test.java.springboot.cleanarq.api.cleanarq.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.java.springboot.cleanarq.api.cleanarq.domain.entities.AddressDomain;
import test.java.springboot.cleanarq.api.cleanarq.gateway.entities.Address;
import test.java.springboot.cleanarq.api.cleanarq.gateway.interfaces.AddressFindByIdGateway;
import test.java.springboot.cleanarq.api.cleanarq.gateway.interfaces.AddressRepository;
import test.java.springboot.cleanarq.api.cleanarq.gateway.translate.AddressGatewayToAddressDomain;

import java.util.Optional;

@Component
public class AddressFindByIdGatewayRepository implements AddressFindByIdGateway {
    @Autowired
    private AddressRepository repository;

    @Override
    public AddressDomain execute(Long id) {
        Optional<Address> addressGateway = repository.findById(id);

        if (addressGateway.isEmpty())
            return null;
        else {
            AddressDomain addressDomain = AddressGatewayToAddressDomain.Translate(addressGateway.get());

            return addressDomain;
        }
    }
}
