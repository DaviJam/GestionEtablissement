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
				Course cours = new Course(res.getString("coursesubject"),res.getFloat("nbhours"),res.getInt("id"));
				
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
				cours = new Course(res.getString("coursesubject"),res.getFloat("nbhours"),res.getInt("id"));
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
	
	public int getIndex( String coursesubject, float nbhours )
	{
		Connection cn = Connect.openConnection();
		int index = -1;
		
		Statement st = null;
		ResultSet res = null;
		try
		{
			st = cn.createStatement();
			res = st.executeQuery("SELECT id FROM Course WHERE coursesubject='"+coursesubject+"' AND nbhours="+nbhours);
			while( res.next() )
				index = res.getInt("id");
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

	public int createCourse(Course course)
	{
		Connection cn = Connect.openConnection();
		PreparedStatement pstmt = null;
		try
		{
			pstmt = cn.prepareStatement("INSERT INTO Course (coursesubject, nbhours) VALUES ( ?, ?)");
			pstmt.setString(1, course.getCourseSubject());
			pstmt.setFloat(2, course.getNbHours());
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

		return 0;

	}
	
	public int create( Course course )
	{
		Connection cn = Connect.openConnection();
		PreparedStatement pstmt = null;
		try
		{
			if( course.getId() != -1 )
				pstmt = cn.prepareStatement("INSERT INTO Course (id, coursesubject, nbhours) VALUES ( ?, ?, ? )");
			else
				pstmt = cn.prepareStatement("INSERT INTO Course (coursesubject, nbhours) VALUES ( ?, ? )");
			
			int index = 1;
			
			if( pstmt.getParameterMetaData().getParameterCount() == 3 )
				pstmt.setInt(index++, course.getId());
			
			pstmt.setString(index++, course.getCourseSubject());
			pstmt.setFloat(index++, course.getNbHours());

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
		
		return getIndex(course.getCourseSubject(), course.getNbHours());
	}

	public int update(Course course)
	{
		get(course.getId());

		Connection cn = Connect.openConnection();
		Statement st = null;

		try {
			st = cn.createStatement();
			st.execute("UPDATE Course SET coursesubject = '" + course.getCourseSubject() + "', nbhours = "  + course.getNbHours() + "");
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
		
		return course.getId();
	}

	public int delete( Course course )
	{
		if( course.getId() != -1 && idExiste(course.getId()) )
		{
			Connection cn = Connect.openConnection();
			
			Statement st = null;
			try
			{
				st = cn.createStatement();
				st.execute("DELETE FROM Course WHERE id="+course.getId());
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
		
		return course.getId();
	}
	
	public boolean idExiste(int index)
	{
		boolean existe = false;
		
		List<Course> alCourse = getAll();
		for( Course cours : alCourse )
			if( index == cours.getId() )
				existe = true;
		
		return existe;
	}
}
