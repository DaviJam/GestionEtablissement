package ensup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ensup.business.School;
import ensup.exception.dao.ExceptionDao;

/**
 * The type School dao.
 */
public class SchoolDao implements ISchoolDao
{
	// nom de la classe
	String className = getClass().getName();
	
	public List<School> getAll() throws ExceptionDao
	{
		String methodName = getClass().getEnclosingMethod().getName();

		Connection cn = Connect.openConnection();
		List<School> alSchool = new ArrayList<School>();
		
		Statement st = null;
		ResultSet res = null;
		try
		{
			st = cn.createStatement();
			res = st.executeQuery("SELECT * FROM School");
			while( res.next() )
			{
				School school = new School(res.getInt("id"),res.getString("surname"),res.getString("email"),res.getString("address"),res.getString("phone"),res.getInt("director"));
				
				alSchool.add(school);
			}

			if(alSchool.isEmpty()) {
				DaoLogger.logDaoError(className, methodName,"La liste est vide.");
			} else {
				DaoLogger.logDaoInfo(className, methodName,"La récupération de liste des établissements a réussie.");
			}
		}
		catch (SQLException e) {
			DaoLogger.logDaoError(className, methodName,"Un problème est survenue lors de l'appel à cette méthode.");
			throw new ExceptionDao("Une erreur est survenue.");}
		finally{
			try {
				st.close();
				cn.close();
			}
			catch(SQLException sqle) {
				DaoLogger.logDaoError(className, methodName,"Un problème est survenue lors de la tentative de fermeture de connection à la base de données.");
				throw new ExceptionDao("Problème au niveau de la fermeture de la connexion"); }
		}
		
		return alSchool;
	}
	
	public School get( int index ) throws ExceptionDao
	{
		String methodName = getClass().getEnclosingMethod().getName();

		Connection cn = Connect.openConnection();
		School school = null;
		
		Statement st = null;
		ResultSet res = null;
		try
		{
			st = cn.createStatement();
			res = st.executeQuery("SELECT * FROM School WHERE id="+index);
			while( res.next() )
				school = new School(res.getInt("id"),res.getString("surname"),res.getString("email"),res.getString("address"),res.getString("phone"),res.getInt("director"));

			if(school == null)
			{
				DaoLogger.logDaoError(className, methodName,"Cette établissement n'existe pas en base de donnée.");
			} else {
				DaoLogger.logDaoInfo(className, methodName,"La récupération de l'établissement a réussie.");
			}
		}
		catch (SQLException e) {
			DaoLogger.logDaoError(className, methodName,"Un problème est survenue lors de l'appel à cette méthode.");
			throw new ExceptionDao("Une erreur est survenue.");}
		finally{
			try {
				st.close();
				cn.close();
			}
			catch(SQLException sqle) {
				DaoLogger.logDaoError(className, methodName,"Un problème est survenue lors de la tentative de fermeture de connection à la base de données.");
				throw new ExceptionDao("Problème au niveau de la fermeture de connexion"); }
		}
		
		return school;
	}
	
	public int getIndex( String surname ) throws ExceptionDao
	{
		String methodName = getClass().getEnclosingMethod().getName();

		Connection cn = Connect.openConnection();
		int index = -1;
		
		Statement st = null;
		ResultSet res = null;
		try
		{
			st = cn.createStatement();
			res = st.executeQuery("SELECT id FROM School WHERE surname='"+surname+"'");
			if( res.next() )
			{
				index = res.getInt("id");
				DaoLogger.logDaoInfo(className, methodName,"L'établissement a été récupéré avec succès.");
			} else
			{
				DaoLogger.logDaoInfo(className, methodName,"Cette établissement n'existe pas en base de donnée.");
			}
			// TODO:  Add logger failed and successfull
		}
		catch (SQLException e) {
			DaoLogger.logDaoError(className, methodName,"Un problème est survenue lors de l'appel à cette méthode.");
			throw new ExceptionDao("Une erreur est survenue.");}
		finally{
			try {
				st.close();
				cn.close();
			}
			catch(SQLException sqle) {
				DaoLogger.logDaoError(className, methodName,"Un problème est survenue lors de la tentative de fermeture de connection à la base de données.");
				throw new ExceptionDao("Problème de fermeture au niveau de la connexion"); }
		}
		
		return index;
	}
	
