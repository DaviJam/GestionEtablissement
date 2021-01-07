package ensup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ensup.business.Director;
import ensup.business.School;

public class SchoolDao implements ISchoolDao
{
	public List<School> getAll()
	{
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
				Director director = (Director)(new DaoPerson()).get(res.getInt("director"));
				School school = new School(res.getInt("id"),res.getString("surname"),res.getString("email"),res.getString("address"),res.getString("phone"),director);
				
				alSchool.add(school);
			}
		}
		catch (SQLException e) {e.printStackTrace();}
		finally{
			try {
				st.close();
				cn.close();
			}
			catch(SQLException sqle) { sqle.printStackTrace(); }
		}
		
		return alSchool;
	}
	
	public School get( int index )
	{
		Connection cn = Connect.openConnection();
		School school = null;
		
		Statement st = null;
		ResultSet res = null;
		try
		{
			st = cn.createStatement();
			res = st.executeQuery("SELECT * FROM School WHERE id="+index);
			while( res.next() )
			{
				Director director = (Director)(new DaoPerson()).get(res.getInt("director"));
				school = new School(res.getInt("id"),res.getString("surname"),res.getString("email"),res.getString("address"),res.getString("phone"),director);
			}
		}
		catch (SQLException e) {e.printStackTrace();}
		finally{
			try {
				st.close();
				cn.close();
			}
			catch(SQLException sqle) { sqle.printStackTrace(); }
		}
		
		return school;
	}
	
	public int getIndex( String surname )
	{
		Connection cn = Connect.openConnection();
		int index = -1;
		
		Statement st = null;
		ResultSet res = null;
		try
		{
			st = cn.createStatement();
			res = st.executeQuery("SELECT id FROM School WHERE surname='"+surname+"'");
			while( res.next() )
			{
				index = res.getInt("id");
			}
		}
		catch (SQLException e) {e.printStackTrace();}
		finally{
			try {
				st.close();
				cn.close();
			}
			catch(SQLException sqle) { sqle.printStackTrace(); }
		}
		
		return index;
	}
	
	public int create( School school )
	{
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
				pstmt.setInt(index++, school.getDirector().getId());
				
				pstmt.execute();
			}
		}
		catch (SQLException e) {res = 2; e.printStackTrace();}
		finally{
			try {
				if( pstmt !=  null )
					pstmt.close();
				cn.close();
			}
			catch(SQLException sqle) {res = 2; sqle.printStackTrace(); }
			res = 0;
		}
		
		return res;
	}

	public int update(School school)
	{
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
		
		if( school.getDirector().getId() != -1 && school.getDirector().getId() != preSchool.getDirector().getId() )
			update += (update != "" ? "," : "")+"director="+school.getDirector().getId();

		if( update != "" )
		{
			Connection cn = Connect.openConnection();
			Statement st = null;
	
			try {
				st = cn.createStatement();
				st.execute("UPDATE School SET "+update);
			}
			catch( SQLException sqle) {res = 2; sqle.printStackTrace();}
			finally{
				try {
					st.close();
					cn.close();
				} catch (SQLException throwables) {
					res = 2;
					throwables.printStackTrace();
				}
				res = 0;
			}
		}
		return res;
	}

	public int delete( int index )
	{
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
			catch (SQLException e) {res = 2; e.printStackTrace();}
			finally{
				try {
					st.close();
					cn.close();
				}
				catch(SQLException sqle) {res = 2; sqle.printStackTrace(); }
				res = 0;
			}
		}
		
		return res;
	}

	public int delete( School school )
	{
		return delete(school.getId());
	}
	
	public boolean indexExist(int index)
	{
		boolean exist = false;
		
		List<School> alSchool = getAll();
		for( School school : alSchool )
			if( index == school.getId() )
				exist = true;
		
		return exist;
	}
}