package fr.idmc.miage.apicredit.controler;

import fr.idmc.miage.apicredit.assembler.DemandeAssembleur;
import fr.idmc.miage.apicredit.entity.Demande;
import fr.idmc.miage.apicredit.service.DemandeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Optional;

@RequestMapping("demandes")
@RestController
@RequiredArgsConstructor
public class DemandeControler {
    private final DemandeService demandeService;
    private final DemandeAssembleur demandeAssembleur;

    @GetMapping
    public ResponseEntity<?> getAll(@PathParam("status") String status, Pageable pageable, PagedResourcesAssembler pagedResourcesAssembler){
        Page<Demande> demandes = (status == null)
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
    public ResponseEntity<?> create(@RequestBody Demande demande){
        Demande d = demandeService.create(demande);
        return new ResponseEntity<>(d,HttpStatus.CREATED);
    }

    @PutMapping({"id"})
    public ResponseEntity<?> put(@PathVariable("id") String id, @RequestBody Demande demande){
        Demande d = demandeService.put(id,demande);
        return new ResponseEntity<>(d,HttpStatus.OK);
    }
}
