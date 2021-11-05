package Modele;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Vue.*;

public class Reservation {
	private int chIdLivre;
	private int chIdEtudiant;
	private String chNom;
	private String chPrenom;
	private String chTitre;
	private ArrayList <Reservation> chListeReservations = new ArrayList <Reservation> ();
	
	public Reservation(int parIdLivre, int parIdEtudiant, String parNom, String parPrenom, String parTitre) {
		chIdLivre = parIdLivre;
		chIdEtudiant = parIdEtudiant;
		chNom = parNom;
		chPrenom = parPrenom;
		chTitre = parTitre;
	}
	
	public Reservation() {
		chIdLivre = 0;
		chIdEtudiant = 0;
		chNom = "";
		chPrenom = "";
		chTitre = "";
	}
	
	public void accepterReservation(PanelPreter parPanelPreter, int parIdEtudiant, int parIdLivre, Statement  parStmt) throws SQLException {
		ResultSet rset = parStmt.executeQuery("SELECT COUNT(*) FROM RESERV WHERE ID_LIVRE = " + parIdLivre + "AND ID_ET = " + parIdEtudiant);
		int existance = 0;
		while(rset.next())
			existance = rset.getInt(1);
		if(existance == 1 ) {
			parStmt.executeUpdate("DELETE FROM RESERV WHERE ID_LIVRE = " + parIdLivre +  " AND ID_ET = '" + parIdEtudiant + "'");
			parStmt.executeUpdate("INSERT INTO EXEMPLAIRE VALUES(0," + parIdLivre + ")");
			rset = parStmt.executeQuery("SELECT ID_EX FROM EXEMPLAIRE WHERE ID_LIVRE = " + parIdLivre);
			int idExemplaire = 0;
			while(rset.next())
				idExemplaire = rset.getInt(1);
			parStmt.executeUpdate("INSERT INTO EMPRUNT VALUES(" + parIdEtudiant + "," + idExemplaire + ",'','')");
			JOptionPane.showMessageDialog(parPanelPreter,"Le livre a bien été prêté","Prêt effectué",JOptionPane.INFORMATION_MESSAGE);
		}
		else 
			JOptionPane.showMessageDialog(parPanelPreter,"L'étudiant " + parIdEtudiant + " n'a pas réservé ce livre","Erreur Prêt",JOptionPane.ERROR_MESSAGE);
	}
	
	public ArrayList <Reservation> listeReservations(Statement parStmt) throws SQLException {
		parStmt.executeUpdate("DELETE FROM RESERV WHERE DATE_FIN_RES < SYSDATE");
		ResultSet rset = parStmt.executeQuery("SELECT LIVRE.ID_LIVRE, ETUDIANT.ID_ET, NOM, PRENOM, TITRE FROM ETUDIANT, LIVRE, RESERV WHERE RESERV.ID_LIVRE = LIVRE.ID_LIVRE AND RESERV.ID_ET = ETUDIANT.ID_ET ORDER BY ID_ET ASC,ID_LIVRE ASC");
		chListeReservations.clear();
		while(rset.next())
			chListeReservations.add(new Reservation(rset.getInt(1),rset.getInt(2), rset.getString(3),rset.getString(4),rset.getString(5)));
		return chListeReservations;
	}
	
	public ArrayList <Reservation> listeReservationsEtudiant(int parIdEtudiant, Statement parStmt) throws SQLException {
		parStmt.executeUpdate("DELETE FROM RESERV WHERE DATE_FIN_RES < SYSDATE");
		ResultSet rset = parStmt.executeQuery("SELECT LIVRE.ID_LIVRE, ETUDIANT.ID_ET, NOM, PRENOM, TITRE FROM ETUDIANT, LIVRE, RESERV WHERE RESERV.ID_LIVRE = LIVRE.ID_LIVRE AND RESERV.ID_ET = ETUDIANT.ID_ET AND ETUDIANT.ID_ET = " + parIdEtudiant + "ORDER BY ID_LIVRE ASC");
		chListeReservations.clear();
		while(rset.next())
			chListeReservations.add(new Reservation(rset.getInt(1),rset.getInt(2), rset.getString(3),rset.getString(4),rset.getString(5)));
		return chListeReservations;
	}
	
	public int nombreReservations(PanelReserver parPanelReserver, int parIdEtudiant, Statement parStmt) throws SQLException {
		ResultSet rset = parStmt.executeQuery("SELECT COUNT(ID_ET) FROM RESERV WHERE ID_ET = " + parIdEtudiant);
		int nombreReservations = 0;
		while(rset.next())
			nombreReservations = rset.getInt(1);
		if(nombreReservations == 5)
			JOptionPane.showMessageDialog(parPanelReserver,"Vous ne pouvez pas réserver plus de 5 livres en même temps","Erreur réservation",JOptionPane.ERROR_MESSAGE);
		return nombreReservations;
	}
	
	public void reserverLivre(PanelReserver parPanelReserver, int parIdEtudiant, int parIdLivre, Statement parStmt) throws SQLException {
		ResultSet rset = parStmt.executeQuery("SELECT COUNT(ID_LIVRE) FROM RESERV WHERE ID_LIVRE = " + parIdLivre + " AND ID_ET = " + parIdEtudiant);
		int existance = 0;
		while(rset.next())
			existance = rset.getInt(1);
		if(existance == 0) {
			parStmt.executeUpdate("INSERT INTO RESERV VALUES(" + parIdLivre + "," + parIdEtudiant + ", '', '')");
			JOptionPane.showMessageDialog(parPanelReserver,"Le livre a bien été réservé","Réservation effectuée",JOptionPane.INFORMATION_MESSAGE);
		}
		else
			JOptionPane.showMessageDialog(parPanelReserver,"Vous avez déjà réservé ce livre","Erreur réservation",JOptionPane.ERROR_MESSAGE);
	}

	public int getChIdEtudiant() {
		return chIdEtudiant;
	}
	
	public int getChIdLivre() {
		return chIdLivre;
	}

	public String getChNom() {
		return chNom;
	}

	public String getChPrenom() {
		return chPrenom;
	}

	public String getChLivre() {
		return chTitre;
	}
}
