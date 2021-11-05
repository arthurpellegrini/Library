package Controleur;

import java.awt.event.*;
import java.sql.*;
import Constantes.*;
import Modele.Connexion;
import Vue.*;


public class ControleurConnexion implements ConstantesInterfaces, ActionListener{
	private FenetreConnexion chFenetreConnexion;
	private FenentreBibliothecaire chFenentreBibliothecaire;
	private FenetreEtudiant chFenetreEtudiant;
	private PanelFormulaireConnexion chPanelFormulaireConnexion;
	private Statement chStmt;
	
	public ControleurConnexion(FenetreConnexion parFenetreConnexion, PanelFormulaireConnexion parPanelFormulaireConnexion, Statement parStmt) throws SQLException {

		chFenetreConnexion = parFenetreConnexion;
		chPanelFormulaireConnexion = parPanelFormulaireConnexion;
		chStmt = parStmt;
		chFenentreBibliothecaire = new FenentreBibliothecaire(chStmt);
		chPanelFormulaireConnexion.enregistreEcouteur(this);
	}
	
	public void actionPerformed(ActionEvent parEvt){
		int idEtudiant = 0;
		if(parEvt.getActionCommand().equals(CONNEXION)) {
			Connexion connexion = new Connexion(chPanelFormulaireConnexion.getEmail(),chPanelFormulaireConnexion.getMotDePasse());
				try {
					idEtudiant = connexion.verificationLogin(chFenetreConnexion,chStmt);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			if(idEtudiant != 0) {
				chFenetreConnexion.setVisible(false);
				if(idEtudiant == 1)
					chFenentreBibliothecaire.setVisible(true);
				else {
					try {
						chFenetreEtudiant = new FenetreEtudiant(idEtudiant, new Connexion().getEmailEtudiantCourrant(idEtudiant,chStmt), chStmt);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					chFenetreEtudiant.setVisible(true);
				}	
			}
		}
	}
}

