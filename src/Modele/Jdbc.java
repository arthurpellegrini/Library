package Modele;

import java.sql.*;

public class Jdbc {
	private Statement chStatement;
	
	public Jdbc() throws SQLException, ClassNotFoundException {
		//Connexion
	  	DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		System.out.println("Connexion à la base de données de la bibliothèque...");
		//Partie à remplir avec ses identifiants et mot de passe Oracle
		chStatement = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:port:....","identifiant", "mot de passe").createStatement ();
		System.out.println("Connecté à la base de données de la bibliothèque...");
	}

	 public Statement getStatement() {
		return chStatement;
	 }
}
