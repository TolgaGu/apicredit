package fr.idmc.miage.apicredit.assembler;

import fr.idmc.miage.apicredit.controler.ClientControler;
import fr.idmc.miage.apicredit.controler.PersonneControler;
import fr.idmc.miage.apicredit.entity.Client;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.core.DummyInvocationUtils.methodOn;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Service
public class ClientAssembleur  implements ResourceAssembler<Client, Resource> {
    @Override
    public Resource toResource(Client client){
        return new Resource(
                client,
                ControllerLinkBuilder.linkTo(methodOn(ClientControler.class).getById(client.getId())).withSelfRel(),
                linkTo(methodOn(PersonneControler.class).getAll(null, null, null)).withRel("collection")
                );
    }
}
