package Vue;

import javax.swing.table.DefaultTableModel;
import Constantes.*;
import Modele.Livre;
import java.sql.*;
import java.util.ArrayList;

public class ModelTableLivre extends DefaultTableModel implements ConstantesInterfaces{
	private static final long serialVersionUID = -4434444736477465691L;
	
	public ModelTableLivre(Statement parStmt, ArrayList <Livre> parListeLivres) throws SQLException {
		this.setColumnCount(ENTETES_LIVRES.length);
		this.setRowCount(parListeLivres.size());
		this.setColumnIdentifiers(ENTETES_LIVRES);

		int ligne = 0;
		for(Livre l: parListeLivres) {
			setValueAt(String.valueOf(l.getIdLivre()),ligne, 0);
			setValueAt(l.getTitre(),ligne,1);
			setValueAt(l.getAuteur(),ligne,2);
			ligne++;	
		}
	}
}
