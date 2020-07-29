package test.java.springboot.cleanarq.api.cleanarq.domain.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.java.springboot.cleanarq.api.cleanarq.domain.entities.AddressDomain;
import test.java.springboot.cleanarq.api.cleanarq.domain.usecases.interfaces.AddressDeleteByIdUseCase;
import test.java.springboot.cleanarq.api.cleanarq.domain.usecases.interfaces.AddressUpdateUseCase;
import test.java.springboot.cleanarq.api.cleanarq.gateway.interfaces.AddressDeleteByIdGateway;
import test.java.springboot.cleanarq.api.cleanarq.gateway.interfaces.AddressUpdateGateway;

@Service
public class AddressDeleteByIdUseCaseService implements AddressDeleteByIdUseCase {
    @Autowired
    private AddressDeleteByIdGateway gateway;

    public void execute(Long id) {
        gateway.execute(id);
    }
}
