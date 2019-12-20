package fr.idmc.miage.apicredit.controler;


import fr.idmc.miage.apicredit.service.ActionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
