package test.java.springboot.cleanarq.api.cleanarq.domain.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.java.springboot.cleanarq.api.cleanarq.domain.entities.AddressDomain;
import test.java.springboot.cleanarq.api.cleanarq.domain.usecases.interfaces.AddressUpdateUseCase;
import test.java.springboot.cleanarq.api.cleanarq.gateway.interfaces.AddressUpdateGateway;

@Service
public class AddressUpdateUseCaseService implements AddressUpdateUseCase {
    @Autowired
    private AddressUpdateGateway gateway;

    public AddressDomain execute(AddressDomain addressDomain) {
        gateway.execute(addressDomain);

        return addressDomain;
    }
}
