package fr.idmc.miage.apicredit.repository;

import fr.idmc.miage.apicredit.entity.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepository extends JpaRepository<Personne,String> {
}
