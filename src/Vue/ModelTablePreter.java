package Vue;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import Constantes.*;
import Modele.Reservation;

public class ModelTablePreter extends DefaultTableModel implements ConstantesInterfaces {
	private static final long serialVersionUID = -677774635042449518L;

	public ModelTablePreter(Statement parStmt, ArrayList<Reservation> chListeReservations) {
		
		this.setColumnCount(ENTETES_RESERVATION.length);
		this.setRowCount(chListeReservations.size());
		this.setColumnIdentifiers(ENTETES_RESERVATION);
		
		int ligne = 0;
		for(Reservation e: chListeReservations) {
			setValueAt(String.valueOf(e.getChIdLivre()),ligne,0);
			setValueAt(String.valueOf(e.getChIdEtudiant()),ligne,1);
			setValueAt(e.getChNom(),ligne,2);
			setValueAt(e.getChPrenom(),ligne,3);
			setValueAt(e.getChLivre(),ligne,4);
			ligne++;	
		}
	}
}
