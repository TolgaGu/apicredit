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

	@Autowired
	private ActionRepository actionRepository;
	@Component
	class DataSetup implements ApplicationRunner{

		@Override
		public void run(ApplicationArguments args) throws Exception {
			actionRepository.save(Action.builder().nom_action(NomAction.EN_ATTENTE_D_ATTRIBUTION).personne(new Personne("6rzgbr44b8g9t6r4"))
					.demande(new Demande("ff8081816e9e21ef016e9e532dbd80000")).etat_action(EtatAction.TERMINEE).date_execution(new Timestamp(System.currentTimeMillis())).build());

			actionRepository.save(Action.builder().nom_action(NomAction.EN_ATTENTE_D_ATTRIBUTION).personne(new Personne("6rzgbr44b8g9t6r4"))
					.demande(new Demande("8a80cb816f24c0ea016f24d97157000f1")).etat_action(EtatAction.TERMINEE).date_execution(new Timestamp(System.currentTimeMillis())).build());
			actionRepository.save(Action.builder().nom_action(NomAction.REVUS_EN_COURS).personne(new Personne("6rzgbr44b8g9t6r4"))
					.demande(new Demande("8a80cb816f24c0ea016f24d97157000f1")).etat_action(EtatAction.TERMINEE).date_execution(new Timestamp(System.currentTimeMillis())).build());
			actionRepository.save(Action.builder().nom_action(NomAction.DECISION_EN_ATTENTE_DE_VALIDATION).personne(new Personne("95r4hrt9h4r9h4r9"))
					.demande(new Demande("8a80cb816f24c0ea016f24d97157000f1")).etat_action(EtatAction.ENCOURS).date_execution(new Timestamp(System.currentTimeMillis())).build());


			actionRepository.save(Action.builder().nom_action(NomAction.EN_ATTENTE_D_ATTRIBUTION).personne(new Personne("6rzgbr44b8g9t6r4"))
					.demande(new Demande("sgjsognonsoe21ef016e9e5gsdpginsd0")).etat_action(EtatAction.TERMINEE).date_execution(new Timestamp(System.currentTimeMillis())).build());
			actionRepository.save(Action.builder().nom_action(NomAction.REVUS_EN_COURS).personne(new Personne("6rzgbr44b8g9t6r4"))
					.demande(new Demande("sgjsognonsoe21ef016e9e5gsdpginsd0")).etat_action(EtatAction.TERMINEE).date_execution(new Timestamp(System.currentTimeMillis())).build());
			actionRepository.save(Action.builder().nom_action(NomAction.DECISION_EN_ATTENTE_DE_VALIDATION).personne(new Personne("95r4hrt9h4r9h4r9"))
					.demande(new Demande("sgjsognonsoe21ef016e9e5gsdpginsd0")).etat_action(EtatAction.TERMINEE).date_execution(new Timestamp(System.currentTimeMillis())).build());
			actionRepository.save(Action.builder().nom_action(NomAction.NOTIFICATION).personne(new Personne("6g544ghet9h4et88"))
					.demande(new Demande("sgjsognonsoe21ef016e9e5gsdpginsd0")).etat_action(EtatAction.ENCOURS).date_execution(new Timestamp(System.currentTimeMillis())).build());

			//7gd4bf6fn46fd4n6d84n6d4n64d6n4d64
			actionRepository.save(Action.builder().nom_action(NomAction.EN_ATTENTE_D_ATTRIBUTION).personne(new Personne("6rzgbr44b8g9t6r4"))
					.demande(new Demande("7gd4bf6fn46fd4n6d84n6d4n64d6n4d64")).etat_action(EtatAction.TERMINEE).date_execution(new Timestamp(System.currentTimeMillis())).build());
			actionRepository.save(Action.builder().nom_action(NomAction.REVUS_EN_COURS).personne(new Personne("6rzgbr44b8g9t6r4"))
					.demande(new Demande("7gd4bf6fn46fd4n6d84n6d4n64d6n4d64")).etat_action(EtatAction.TERMINEE).date_execution(new Timestamp(System.currentTimeMillis())).build());
			actionRepository.save(Action.builder().nom_action(NomAction.DECISION_EN_ATTENTE_DE_VALIDATION).personne(new Personne("95r4hrt9h4r9h4r9"))
					.demande(new Demande("7gd4bf6fn46fd4n6d84n6d4n64d6n4d64")).etat_action(EtatAction.TERMINEE).date_execution(new Timestamp(System.currentTimeMillis())).build());
			actionRepository.save(Action.builder().nom_action(NomAction.REJET).personne(new Personne("6g544ghet9h4et88"))
					.demande(new Demande("7gd4bf6fn46fd4n6d84n6d4n64d6n4d64")).etat_action(EtatAction.TERMINEE).date_execution(new Timestamp(System.currentTimeMillis())).build());

		}
	}

	public static void main(String[] args) {
		SpringApplication.run(ApicreditApplication.class, args);
	}

}
