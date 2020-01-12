package fr.idmc.miage.apicredit.controler;

import com.google.gson.Gson;
import fr.idmc.miage.apicredit.assembler.DemandeAssembleur;
import fr.idmc.miage.apicredit.entity.Demande;
import fr.idmc.miage.apicredit.input.InputDemande;
import fr.idmc.miage.apicredit.jwt.Username;
import fr.idmc.miage.apicredit.service.DemandeService;
import lombok.AllArgsConstructor;
import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PersistenceProperty;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.io.UnsupportedEncodingException;
import java.util.Optional;

@RequestMapping("demandes")
@RestController
@AllArgsConstructor
public class DemandeControler {

    private final DemandeService demandeService;
    private final DemandeAssembleur demandeAssembleur;


    @GetMapping(value = "{id}")
    public ResponseEntity<?> getById(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response){

        String requestTokenHeader = request.getHeader("Authorization");
        String userid=null;
        String jwtToken = requestTokenHeader.substring(7);
        String[] pieces = jwtToken.split("\\.");
        String b64payload = pieces[1];
        try {
            userid = new String(Base64.decodeBase64(b64payload), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Username gson =new Gson().fromJson(userid, Username.class);

        return Optional.ofNullable(demandeService.findById(id,gson.getUser_name()))
                .filter(Optional::isPresent)
                .map(i -> new ResponseEntity<>(demandeAssembleur.toResource(i.get()), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));



    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid InputDemande demande){
        Demande d = demandeService.create(demande);
        return new ResponseEntity<>(d,HttpStatus.CREATED);
    }


    @PutMapping("{id}")
    public ResponseEntity<?> put(@PathVariable("id") String id, @RequestBody Demande demande){
        Demande d = demandeService.put(id,demande);
        return new ResponseEntity<>(d,HttpStatus.OK);
    }

}
