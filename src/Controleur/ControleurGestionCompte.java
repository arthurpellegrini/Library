package Controleur;

import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Constantes.*;
import Modele.Etudiant;
import Vue.*;

public class ControleurGestionCompte implements ActionListener, ConstantesInterfaces{
	private PanelGestionCompte chPanelGestionCompte;
	private PanelFormulaireGestionCompte chPanelFormulaireGestionCompte;
	private PanelTableGestionCompte chPanelTableGestionCompte;
	private Statement chStmt;

	public ControleurGestionCompte(PanelGestionCompte parPanelGestionCompte, PanelFormulaireGestionCompte parPanelFormulaireGestionCompte, PanelTableGestionCompte parPanelTableGestionCompte, Statement parStmt){
		chPanelGestionCompte = parPanelGestionCompte;
		chPanelFormulaireGestionCompte = parPanelFormulaireGestionCompte;
		chPanelFormulaireGestionCompte.enregistreEcouteur(this);
		chPanelTableGestionCompte = parPanelTableGestionCompte;
		chStmt = parStmt;
	}
	
	public void actionPerformed(ActionEvent parEvt) {
		ArrayList<Etudiant> listeEtudiants;
		if(parEvt.getActionCommand().equals(CREER)) {
			try {
				new Etudiant().ajouterEtudiant(chPanelGestionCompte, chPanelFormulaireGestionCompte.getNom(),chPanelFormulaireGestionCompte.getPrenom(),chStmt);
				listeEtudiants = new Etudiant().listeEtudiants(chStmt);
				chPanelTableGestionCompte.setModelGestionCompte(chStmt,listeEtudiants);
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		
		if(parEvt.getActionCommand().equals(EDITER)) {
			try {	
				new Etudiant().modifierEtudiant(chPanelGestionCompte, chPanelFormulaireGestionCompte.getNom(),chPanelFormulaireGestionCompte.getPrenom(),JOptionPane.showInputDialog("Entrer le nouveau Nom"),JOptionPane.showInputDialog("Entrer le nouveau Prénom"),chStmt);
				listeEtudiants = new Etudiant().listeEtudiants(chStmt);
				chPanelTableGestionCompte.setModelGestionCompte(chStmt,listeEtudiants);
			} catch (SQLException e) {
				System.out.println(e);
			}
			
		}
		
		if(parEvt.getActionCommand().equals(SUPPRIMER)) {
			try {
				new Etudiant().supprimerEtudiant(chPanelGestionCompte, chPanelFormulaireGestionCompte.getNom(),chPanelFormulaireGestionCompte.getPrenom(),chStmt);
				listeEtudiants = new Etudiant().listeEtudiants(chStmt);
				chPanelTableGestionCompte.setModelGestionCompte(chStmt,listeEtudiants);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(chPanelGestionCompte,"Impossible de supprimer cet étudiant car il a des réservations en cours","Erreur suppression", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
