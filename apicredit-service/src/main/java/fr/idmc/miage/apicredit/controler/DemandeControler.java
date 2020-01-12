package fr.idmc.miage.apicredit.controler;

import fr.idmc.miage.apicredit.assembler.DemandeAssembleur;
import fr.idmc.miage.apicredit.entity.Demande;
import fr.idmc.miage.apicredit.entity.Personne;
import fr.idmc.miage.apicredit.input.InputDemande;
import fr.idmc.miage.apicredit.service.ActionService;
import fr.idmc.miage.apicredit.service.DemandeService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PersistenceProperty;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.Optional;

@RequestMapping("demandes")
@RestController
@AllArgsConstructor
public class DemandeControler {

    private final DemandeService demandeService;
    private final DemandeAssembleur demandeAssembleur;

    @GetMapping
    public ResponseEntity<?> getAll(@PathParam("status") String status, Pageable pageable, PagedResourcesAssembler<Demande> pagedResourcesAssembler){
        Page<Demande> demandes = (status == null || status.isBlank())
                ? demandeService.findAll(pageable)
                : demandeService.findByStatus(status, pageable);

        if (demandes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(pagedResourcesAssembler.toResource(demandes, demandeAssembleur), HttpStatus.OK);

    }

    @GetMapping(value = "{id}")
    public ResponseEntity<?> getById(@PathVariable("id") String id){
        return Optional.ofNullable(demandeService.findById(id))
                .filter(Optional::isPresent)
                .map(i -> new ResponseEntity<>(demandeAssembleur.toResource(i.get()), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid InputDemande demande){
        String d = demandeService.create(demande);
        return new ResponseEntity<>(d,HttpStatus.CREATED);
    }


    @PutMapping("{id}")
    public ResponseEntity<?> put(@PathVariable("id") String id, @RequestBody Demande demande){
        Demande d = demandeService.put(id,demande);
        return new ResponseEntity<>(d,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> rejectDemande(@RequestBody Personne personne, @PathVariable("id") String id){
        Demande d = demandeService.delete(id,personne);
        return  new ResponseEntity<>(d,HttpStatus.OK);
    }
}