	public int create( School school ) throws ExceptionDao
	{
		String methodName = getClass().getEnclosingMethod().getName();

		int res = 1;
		Connection cn = Connect.openConnection();
		PreparedStatement pstmt = null;
		try
		{
			//Vérifie qu'il n'y a pas de double
			if( school.getId() != -1 || getIndex(school.getLastname()) == -1 )
			{
				if(school.getId() != -1)
					pstmt = cn.prepareStatement("INSERT INTO School (id, surname, email, address, phone, director) VALUES ( ?, ?, ?, ?, ?, ? )");
				else
					pstmt = cn.prepareStatement("INSERT INTO School (surname, email, address, phone, director) VALUES ( ?, ?, ?, ?, ? )");
				
				int index = 1;
				if(pstmt.getParameterMetaData().getParameterCount() == 3)
					pstmt.setInt(index++, school.getId());
				
				pstmt.setString(index++, school.getLastname());
				pstmt.setString(index++, school.getMailAddress());
				pstmt.setString(index++, school.getAddress());
				pstmt.setString(index++, school.getPhoneNumber());
				pstmt.setInt(index++, school.getDirector());
				
				pstmt.execute();
			}
			// TODO:  Add logger failed and successfull
		}
		catch (SQLException e) {
			res = 2;
			// TODO:  Add logger failed
			throw new ExceptionDao("Une erreur est survenue.");}
		finally{
			try {
				if( pstmt !=  null )
					pstmt.close();
				cn.close();
			}
			catch(SQLException sqle) {
				res = 2;
				// TODO:  Add logger failed
				throw new ExceptionDao("Problème au niveau de la fermeture de connexion"); }
			res = 0;
		}
		
		return res;
	}

	public int update(School school) throws ExceptionDao
	{
		String methodName = getClass().getEnclosingMethod().getName();

		int res = 1;
		School preSchool = get(school.getId());
		String update = "";
		
		if( school.getLastname() != null && ! school.getLastname().equals(preSchool.getLastname()) )
			update += "surname='"+school.getLastname()+"'";
		
		if( school.getMailAddress() != null && ! school.getMailAddress().equals(preSchool.getMailAddress()) )
			update += (update != "" ? "," : "")+"email='"+school.getMailAddress()+"'";
		
		if( school.getAddress() != null && ! school.getAddress().equals(preSchool.getAddress()) )
			update += (update != "" ? "," : "")+"address='"+school.getAddress()+"'";
		
		if( school.getPhoneNumber() != null && ! school.getPhoneNumber().equals(preSchool.getPhoneNumber()) )
			update += (update != "" ? "," : "")+"phone='"+school.getPhoneNumber()+"'";
		
		if( school.getDirector() != -1 && school.getDirector() != preSchool.getDirector() )
			update += (update != "" ? "," : "")+"director="+school.getDirector();

		if( update != "" )
		{
			Connection cn = Connect.openConnection();
			Statement st = null;
	
			try {
				st = cn.createStatement();
				st.execute("UPDATE School SET "+update);
			}
			catch( SQLException sqle) {
				res = 2;
				// TODO:  Add logger failed
				throw new ExceptionDao("Une erreur est survenue.");}
			finally{
				try {
					st.close();
					cn.close();
				} catch (SQLException throwables) {
					res = 2;
					// TODO:  Add logger failed
					throw new ExceptionDao("Problème au niveau de la fermeture de connexion");
				}
				res = 0;
			}
		}
		return res;
	}

	public int delete( int index ) throws ExceptionDao
	{
		String methodName = getClass().getEnclosingMethod().getName();

		int res = 1;
		if( index != -1 && indexExist(index) )
		{
			Connection cn = Connect.openConnection();
			
			Statement st = null;
			try
			{
				st = cn.createStatement();
				st.execute("DELETE FROM School WHERE id="+index);
			}
			catch (SQLException e) {
				res = 2;
				// TODO:  Add logger failed
				throw new ExceptionDao("Une erreur est survenue.");}
			finally{
				try {
					st.close();
					cn.close();
				}
				catch(SQLException sqle) {
					res = 2;
					// TODO:  Add logger failed
					throw new ExceptionDao("Problème au niveau de la fermeture de connexion"); }
				res = 0;
			}
		}
		
		return res;
	}

	public int delete( School school ) throws ExceptionDao
	{
		String methodName = getClass().getEnclosingMethod().getName();
		try
		{
			return delete(school.getId());
		} catch(ExceptionDao e){
			// TODO:  Add logger failed
			throw new ExceptionDao("Une erreur est survenue.");
		}
	}
	
	public boolean indexExist(int index) throws ExceptionDao
	{
		String methodName = getClass().getEnclosingMethod().getName();
		List<School> alSchool;
		boolean exist = false;

		try
		{
			alSchool = getAll();
			for( School school : alSchool )
				if( index == school.getId() )
					exist = true;
		// TODO:  Add logger failed and successfull

		} catch(ExceptionDao e){
			// TODO:  Add logger failed
			throw new ExceptionDao("Une erreur est survenue.");
		}
		return exist;
	}
}