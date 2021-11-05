package Vue;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

import Constantes.ConstantesInterfaces;
import Modele.Livre;

public class PanelTableLivre extends JPanel implements ConstantesInterfaces{
	private static final long serialVersionUID = -2702168420181097926L;
	private ModelTableLivre chModele;
	private JTable chTableLivre;
	
	public PanelTableLivre(Statement parStmt, ArrayList<Livre> parListeLivres) throws SQLException {
		chModele = new ModelTableLivre(parStmt,parListeLivres);
		chTableLivre = new JTable (chModele) ;
		chTableLivre.setRowHeight(25);
		chTableLivre.getTableHeader().setResizingAllowed(false);
		chTableLivre.getTableHeader().setReorderingAllowed(false);
		chTableLivre.getTableHeader().setFont(US_12);
		chTableLivre.getTableHeader().setBackground(ORANGE);
		chTableLivre.setDefaultRenderer ( Object.class, new CelluleRenderer());
		JScrollPane scrollPane = new JScrollPane(chTableLivre, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED) ;
		this.add(scrollPane);
		scrollPane.setBackground(GRIS_FONCE);
	}
	
	public void setModelTableLivre(Statement parStmt, ArrayList<Livre> parListeLivres) throws SQLException {
		ModelTableLivre modele = new ModelTableLivre(parStmt, parListeLivres);
		chTableLivre.setModel(modele);
	}
}
