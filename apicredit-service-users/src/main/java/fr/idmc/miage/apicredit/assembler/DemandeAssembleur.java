package fr.idmc.miage.apicredit.assembler;

import fr.idmc.miage.apicredit.controler.ClientControler;
import fr.idmc.miage.apicredit.controler.DemandeControler;
import fr.idmc.miage.apicredit.entity.Demande;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.core.DummyInvocationUtils.methodOn;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Service
public class DemandeAssembleur implements ResourceAssembler<Demande, Resource> {

    @Override
    public Resource toResource(Demande demande) {
        return new Resource(
                demande,
                ControllerLinkBuilder.linkTo(methodOn(DemandeControler.class).getById(demande.getId(),null,null)).withSelfRel(),
                linkTo(methodOn(ClientControler.class).getById(demande.getClient())).withRel("client")
        );
    }
}
