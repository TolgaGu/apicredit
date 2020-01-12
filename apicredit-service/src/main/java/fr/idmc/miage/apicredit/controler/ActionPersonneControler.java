package fr.idmc.miage.apicredit.controler;


import fr.idmc.miage.apicredit.assembler.ActionAssembleur;
import fr.idmc.miage.apicredit.entity.Action;
import fr.idmc.miage.apicredit.service.ActionService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("personnes")
@AllArgsConstructor
public class ActionPersonneControler {


    private final ActionService actionService;
    private final ActionAssembleur actionAssembleur;


    @GetMapping("/{id}/actions")
    public ResponseEntity<?> getAll(@PathVariable("id") String id, Pageable pageable, PagedResourcesAssembler<Action> pagedResourcesAssembler){
        return new ResponseEntity<>(pagedResourcesAssembler.toResource(actionService.getAllActionsFromPersonne(id, pageable),actionAssembleur), HttpStatus.OK);
    }

}
