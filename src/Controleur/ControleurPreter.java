package Controleur;

import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import Constantes.*;
import Modele.*;
import Vue.*;

public class ControleurPreter implements ActionListener, ConstantesInterfaces {
	private PanelPreter chPanelPreter;
	private PanelFormulairePreter chPanelFormulairePreter;
	private PanelTablePreter chPanelTablePreter;
	private PanelRendre chPanelRendre;
	private Statement chStmt;
	
	public ControleurPreter(PanelPreter parPanelPreter, PanelFormulairePreter parPanelFormulairePreter, PanelTablePreter parPanelTablePreter,PanelRendre parPanelRendre, Statement parStmt) {
		chPanelPreter = parPanelPreter;
		chPanelFormulairePreter = parPanelFormulairePreter;
		chPanelFormulairePreter.enregistreEcouteur(this);
		chPanelTablePreter= parPanelTablePreter;
		chPanelRendre = parPanelRendre;
		chStmt = parStmt;
	}

	public void actionPerformed(ActionEvent parEvt) {
		ArrayList<Reservation> listeReservations;
		ArrayList<Emprunt> listeEmprunts;
		if(parEvt.getActionCommand().equals(PRETER)) {
			try {
				int nombreEmprunts = new Emprunt().nombreEmprunts(chPanelPreter, chPanelFormulairePreter.getFieldIdEt(),chStmt);
				if(nombreEmprunts < 5)
					new Reservation().accepterReservation(chPanelPreter, chPanelFormulairePreter.getFieldIdEt(),chPanelFormulairePreter.getFieldIdLivre(),chStmt);
				listeReservations = new Reservation().listeReservations(chStmt);
				chPanelTablePreter.setModelTablePreter(chStmt,listeReservations);
				listeEmprunts = new Emprunt().listeEmprunts(chStmt);
				chPanelRendre.getModelTableRendre().setModelTableRendre(chStmt,listeEmprunts);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
