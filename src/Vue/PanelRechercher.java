package Vue;

import java.awt.GridLayout;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JPanel;
import Constantes.*;
import Controleur.ControleurRechercher;
import Modele.Livre;

public class PanelRechercher extends JPanel implements ConstantesInterfaces{
	
	private static final long serialVersionUID = 2054850578252990393L;
	private PanelFormulaireRechercher chPanelFormulaireRechercher;
	private PanelTableLivre chPanelTableLivre;
	
	public PanelRechercher (Statement parStmt) throws SQLException {
		
		setLayout(new GridLayout(2,1));
		ArrayList<Livre> listeLivres = new Livre().listeLivres(parStmt);
	
		chPanelFormulaireRechercher = new PanelFormulaireRechercher();
		chPanelTableLivre = new PanelTableLivre(parStmt, listeLivres);
		chPanelTableLivre.setLayout(new GridLayout());
	
		add(chPanelFormulaireRechercher);
		add(chPanelTableLivre);
		setBackground(GRIS_FONCE);
		
		new ControleurRechercher(chPanelFormulaireRechercher,chPanelTableLivre,parStmt);
	}
	
	public PanelTableLivre getModelTableRechercher() {
		return chPanelTableLivre;
	}
}
