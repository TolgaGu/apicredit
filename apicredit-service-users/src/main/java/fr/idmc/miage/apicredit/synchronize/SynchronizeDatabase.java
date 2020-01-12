package fr.idmc.miage.apicredit.synchronize;

import fr.idmc.miage.apicredit.entity.Client;
import fr.idmc.miage.apicredit.entity.Demande;
import fr.idmc.miage.apicredit.input.InputClient;
import fr.idmc.miage.apicredit.worker.AuthenticationWorker;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SynchronizeDatabase {

    private static final Logger LOGGER = Logger.getLogger(SynchronizeDatabase.class.getName());


    public static void syncDemande(Demande demande) {

        HttpResponse<String> response = Unirest.post("http://localhost:8080/demandes")
                .header("Content-Type", "application/json")
                .body("{\n\t \"client\":\"" + demande.getClient() + "\"," +
                        "\n\"revenus_sur_trois_annees\":\"" + demande.getRevenus_sur_trois_annees() + "\",\n " +
                        "\"montant_credit\":\"" + demande.getMontant_credit() + "\",\n" +
                        "\"private_id\":\"" + demande.getPrivate_id() + "\",\n" +
                        "\"duree_en_mois\":\"" + demande.getDuree_en_mois() +"\"}")
                .asString();
        LOGGER.log(Level.INFO,"Demande synchronized : "+response.getStatus());

    }

    public static void syncClient(InputClient client){
        HttpResponse<String> response = Unirest.post("http://localhost:8080/clients")
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Basic YXBpY3JlZGl0OmFwaXByb2plY3RzZWNyZXQ=")
                .body("{\n\t \"nom\":\""+client.getNom()+"\",\n"+
                        "\"prenom\":\""+client.getPrenom()+"\",\n "+
                        "\"adresse\":\""+client.getAdresse()+"\",\n"+
                        "\"date_de_naissance\":\""+client.getDate_de_naissance()+"\",\n"+
                        "\"private_id\":\""+client.getPrivate_id()+"\",\n"+
                        "\"password\" : \""+client.getPassword()+"\"\n}")
                .asString();


        LOGGER.log(Level.INFO,"Client synchronized : "+response.getStatus());

    }
}
