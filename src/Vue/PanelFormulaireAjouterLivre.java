package Vue;

import java.awt.*;
import javax.swing.*;
import Constantes.*;
import Controleur.*;

public class PanelFormulaireAjouterLivre extends JPanel implements ConstantesInterfaces {
	private static final long serialVersionUID = 4073992862196715407L;
	private JTextField chFieldTitre = new JTextField(20);;
	private JTextField chFieldAuteur = new JTextField(20);;
	private JButton chBoutonAjout = new JButton(AJOUTER);
	
	public PanelFormulaireAjouterLivre() {
		
		//Initialisation du layout
		setLayout(new GridBagLayout());
		GridBagConstraints contrainte = new GridBagConstraints();
		contrainte.insets = new Insets(5,5,5,5);
		contrainte.fill = GridBagConstraints.BOTH;
		contrainte.anchor = GridBagConstraints.WEST;
		setBackground (GRIS_FONCE);
				
		//Initialisation des labels
		JLabel labelTitre = new JLabel(TITRE_MIN);
		labelTitre.setFont (US_14);
		labelTitre.setForeground (BLANC);
		labelTitre.setDisplayedMnemonic('T');
		labelTitre.setLabelFor(chFieldTitre);
		
		JLabel labelAuteur = new JLabel(AUTEUR_MIN);
		labelAuteur.setFont (US_14);
		labelAuteur.setForeground (BLANC);
		labelAuteur.setDisplayedMnemonic('A');
		labelAuteur.setLabelFor(chFieldAuteur);
				
		//Partie Recherche
		contrainte.gridy = 0; contrainte.gridx = 0; 
		this.add(labelTitre, contrainte);
		contrainte.gridx ++;
		chFieldTitre.setFont(US_12);
		chFieldTitre.setForeground(BLANC);
		chFieldTitre.setBackground(GRIS_CLAIR);
		this.add(chFieldTitre, contrainte);
	
		contrainte.gridy ++; contrainte.gridx = 0; 
		this.add(labelAuteur, contrainte);
		contrainte.gridx ++;
		chFieldAuteur.setFont(US_12);
		chFieldAuteur.setForeground(BLANC);
		chFieldAuteur.setBackground(GRIS_CLAIR);
		this.add(chFieldAuteur, contrainte);
				
		//Partie Bouton
		contrainte.gridx = 1; contrainte.gridy = 2;
		chBoutonAjout.setFont(US_12);
		chBoutonAjout.setForeground(BLANC);
		chBoutonAjout.setBackground(GRIS_CLAIR);
		this.add(chBoutonAjout, contrainte);
	}
	
	public void enregistreEcouteur(ControleurAjouterLivre parControleur) {
		chBoutonAjout.addActionListener(parControleur);
		chBoutonAjout.setActionCommand(AJOUTER);	
	}
	
	public String getFieldTitre() {	
		return chFieldTitre.getText();
	}
	
	public String getFieldAuteur() {	
		return chFieldAuteur.getText();
	}
}
