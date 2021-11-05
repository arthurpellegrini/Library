package Modele;

import java.sql.*;
import javax.swing.JOptionPane;
import Constantes.*;
import Vue.FenetreConnexion;

public class Connexion implements ConstantesInterfaces{
	public String chEmail;
	private String chMotDePasse;

	public Connexion(String parEmail, String parMotDePasse) {
		chEmail = parEmail;
		chMotDePasse = parMotDePasse;
	}
	
	public Connexion() {
		chEmail = "";
		chMotDePasse = "";
	}

	public int verificationLogin(FenetreConnexion parFenetreConnexion,Statement parStmt) throws SQLException {
		if( EMAIL_BIBLIOTHECAIRE.equals(chEmail) && MOT_DE_PASSE_BIBLIOTHECAIRE.equals(chMotDePasse)) {
			JOptionPane.showMessageDialog(parFenetreConnexion,"Bienvenue Bibliothécaire","Connexion réussie",JOptionPane.INFORMATION_MESSAGE);
			return 1;
		}
		ResultSet rset = parStmt.executeQuery("SELECT ID_ET FROM ETUDIANT WHERE EMAIL = '" + chEmail + "' AND MDP = '" + chMotDePasse + "'");
		while (rset.next()) {
			int idEtudiant = rset.getInt(1);
			JOptionPane.showMessageDialog(parFenetreConnexion,"Bienvenue " + getEtudiantCourrant(idEtudiant, parStmt),"Connexion réussie",JOptionPane.INFORMATION_MESSAGE);
			System.out.println("ID_Etudiant : " + idEtudiant);
			return idEtudiant;
		}
		JOptionPane.showMessageDialog(parFenetreConnexion,"Email et/ou mot de passe incorrect","Erreur connexion",JOptionPane.ERROR_MESSAGE);
		return 0;
	}
	
	public String getEmailEtudiantCourrant(int parIdEtudiant, Statement parStmt) throws SQLException {
		ResultSet rset = parStmt.executeQuery("SELECT EMAIL FROM ETUDIANT WHERE ID_ET = " + parIdEtudiant);
		while (rset.next ()) {
			return rset.getString(1);
		}
		return null;
	}
	
	public String getEtudiantCourrant(int parIdEtudiant, Statement parStmt) throws SQLException {
		ResultSet rset = parStmt.executeQuery("SELECT PRENOM, NOM FROM ETUDIANT WHERE ID_ET = " + parIdEtudiant);
		while (rset.next ()) {
			return rset.getString(1) + " " + rset.getString(2);
		}
		return null;
	}
}