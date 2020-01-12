package fr.idmc.miage.apicredit.controler;


import fr.idmc.miage.apicredit.assembler.PersonneAssembleur;
import fr.idmc.miage.apicredit.entity.Personne;
import fr.idmc.miage.apicredit.service.PersonneService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Optional;

@RequestMapping("personnes")
@RestController
@AllArgsConstructor
public class PersonneControler {

    private final PersonneService personneService;
    private final PersonneAssembleur personneAssembleur;

    @GetMapping
    public ResponseEntity<?> getAll(@PathParam("recherche") String recherche, Pageable pageable, PagedResourcesAssembler<Personne> pagedResourcesAssembler) {
        Page<Personne> personnes = (recherche == null || recherche.isBlank())
                ? personneService.findAll(pageable)
                : personneService.findByNomOrPrenom(recherche, pageable);

        if (personnes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(pagedResourcesAssembler.toResource(personnes, personneAssembleur), HttpStatus.OK);
    }


    @GetMapping(value = "{id}")
    public ResponseEntity<?> getById(@PathVariable("id") String id) {
        return Optional.ofNullable(personneService.findById(id))
                .filter(Optional::isPresent)
                .map(i -> new ResponseEntity<>(personneAssembleur.toResource(i.get()), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PutMapping("{id}")
    public ResponseEntity<?> put(@PathVariable("id") String id, @RequestBody Personne personne){
        Personne p = personneService.put(id,personne);
        return new ResponseEntity<>(p,HttpStatus.OK);
    }
}
