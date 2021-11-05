package Vue;

import java.sql.*;
import javax.swing.*;
import Constantes.*;

public class FenetreEtudiant extends JFrame implements ConstantesInterfaces {
	private static final long serialVersionUID = 5713084436146948003L;
	
	public FenetreEtudiant (int parIdEtudiant, String parEmail, Statement parStmt) throws SQLException {
        super("Espace Etudiant (" + parEmail + ")");
        //Création des panels
        PanelRechercher panelRechercher = new PanelRechercher(parStmt);
        PanelReserver panelReserver = new PanelReserver(parIdEtudiant, parStmt);
        
        //Création des onglest
        JTabbedPane onglets = new JTabbedPane();
        onglets.setFont(US_14);
        onglets.setBackground(ORANGE);
        onglets.setBounds(40,20,300,300);
        onglets.add("Rechercher Livre", panelRechercher);
        onglets.add("Réservation", panelReserver);
        add(onglets);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(HORIZONTAL_BE,VERTICAL_BE); setResizable(RESIZABLE); 
        setVisible(false); setLocation (POSX_BE,POSY_BE);
        setBackground (GRIS_FONCE);
	}
}
