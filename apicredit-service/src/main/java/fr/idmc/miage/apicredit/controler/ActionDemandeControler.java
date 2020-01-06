package fr.idmc.miage.apicredit.controler;


import fr.idmc.miage.apicredit.assembler.ActionAssembleur;
import fr.idmc.miage.apicredit.entity.Action;
import fr.idmc.miage.apicredit.entity.Personne;
import fr.idmc.miage.apicredit.service.ActionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("demandes")
@RequiredArgsConstructor
public class ActionDemandeControler {
    private final ActionService actionService;
    private final ActionAssembleur actionAssembleur;

    @GetMapping("/{id}/actions")
    public ResponseEntity<?> getAll(@PathVariable("id") String id, Pageable pageable, PagedResourcesAssembler<Action> pagedResourcesAssembler){
        return new ResponseEntity<>(pagedResourcesAssembler.toResource(actionService.getAllActionsFromDemande(id, pageable),actionAssembleur), HttpStatus.OK);
    }


    @PostMapping("/{demandeId}/actions")
    public ResponseEntity<?> post(@RequestBody Action action,@PathVariable("demandeId") String demandeId){

        return new ResponseEntity<>(actionAssembleur.toResource(actionService.addAction(action,demandeId)),HttpStatus.CREATED);
    }

    @DeleteMapping("/{demandeId}/actions/{id}")
    public ResponseEntity<?> put(@RequestBody Personne personne, @PathVariable("demandeId") String demandeId, @PathVariable("id") String id){
        Action a = actionService.finishAction(personne,demandeId,id);
        return new ResponseEntity<>(a,HttpStatus.OK);
    }
}
