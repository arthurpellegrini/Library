package Modele;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Vue.PanelAjouterLivre;

public class Livre {
	private int chIdLivre;
	private String chTitre;
	private String chAuteur;
	private ArrayList<Livre> chListeLivres = new ArrayList <Livre> ();
	
	public Livre(int parIdLivre, String parTitre, String parAuteur) {
		chIdLivre = parIdLivre;
		chTitre = parTitre;
		chAuteur = parAuteur;
	}
	
	public Livre() {
		chIdLivre = 0;
		chTitre = "";
		chAuteur = "";
	}
	
	//Partie Recherche de Livres
	public ArrayList<Livre> listeLivres(Statement parStmt) throws SQLException {
		ResultSet rset = parStmt.executeQuery ("SELECT * FROM LIVRE ORDER BY ID_LIVRE ASC");
		chListeLivres.clear();
		while (rset.next ())
			chListeLivres.add(new Livre(rset.getInt(1),rset.getString(2), rset.getString(3)));
		return chListeLivres;
	}

	public ArrayList<Livre> rechercherLivreIdLivre(int parIdLivre, Statement parStmt) throws SQLException {
		ResultSet rset = parStmt.executeQuery ("SELECT * FROM LIVRE WHERE ID_LIVRE LIKE '%" + parIdLivre + "%' ORDER BY ID_LIVRE ASC");
		chListeLivres.clear();
		while (rset.next ())
			chListeLivres.add(new Livre(rset.getInt(1),rset.getString(2), rset.getString(3)));
		return chListeLivres;
	}
	
	public ArrayList<Livre> rechercherLivreTitre(String parTitre, Statement parStmt) throws SQLException {
		parTitre = parTitre.replaceAll("'", "''");
		ResultSet rset = parStmt.executeQuery ("SELECT * FROM LIVRE WHERE TITRE LIKE '%" + parTitre.substring(0, 1).toUpperCase() + parTitre.substring(1).toLowerCase() + "%' ORDER BY ID_LIVRE ASC");
		chListeLivres.clear();
		while (rset.next ())
			chListeLivres.add(new Livre(rset.getInt(1),rset.getString(2), rset.getString(3)));
		return chListeLivres;
	}

	public ArrayList<Livre> rechercherLivreAuteur(String parAuteur, Statement parStmt) throws SQLException {
		parAuteur = parAuteur.replaceAll("'", "''");
		ResultSet rset = parStmt.executeQuery ("SELECT * FROM LIVRE WHERE AUTEUR LIKE '%" + parAuteur.substring(0, 1).toUpperCase() + parAuteur.substring(1).toLowerCase() + "%' ORDER BY ID_LIVRE ASC");
		chListeLivres.clear();
		while (rset.next ())
			chListeLivres.add(new Livre(rset.getInt(1),rset.getString(2), rset.getString(3)));
		return chListeLivres;
	}
	
	public void ajouterLivre(PanelAjouterLivre parPanelAjouterLivre, String parTitre,String parAuteur, Statement parStmt) throws SQLException {
		parTitre = parTitre.replaceAll("'", "''");
		parAuteur = parAuteur.replaceAll("'", "''");
		ResultSet rset = parStmt.executeQuery("SELECT COUNT(ID_LIVRE) FROM LIVRE WHERE TITRE = '" + parTitre.substring(0, 1).toUpperCase() + parTitre.substring(1).toLowerCase() + "' AND AUTEUR = '" + parAuteur.substring(0, 1).toUpperCase() + parAuteur.substring(1).toLowerCase() + "'");
		int existance = 0;
		while(rset.next())
			existance = rset.getInt(1);
		if(existance == 0) {
			parStmt.executeUpdate("INSERT INTO LIVRE VALUES(0,'" + parTitre + "','" + parAuteur + "')");
			JOptionPane.showMessageDialog(parPanelAjouterLivre,"Le livre a bien été ajouté","Ajout effectué",JOptionPane.INFORMATION_MESSAGE);
		}
		else
			JOptionPane.showMessageDialog(parPanelAjouterLivre,"Ce livre existe déjà","Erreur ajout",JOptionPane.ERROR_MESSAGE);
	}

	public int getIdLivre() {
		return chIdLivre;
	}
	
	public String getTitre() {
		return chTitre;
	}

	public String getAuteur() {
		return chAuteur;
	}
}
