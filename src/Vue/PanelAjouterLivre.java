package Vue;

import java.awt.GridLayout;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JPanel;
import Constantes.*;
import Controleur.ControleurAjouterLivre;
import Modele.Livre;

public class PanelAjouterLivre extends JPanel implements ConstantesInterfaces {
	private static final long serialVersionUID = 1L;
	private PanelFormulaireAjouterLivre chPanelAjoutLivre; 
	private PanelTableLivre chPanelTableLivre;
	
	public PanelAjouterLivre(PanelRechercher parPanelRechercher, Statement parStmt) throws SQLException{
		
		setLayout(new GridLayout(2,1));
		ArrayList<Livre> listeLivres = new Livre().listeLivres(parStmt);
		
		chPanelAjoutLivre = new PanelFormulaireAjouterLivre();
		chPanelTableLivre = new PanelTableLivre(parStmt,listeLivres);
		chPanelTableLivre.setLayout(new GridLayout());
		
		add(chPanelAjoutLivre);
		add(chPanelTableLivre);
		setBackground(GRIS_FONCE);
		
		new ControleurAjouterLivre(this, chPanelAjoutLivre, parPanelRechercher, parStmt);
	}
	
	public PanelTableLivre getModelTableAjouterLivre() {
		return chPanelTableLivre;
	}
}
