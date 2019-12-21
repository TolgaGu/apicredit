package fr.idmc.miage.apicredit;

import fr.idmc.miage.apicredit.entity.Action;
import fr.idmc.miage.apicredit.entity.Demande;
import fr.idmc.miage.apicredit.entity.EtatAction;
import fr.idmc.miage.apicredit.entity.Personne;
import fr.idmc.miage.apicredit.repository.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class ApicreditApplication {

	@Autowired
	private ActionRepository actionRepository;
	@Component
	class DataSetup implements ApplicationRunner{

		@Override
		public void run(ApplicationArguments args) throws Exception {
			actionRepository.save(Action.builder().nom_action("en attende d'attribution").personne_en_charge(new Personne("6rzgbr44b8g9t6r4"))
					.demande(new Demande("ff8081816e9e21ef016e9e532dbd80000")).etat_action(EtatAction.TERMINEE).build());

			actionRepository.save(Action.builder().nom_action("en attende d'attribution").personne_en_charge(new Personne("6rzgbr44b8g9t6r4"))
					.demande(new Demande("8a80cb816f24c0ea016f24d97157000f1")).etat_action(EtatAction.TERMINEE).build());
			actionRepository.save(Action.builder().nom_action("revus en cours").personne_en_charge(new Personne("6rzgbr44b8g9t6r4"))
					.demande(new Demande("8a80cb816f24c0ea016f24d97157000f1")).etat_action(EtatAction.TERMINEE).build());
			actionRepository.save(Action.builder().nom_action("décision en attente de validation").personne_en_charge(new Personne("95r4hrt9h4r9h4r9"))
					.demande(new Demande("8a80cb816f24c0ea016f24d97157000f1")).etat_action(EtatAction.TERMINEE).build());


			actionRepository.save(Action.builder().nom_action("en attende d'attribution").personne_en_charge(new Personne("6rzgbr44b8g9t6r4"))
					.demande(new Demande("sgjsognonsoe21ef016e9e5gsdpginsd0")).etat_action(EtatAction.TERMINEE).build());
			actionRepository.save(Action.builder().nom_action("revus en cours").personne_en_charge(new Personne("6rzgbr44b8g9t6r4"))
					.demande(new Demande("sgjsognonsoe21ef016e9e5gsdpginsd0")).etat_action(EtatAction.TERMINEE).build());
			actionRepository.save(Action.builder().nom_action("décision en attente de validation").personne_en_charge(new Personne("95r4hrt9h4r9h4r9"))
					.demande(new Demande("sgjsognonsoe21ef016e9e5gsdpginsd0")).etat_action(EtatAction.TERMINEE).build());
			actionRepository.save(Action.builder().nom_action("notfication").personne_en_charge(new Personne("6g544ghet9h4et88"))
					.demande(new Demande("sgjsognonsoe21ef016e9e5gsdpginsd0")).etat_action(EtatAction.TERMINEE).build());
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(ApicreditApplication.class, args);
	}

}
