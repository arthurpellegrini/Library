package Vue;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

import Constantes.ConstantesInterfaces;
import Modele.Emprunt;

public class PanelTableRetard extends JPanel implements ConstantesInterfaces{
	
	private static final long serialVersionUID = -2702168420181097926L;
	private ModelTableRetard chModele;
	private JTable chTableRetard;
	
	public PanelTableRetard(Statement parStmt) throws SQLException {
		ArrayList<Emprunt> listeEmpruntsRetards = new Emprunt().listeEmpruntsRetard(parStmt);
		chModele = new ModelTableRetard(parStmt,listeEmpruntsRetards);
		chTableRetard = new JTable (chModele) ;
		chTableRetard.setRowHeight(25);
		chTableRetard.getTableHeader().setResizingAllowed(false);
		chTableRetard.getTableHeader().setReorderingAllowed(false);
		chTableRetard.getTableHeader().setFont(US_12);
		chTableRetard.getTableHeader().setBackground(ORANGE);
		chTableRetard.setDefaultRenderer ( Object.class, new CelluleRenderer ());
		JScrollPane scrollPane = new JScrollPane(chTableRetard, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED) ;
		this.add(scrollPane);
		scrollPane.setBackground(GRIS_FONCE);
	}
	
	public void setModelTableRetard(Statement parStmt, ArrayList<Emprunt> parListeEmpruntsRetards) throws SQLException {
		ModelTableRetard modele = new ModelTableRetard(parStmt, parListeEmpruntsRetards);
		chTableRetard.setModel(modele);
	}
}
