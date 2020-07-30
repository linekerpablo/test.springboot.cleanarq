package test.java.springboot.cleanarq.api.cleanarq.gateway.interfaces;

import test.java.springboot.cleanarq.api.cleanarq.domain.entities.AddressDomain;

import java.util.List;

public interface AddressFindAllGateway {
    List<AddressDomain> execute();
}
