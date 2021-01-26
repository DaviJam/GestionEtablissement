package ensup.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The type Connect.
 */
public class Connect
{
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/gestionetablissement?serverTimezone=UTC";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";

	/**
	 * Open an connention with the information in the class
	 *
	 * @return an connection open
	 */
	public static Connection openConnection() throws ExceptionDao
	{
		Connection cn = null;
		try
		{
			//Chargement du Driver
			Class.forName(DRIVER);
			//?useUnicode=true&characterEncoding=utf8&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC
			
			//Récuperation de la connection
			if( URL != null && USERNAME != null && PASSWORD != null )
				cn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			if( cn == null && URL != null )
				cn = DriverManager.getConnection(URL);
		}
		catch (ClassNotFoundException | SQLException e){
			throw new ExceptionDao("Base de donnée : Impossible d'accéder à la base de donnée.");
		}
		
		return cn;
	}
}
