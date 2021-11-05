package Vue;

import java.awt.GridLayout;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JPanel;
import Constantes.*;
import Controleur.ControleurRendre;
import Modele.Emprunt;

public class PanelRendre extends JPanel implements ConstantesInterfaces{
	private static final long serialVersionUID = 1L;
	private PanelFormulaireRendre chPanelFormulaireRendu;
	private PanelTableRendre chPanelTableRendre;
		
	public PanelRendre(PanelTableRetard parPanelTableRetard, Statement parStmt) throws SQLException {
		setLayout(new GridLayout(2,1));
		ArrayList<Emprunt> chListeEmprunts = new Emprunt().listeEmprunts(parStmt);
		
		chPanelFormulaireRendu = new PanelFormulaireRendre(parStmt);
		chPanelTableRendre = new PanelTableRendre(parStmt, chListeEmprunts);
		chPanelTableRendre.setLayout(new GridLayout());
		
		add(chPanelFormulaireRendu);
		add(chPanelTableRendre);
		setBackground(GRIS_FONCE);
		
		new ControleurRendre(this, chPanelFormulaireRendu,chPanelTableRendre,parPanelTableRetard, parStmt);
	}
	
	public PanelTableRendre getModelTableRendre() {
		return chPanelTableRendre;
	}
}
