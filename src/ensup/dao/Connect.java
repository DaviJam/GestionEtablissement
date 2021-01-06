package ensup.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect
{
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://vps-0c0ccce5.vps.ovh.net:3306/GestionEtablissement";
	private static final String USERNAME = "web";
	private static final String PASSWORD = "Ensup2020*";
	
	public Connection cn;
	
	public Connect()
	{
		this.cn = null;
		openConnection();
	}
	
	public Connection getConnection() { return this.cn; }
	
	public void openConnection()
	{
		try
		{
			//Chargement du Driver
			Class.forName(DRIVER);
			//?useUnicode=true&characterEncoding=utf8&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC
			
			//Récuperation de la connection
			if( URL != null && USERNAME != null && PASSWORD != null )
				this.cn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			if( this.cn == null && URL != null )
				this.cn = DriverManager.getConnection(URL);
		}
		catch (ClassNotFoundException cnfe){cnfe.printStackTrace();}
		catch (SQLException sqle)          {sqle.printStackTrace();}
	}
	
	public void closeConnection()
	{
		try {
			this.cn.close();
		}
		catch (SQLException e) {e.printStackTrace();}
	}
}
