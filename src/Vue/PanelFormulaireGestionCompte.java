package Vue;

import java.awt.*;
import java.sql.Statement;
import javax.swing.*;
import Constantes.*;
import Controleur.*;

public class PanelFormulaireGestionCompte extends JPanel implements ConstantesInterfaces{
	private static final long serialVersionUID = 7791799444861745993L;
	JTextField chFieldNom = new JTextField(20);
	JTextField chFieldPrenom = new JTextField(20);
	JButton chBoutonCreate = new JButton(CREER);
	JButton chBoutonEdit = new JButton(EDITER);
	JButton chBoutonDelete = new JButton(SUPPRIMER);
	
	public PanelFormulaireGestionCompte(Statement parStmt) {
		//Initialisation du layout
		setLayout(new GridBagLayout());
		GridBagConstraints contrainte = new GridBagConstraints();
		contrainte.insets = new Insets(5,5,5,5);
		contrainte.fill = GridBagConstraints.BOTH;
		contrainte.anchor = GridBagConstraints.WEST;
		setBackground (GRIS_FONCE);
		
		//Initialisation des labels
		JLabel labelNom = new JLabel(NOM_MIN);
		labelNom.setFont (US_14);
		labelNom.setForeground (BLANC);
		labelNom.setDisplayedMnemonic('N');
		labelNom.setLabelFor(chFieldNom);
		
		JLabel labelPrenom = new JLabel(PRENOM_MIN);
		labelPrenom.setFont (US_14);
		labelPrenom.setForeground (BLANC);
		labelPrenom.setDisplayedMnemonic('P');
		labelPrenom.setLabelFor(chFieldPrenom);

		//Partie Nom
		contrainte.gridy =0; contrainte.gridx = 0; 
		this.add(labelNom, contrainte);
		contrainte.gridx ++;
		chFieldNom.setFont(US_12);
		chFieldNom.setForeground(BLANC);
		chFieldNom.setBackground(GRIS_CLAIR);
		this.add(chFieldNom, contrainte);
		
		//Partie Prenom
		contrainte.gridy ++; contrainte.gridx = 0; 
		this.add(labelPrenom, contrainte);
		contrainte.gridx ++;
		chFieldPrenom.setFont(US_12);
		chFieldPrenom.setForeground(BLANC);
		chFieldPrenom.setBackground(GRIS_CLAIR);
		this.add(chFieldPrenom, contrainte);
		
		//Partie BoutonCreate
		contrainte.gridx = 1; contrainte.gridy++;
		chBoutonCreate.setFont(US_12);
		chBoutonCreate.setForeground(BLANC);
		chBoutonCreate.setBackground(GRIS_CLAIR);
		this.add(chBoutonCreate, contrainte);
		
		//Partie BoutonEdit
		contrainte.gridx = 1; contrainte.gridy++;
		chBoutonEdit.setFont(US_12);
		chBoutonEdit.setForeground(BLANC);
		chBoutonEdit.setBackground(GRIS_CLAIR);
		this.add(chBoutonEdit, contrainte);
				
		//Partie BoutonDelete
		contrainte.gridx = 1; contrainte.gridy++;
		chBoutonDelete.setFont(US_12);
		chBoutonDelete.setForeground(BLANC);
		chBoutonDelete.setBackground(GRIS_CLAIR);
		this.add(chBoutonDelete, contrainte);
	}

	public void enregistreEcouteur(ControleurGestionCompte parControleur) {	
		chBoutonCreate.addActionListener(parControleur);
		chBoutonCreate.setActionCommand(CREER);
		chBoutonEdit.addActionListener(parControleur);
		chBoutonEdit.setActionCommand(EDITER);
		chBoutonDelete.addActionListener(parControleur);
		chBoutonDelete.setActionCommand(SUPPRIMER);
	}
	
	public String getNom() {
		return chFieldNom.getText();
	}
	
	public String getPrenom() {
		return chFieldPrenom.getText();
	}
}
