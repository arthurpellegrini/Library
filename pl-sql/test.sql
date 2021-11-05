DELETE FROM EMPRUNT;
DELETE FROM EXEMPLAIRE;
DELETE FROM RESERV;

/*¨Partie Test Triggers*/
--Test Triggers Etudiant
DELETE FROM ETUDIANT WHERE PRENOM = 'Emmanuel'; 
INSERT INTO ETUDIANT VALUES(0,'PRESIDENT','emmANUel','','');
SELECT * FROM ETUDIANT WHERE PRENOM = 'Emmanuel';
UPDATE ETUDIANT SET NOM = 'MaCrOn' WHERE NOM = 'President';
SELECT * FROM ETUDIANT WHERE PRENOM = 'Emmanuel';

--Test Triggers Livre
DELETE FROM LIVRE WHERE TITRE = 'Maus';
INSERT INTO LIVRE VALUES(0,'MAuS','ArT SpIEgeLMan');
commit;
SELECT * FROM LIVRE WHERE TITRE = 'Maus';

--Test Triggers Exemplaire
INSERT INTO EXEMPLAIRE VALUES(0,5030);

--Test Trigger Emprunt(date automatique)
INSERT INTO EMPRUNT VALUES(21053023,122501,'','');

--Test Trigger Reserv(date automatique)
INSERT INTO RESERV VALUES(5016,21053001,'','');


/*Partie Test Interface*/
--IMPORTANT NE PAS OUBLIER LE COMMIT
----Tous les emprunts
select Exemplaire.id_ex,nom,prenom,titre 
  from etudiant,emprunt,exemplaire,livre 
    where etudiant.id_et = emprunt.id_et and emprunt.id_ex = exemplaire.id_ex and exemplaire.id_livre = livre.id_livre;
commit;

--Tous les emprunts de + de 15 jours
SELECT Exemplaire.id_ex,nom,prenom,titre 
  FROM etudiant,emprunt,exemplaire,livre 
    WHERE etudiant.id_et = emprunt.id_et and emprunt.id_ex = exemplaire.id_ex and exemplaire.id_livre = livre.id_livre 
      AND Exemplaire.ID_EX IN(SELECT ID_EX FROM EMPRUNT WHERE DATE_RETOUR < SYSDATE);
      commit;
      
--Autres
select etudiant.id_et,nom,prenom,titre from etudiant,emprunt,exemplaire,livre
where etudiant.id_et = emprunt.id_et and emprunt.id_ex = exemplaire.id_ex and exemplaire.id_livre = livre.id_livre;
commit;


select Exemplaire.id_ex,Etudiant.id_Et,nom,prenom,titre
				from etudiant,emprunt,exemplaire,livre 
        where etudiant.id_et = emprunt.id_et and emprunt.id_ex = exemplaire.id_ex and exemplaire.id_livre = livre.id_livre;
        commit;
        
SELECT Exemplaire.id_ex,Etudiant.id_et,nom,prenom,titre FROM etudiant,emprunt,exemplaire,livre WHERE etudiant.id_et = emprunt.id_et and emprunt.id_ex = exemplaire.id_ex and exemplaire.id_livre = livre.id_livre AND Exemplaire.ID_EX IN(SELECT ID_EX FROM EMPRUNT WHERE DATE_RETOUR < SYSDATE);
commit;

Insert into exemplaire values(0,5101);
commit;
SELECT ID_EX FROM EXEMPLAIRE WHERE ID_LIVRE = 5100;
commit;

DELETE from RESERV where ID_LIVRE = 5101 AND ID_ET = 21053023;
commit;

select livre.id_livre,etudiant.id_et,nom,prenom,titre from etudiant,livre,reserv where reserv.id_livre = livre.id_livre and reserv.id_et = etudiant.id_et And etudiant.id_et = 21053012 ORDER BY ID_LIVRE; 

SELECT * FROM LIVRE WHERE TITRE = 'Maus' and auteur = 'Art spiegelman';
select COUNT(Id_LIVRE) from LIVRE where TITRE = '" + parTitre.substring(0, 1).toUpperCase() + parTitre.substring(1).toLowerCase() + "' AND ID_ET =;

select COUNT(Id_ET) from ETUDIANT where NOM = 'Pellegrini' AND PRENOM = 'Arthur';

SELECT COUNT(*) FROM RESERV WHERE ID_LIVRE = 5100 AND ID_ET = 21053023;

select Exemplaire.id_ex,Etudiant.id_Et,nom,prenom,titre from etudiant,emprunt,exemplaire,livre where etudiant.id_et = emprunt.id_et and emprunt.id_ex = exemplaire.id_ex and exemplaire.id_livre = livre.id_livre ORDER BY ID_ET ASC, ID_EX ASC

DELETE FROM RESERV WHERE DATE_FIN_RES < SYSDATE;
SELECT * FROM RESERV;
rollback;