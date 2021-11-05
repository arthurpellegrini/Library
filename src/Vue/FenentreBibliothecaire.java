package Vue;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import Constantes.ConstantesInterfaces;

public class FenentreBibliothecaire extends JFrame implements ConstantesInterfaces {
	private static final long serialVersionUID = 5713084436146948003L;
	
	public FenentreBibliothecaire (Statement parStmt) throws SQLException {
        super("Espace Bibliothécaire (" + EMAIL_BIBLIOTHECAIRE + ")");
        //Création des panels
        PanelRechercher panelRechercher = new PanelRechercher(parStmt);
        PanelAjouterLivre panelAjouterLivre = new PanelAjouterLivre(panelRechercher,parStmt);
        PanelTableRetard panelTableRetard = new PanelTableRetard(parStmt);
        PanelRendre panelRendre = new PanelRendre(panelTableRetard,parStmt);
        PanelPreter panelPreter = new PanelPreter(panelRendre,parStmt);
        PanelGestionCompte panelGestionCompte = new PanelGestionCompte(parStmt);
        
        //Partie Layout de PanelTableRetard
        panelTableRetard.setLayout(new GridLayout());
        
        //Partie Onglets
        
        JTabbedPane onglets = new JTabbedPane();
        onglets.setFont(US_14);
        onglets.setBackground(ORANGE);
        onglets.setBounds(40,20,300,300);
        onglets.add("Rechercher Livre", panelRechercher);
        onglets.add("Ajouter Livre", panelAjouterLivre);
        onglets.add("Prêter",panelPreter);
        onglets.add("Rendre",panelRendre);
        onglets.add("Gestion Compte", panelGestionCompte);
        onglets.add("Retard",panelTableRetard);
        add(onglets);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(HORIZONTAL_BE,VERTICAL_BE); setResizable(RESIZABLE); 
        setVisible(false); setLocation (POSX_BE,POSY_BE);
        setBackground (GRIS_FONCE);
	}
}
