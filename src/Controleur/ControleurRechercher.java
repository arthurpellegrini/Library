package Controleur;

import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import Constantes.*;
import Modele.Livre;
import Vue.*;

public class ControleurRechercher  implements ActionListener, ConstantesInterfaces {
	
	private PanelFormulaireRechercher chPanelFormulaireRecherche;
	private PanelTableLivre chPanelTableLivre;
	private Statement chStmt;
	
	public ControleurRechercher(PanelFormulaireRechercher parPanelFormulaireRecherche, PanelTableLivre parPanelTableLivre, Statement parStmt){
		chPanelFormulaireRecherche = parPanelFormulaireRecherche;
		chPanelFormulaireRecherche.enregistreEcouteur(this);
		chPanelTableLivre = parPanelTableLivre;
		chStmt = parStmt;
	}
	
	public void actionPerformed(ActionEvent parEvt) {
		
		if(parEvt.getActionCommand().equals(RECHERCHER)) {
			ArrayList<Livre> listeLivres;
			
			if(chPanelFormulaireRecherche.getComboBoxCriteres() == ENTETES_LIVRES[0]) {
				try {
					listeLivres = new Livre().rechercherLivreIdLivre(Integer.valueOf(chPanelFormulaireRecherche.getRecherche()), chStmt);
					chPanelTableLivre.setModelTableLivre(chStmt,listeLivres);
				} catch (SQLException e) {
					System.out.println(e);
					}
				}
			
			if(chPanelFormulaireRecherche.getComboBoxCriteres() == ENTETES_LIVRES[1]) {
				try {
					listeLivres = new Livre().rechercherLivreTitre(chPanelFormulaireRecherche.getRecherche(), chStmt);
					chPanelTableLivre.setModelTableLivre(chStmt,listeLivres);
				} catch (SQLException e) {
					System.out.println(e);
					}
				}
			
			if(chPanelFormulaireRecherche.getComboBoxCriteres() == ENTETES_LIVRES[2]) {
				
				try {
					listeLivres =  new Livre().rechercherLivreAuteur(chPanelFormulaireRecherche.getRecherche(), chStmt);
					chPanelTableLivre.setModelTableLivre(chStmt,listeLivres);
				} catch (SQLException e) {
					System.out.println(e);
					}
				}
			}
		}
	}