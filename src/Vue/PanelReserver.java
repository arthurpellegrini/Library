package Vue;

import java.awt.GridLayout;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JPanel;
import Constantes.ConstantesInterfaces;
import Controleur.ControleurReserver;
import Modele.Reservation;

public class PanelReserver extends JPanel implements ConstantesInterfaces{
	private static final long serialVersionUID = 2054850578252990393L;

	public PanelReserver (int parId_ET, Statement parStmt) throws SQLException {
		
		setLayout(new GridLayout(2,1));
		ArrayList<Reservation> listeReservations = new Reservation().listeReservationsEtudiant(parId_ET,parStmt);
		
		PanelFormulaireReserver panelFormulaireReserver = new PanelFormulaireReserver();
		PanelTablePreter panelTablePreter = new PanelTablePreter(parStmt, listeReservations);
		panelTablePreter.setLayout(new GridLayout());
		
		add(panelFormulaireReserver);
		add(panelTablePreter);
		setBackground(GRIS_FONCE);
		
		new ControleurReserver(this, panelFormulaireReserver, panelTablePreter, parId_ET,parStmt);
	}
}
