package ensup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ensup.business.Course;

public class CourseDao
{	
	public CourseDao(Connect connect)
	{
	}
	
	public Course get( int indice )
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
	
	public void add( String subject, float nbHours )
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
}
