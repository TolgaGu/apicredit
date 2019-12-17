package fr.idmc.miage.apicredit.controler;

import fr.idmc.miage.apicredit.entity.Demande;
import fr.idmc.miage.apicredit.service.DemandeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("demandes")
@RestController
@RequiredArgsConstructor
public class DemandeControler {
    private final DemandeService demandeService;

    @GetMapping
    public String get(){
        return "Wesh alors";
    }
    @PostMapping
    public Demande create(@RequestBody Demande demande){
        Demande d = demandeService.create(demande);
        return d;
    }
}
