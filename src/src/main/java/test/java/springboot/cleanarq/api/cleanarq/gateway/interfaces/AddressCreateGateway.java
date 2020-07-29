package test.java.springboot.cleanarq.api.cleanarq.gateway.interfaces;

import test.java.springboot.cleanarq.api.cleanarq.domain.entities.AddressDomain;

public interface AddressCreateGateway {
    AddressDomain execute(AddressDomain addressDomain);
}
