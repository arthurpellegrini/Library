package Vue;

import java.awt.GridLayout;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JPanel;
import Modele.*;
import Constantes.*;
import Controleur.ControleurGestionCompte;

public class PanelGestionCompte extends JPanel implements ConstantesInterfaces{
	private static final long serialVersionUID = 2054850578252990393L;

	public PanelGestionCompte (Statement parStmt) throws SQLException {
		setLayout(new GridLayout(2,1));
		ArrayList <Etudiant> listeEtudiants = new Etudiant().listeEtudiants(parStmt);
		
		PanelFormulaireGestionCompte panelFormulaireGestionCompte = new PanelFormulaireGestionCompte(parStmt);
		PanelTableGestionCompte panelTableGestionCompte = new PanelTableGestionCompte(parStmt, listeEtudiants);
		panelTableGestionCompte.setLayout(new GridLayout());
	
		add(panelFormulaireGestionCompte);
		add(panelTableGestionCompte);
		setBackground(GRIS_FONCE);
		
		new ControleurGestionCompte(this, panelFormulaireGestionCompte, panelTableGestionCompte,parStmt);
	}
}