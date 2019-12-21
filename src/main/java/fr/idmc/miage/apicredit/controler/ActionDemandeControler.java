package fr.idmc.miage.apicredit.controler;


import fr.idmc.miage.apicredit.entity.Action;
import fr.idmc.miage.apicredit.entity.Demande;
import fr.idmc.miage.apicredit.service.ActionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("demandes")
@RequiredArgsConstructor
public class ActionDemandeControler {
    private final ActionService actionService;

    @GetMapping("/{id}/actions")
    public ResponseEntity<?> getAll(@PathVariable("id") String id, Pageable pageable, PagedResourcesAssembler pagedResourcesAssembler){
        return new ResponseEntity<>(actionService.getAllActions(id, pageable), HttpStatus.OK);
    }

    @GetMapping("/{demandeId}/actions/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") String id){
        return new ResponseEntity<>(actionService.getAction(id), HttpStatus.OK);
    }
    @PostMapping("/{demandeId}/actions")
    public ResponseEntity<?> post(@RequestBody Action action,@PathVariable("demandeId") String demandeId){

        return new ResponseEntity<>(actionService.addAction(action,demandeId),HttpStatus.CREATED);
    }

    @PutMapping("/{demandeId}/actions/{id}")
    public ResponseEntity<?> put(@RequestBody Action action,@PathVariable("demandeId") String demandeId, @PathVariable("id") String id){
        Action a = actionService.update(action,demandeId,id);
        return new ResponseEntity<>(a,HttpStatus.OK);
    }
}
