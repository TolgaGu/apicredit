INSERT INTO demande (id, nom, prenom, adresse, date_de_naissance, revenus_sur_trois_annees, montant_credit, duree_en_mois, etat_demande) VALUES ('ff8081816e9e21ef016e9e532db80000','Michel','Michel','test', '15-02-1995', 100000, 20000, 18,1);
INSERT INTO demande (id, nom, prenom, adresse, date_de_naissance, revenus_sur_trois_annees, montant_credit, duree_en_mois, etat_demande) VALUES ('8a80cb816f24c0ea016f24d971570001','Jean','Pierre','test', '15-10-1985', 10000, 20000, 18,3);
INSERT INTO demande (id, nom, prenom, adresse, date_de_naissance, revenus_sur_trois_annees, montant_credit, duree_en_mois, etat_demande) VALUES ('sgjsognonsoe21ef016e9e5gsdpginsd0','Clément','Pala','test', '15-01-1999', 15000, 20000, 18,4);

INSERT INTO personne (id,nom,prenom) VALUES ('6rzgbr44b8g9t6r4','Thomas','Julien');
INSERT INTO personne (id,nom,prenom) VALUES ('95r4hrt9h4r9h4r9','Bennin','Nicolas');

INSERT INTO action (id, nom_action, personne_en_charge, demande, etat_action) VALUES('fz9g9e4e9g9ge84f9','en attente d attribution','6rzgbr44b8g9t6r4','ff8081816e9e21ef016e9e532db80000',2);

INSERT INTO action (id, nom_action, personne_en_charge, demande, etat_action) VALUES('pzf979zfg9re847rz','en attente d attribution','6rzgbr44b8g9t6r4','8a80cb816f24c0ea016f24d971570001',2);
INSERT INTO action (id, nom_action, personne_en_charge, demande, etat_action) VALUES('ge4t9g4g9ggt4g4t9','Revu en cours','6rzgbr44b8g9t6r4','8a80cb816f24c0ea016f24d971570001',2);
INSERT INTO action (id, nom_action, personne_en_charge, demande, etat_action) VALUES('ozjgeogseiognpize','décision en attente de validation','95r4hrt9h4r9h4r9','8a80cb816f24c0ea016f24d971570001',1);

INSERT INTO action (id, nom_action, personne_en_charge, demande, etat_action) VALUES('pzf979z9g9gtf47rz','en attente d attribution','6rzgbr44b8g9t6r4','sgjsognonsoe21ef016e9e5gsdpginsd0',2);
INSERT INTO action (id, nom_action, personne_en_charge, demande, etat_action) VALUES('9jtuffj9u4j9y4j94','Revu en cours','6rzgbr44b8g9t6r4','sgjsognonsoe21ef016e9e5gsdpginsd0',2);
INSERT INTO action (id, nom_action, personne_en_charge, demande, etat_action) VALUES('9ge49ge49g4e9g9eg','décision en attente de validation','95r4hrt9h4r9h4r9','sgjsognonsoe21ef016e9e5gsdpginsd0',2);
INSERT INTO action (id, nom_action, personne_en_charge, demande, etat_action) VALUES('j9y4j9y9ju4y94y94','notiﬁcation','95r4hrt9h4r9h4r9','sgjsognonsoe21ef016e9e5gsdpginsd0',1);
