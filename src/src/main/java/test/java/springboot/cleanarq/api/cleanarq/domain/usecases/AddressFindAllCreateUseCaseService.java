package test.java.springboot.cleanarq.api.cleanarq.domain.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.java.springboot.cleanarq.api.cleanarq.domain.entities.AddressDomain;
import test.java.springboot.cleanarq.api.cleanarq.domain.usecases.interfaces.AddressFindAllUseCase;
import test.java.springboot.cleanarq.api.cleanarq.domain.usecases.interfaces.AddressFindByIdUseCase;
import test.java.springboot.cleanarq.api.cleanarq.gateway.interfaces.AddressFindAllGateway;
import test.java.springboot.cleanarq.api.cleanarq.gateway.interfaces.AddressFindByIdGateway;

import java.util.List;

@Service
public class AddressFindAllCreateUseCaseService implements AddressFindAllUseCase {
    @Autowired
    private AddressFindAllGateway gateway;

    public List<AddressDomain> execute() {
        List<AddressDomain> listAddressDomain = gateway.execute();

        return listAddressDomain;
    }
}
