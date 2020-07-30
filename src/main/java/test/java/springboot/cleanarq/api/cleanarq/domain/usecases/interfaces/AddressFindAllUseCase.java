package test.java.springboot.cleanarq.api.cleanarq.domain.usecases.interfaces;

import test.java.springboot.cleanarq.api.cleanarq.domain.entities.AddressDomain;

import java.util.List;

public interface AddressFindAllUseCase {
    List<AddressDomain> execute();
}
