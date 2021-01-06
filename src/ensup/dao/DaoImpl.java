package ensup.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoImpl
{
    //Information accès base de donnees
	/**
     * The driver.
     */
	final String driver = "com.mysql.cj.jdbc.Driver";
	/**
     * The Url of the Database.
     */
    final String url = "jdbc:mysql://vps-0c0ccce5.vps.ovh.net:3306/GestionEtablissement";
    /**
     * The Username.
     */
    final String username = "web";
    /**
     * The Mdp.
     */
    final String mdp = "Ensup2020*";

    /**
     * The Cn.
     */
// initialisation des variables java permettant de dialoguer avec la bdd
    // connecter a la base de données
    Connection cn = null;
    /**
     * The St.
     */
// exxecuter la requete
    PreparedStatement st = null;
    /**
     * The Rs.
     */
// récupérer le résultat
    ResultSet rs = null;
    /**
     * The Res.
     */
// nombre de mises à jour
    int res = 0;
    
    public DaoImpl()
    {
    	this.cn = null;
    }
    
    public Connection openConnection()
	{
		try
		{
			//Chargement du Driver
			Class.forName(driver);
			
			//Récuperation de la connection
			if( url != null && username != null && mdp != null )
				this.cn = DriverManager.getConnection(url, username, mdp);
			
			if( this.cn == null && url != null )
				this.cn = DriverManager.getConnection(url);
		}
		catch (ClassNotFoundException cnfe){cnfe.printStackTrace();}
		catch (SQLException sqle)          {sqle.printStackTrace();}
		
		return this.cn;
	}
    
    public Connection getConnection() { return this.cn; }
}
