package test.java.springboot.cleanarq.api.cleanarq.domain.usecases.interfaces;

import test.java.springboot.cleanarq.api.cleanarq.domain.entities.AddressDomain;

public interface AddressFindByIdUseCase {
    AddressDomain execute(Long id);
}
