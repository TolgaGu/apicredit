package fr.idmc.miage.apicredit.repository;

import fr.idmc.miage.apicredit.entity.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client,String> {
}
