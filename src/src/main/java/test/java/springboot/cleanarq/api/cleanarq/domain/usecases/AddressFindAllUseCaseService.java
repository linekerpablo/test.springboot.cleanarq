package test.java.springboot.cleanarq.api.cleanarq.domain.usecases;

import org.springframework.stereotype.Service;
import test.java.springboot.cleanarq.api.cleanarq.domain.entities.AddressDomain;
import test.java.springboot.cleanarq.api.cleanarq.domain.usecases.interfaces.AddressFindAllUseCase;
import test.java.springboot.cleanarq.api.cleanarq.gateway.interfaces.AddressFindAllGateway;

import java.util.List;

@Service
public class AddressFindAllUseCaseService implements AddressFindAllUseCase {
    private AddressFindAllGateway gateway;

    public AddressFindAllUseCaseService(AddressFindAllGateway gateway) {
        this.gateway = gateway;
    }

    public List<AddressDomain> execute() {
        List<AddressDomain> listAddressDomain = gateway.execute();

        return listAddressDomain;
    }
}
