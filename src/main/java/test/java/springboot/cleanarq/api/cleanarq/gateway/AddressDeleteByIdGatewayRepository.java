package test.java.springboot.cleanarq.api.cleanarq.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.java.springboot.cleanarq.api.cleanarq.domain.entities.AddressDomain;
import test.java.springboot.cleanarq.api.cleanarq.gateway.entities.Address;
import test.java.springboot.cleanarq.api.cleanarq.gateway.interfaces.AddressDeleteByIdGateway;
import test.java.springboot.cleanarq.api.cleanarq.gateway.interfaces.AddressRepository;
import test.java.springboot.cleanarq.api.cleanarq.gateway.interfaces.AddressUpdateGateway;
import test.java.springboot.cleanarq.api.cleanarq.gateway.translate.AddressDomainToAddressGateway;

@Component
public class AddressDeleteByIdGatewayRepository implements AddressDeleteByIdGateway {
    @Autowired
    private AddressRepository repository;

    public void execute(Long id) {
        repository.deleteById(id);
    }
}
