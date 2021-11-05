package Vue;

import java.awt.*;

import javax.swing.*;

import Constantes.*;
import Controleur.*;

public class PanelFormulaireRechercher extends JPanel implements ConstantesInterfaces{
	private static final long serialVersionUID = 7791799444861745993L;
	private JTextField chFieldRecherche = new JTextField(20);
	private JComboBox <String> chComboCriteres = new JComboBox<String>(ENTETES_LIVRES);
	private JButton chBoutonRecherche = new JButton(RECHERCHER);
	
	public PanelFormulaireRechercher() {
		//Initialisation du layout
		setLayout(new GridBagLayout());
		GridBagConstraints contrainte = new GridBagConstraints();
		contrainte.insets = new Insets(5,5,5,5);
		contrainte.fill = GridBagConstraints.BOTH;
		contrainte.anchor = GridBagConstraints.WEST;
		setBackground (GRIS_FONCE);
		
		//Initialisation des labels
		JLabel labelRecherche = new JLabel(RECHERCHER_MIN);
		labelRecherche.setFont (US_14);
		labelRecherche.setForeground (BLANC);
		labelRecherche.setDisplayedMnemonic('R');
		labelRecherche.setLabelFor(chFieldRecherche);
		
		JLabel labelCriteres = new JLabel(CRITERES_MIN);
		labelCriteres.setFont (US_14);
		labelCriteres.setForeground (BLANC);
		labelCriteres.setDisplayedMnemonic('C');
		labelCriteres.setLabelFor(chComboCriteres);
		
		//Partie Recherche
		contrainte.gridy =0; contrainte.gridx = 0; 
		this.add(labelRecherche, contrainte);
		contrainte.gridx ++;
		chFieldRecherche.setFont(US_12);
		chFieldRecherche.setForeground(BLANC);
		chFieldRecherche.setBackground(GRIS_CLAIR);
		this.add(chFieldRecherche, contrainte);
		
		//Partie Critère
		contrainte.gridy ++; contrainte.gridx = 0; 
		this.add(labelCriteres, contrainte);
		contrainte.gridx ++;
		chComboCriteres.setFont(US_12);
		chComboCriteres.setForeground(BLANC);
		chComboCriteres.setBackground(GRIS_CLAIR);
		this.add(chComboCriteres, contrainte);
		
		//Partie Bouton
		contrainte.gridx = 1; contrainte.gridy = 2;
		chBoutonRecherche.setFont(US_12);
		chBoutonRecherche.setForeground(BLANC);
		chBoutonRecherche.setBackground(GRIS_CLAIR);
		this.add(chBoutonRecherche, contrainte);
	}
	
	public void enregistreEcouteur(ControleurRechercher parControleur) {	
		chBoutonRecherche.addActionListener(parControleur);
		chBoutonRecherche.setActionCommand(RECHERCHER);
	}
	
	public String getComboBoxCriteres() {
		return chComboCriteres.getSelectedItem().toString();
	}
	
	public String getRecherche() {
		return chFieldRecherche.getText();
	}
} //PanelRecherche
