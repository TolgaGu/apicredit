package fr.idmc.miage.apicredit.controler;


import fr.idmc.miage.apicredit.assembler.ActionAssembleur;
import fr.idmc.miage.apicredit.entity.Action;
import fr.idmc.miage.apicredit.service.ActionService;
import lombok.RequiredArgsConstructor;
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
@RequestMapping("actions")
@RequiredArgsConstructor
public class ActionControler {

    private final ActionService actionService;
    private final ActionAssembleur actionAssembleur;

    @GetMapping("actions/{id}")
    public ResponseEntity<?> getById(@PathVariable("demandeId") String demandeId, @PathVariable("id") String id, Pageable pageable, PagedResourcesAssembler<Action> pagedResourcesAssembler){
        return Optional.ofNullable(actionService.getAction(id))
                .filter(Optional::isPresent)
                .map(i -> new ResponseEntity<>(actionAssembleur.toResource(i.get()), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
