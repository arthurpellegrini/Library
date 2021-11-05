package Constantes;

import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;

public interface ConstantesInterfaces {
	final boolean RESIZABLE = false;
	//Taille et Position Fenetre Connexion
	final int HORIZONTAL_CON = 550;
    final int VERTICAL_CON = 250;
    final int POSX_CON = (Toolkit.getDefaultToolkit().getScreenSize().width - HORIZONTAL_CON)/2;
    final int POSY_CON = (Toolkit.getDefaultToolkit().getScreenSize().height - VERTICAL_CON)/2;
	
	//Taille et Position Fenêtres Bibliothécaire & Etudiant
	final int HORIZONTAL_BE = 1000;
    final int VERTICAL_BE = 500;
    final int POSX_BE = (Toolkit.getDefaultToolkit().getScreenSize().width - HORIZONTAL_BE)/2;
    final int POSY_BE = (Toolkit.getDefaultToolkit().getScreenSize().height - VERTICAL_BE)/2;
    
    //Identifiants Connexion Bibliothecaire
    final String EMAIL_BIBLIOTHECAIRE = "bibliothecaire@uvsq.fr";
    final String MOT_DE_PASSE_BIBLIOTHECAIRE = "livre";
    
    //Intitulés JBouton
    final String CONNEXION ="CONNEXION";
    final String RECHERCHER ="RECHERCHER";
    final String RESERVER ="RESERVER";
    final String AJOUTER ="AJOUTER";
    final String PRETER = "PRETER";
    final String RENDRE ="RENDRE";
    final String CREER ="CREER";
    final String EDITER ="EDITER";
    final String SUPPRIMER ="SUPPRIMER";
    
    //Intitulés JLablels
    final String IDCON_MIN ="Identifiants Connexion";
    final String EMAIL_MIN ="Email";
    final String MDP_MIN ="Mot de passe";
    final String RECHERCHER_MIN ="Rechercher";
    final String CRITERES_MIN ="Critères";
    final String ID_LIVRE_MIN ="Id Livre";
    final String TITRE_MIN ="Titre";
    final String AUTEUR_MIN ="Auteur";
    final String ID_ETUDIANT_MIN ="Id Etudiant";
    final String ID_EXEMPLAIRE_MIN ="Id Exemplaire";
    final String NOM_MIN ="Nom";
    final String PRENOM_MIN ="Prénom";
    
    //Intitulés JTable
    final String[] ENTETES_LIVRES = {"Id Livre","Titre","Auteur"};
    final String[] ENTETES_RESERVATION = {"Id Livre","Id Etudiant","Nom","Prénom","Livre"};
    final String[] ENTETES_EMPRUNT = {"Id Exemplaire","Id Etudiant","Prénom","Nom","Livre"};
    final String[] ENTETES_RENDRE = {"Id Exemplaire","Id Etudiant","Nom","Prénom","Livre"};
    final String[] ENTETES_ETUDIANTS = {"Nom","Prénom","Email","Mdp"};
    final String[] ENTETES_RETARD = {"Id Exemplaire","Livre","Id Etudiant","Nom","Prénom","Email"};
    
    //Couleurs
    //final Color ORANGE = new Color (176, 91, 46);
    final Color ORANGE = new Color (255, 179, 71);
    final Color BLANC = new Color (255, 255, 255);
    final Color GRIS_CLAIR = new Color (60, 63, 65);
    final Color GRIS_FONCE = new Color (49, 51, 53);

    //Polices
    public final static Font US_24 = new Font ("Uni Sans", Font.PLAIN,24);
    public final static Font US_14 = new Font ("Uni Sans", Font.PLAIN,14);
    public final static Font US_12 = new Font ("Uni Sans", Font.PLAIN,14);
}
