package fr.idmc.miage.apicredit.assembler;

import fr.idmc.miage.apicredit.entity.Demande;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Service;

@Service
public class ActionAssembleur implements ResourceAssembler<Demande, Resource> {
    @Override
    public Resource toResource(Demande demande) {
        return null;
    }
}
