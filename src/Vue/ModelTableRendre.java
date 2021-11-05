package Vue;

import javax.swing.table.DefaultTableModel;
import Constantes.*;
import Modele.Emprunt;
import java.sql.*;
import java.util.ArrayList;

public class ModelTableRendre extends DefaultTableModel implements ConstantesInterfaces{
	private static final long serialVersionUID = -4434444736477465691L;
	
	public ModelTableRendre(Statement parStmt, ArrayList<Emprunt> chListeEmprunts) throws SQLException {
		
		this.setColumnCount(ENTETES_RENDRE.length);
		this.setRowCount(chListeEmprunts.size());
		this.setColumnIdentifiers(ENTETES_RENDRE);
		
		int ligne = 0;
		for(Emprunt e: chListeEmprunts) {
			setValueAt(String.valueOf(e.getIdExemplaire()),ligne,0);
			setValueAt(String.valueOf(e.getIdEtudiant()),ligne,1);
			setValueAt(e.getNom(),ligne,2);
			setValueAt(e.getPrenom(),ligne,3);
			setValueAt(e.getLivre(),ligne,4);
			ligne++;	
		}
	}
}