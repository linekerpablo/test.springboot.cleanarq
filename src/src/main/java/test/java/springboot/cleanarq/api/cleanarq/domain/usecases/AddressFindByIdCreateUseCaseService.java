package test.java.springboot.cleanarq.api.cleanarq.domain.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.java.springboot.cleanarq.api.cleanarq.domain.entities.AddressDomain;
import test.java.springboot.cleanarq.api.cleanarq.domain.usecases.interfaces.AddressFindByIdUseCase;
import test.java.springboot.cleanarq.api.cleanarq.gateway.interfaces.AddressFindByIdGateway;

@Service
public class AddressFindByIdCreateUseCaseService implements AddressFindByIdUseCase {
    @Autowired
    private AddressFindByIdGateway gateway;

    public AddressDomain execute(Long id) {
        AddressDomain addressDomain = gateway.execute(id);

        return addressDomain;
    }
}
