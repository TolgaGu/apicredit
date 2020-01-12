
INSERT INTO client (id, nom, prenom, adresse, date_de_naissance) VALUES ('rthh6rf4h6r4h6r4h64df6hn4gfd6h4fd','Michel','Michel','75  place Stanislas 54000 Nancy', '15-02-1995');
INSERT INTO client (id, nom, prenom, adresse, date_de_naissance) VALUES ('kuy4kg6y4k6g4k6g4hk6j4hk64gh6k4g6','Jean','Pierre','25  Square de la Couronne 75001 Paris', '15-10-1985');
INSERT INTO client (id, nom, prenom, adresse, date_de_naissance) VALUES ('bf435nf354gn4fvn64f6h4h6gnfh34n5f','Clément','Pala','46  place Stanislas 44100 Nantes', '15-01-1999');
INSERT INTO client (id, nom, prenom, adresse, date_de_naissance) VALUES ('d3f4h35df43jh1gbn3f4gnjhf32hn1f5n','Vandal','Dominique','49  rue Banaudon 69008 Lyon', '15-01-1999');

INSERT INTO demande (id, idclient, revenus_sur_trois_annees, montant_credit, duree_en_mois, etat_demande) VALUES ('ff8081816e9e21ef016e9e532dbd80000','rthh6rf4h6r4h6r4h64df6hn4gfd6h4fd', 100000, 20000, 18,1);
INSERT INTO demande (id, idclient, revenus_sur_trois_annees, montant_credit, duree_en_mois, etat_demande) VALUES ('8a80cb816f24c0ea016f24d97157000f1','kuy4kg6y4k6g4k6g4hk6j4hk64gh6k4g6', 35000, 20000, 18,3);
INSERT INTO demande (id, idclient, revenus_sur_trois_annees, montant_credit, duree_en_mois, etat_demande) VALUES ('sgjsognonsoe21ef016e9e5gsdpginsd0','bf435nf354gn4fvn64f6h4h6gnfh34n5f', 15000, 20000, 18,4);
INSERT INTO demande (id, idclient, revenus_sur_trois_annees, montant_credit, duree_en_mois, etat_demande) VALUES ('7gd4bf6fn46fd4n6d84n6d4n64d6n4d64','d3f4h35df43jh1gbn3f4gnjhf32hn1f5n', 150000, 300000, 32,5);

INSERT INTO personne (id,nom,prenom) VALUES ('6rzgbr44b8g9t6r4','Thomas','Julien');
INSERT INTO personne (id,nom,prenom) VALUES ('95r4hrt9h4r9h4r9','Bennin','Nicolas');
INSERT INTO personne (id,nom,prenom) VALUES ('6g544ghet9h4et88','Renaud','Quantin');

INSERT INTO action (id, date_execution, etat_action, nom_action, demande_id, personne_id) values('8a88808d6f972555016f97255fec0002','2020-01-12 01:26:46.636',1,2,'8a80cb816f24c0ea016f24d97157000f1','6rzgbr44b8g9t6r4');
INSERT INTO action (id, date_execution, etat_action, nom_action, demande_id, personne_id) values('8a88808d6f972555016f97255fee0003','2020-01-12 01:26:46.637',0,3,'8a80cb816f24c0ea016f24d97157000f1','95r4hrt9h4r9h4r9');
INSERT INTO action (id, date_execution, etat_action, nom_action, demande_id, personne_id) values('8a88808d6f972555016f97255ff00004','2020-01-12 01:26:46.639',1,1,'sgjsognonsoe21ef016e9e5gsdpginsd0','6rzgbr44b8g9t6r4');
INSERT INTO action (id, date_execution, etat_action, nom_action, demande_id, personne_id) values('8a88808d6f972555016f97255ff10005','2020-01-12 01:26:46.641',1,2,'sgjsognonsoe21ef016e9e5gsdpginsd0','6rzgbr44b8g9t6r4');
INSERT INTO action (id, date_execution, etat_action, nom_action, demande_id, personne_id) values('8a88808d6f972555016f97255ff30006','2020-01-12 01:26:46.643',1,3,'sgjsognonsoe21ef016e9e5gsdpginsd0','95r4hrt9h4r9h4r9');
INSERT INTO action (id, date_execution, etat_action, nom_action, demande_id, personne_id) values('8a88808d6f972555016f97255ff60007','2020-01-12 01:26:46.646',0,4,'sgjsognonsoe21ef016e9e5gsdpginsd0','6g544ghet9h4et88');
INSERT INTO action (id, date_execution, etat_action, nom_action, demande_id, personne_id) values('8a88808d6f972555016f97255ff80008','2020-01-12 01:26:46.648',1,1,'7gd4bf6fn46fd4n6d84n6d4n64d6n4d64','6rzgbr44b8g9t6r4');
INSERT INTO action (id, date_execution, etat_action, nom_action, demande_id, personne_id) values('8a88808d6f972555016f97255ffa0009','2020-01-12 01:26:46.649',1,2,'7gd4bf6fn46fd4n6d84n6d4n64d6n4d64','6rzgbr44b8g9t6r4');
INSERT INTO action (id, date_execution, etat_action, nom_action, demande_id, personne_id) values('8a88808d6f972555016f97255ffb000a','2020-01-12 01:26:46.651',1,3,'7gd4bf6fn46fd4n6d84n6d4n64d6n4d64','95r4hrt9h4r9h4r9');
INSERT INTO action (id, date_execution, etat_action, nom_action, demande_id, personne_id) values('8a88808d6f972555016f97255ffd000b','2020-01-12 01:26:46.653',1,5,'7gd4bf6fn46fd4n6d84n6d4n64d6n4d64','6g544ghet9h4et88');