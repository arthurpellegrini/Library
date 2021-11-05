package Modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Vue.PanelGestionCompte;

public class Etudiant {
	private String chNom;
	private String chPrenom;
	private String chEmail;
	private String chMotDePasse;
	private ArrayList<Etudiant> chListeEtudiants = new ArrayList <Etudiant> ();

	public Etudiant(String parNom, String parPrenom, String parMdp) {
		chNom = parNom ;
		chPrenom = parPrenom ;
		chEmail = chPrenom.toLowerCase() + "." + chNom.toLowerCase() + "@uvsq.fr" ;
		chMotDePasse = parMdp;
	}
	
	public Etudiant() {
		chNom = "";
		chPrenom = "";
		chEmail = "";
		chMotDePasse = "";
	}
	
	public ArrayList<Etudiant> listeEtudiants(Statement parStmt) throws SQLException {
		ResultSet rset = parStmt.executeQuery("SELECT NOM, PRENOM, MDP FROM ETUDIANT ORDER BY ID_ET ASC");
		chListeEtudiants.clear();
		while (rset.next ())
			chListeEtudiants.add(new Etudiant(rset.getString(1), rset.getString(2), rset.getString(3)));
		return chListeEtudiants;
	}
	
	public void ajouterEtudiant(PanelGestionCompte parPanelGestionCompte, String parNom,String parPrenom, Statement parStmt) throws SQLException {
		parNom = parNom.replaceAll("'", "''");
		parPrenom = parPrenom.replaceAll("'", "''");
		ResultSet rset = parStmt.executeQuery("SELECT COUNT(ID_ET) FROM ETUDIANT WHERE NOM = '" + parNom.substring(0, 1).toUpperCase() + parNom.substring(1).toLowerCase() + "' AND PRENOM = '" + parPrenom.substring(0, 1).toUpperCase() + parPrenom.substring(1).toLowerCase() + "'");
		int existance = 0;
		while(rset.next())
			existance = rset.getInt(1);
		if(existance == 0) {
			parStmt.executeUpdate("INSERT INTO ETUDIANT VALUES(0,'" + parNom + "', '" + parPrenom + "','@', 'mdp')");
			JOptionPane.showMessageDialog(parPanelGestionCompte,"L'étudiant " + parNom.substring(0, 1).toUpperCase() + parNom.substring(1).toLowerCase() + " " + parPrenom.substring(0, 1).toUpperCase() + parPrenom.substring(1).toLowerCase() + " a bien été ajouté","Insertion réussie",JOptionPane.INFORMATION_MESSAGE);
			}
		else 
			JOptionPane.showMessageDialog(parPanelGestionCompte,"Cet étudiant existe déjà","Erreur création étudiant",JOptionPane.ERROR_MESSAGE);
	}
	
	public void modifierEtudiant(PanelGestionCompte parPanelGestionCompte, String parNom,String parPrenom, String parNouveauNom,String parNouveauPrenom, Statement parStmt) throws SQLException {
		parNom = parNom.replaceAll("'", "''");
		parPrenom = parPrenom.replaceAll("'", "''");
		parNouveauNom = parNouveauNom.replaceAll("'", "''");
		parNouveauPrenom = parNouveauPrenom.replaceAll("'", "''");
		ResultSet rset = parStmt.executeQuery("SELECT COUNT(ID_ET) FROM ETUDIANT WHERE NOM = '" + parNom.substring(0, 1).toUpperCase() + parNom.substring(1).toLowerCase() + "' AND PRENOM = '" + parPrenom.substring(0, 1).toUpperCase() + parPrenom.substring(1).toLowerCase() + "'");
		int existanceAncien = 0;
		while(rset.next())
			existanceAncien = rset.getInt(1);
		int existanceNouveau = 0;
		rset = parStmt.executeQuery("SELECT COUNT(ID_ET) FROM ETUDIANT WHERE NOM = '" + parNouveauNom.substring(0, 1).toUpperCase() + parNouveauNom.substring(1).toLowerCase() + "' AND PRENOM = '" + parNouveauPrenom.substring(0, 1).toUpperCase() + parNouveauPrenom.substring(1).toLowerCase() + "'");
		while(rset.next())
			existanceNouveau = rset.getInt(1);
		if(existanceAncien == 1 & existanceNouveau == 0) {
			parStmt.executeUpdate("UPDATE ETUDIANT SET NOM = '" + parNouveauNom + "', PRENOM = '" + parNouveauPrenom + "' WHERE NOM = '" + parNom.substring(0, 1).toUpperCase() + parNom.substring(1).toLowerCase() + "' AND PRENOM = '" + parPrenom.substring(0, 1).toUpperCase() + parPrenom.substring(1).toLowerCase() + "'");
			JOptionPane.showMessageDialog(parPanelGestionCompte,"L'étudiant " + parNom.substring(0, 1).toUpperCase() + parNom.substring(1).toLowerCase() + " " + parPrenom.substring(0, 1).toUpperCase() + parPrenom.substring(1).toLowerCase() + " a bien été modifié en " + parNouveauNom.substring(0, 1).toUpperCase() + parNouveauNom.substring(1).toLowerCase() + " " + parNouveauPrenom.substring(0, 1).toUpperCase() + parNouveauPrenom.substring(1).toLowerCase(),"Modification réussie",JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			if(existanceAncien == 0) {
				JOptionPane.showMessageDialog(parPanelGestionCompte,"L'étudiant que vous essayez de modifier n'existe pas","Erreur modification",JOptionPane.ERROR_MESSAGE);
			}
			if(existanceNouveau == 1) {
				JOptionPane.showMessageDialog(parPanelGestionCompte,"Le nouveau nom ou prénom est déjà utilisé par un autre étudiant","Erreur modification",JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public void supprimerEtudiant(PanelGestionCompte parPanelGestionCompte, String parNom,String parPrenom, Statement parStmt) throws SQLException {
		parNom = parNom.replaceAll("'", "''");
		parPrenom = parPrenom.replaceAll("'", "''");
		ResultSet rset = parStmt.executeQuery("SELECT COUNT(ID_ET) FROM ETUDIANT WHERE NOM = '" + parNom.substring(0, 1).toUpperCase() + parNom.substring(1).toLowerCase() + "' AND PRENOM = '" + parPrenom.substring(0, 1).toUpperCase() + parPrenom.substring(1).toLowerCase() + "'");
		int existance = 0;
		while(rset.next())
			existance = rset.getInt(1);
		if(existance == 1) {
			parStmt.executeUpdate("DELETE FROM ETUDIANT WHERE NOM = '" + parNom.substring(0, 1).toUpperCase() + parNom.substring(1).toLowerCase() + "' AND PRENOM = '" + parPrenom.substring(0, 1).toUpperCase() + parPrenom.substring(1).toLowerCase() + "'");
			JOptionPane.showMessageDialog(parPanelGestionCompte,"L'étudiant " + parNom.substring(0, 1).toUpperCase() + parNom.substring(1).toLowerCase() + " " + parPrenom.substring(0, 1).toUpperCase() + parPrenom.substring(1).toLowerCase() + " a bien été supprimé","Suppression réussie",JOptionPane.INFORMATION_MESSAGE);
		}
		else 
			JOptionPane.showMessageDialog(parPanelGestionCompte,"Cet étudiant n'existe pas","Erreur suppression étudiant",JOptionPane.ERROR_MESSAGE);
	}
	
	public String getNom() {
		return chNom;
	}
	
	public String getPrenom() {
		return chPrenom;
	}
	
	public String getEmail() {
		return chEmail;
	}
	
	public String getMdp() {
		return chMotDePasse;
	}
}
