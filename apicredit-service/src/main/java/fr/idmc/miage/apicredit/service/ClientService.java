package fr.idmc.miage.apicredit.service;

import fr.idmc.miage.apicredit.entity.Client;
import fr.idmc.miage.apicredit.entity.Personne;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ClientService {
    public Page<Client> findAll(Pageable pageable) {
        return null;
    }

    public Page<Client> findByNomOrPrenom(String recherche, Pageable pageable) {
        return null;
    }

    public Optional<Client> findById(String id) {
        return null;
    }

    public Client put(String id, Client client) {
        return null;
    }
}
