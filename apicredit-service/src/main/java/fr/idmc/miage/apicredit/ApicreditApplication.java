package fr.idmc.miage.apicredit;

import fr.idmc.miage.apicredit.entity.*;
import fr.idmc.miage.apicredit.repository.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@SpringBootApplication
public class ApicreditApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApicreditApplication.class, args);
	}

}
