package Vue;

import javax.swing.table.DefaultTableModel;
import Constantes.*;
import Modele.*;
import java.sql.*;
import java.util.ArrayList;

public class ModelTableGestionCompte extends DefaultTableModel implements ConstantesInterfaces{
	private static final long serialVersionUID = -4434444736477465691L;

	public ModelTableGestionCompte(Statement parStmt, ArrayList <Etudiant> parListeEtudiants) throws SQLException {
		this.setColumnCount(ENTETES_ETUDIANTS.length);
		this.setRowCount(parListeEtudiants.size());
		this.setColumnIdentifiers(ENTETES_ETUDIANTS);
		
		int ligne = 0;
		for(Etudiant e : parListeEtudiants) {
			setValueAt(e.getNom(),ligne,0);
			setValueAt(e.getPrenom(),ligne,1);
			setValueAt(e.getEmail(),ligne,2);
			setValueAt(e.getMdp(),ligne,3);
			ligne++;
		}
	}
}
