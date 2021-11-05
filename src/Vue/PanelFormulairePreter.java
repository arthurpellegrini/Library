package Vue;

import java.awt.*;
import javax.swing.*;
import Constantes.ConstantesInterfaces;
import Controleur.ControleurPreter;

public class PanelFormulairePreter extends JPanel implements ConstantesInterfaces {
	private static final long serialVersionUID = 4413557137353785513L;
	private JTextField chFieldIdLivre = new JTextField(20);
	private JTextField chFieldIdEtudiant = new JTextField(20);
	private JButton chBoutonAccepter = new JButton(PRETER);
	
	public PanelFormulairePreter() {
		//Création du Layout
		setLayout(new GridBagLayout());
		GridBagConstraints contrainte = new GridBagConstraints();
		contrainte.insets = new Insets(5,5,5,5);
		contrainte.fill = GridBagConstraints.BOTH;
		contrainte.anchor = GridBagConstraints.WEST;
		
		//Intanciation des Labels
		JLabel labelIdLivre = new JLabel(ID_LIVRE_MIN);
		labelIdLivre.setFont (US_14);
		labelIdLivre.setForeground (BLANC);
		labelIdLivre.setDisplayedMnemonic('L');
		labelIdLivre.setLabelFor(chFieldIdLivre);
		
		JLabel labelIdEtudiant = new JLabel(ID_ETUDIANT_MIN);
		labelIdEtudiant.setFont (US_14);
		labelIdEtudiant.setForeground (BLANC);
		labelIdEtudiant.setDisplayedMnemonic('E');
		labelIdEtudiant.setLabelFor(chFieldIdEtudiant);
	
		//ID_Livre
		contrainte.gridy = 0; contrainte.gridx = 0; 
		this.add(labelIdLivre, contrainte);
		contrainte.gridx ++;
		chFieldIdLivre.setFont(US_12);
		chFieldIdLivre.setForeground(BLANC);
		chFieldIdLivre.setBackground(GRIS_CLAIR);
		this.add(chFieldIdLivre, contrainte);
		
		//ID_ETUDIANT
		contrainte.gridy ++; contrainte.gridx = 0; 
		this.add(labelIdEtudiant, contrainte);
		contrainte.gridx ++;
		chFieldIdEtudiant.setFont(US_12);
		chFieldIdEtudiant.setForeground(BLANC);
		chFieldIdEtudiant.setBackground(GRIS_CLAIR);
		this.add(chFieldIdEtudiant, contrainte);
		
		//Partie Bouton
		contrainte.gridx = 1; contrainte.gridy = 2;
		chBoutonAccepter.setFont(US_12);
		chBoutonAccepter.setForeground(BLANC);
		chBoutonAccepter.setBackground(GRIS_CLAIR);
		this.add(chBoutonAccepter, contrainte);
		setBackground (GRIS_FONCE);
	}
	
	public void enregistreEcouteur(ControleurPreter parControleur) {
		chBoutonAccepter.addActionListener(parControleur);
		chBoutonAccepter.setActionCommand(PRETER);
	}

	public int getFieldIdEt() {
		return Integer.valueOf(chFieldIdEtudiant.getText());
	}
	
	public int getFieldIdLivre() {
		return Integer.valueOf(chFieldIdLivre.getText());
	}

}
