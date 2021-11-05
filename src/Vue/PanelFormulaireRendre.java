package Vue;

import java.awt.*;
import java.sql.Statement;
import javax.swing.*;
import Constantes.*;
import Controleur.ControleurRendre;

public class PanelFormulaireRendre extends JPanel implements ConstantesInterfaces {
	static final long serialVersionUID = -118402856422078000L;
	private JTextField chFieldIdExemplaire = new JTextField(20);
	private JButton chBoutonRendre = new JButton(RENDRE);
	
	public PanelFormulaireRendre(Statement parStmt) {
		
		//Création du Layout
		setLayout(new GridBagLayout());
		GridBagConstraints contrainte = new GridBagConstraints();
		contrainte.insets = new Insets(5,5,5,5);
		contrainte.fill = GridBagConstraints.BOTH;
		contrainte.anchor = GridBagConstraints.WEST;
				
		//Intanciation des Labels
		JLabel labelIdExemplaire = new JLabel(ID_EXEMPLAIRE_MIN);
		labelIdExemplaire.setFont (US_14);
		labelIdExemplaire.setForeground (BLANC);
		labelIdExemplaire.setDisplayedMnemonic('I');
		labelIdExemplaire.setLabelFor(chFieldIdExemplaire);
					
		//Id Exemplaire
		contrainte.gridy = 0; contrainte.gridx = 0; 
		this.add(labelIdExemplaire, contrainte);
		contrainte.gridx ++;
		chFieldIdExemplaire.setFont(US_12);
		chFieldIdExemplaire.setForeground(BLANC);
		chFieldIdExemplaire.setBackground(GRIS_CLAIR);
		this.add(chFieldIdExemplaire, contrainte);
			
		//Partie Bouton
		contrainte.gridx = 1; contrainte.gridy ++;
		chBoutonRendre.setFont(US_12);
		chBoutonRendre.setForeground(BLANC);
		chBoutonRendre.setBackground(GRIS_CLAIR);
		this.add(chBoutonRendre, contrainte);
				
		setBackground (GRIS_FONCE);
	}
	
	public void enregistreEcouteur(ControleurRendre parControleurRendu) {
		chBoutonRendre.addActionListener(parControleurRendu);
		chBoutonRendre.setActionCommand(RENDRE);
	}
	
	public int getChFieldIdEx() {
		return Integer.valueOf(chFieldIdExemplaire.getText());
	}
}
