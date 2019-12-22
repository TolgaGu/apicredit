package fr.idmc.miage.apicredit.assembler;

import fr.idmc.miage.apicredit.controler.ActionDemandeControler;
import fr.idmc.miage.apicredit.controler.ActionPersonneControler;
import fr.idmc.miage.apicredit.controler.DemandeControler;
import fr.idmc.miage.apicredit.controler.PersonneControler;
import fr.idmc.miage.apicredit.entity.Personne;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.core.DummyInvocationUtils.methodOn;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Service
public class PersonneAssembleur implements ResourceAssembler<Personne, Resource> {

    @Override
    public Resource toResource(Personne personne) {
        return new Resource(
                personne,
                ControllerLinkBuilder.linkTo(methodOn(PersonneControler.class).getById(personne.getId())).withSelfRel(),
                linkTo(methodOn(PersonneControler.class).getAll(null, null, null)).withRel("collection"),
                linkTo(methodOn(ActionPersonneControler.class).getAll(personne.getId(), null, null)).withRel("actions")
        );
    }
}
