package Vue;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import Constantes.*;
import Modele.Emprunt;

public class ModelTableRetard extends DefaultTableModel implements ConstantesInterfaces{
	private static final long serialVersionUID = -4434444736477465691L;
	
	public ModelTableRetard(Statement parStmt, ArrayList<Emprunt> chListeEmpruntsRetard) throws SQLException {
		
		this.setColumnCount(ENTETES_RETARD.length);
		this.setRowCount(chListeEmpruntsRetard.size());
		this.setColumnIdentifiers(ENTETES_RETARD);
		
		int ligne = 0;
		for(Emprunt e: chListeEmpruntsRetard) {
			setValueAt(String.valueOf(e.getIdExemplaire()),ligne,0);
			setValueAt(e.getLivre(),ligne,1);
			setValueAt(String.valueOf(e.getIdEtudiant()),ligne,2);
			setValueAt(e.getNom(),ligne,3);
			setValueAt(e.getPrenom(),ligne,4);
			setValueAt(e.getEmail(),ligne,5);
			ligne++;	
		}
	}
}
