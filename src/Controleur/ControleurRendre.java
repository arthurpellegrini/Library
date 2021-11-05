package Controleur;

import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import Constantes.*;
import Modele.Emprunt;
import Vue.*;

public class ControleurRendre implements ConstantesInterfaces, ActionListener {
	private PanelRendre chPanelRendre;
	private PanelFormulaireRendre chPanelFormulaireRendre;
	private PanelTableRendre chPanelTableRendre;
	private PanelTableRetard chPanelTableRetard;
	private Statement chStmt;
	
	public ControleurRendre(PanelRendre parPanelRendre, PanelFormulaireRendre parPanelFormualaireRendre, PanelTableRendre parPanelTableRendre,PanelTableRetard parPanelTableRetard, Statement parStmt) {
		chPanelRendre = parPanelRendre;
		chPanelFormulaireRendre = parPanelFormualaireRendre;
		chPanelFormulaireRendre.enregistreEcouteur(this);
		chPanelTableRendre = parPanelTableRendre;
		chPanelTableRetard = parPanelTableRetard;
		chStmt = parStmt;
	}

	public void actionPerformed(ActionEvent parEvt) {
		ArrayList<Emprunt> listeEmprunts;
		ArrayList<Emprunt> listeRetardEmprunts;
		
		if(parEvt.getActionCommand().equals(RENDRE)) {
			try {
				new Emprunt().rendreLivre(chPanelRendre,chPanelFormulaireRendre.getChFieldIdEx(), chStmt);
				listeEmprunts = new Emprunt().listeEmprunts(chStmt);
				listeRetardEmprunts = new Emprunt().listeEmpruntsRetard(chStmt);
				chPanelTableRendre.setModelTableRendre(chStmt,listeEmprunts);
				chPanelTableRetard.setModelTableRetard(chStmt,listeRetardEmprunts);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}
}
