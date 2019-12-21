package fr.idmc.miage.apicredit.assembler;

import fr.idmc.miage.apicredit.controler.ActionControler;
import fr.idmc.miage.apicredit.controler.ActionDemandeControler;
import fr.idmc.miage.apicredit.controler.DemandeControler;
import fr.idmc.miage.apicredit.controler.PersonneControler;
import fr.idmc.miage.apicredit.entity.Action;
import fr.idmc.miage.apicredit.entity.Demande;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.core.DummyInvocationUtils.methodOn;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Service
public class ActionAssembleur implements ResourceAssembler<Action, Resource> {
    @Override
    public Resource toResource(Action action) {
        return new Resource(
                action,
                ControllerLinkBuilder.linkTo(methodOn(ActionControler.class).getById(action.getDemande().getId(),action.getId(),null,null)).withSelfRel(),
                linkTo(methodOn(DemandeControler.class).getById(action.getDemande().getId())).withRel("demande"),
                linkTo(methodOn(PersonneControler.class).getById(action.getPersonne().getId())).withRel("personne")
        );
    }
}
