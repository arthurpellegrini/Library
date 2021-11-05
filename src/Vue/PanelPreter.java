package Vue;

import java.awt.GridLayout;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JPanel;
import Constantes.ConstantesInterfaces;
import Controleur.ControleurPreter;
import Modele.Reservation;

public class PanelPreter extends JPanel implements ConstantesInterfaces {
	private static final long serialVersionUID = 2054850578252990393L;
	private PanelFormulairePreter chPanelFormulairePreter;
	private PanelTablePreter chPanelTablePreter;
	
	public PanelPreter(PanelRendre parPanelRendre,Statement parStmt) throws SQLException {
		
		setLayout(new GridLayout(2,1));
		ArrayList<Reservation> listeReservations = new Reservation().listeReservations(parStmt);
	
		chPanelFormulairePreter = new PanelFormulairePreter();
		chPanelTablePreter = new PanelTablePreter(parStmt, listeReservations);
		chPanelTablePreter.setLayout(new GridLayout());
	
		add(chPanelFormulairePreter);
		add(chPanelTablePreter);
		setBackground(GRIS_FONCE);
		
		new ControleurPreter(this, chPanelFormulairePreter, chPanelTablePreter, parPanelRendre, parStmt);
	}
}
