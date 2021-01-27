package ensup.dao;

import ensup.business.Course;
import ensup.dao.DaoException.ExceptionDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Course dao.
 */
public class CourseDao implements ICourseDao
{
	@Override
	public List<Course> getAll() throws ExceptionDao
	{
		Connection cn = Connect.openConnection();
		List<Course> allCourse = new ArrayList<Course>();
		
		Statement st = null;
		ResultSet res = null;
		try
		{
			st = cn.createStatement();
			res = st.executeQuery("SELECT * FROM Course");
			if(!res.next()){
				throw  new ExceptionDao("pas de données dans la base  ");
			}
			while( res.next() )
			{
				Course cours = new Course(res.getString("coursesubject"),res.getFloat("nbhours"),res.getInt("id"));
				
				allCourse.add(cours);
			}
		}
		catch (SQLException | ExceptionDao e) {e.printStackTrace();}
		finally{
			try {
				st.close();
				cn.close();
			}
			catch(SQLException sqle) { sqle.printStackTrace(); }
		}
		
		return allCourse;
	}

	@Override
	public Course get( int index )  throws ExceptionDao
	{
		Connection cn = Connect.openConnection();
		Course cours = null;

		Statement st = null;
		ResultSet res = null;
		try
		{
			st = cn.createStatement();
			res = st.executeQuery("SELECT * FROM Course WHERE id="+index);
			if(!res.next()){
				throw  new ExceptionDao("pas de données dans la base  ");
			}
			while( res.next() )
				cours = new Course(res.getString("coursesubject"),res.getFloat("nbhours"),res.getInt("id"));
		}
		catch (SQLException | ExceptionDao e) {e.printStackTrace();}
		finally{
			try {
				st.close();
				cn.close();
			}
			catch(SQLException sqle) { sqle.printStackTrace(); }
		}

		return cours;
	}

	@Override
	public int getIndex( String coursesubject, float nbhours ) throws ExceptionDao
	{
		Connection cn = Connect.openConnection();
		int index = -1;
		
		Statement st = null;
		ResultSet res = null;
		try
		{
			st = cn.createStatement();
			res = st.executeQuery("SELECT id FROM Course WHERE coursesubject='"+coursesubject+"' AND nbhours="+nbhours);
			if(!res.next()){
				throw  new ExceptionDao("pas de données dans la base  ");
			}
			while( res.next() )
				index = res.getInt("id");
		}
		catch (SQLException | ExceptionDao e) {e.printStackTrace();}
		finally{
			try {
				st.close();
				cn.close();
			}
			catch(SQLException sqle) { sqle.printStackTrace(); }
		}
		
		return index;
	}

	@Override
	public int create( Course course ) throws ExceptionDao
	{
		int res = 1;
		Connection cn = Connect.openConnection();
		PreparedStatement pstmt = null;
		try
		{
			//Vérifie qu'il n'y a pas de double
			if( course.getId() != -1 || getIndex(course.getCourseSubject(), course.getNbHours()) == -1 )
			{
				if(course.getId() != -1)
					pstmt = cn.prepareStatement("INSERT INTO Course (id, coursesubject, nbhours) VALUES ( ?, ?, ? )");
				else
					pstmt = cn.prepareStatement("INSERT INTO Course (coursesubject, nbhours) VALUES ( ?, ? )");
			
				int index = 1;
				if(pstmt.getParameterMetaData().getParameterCount() == 3)
					pstmt.setInt(index++, course.getId());
				
				pstmt.setString(index++, course.getCourseSubject());
				pstmt.setFloat(index++, course.getNbHours());
				
				pstmt.execute();
			}else{

					throw  new ExceptionDao("Ce cours existe déja!");

			}
		}
		catch (SQLException | ExceptionDao e) {res=2; e.printStackTrace();}
		finally{
			try {
				if( pstmt !=  null )
					pstmt.close();
				cn.close();
			}
			catch(SQLException sqle) {res=2; sqle.printStackTrace(); }
			res = 0;
		}
		
		return res;
	}

	@Override
	public int update(Course course) throws ExceptionDao
	{
		int res = 1;
		Course preCourse = get(course.getId());
		String update = "";
		
		if( course.getCourseSubject() != null && ! course.getCourseSubject().equals(preCourse.getCourseSubject()) )
			update += "coursesubject='"+course.getCourseSubject()+"'";
		
		if( course.getNbHours() != -1 && course.getNbHours() != preCourse.getNbHours() )
			update += (update != "" ? "," : "")+"nbhours='"+course.getNbHours()+"'";

		if( update != "" )
		{
			Connection cn = Connect.openConnection();
			Statement st = null;
			try {
				st = cn.createStatement();
				st.execute("UPDATE Course SET "+update+" WHERE id="+course.getId());
			}
			catch( SQLException sqle) {res=2; sqle.printStackTrace();}
			finally {
				try {
					st.close();
					cn.close();
				}
				catch (SQLException throwables) { res=2; throwables.printStackTrace();}
				res = 0;
			}
		}
		return res;
	}

	@Override
	public int delete( int index ) throws ExceptionDao {
		int res = 1;
		if( index != -1 && indexExist(index) )
		{
			Connection cn = Connect.openConnection();
			
			Statement st = null;
			try
			{
				st = cn.createStatement();
				st.execute("DELETE FROM Course WHERE id="+index);
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

	@Override
	public int delete( Course course ) throws ExceptionDao
	{
		return delete(course.getId());
	}
	@Override
	public boolean indexExist(int index) throws ExceptionDao {
		boolean existe = false;
		
		List<Course> alCourse = getAll();
		for( Course cours : alCourse )
			if( index == cours.getId() )
				existe = true;
		
		return existe;
	}
}
