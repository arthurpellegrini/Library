/*Partie LIVRE*/
--Séquence et trigger pour les données d'un livre
DROP SEQUENCE seq_id_livre;
CREATE SEQUENCE seq_id_livre START WITH 5102 INCREMENT BY 1;

--DROP TRIGGER livreData;
CREATE OR REPLACE TRIGGER livreData
  Before Insert On LIVRE
  For Each Row
DECLARE
  titre LIVRE.TITRE%TYPE;
  auteur LIVRE.AUTEUR%TYPE;
BEGIN
  titre := CONCAT(UPPER(SUBSTR(:new.TITRE,1,1)),LOWER(SUBSTR(:new.TITRE,2)));
  auteur := CONCAT(UPPER(SUBSTR(:new.AUTEUR,1,1)),LOWER(SUBSTR(:new.AUTEUR,2)));
  Select titre Into :new.TITRE From dual;
  Select auteur Into :new.AUTEUR From dual;
  Select seq_id_livre.nextval Into :new.ID_LIVRE From dual;
END;
/

/*Partie EXEMPLAIRE*/
--Séquence et trigger pour les données d'un Exemplaire
DROP SEQUENCE seq_id_ex;
CREATE SEQUENCE seq_id_ex START WITH 122500 INCREMENT BY 1;
--DROP TRIGGER exemplaireData;
CREATE OR REPLACE TRIGGER exemplaireData
  Before Insert On EXEMPLAIRE
  For Each Row
  
BEGIN
  SELECT seq_id_ex.nextval INTO :new.ID_EX FROM DUAL;
END;
/

/*Partie ETUDIANT*/
--Séquence et trigger pour les données d'un étudiant

DROP SEQUENCE seq_id_etudiant;
CREATE SEQUENCE seq_id_etudiant START WITH 21053000 INCREMENT BY 1;

--ALTER TRIGGER etudiantId DISABLE;
--DROP TRIGGER etudiantId;
CREATE OR REPLACE TRIGGER etudiantId
  Before Insert On ETUDIANT
  For Each Row
  
BEGIN
  SELECT seq_id_etudiant.nextval INTO :new.ID_ET FROM dual;
END;
/

--Creation d'un étudiant
--DROP TRIGGER etudiantData

CREATE OR REPLACE TRIGGER etudiantData
Before Insert or Update on Etudiant
For Each Row

DECLARE 
  nom ETUDIANT.NOM%TYPE;
  prenom ETUDIANT.PRENOM%TYPE;
  email ETUDIANT.EMAIL%TYPE;
  mdp ETUDIANT.MDP%TYPE;
BEGIN
  nom := CONCAT(UPPER(SUBSTR(:new.NOM,1,1)),LOWER(SUBSTR(:new.NOM,2)));
  prenom := CONCAT(UPPER(SUBSTR(:new.PRENOM,1,1)),LOWER(SUBSTR(:new.PRENOM,2)));
  email := LOWER(:new.PRENOM) || '.' || LOWER(:new.NOM) || '@uvsq.fr';
  mdp := dbms_random.string('a', 8);
  SELECT nom INTO :new.NOM FROM DUAL;
  SELECT prenom INTO :new.PRENOM FROM DUAL;
  SELECT email INTO :new.EMAIL FROM DUAL;
  SELECT mdp INTO :new.MDP FROM DUAL;
END;
/

/*PARTIE EMPRUNT*/
--DROP TRIGGER empruntDate
CREATE OR REPLACE TRIGGER empruntDate
BEFORE INSERT ON EMPRUNT 
FOR EACH ROW

DECLARE 
  date_emp EMPRUNT.DATE_EMP%TYPE;
  date_retour EMPRUNT.DATE_RETOUR%TYPE;
BEGIN
  date_emp := TO_CHAR(SYSDATE,'DD/MM/YYYY');
  date_retour := TO_CHAR(SYSDATE + 15,'DD/MM/YYYY');
  SELECT date_emp INTO :new.DATE_EMP FROM DUAL;
  SELECT date_retour INTO :new.DATE_RETOUR FROM DUAL;
END;
/

/*PARTIE RESERV*/
--DROP TRIGGER reservDate
CREATE OR REPLACE TRIGGER reservDate
BEFORE INSERT ON RESERV
FOR EACH ROW

DECLARE 
  date_res RESERV.DATE_RES%TYPE;
  date_fin_res RESERV.DATE_FIN_RES%TYPE;
BEGIN
  date_res := TO_CHAR(SYSDATE,'DD/MM/YYYY');
  date_fin_res := TO_CHAR(SYSDATE + 5,'DD/MM/YYYY');
  SELECT date_res INTO :new.DATE_RES FROM DUAL;
  SELECT date_fin_res INTO :new.DATE_FIN_RES FROM DUAL;
END;
/
