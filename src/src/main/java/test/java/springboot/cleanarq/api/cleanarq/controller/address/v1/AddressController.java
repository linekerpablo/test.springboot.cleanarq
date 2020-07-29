package test.java.springboot.cleanarq.api.cleanarq.controller.address.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import test.java.springboot.cleanarq.api.cleanarq.controller.translate.AddressModelRequestToAddress;
import test.java.springboot.cleanarq.api.cleanarq.domain.entities.AddressDomain;
import test.java.springboot.cleanarq.api.cleanarq.domain.usecases.interfaces.*;
import test.java.springboot.cleanarq.api.cleanarq.controller.models.AddressModelRequest;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping({"/address"})
public class AddressController {
    @Autowired
    private AddressCreateUseCase addressCreateUseCase;

    @Autowired
    private AddressFindByIdUseCase addressFindByIdUseCase;

    @Autowired
    private AddressUpdateUseCase addressUpdateUseCase;

    @Autowired
    private AddressFindAllUseCase addressFindAllUseCase;

    @Autowired
    private AddressDeleteByIdUseCase addressDeleteByIdUseCase;

    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody AddressModelRequest request) throws URISyntaxException {
        AddressDomain address = AddressModelRequestToAddress.Translate(request, null);

        address = addressCreateUseCase.execute(address);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(address.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@RequestBody AddressModelRequest request, @PathVariable long id) {

        AddressDomain address = addressFindByIdUseCase.execute(id);

        if (address == null)
            return ResponseEntity.notFound().build();

        address = AddressModelRequestToAddress.Translate(request, id);

        addressUpdateUseCase.execute(address);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public EntityModel<AddressDomain> findById(@PathVariable long id) throws Exception {
        AddressDomain address = addressFindByIdUseCase.execute(id);

        if (address == null)
            throw new Exception("id-" + id);

        EntityModel<AddressDomain> resource = EntityModel.of(address);

        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).findAll());

        resource.add(linkTo.withRel("all-addresses"));

        return resource;
    }

    @GetMapping
    public List<AddressDomain> findAll() {
        List<AddressDomain> listAddressDomain = addressFindAllUseCase.execute();

        return listAddressDomain;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        addressDeleteByIdUseCase.execute(id);
    }
}
