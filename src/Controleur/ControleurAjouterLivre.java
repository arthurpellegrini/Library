package Controleur;

import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import Constantes.*;
import Modele.Livre;
import Vue.*;

public class ControleurAjouterLivre implements ActionListener, ConstantesInterfaces{
	private PanelAjouterLivre chPanelAjouterLivre;
	private PanelFormulaireAjouterLivre chPanelFormulaireAjouterLivre;
	private PanelRechercher chPanelRechercher;
	private Statement chStmt;
	
	public ControleurAjouterLivre(PanelAjouterLivre parPanelAjouterLivre, PanelFormulaireAjouterLivre parPanelFormulaireAjouterLivre, PanelRechercher parPanelRechercher, Statement parStmt) {
		chPanelAjouterLivre = parPanelAjouterLivre; 
		chPanelFormulaireAjouterLivre = parPanelFormulaireAjouterLivre;
		chPanelFormulaireAjouterLivre.enregistreEcouteur(this);	
		chPanelRechercher = parPanelRechercher;
		chStmt = parStmt;
	}
	
	public void actionPerformed(ActionEvent parEvt) {
		
		if(parEvt.getActionCommand().equals(AJOUTER)) {
			try {
				new Livre().ajouterLivre(chPanelAjouterLivre, chPanelFormulaireAjouterLivre.getFieldTitre(),chPanelFormulaireAjouterLivre.getFieldAuteur(),chStmt);
				ArrayList<Livre> listeLivre = new Livre().listeLivres(chStmt);
				chPanelAjouterLivre.getModelTableAjouterLivre().setModelTableLivre(chStmt,listeLivre);
				chPanelRechercher.getModelTableRechercher().setModelTableLivre(chStmt,listeLivre);
			} catch (SQLException e) {
				System.out.println(e);
			} 
		}
	}
}
