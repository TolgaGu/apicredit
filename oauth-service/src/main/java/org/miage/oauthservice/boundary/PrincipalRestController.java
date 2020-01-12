package org.miage.oauthservice.boundary;

import java.security.Principal;

import lombok.AllArgsConstructor;
import org.miage.oauthservice.entity.Account;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
class PrincipalRestController {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    @GetMapping(value = "/user")
    public Principal principal(Principal principal) {
        return principal;
    }

    @PostMapping(value = "/user")
    public ResponseEntity<?> create(@RequestBody Account account){
        return new ResponseEntity<>(accountRepository.save(new Account("test", passwordEncoder.encode("test"),true)), HttpStatus.CREATED);
    }
}