package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Constantes.ConstantesInterfaces;
import Modele.Reservation;
import Vue.PanelFormulaireReserver;
import Vue.PanelReserver;
import Vue.PanelTablePreter;


public class ControleurReserver implements ConstantesInterfaces, ActionListener {
	private PanelReserver chPanelReserver;
	private PanelFormulaireReserver chPaneFormulaireReserver;
	private PanelTablePreter chPanelTablePreter;
	private int chIdEtudiant;
	private Statement chStmt;
	
	
	public ControleurReserver(PanelReserver parPanelReserver, PanelFormulaireReserver parPaneFormulaireReserver, PanelTablePreter parPanelTablePreter, int parIdEt,Statement parStmt) {
		chPanelReserver = parPanelReserver;
		chPaneFormulaireReserver = parPaneFormulaireReserver;
		chPaneFormulaireReserver.enregistreEcouteur(this);
		chPanelTablePreter = parPanelTablePreter;
		chIdEtudiant = parIdEt;
		chStmt = parStmt;
	}

	public void actionPerformed(ActionEvent parEvt) {
		ArrayList<Reservation> listeReservations;
		if(parEvt.getActionCommand().equals(RESERVER)) {
			
			try {
				int nombreReservations = new Reservation().nombreReservations(chPanelReserver, chIdEtudiant,chStmt);
				if(nombreReservations < 5)
					new Reservation().reserverLivre(chPanelReserver,chIdEtudiant,Integer.valueOf(chPaneFormulaireReserver.getIdReserver()), chStmt);
				listeReservations = new Reservation().listeReservationsEtudiant(chIdEtudiant,chStmt);
				chPanelTablePreter.setModelTablePreter(chStmt,listeReservations);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(chPanelReserver, "Il n'existe aucun livre ayant pour identifiant : " + chPaneFormulaireReserver.getIdReserver(),"Erreur réservation",JOptionPane.ERROR_MESSAGE);
			}
		}
	}		
}