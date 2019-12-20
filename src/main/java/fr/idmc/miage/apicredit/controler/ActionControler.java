package fr.idmc.miage.apicredit.controler;


import fr.idmc.miage.apicredit.entity.Action;
import fr.idmc.miage.apicredit.entity.Demande;
import fr.idmc.miage.apicredit.service.ActionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("demandes")
@RequiredArgsConstructor
public class ActionControler {
    private final ActionService actionService;

    @GetMapping("/{id}/actions")
    public ResponseEntity<?> getAll(@PathVariable("id") String id){
        return new ResponseEntity<>(actionService.getAllActions(id), HttpStatus.OK);
    }

    @GetMapping("/{demandeId}/actions/{id}")
    public ResponseEntity<?> get(@PathVariable("id") String id){
        return new ResponseEntity<>(actionService.getAction(id), HttpStatus.OK);
    }
    @PostMapping("/{demandeId}/actions")
    public ResponseEntity<?> post(@RequestBody Action action,@PathVariable("demandeId") String demandeId){
        action.setDemande(new Demande(demandeId));
        return new ResponseEntity<>(actionService.addAction(action),HttpStatus.CREATED);
    }
}
