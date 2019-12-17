package fr.idmc.miage.apicredit.repository;

import fr.idmc.miage.apicredit.entity.Demande;
import org.springframework.data.repository.CrudRepository;

public interface DemandeRepository extends CrudRepository<Demande, String> {
}
