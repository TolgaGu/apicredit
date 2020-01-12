package fr.idmc.miage.apicredit.controler;

import fr.idmc.miage.apicredit.assembler.ClientAssembleur;
import fr.idmc.miage.apicredit.entity.Client;
import fr.idmc.miage.apicredit.entity.Demande;
import fr.idmc.miage.apicredit.entity.Personne;
import fr.idmc.miage.apicredit.exception.ClientAuthenticationCreatingException;
import fr.idmc.miage.apicredit.input.InputClient;
import fr.idmc.miage.apicredit.input.InputDemande;
import fr.idmc.miage.apicredit.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.Optional;


@RequestMapping("clients")
@RestController
@AllArgsConstructor
public class ClientControler {
    private final ClientService clientService;
    private final ClientAssembleur clientAssembleur;

    @GetMapping
    public ResponseEntity<?> getAll(@PathParam("recherche") String recherche, Pageable pageable, PagedResourcesAssembler<Client> pagedResourcesAssembler) {
        Page<Client> clients = (recherche == null || recherche.isBlank())
                ? clientService.findAll(pageable)
                : clientService.findByNomOrPrenom(recherche, pageable);

        if (clients.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(pagedResourcesAssembler.toResource(clients, clientAssembleur), HttpStatus.OK);
    }


    @GetMapping(value = "{id}")
    public ResponseEntity<?> getById(@PathVariable("id") String id) {
        return Optional.ofNullable(clientService.findById(id))
                .filter(Optional::isPresent)
                .map(i -> new ResponseEntity<>(clientAssembleur.toResource(i.get()), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid InputClient client) throws ClientAuthenticationCreatingException {
        return new ResponseEntity<>(clientService.create(client),HttpStatus.CREATED);
    }


    @PutMapping("{id}")
    public ResponseEntity<?> put(@PathVariable("id") String id, @RequestBody Client client){
        Client p = clientService.put(id,client);
        return new ResponseEntity<>(p,HttpStatus.OK);
    }
}
