package Modele;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Vue.*;

public class Emprunt {
	
	private int chIdExemplaire;
	private int chIdEtudiant;
	private String chPrenom;
	private String chNom;
	private String chLivre;
	private String chEmail;
	private ArrayList <Emprunt> chListeEmprunts = new ArrayList <Emprunt> ();
	
	public Emprunt(int parIdExemplaire, int parIdEtudiant, String parPrenom, String parNom, String parLivre, String parEmail) {
		chIdExemplaire = parIdExemplaire;
		chIdEtudiant = parIdEtudiant;
		chPrenom = parPrenom;
		chNom = parNom;
		chLivre = parLivre;
		chEmail = parEmail;
	}
	
	public Emprunt() {
		chIdExemplaire = 0;
		chIdEtudiant = 0;
		chPrenom = "";
		chNom = "";
		chLivre = "";
		chEmail = "";
	}
	
	public void rendreLivre(PanelRendre parPanelRendre, int parIdExemplaire, Statement parStmt) throws SQLException {
		ResultSet rset = parStmt.executeQuery("SELECT COUNT(*) FROM EMPRUNT WHERE ID_EX = " + parIdExemplaire);
		int reserv = 0;
		while(rset.next())
			reserv = rset.getInt(1);
		if(reserv == 1 ) {
			parStmt.executeUpdate("DELETE FROM EMPRUNT WHERE ID_EX = " + parIdExemplaire);
			parStmt.executeUpdate("DELETE FROM EXEMPLAIRE WHERE ID_EX = " + parIdExemplaire);
			JOptionPane.showMessageDialog(parPanelRendre,"Le livre a bien été rendu","Rendu effectué",JOptionPane.INFORMATION_MESSAGE);
		}
		else 
			JOptionPane.showMessageDialog(parPanelRendre,"L'exemplaire " + parIdExemplaire + " n'a pas été emprunté","Erreur Rendu",JOptionPane.ERROR_MESSAGE);
	}
	
	public ArrayList <Emprunt> listeEmprunts(Statement parStmt) throws SQLException {
		ResultSet rset = parStmt.executeQuery("SELECT EXEMPLAIRE.ID_EX, ETUDIANT.ID_ET, NOM, PRENOM, TITRE FROM ETUDIANT, EMPRUNT, EXEMPLAIRE, LIVRE WHERE ETUDIANT.ID_ET = EMPRUNT.ID_ET AND EMPRUNT.ID_EX = EXEMPLAIRE.ID_EX AND EXEMPLAIRE.ID_LIVRE = LIVRE.ID_LIVRE ORDER BY ID_ET ASC, ID_EX ASC");
		chListeEmprunts.clear();
		while(rset.next())
			chListeEmprunts.add(new Emprunt(rset.getInt(1),rset.getInt(2), rset.getString(3),rset.getString(4),rset.getString(5),""));
		return chListeEmprunts;
	}
	
	public ArrayList <Emprunt> listeEmpruntsRetard(Statement parStmt) throws SQLException {
		ResultSet rset = parStmt.executeQuery("SELECT EXEMPLAIRE.ID_EX, ETUDIANT.ID_ET, NOM, PRENOM, TITRE, EMAIL FROM ETUDIANT, EMPRUNT, EXEMPLAIRE, LIVRE WHERE ETUDIANT.ID_ET = EMPRUNT.ID_ET AND EMPRUNT.ID_EX = EXEMPLAIRE.ID_EX AND EXEMPLAIRE.ID_LIVRE = LIVRE.ID_LIVRE AND EXEMPLAIRE.ID_EX IN(SELECT ID_EX FROM EMPRUNT WHERE DATE_RETOUR < SYSDATE)");
		chListeEmprunts.clear();
		while(rset.next())
			chListeEmprunts.add(new Emprunt(rset.getInt(1),rset.getInt(2),rset.getString(3),rset.getString(4),rset.getString(5),rset.getString(6)));
		return chListeEmprunts;
	}
	
	public int nombreEmprunts(PanelPreter parPanelPreter, int parIdEt, Statement parStmt) throws SQLException {
		ResultSet rset = parStmt.executeQuery("SELECT COUNT(ID_ET) FROM EMPRUNT WHERE ID_ET = " + parIdEt);
		int nombreEmprunts = 0;
		while(rset.next())
			nombreEmprunts = rset.getInt(1);
		if(nombreEmprunts == 5)
			JOptionPane.showMessageDialog(parPanelPreter,"Vous ne pouvez pas emprunter plus de 5 livres en même temps","Erreur emprunt",JOptionPane.ERROR_MESSAGE);
		return nombreEmprunts;
	}

	public int getIdExemplaire() {
		return chIdExemplaire;
	}
	
	public int getIdEtudiant() {
		return chIdEtudiant;
	}
	
	public String getPrenom() {
		return chPrenom;
	}

	public String getNom() {
		return chNom;
	}

	public String getLivre() {
		return chLivre;
	}

	public String getEmail() {
		return chEmail;
	}
}
