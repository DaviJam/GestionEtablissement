package ensup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ensup.business.Course;

public class CourseDao
{
	public static List<Course> readAll()
	{
		Connection cn = Connect.openConnection();
		List<Course> alCourse = new ArrayList<Course>();
		
		Statement st = null;
		ResultSet res = null;
		try
		{
			st = cn.createStatement();
			res = st.executeQuery("SELECT * FROM Course");
			while( res.next() )
			{
				Course cours = new Course(res.getString("subject"),res.getFloat("nbHours"),res.getInt("id"));
				
				alCourse.add(cours);
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
		
		return alCourse;
	}
	
	public static Course read( int indice )
	{
		Connection cn = Connect.openConnection();
		Course cours = null;
		
		Statement st = null;
		ResultSet res = null;
		try
		{
			st = cn.createStatement();
			res = st.executeQuery("SELECT * FROM Course WHERE id="+indice);
			while( res.next() )
				cours = new Course(res.getString("subject"),res.getFloat("nbHours"),res.getInt("id"));
		}
		catch (SQLException e) {e.printStackTrace();}
		finally{
			try {
				st.close();
				cn.close();
			}
			catch(SQLException sqle) { sqle.printStackTrace(); }
		}
		
		return cours;
	}
	
	public static void create( String subject, float nbHours )
	{
		Connection cn = Connect.openConnection();
		PreparedStatement pstmt = null;
		try
		{
			pstmt = cn.prepareStatement("INSERT INTO Course (\\\"subject\\\", \\\"nbHours\\\") VALUES ( ?, ?)");
			
			int indice = 0;
			pstmt.setString(indice++, subject);
			pstmt.setFloat(indice++, nbHours);

			pstmt.execute();
		}
		catch (SQLException e) {e.printStackTrace();}
		finally{
			try {
				pstmt.close();
				cn.close();
			}
			catch(SQLException sqle) { sqle.printStackTrace(); }
		}
	}
	
	public static void delete( int indice )
	{
		if( indice != -1 && idExiste(indice) )
		{
			Connection cn = Connect.openConnection();
			
			Statement st = null;
			try
			{
				st = cn.createStatement();
				st.execute("DELETE FROM Course WHERE id="+indice);
			}
			catch (SQLException e) {e.printStackTrace();}
			finally{
				try {
					st.close();
					cn.close();
				}
				catch(SQLException sqle) { sqle.printStackTrace(); }
			}
		}
	}
	
	public static boolean idExiste(int indice)
	{
		boolean existe = false;
		
		List<Course> alCourse = readAll();
		for( Course cours : alCourse )
			if( indice == cours.getId() )
				existe = true;
		
		return existe;
	}
}
