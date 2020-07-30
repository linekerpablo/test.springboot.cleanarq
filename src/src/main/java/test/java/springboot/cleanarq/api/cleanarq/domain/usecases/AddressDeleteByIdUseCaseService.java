package test.java.springboot.cleanarq.api.cleanarq.domain.usecases;

import org.springframework.stereotype.Service;
import test.java.springboot.cleanarq.api.cleanarq.domain.usecases.interfaces.AddressDeleteByIdUseCase;
import test.java.springboot.cleanarq.api.cleanarq.gateway.interfaces.AddressDeleteByIdGateway;

@Service
public class AddressDeleteByIdUseCaseService implements AddressDeleteByIdUseCase {
    private AddressDeleteByIdGateway gateway;

    public AddressDeleteByIdUseCaseService(AddressDeleteByIdGateway gateway) {
        this.gateway = gateway;
    }

    public void execute(Long id) {
        gateway.execute(id);
    }
}
