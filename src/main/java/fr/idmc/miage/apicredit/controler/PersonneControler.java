package fr.idmc.miage.apicredit.controler;


import fr.idmc.miage.apicredit.entity.Demande;
import fr.idmc.miage.apicredit.entity.Personne;
import fr.idmc.miage.apicredit.service.PersonneService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RequestMapping("personnes")
@RestController
@RequiredArgsConstructor
public class PersonneControler {

    private final PersonneService personneService;

    @GetMapping
    public ResponseEntity<?> getAll(@PathParam("nom") String nom,@PathParam("prenom") String prenom, Pageable pageable, PagedResourcesAssembler<Personne> pagedResourcesAssembler){
        Page<Demande> demandes = (nom.isBlank() && prenom.isBlank())
                ? demandeService.findAll(pageable)
                : demandeService.findByStatus(status, pageable);

        if (demandes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(pagedResourcesAssembler.toResource(demandes, demandeAssembleur), HttpStatus.OK);

    }
}
