package test.java.springboot.cleanarq.api.cleanarq.gateway.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.java.springboot.cleanarq.api.cleanarq.gateway.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
