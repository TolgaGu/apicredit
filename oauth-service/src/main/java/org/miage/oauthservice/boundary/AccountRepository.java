package org.miage.oauthservice.boundary;

import java.util.Optional;
import org.miage.oauthservice.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByUsername(String username);
}