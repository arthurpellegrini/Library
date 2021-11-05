package Vue;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import Constantes.*;
import Modele.Etudiant;

public class PanelTableGestionCompte extends JPanel implements ConstantesInterfaces{ 
	private static final long serialVersionUID = -2702168420181097926L;
	ModelTableGestionCompte chModele;
	JTable chTableComptes;
	
	public PanelTableGestionCompte(Statement parStmt, ArrayList <Etudiant> parListeEtudiants) throws SQLException {
		chModele = new ModelTableGestionCompte(parStmt,parListeEtudiants);
		chTableComptes = new JTable (chModele);
		chTableComptes.setRowHeight(25);
		chTableComptes.getTableHeader().setResizingAllowed(false);
		chTableComptes.getTableHeader().setReorderingAllowed(false);
		chTableComptes.getTableHeader().setFont(US_12);
		chTableComptes.getTableHeader().setBackground(ORANGE);
		chTableComptes.setDefaultRenderer ( Object.class, new CelluleRenderer());
		JScrollPane scrollPane = new JScrollPane(chTableComptes, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED) ;
		this.add(scrollPane) ;
		scrollPane.setBackground(GRIS_FONCE);
	}
	
	public void setModelGestionCompte(Statement parStmt, ArrayList <Etudiant> parListeEtudiants) throws SQLException {
		ModelTableGestionCompte modele = new ModelTableGestionCompte(parStmt,parListeEtudiants);
		chTableComptes.setModel(modele);
	}
}
