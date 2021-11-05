package Vue;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import Constantes.*;
import Modele.Reservation;

public class PanelTablePreter extends JPanel implements ConstantesInterfaces {
	private static final long serialVersionUID = 1L;
	private ModelTablePreter chModele;
	private JTable chTablePreter;
	
	public PanelTablePreter(Statement parStmt, ArrayList<Reservation> parListeReservations) throws SQLException {
		chModele = new ModelTablePreter(parStmt,parListeReservations);
		chTablePreter = new JTable(chModele) ;
		chTablePreter.setRowHeight(25);
		chTablePreter.getTableHeader().setResizingAllowed(false);
		chTablePreter.getTableHeader().setReorderingAllowed(false);
		chTablePreter.getTableHeader().setFont(US_12);
		chTablePreter.getTableHeader().setBackground(ORANGE);
		chTablePreter.setDefaultRenderer ( Object.class, new CelluleRenderer ());
		JScrollPane scrollPane = new JScrollPane(chTablePreter, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED) ;
		this.add(scrollPane);
		scrollPane.setBackground(GRIS_FONCE);
	}
	
	public void setModelTablePreter(Statement parStmt, ArrayList<Reservation> parListeReservations) throws SQLException {
		ModelTablePreter modele = new ModelTablePreter(parStmt, parListeReservations);
		chTablePreter.setModel(modele);
	}
}