package fr.idmc.miage.apicredit.assembler;

import fr.idmc.miage.apicredit.controler.ActionDemandeControler;
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
                ControllerLinkBuilder.linkTo(methodOn(DemandeControler.class).getById(demande.getId())).withSelfRel(),
                linkTo(methodOn(DemandeControler.class).getAll(null, null, null)).withRel("collection"),
                linkTo(methodOn(ActionDemandeControler.class).getAll(demande.getId(),null,null)).withRel("actions")
        );
    }
}
