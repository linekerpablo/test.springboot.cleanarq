package test.java.springboot.cleanarq.api.cleanarq.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.java.springboot.cleanarq.api.cleanarq.domain.entities.AddressDomain;
import test.java.springboot.cleanarq.api.cleanarq.gateway.entities.Address;
import test.java.springboot.cleanarq.api.cleanarq.gateway.interfaces.AddressFindAllGateway;
import test.java.springboot.cleanarq.api.cleanarq.gateway.interfaces.AddressRepository;
import test.java.springboot.cleanarq.api.cleanarq.gateway.translate.ListAddressGatewayToListAddressDomain;

import java.util.List;

@Component
public class AddressFindAllGatewayRepository implements AddressFindAllGateway {
    @Autowired
    private AddressRepository repository;

    @Override
    public List<AddressDomain> execute() {
        List<Address> listAddressGateway = repository.findAll();

        List<AddressDomain> listAddressDomain = ListAddressGatewayToListAddressDomain.Translate(listAddressGateway);

        return listAddressDomain;
    }
}
