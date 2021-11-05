package Vue;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import Constantes.*;
import Modele.Emprunt;

public class PanelTableRendre extends JPanel implements ConstantesInterfaces{
	private static final long serialVersionUID = -2702168420181097926L;
	private ModelTableRendre chModele;
	private JTable chTableRendre;
	
	public PanelTableRendre(Statement parStmt, ArrayList<Emprunt> parListeEtudiants) throws SQLException {
		chModele = new ModelTableRendre(parStmt,parListeEtudiants);
		chTableRendre = new JTable (chModele) ;
		chTableRendre.setRowHeight(25);
		chTableRendre.getTableHeader().setResizingAllowed(false);
		chTableRendre.getTableHeader().setReorderingAllowed(false);
		chTableRendre.getTableHeader().setFont(US_12);
		chTableRendre.getTableHeader().setBackground(ORANGE);
		chTableRendre.setDefaultRenderer ( Object.class, new CelluleRenderer());
		JScrollPane scrollPane = new JScrollPane(chTableRendre, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED) ;
		this.add(scrollPane);
		scrollPane.setBackground(GRIS_FONCE);
	}
	
	public void setModelTableRendre(Statement parStmt, ArrayList<Emprunt> parListeEtudiants) throws SQLException {
		ModelTableRendre modele = new ModelTableRendre(parStmt, parListeEtudiants);
		chTableRendre.setModel(modele);
	}
}
