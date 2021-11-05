package Vue;

import java.sql.*;
import javax.swing.JFrame;
import Constantes.*;
import Controleur.*;
import Modele.Jdbc;

public class FenetreConnexion extends JFrame implements ConstantesInterfaces {
	private static final long serialVersionUID = 5713084436146948003L;
	
    public FenetreConnexion (Statement parStmt) throws SQLException {
        super("Portail Connexion Bibliothèque");
        PanelFormulaireConnexion panelFormulaireConnexion = new PanelFormulaireConnexion();
      
        setContentPane(panelFormulaireConnexion);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(HORIZONTAL_CON,VERTICAL_CON); setResizable(RESIZABLE); 
        setVisible(true); setLocation (POSX_CON,POSY_CON);
        setBackground (BLANC);
      
        new ControleurConnexion(this, panelFormulaireConnexion, parStmt);
    }

    public static void main (String  [] args) throws ClassNotFoundException, SQLException {  	
    	Jdbc connexion = new Jdbc();
    	Statement stmt = connexion.getStatement();
        new FenetreConnexion(stmt);
    }
}
