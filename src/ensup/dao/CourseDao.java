package ensup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ensup.business.Course;

public class CourseDao implements ICourseDao
{

	public List<Course> getAll()
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


	public Course get( int index )
	{

		Connection cn = Connect.openConnection();
		Course cours = null;
		
		Statement st = null;
		ResultSet res = null;
		try
		{
			st = cn.createStatement();
			res = st.executeQuery("SELECT * FROM Course WHERE id="+index);
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



	public void addCourse( Course course )
	{
		String subject = course.getCourseSubject();
		float nbHours = course.getNbHours();

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

	public void delete( Course entity )
	{
		int indice = entity.getId();
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
	
	public boolean idExiste(int indice)
	{
		boolean existe = false;
		
		List<Course> alCourse = getAll();
		for( Course cours : alCourse )
			if( indice == cours.getId() )
				existe = true;
		
		return existe;
	}

	public int updateCourse(Course course) {
		get(course.getId());

		Connection cn = Connect.openConnection();
		Statement st = null;

		try {
			st = cn.createStatement();
			st.execute("UPDATE Course SET subject = '" + course.getCourseSubject() + "', nbHours = "  + course.getNbHours() + "");
		}
		catch( SQLException sqle) {sqle.printStackTrace();}
		finally{
			try {
				st.close();
				cn.close();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}
		return 0;
	}


}
