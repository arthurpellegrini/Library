package Vue;

import java.awt.*;
import javax.swing.*;
import Constantes.*;
import Controleur.*;

public class PanelFormulaireConnexion extends JPanel implements ConstantesInterfaces {
	private static final long serialVersionUID = 1719514909368054451L;
    private JTextField chFieldEmail = new JTextField(25);
    private JPasswordField chFieldMotDePasse = new JPasswordField(25);
    private JButton chBoutonConnexion = new JButton(CONNEXION);
    
    public PanelFormulaireConnexion () {
        // GridBagLayout
        setLayout(new GridBagLayout());
        GridBagConstraints contrainte = new GridBagConstraints ();
        contrainte.fill = GridBagConstraints.BOTH;
        contrainte.insets = new Insets(5,10,5,10);
        setBackground (GRIS_FONCE);

        // Instanciation labels
        JLabel labelTitre = new JLabel (IDCON_MIN);
        labelTitre.setFont (US_24);
        labelTitre.setForeground (ORANGE);

        JLabel labelEmail = new JLabel (EMAIL_MIN);
        labelEmail.setFont (US_14);
        labelEmail.setForeground (BLANC);

        JLabel labelMotDePasse = new JLabel (MDP_MIN);
        labelMotDePasse.setFont (US_14);
        labelMotDePasse.setForeground (BLANC);

        // labelTitre
        contrainte.gridy=0; contrainte.gridx=1; contrainte.gridwidth =4;
        add(labelTitre, contrainte);

        // labelEmail & chFieldEmail
        contrainte.gridy++; contrainte.gridx=0; contrainte.gridwidth =1;
        labelEmail.setDisplayedMnemonic('E');
        labelEmail.setLabelFor(chFieldEmail);
        add (labelEmail, contrainte);
        contrainte.gridx++; contrainte.gridwidth =4 ;
        chFieldEmail.setFont(US_12);
        chFieldEmail.setForeground(BLANC);
        chFieldEmail.setBackground(GRIS_CLAIR);
        add (chFieldEmail, contrainte);

        // labelMotdePasse & chFieldMotDePasse
        contrainte.gridy++; contrainte.gridx =0 ; contrainte.gridwidth =1;
        labelMotDePasse.setDisplayedMnemonic('M');
        labelMotDePasse.setLabelFor(chFieldMotDePasse);
        add (labelMotDePasse, contrainte);
        contrainte.gridx++; contrainte.gridwidth =4;
        chFieldMotDePasse.setEchoChar('*');
        chFieldMotDePasse.setFont(US_12);
        chFieldMotDePasse.setForeground(BLANC);
        chFieldMotDePasse.setBackground(GRIS_CLAIR);
        add (chFieldMotDePasse, contrainte);

        // chBoutonLogin
        contrainte.gridy++; contrainte.gridx=4;
        chBoutonConnexion.setFont(US_12);
        chBoutonConnexion.setForeground(BLANC);
        chBoutonConnexion.setBackground(GRIS_CLAIR);
        add(chBoutonConnexion, contrainte);
        reset();
    }
    
    public void enregistreEcouteur(ControleurConnexion parControleur) {	
    	chBoutonConnexion.addActionListener(parControleur);
    	chBoutonConnexion.setActionCommand(CONNEXION);
    	reset();
	}

    public void reset() {
        chFieldEmail.setText(new String());
        chFieldMotDePasse.setText(new String());
    }

    public String getEmail() {
       return chFieldEmail.getText();
    }

    public String getMotDePasse() {
        return String.valueOf(chFieldMotDePasse.getPassword());
    }
}
