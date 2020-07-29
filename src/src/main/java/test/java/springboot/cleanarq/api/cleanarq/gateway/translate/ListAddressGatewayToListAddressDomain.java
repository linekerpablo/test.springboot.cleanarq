package test.java.springboot.cleanarq.api.cleanarq.gateway.translate;

import test.java.springboot.cleanarq.api.cleanarq.domain.entities.AddressDomain;
import test.java.springboot.cleanarq.api.cleanarq.gateway.entities.Address;

import java.util.List;
import java.util.stream.Collectors;

public class ListAddressGatewayToListAddressDomain {
    public static List<AddressDomain> Translate(List<Address> listAddressGateway) {
        return listAddressGateway.stream().map(AddressGatewayToAddressDomain::Translate).collect(Collectors.toList());
    }
}
