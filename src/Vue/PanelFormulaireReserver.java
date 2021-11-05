package Vue;

import java.awt.*;
import javax.swing.*;
import Constantes.*;
import Controleur.ControleurReserver;

public class PanelFormulaireReserver extends JPanel implements ConstantesInterfaces{
	private static final long serialVersionUID = 7791799444861745993L;
	private JTextField chFieldIdLivre = new JTextField(20);
	private JButton chBoutonReserver = new JButton(RESERVER);
	
	public PanelFormulaireReserver() {
		//Initialisation du layout
		setLayout(new GridBagLayout());
		GridBagConstraints contrainte = new GridBagConstraints();
		contrainte.insets = new Insets(5,5,5,5);
		contrainte.fill = GridBagConstraints.BOTH;
		contrainte.anchor = GridBagConstraints.WEST;
		setBackground (GRIS_FONCE);
		
		//Initialisation des labels
		JLabel labelReserver = new JLabel(ID_LIVRE_MIN);
		labelReserver.setFont (US_14);
		labelReserver.setForeground (BLANC);
		labelReserver.setDisplayedMnemonic('I');
		labelReserver.setLabelFor(chFieldIdLivre);
		
		//Partie Recherche
		contrainte.gridy =0; contrainte.gridx = 0; 
		this.add(labelReserver, contrainte);
		contrainte.gridx ++;
		chFieldIdLivre.setFont(US_12);
		chFieldIdLivre.setForeground(BLANC);
		chFieldIdLivre.setBackground(GRIS_CLAIR);
		this.add(chFieldIdLivre, contrainte);
		
		//Partie Bouton
		contrainte.gridx = 1; contrainte.gridy = 2;
		chBoutonReserver.setFont(US_12);
		chBoutonReserver.setForeground(BLANC);
		chBoutonReserver.setBackground(GRIS_CLAIR);
		this.add(chBoutonReserver, contrainte);
	}
	
	public void enregistreEcouteur(ControleurReserver controleurReserver) {	
		chBoutonReserver.addActionListener(controleurReserver);
		chBoutonReserver.setActionCommand(RESERVER);
	}
	
	public int getIdReserver() {
		return Integer.valueOf(chFieldIdLivre.getText());
	}
} //PanelRecherche
