package ensup.dao;

import ensup.business.*;
import ensup.exception.dao.ExceptionDao;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static ensup.dao.Connect.openConnection;

/**
 * The type Dao.
 */
public class PersonDao implements IDao<Person>
{
    /**
     * The Cn.
     */
// initialisation des variables java permettant de dialoguer avec la bdd
    // connecter a la base de données
    Connection cn = null;
    /**
     * The St.
     */
// executer la requete
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


    /**
     * Instantiates a new Dao person.
     */
    public PersonDao()
    {

    }

    /**
     * Create person. Person could be of type Teacher, Director, Student or Manager
     *
     * @param entity the person object
     * @return Result of the request, if an exception was catched, returns -1
     */
    @Override
    public int create(Person entity) throws ExceptionDao {
        try {
            /*
             * CrÃ©er la connexion
             */
            cn = openConnection();

            /*
             * CrÃ©er la requete
             */
            String sql_request = "INSERT INTO Person(" +
                    "firstname," +
                    "lastname," +
                    "email," +
                    "address,"+
                    "phone,"+
                    "role,"+
                    "password,"+
                    "dateofbirth,"+
                    "subjecttaught) "+
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?) ";
            st = cn.prepareStatement(sql_request);
            st.setString(1, entity.getFirstname());
            st.setString(2, entity.getLastname());
            st.setString(3, entity.getMailAddress());
            st.setString(4, entity.getAddress());
            st.setString(5, entity.getPhoneNumber());
            st.setInt   (6, entity.getRole().getNum());
            st.setString(7, entity.getPassword());

            if(entity instanceof Student)
            {
                st.setDate  (8, new java.sql.Date(((Student) entity).getDateOfBirth().getTime()));
                st.setString (9, null);
            }else if(entity instanceof Teacher)
            {
                st.setDate  (8, null);
                st.setString (9, ((Teacher) entity).getSubjectTaught());
            }else
            {
                st.setDate  (8, null);
                st.setString (9, null);
            }

            /*
             * ExÃ©cuter la requÃªte
             */
            res = st.executeUpdate();

            /*
             * Fermer la connexion
             */
            cn.close();

            /**
             * Log to file
             */
                File propertiesFileDao = new File( "Properties/log4j.properties");
                PropertyConfigurator.configure(propertiesFileDao.toString());
                Logger log = Logger.getLogger(PersonDao.class.getName());
                log.info("L'utilisateur " + entity.getLastname() +" "+entity.getFirstname() + " " + entity.getMailAddress() + " a été créé.");

        } catch (SQLException e) {

        } finally {

        }
        return res;
    }

    /**
     * Update person. Person could be of type Teacher, Director, Student or Manager
     *
     * @param entity the person object
     * @return Result of the request, if an exception was catched, returns -1
     */
    @Override
    public int update(Person entity) throws ExceptionDao{
        try {
            /*
             * CrÃ©er la connexion
             */
            cn = openConnection();

            /*
             * CrÃ©er la requÃªte
             */
            String sql_request = "UPDATE Person SET " +
                    "firstname = ?, " +
                    "lastname = ?, " +
                    "address =  ?, "+
                    "phone = ?, "+
                    "role = ?, "+
                    "password = ?, "+
                    "dateofbirth = ?, "+
                    "subjecttaught = ? "+
                    "WHERE email = ?";
            st = cn.prepareStatement(sql_request);
            st.setString(1, entity.getFirstname());
            st.setString(2, entity.getLastname());
            st.setString(3, entity.getAddress());
            st.setString(4, entity.getPhoneNumber());
            st.setInt   (5, entity.getRole().getNum());
            st.setString(6, entity.getPassword());
            if(entity instanceof Student)
            {
                st.setDate  (7, new java.sql.Date(((Student) entity).getDateOfBirth().getTime()));
                st.setString(8, null);
            }else if(entity instanceof Teacher)
            {
                st.setDate(7, null);
                st.setString (8, ((Teacher) entity).getSubjectTaught());
            }else
            {
                st.setDate(7, null);
                st.setString (8, null);
            }
            st.setString (9,  entity.getMailAddress());
            /*
             * ExÃ©cuter la requÃªte
             */
            res = st.executeUpdate();

            /*
             * Fermer la connexion
             */
            cn.close();

        } catch (SQLException e) {

        } finally {

        }
        return res;
    }

    /**
     * Get person.
     *
     * @param index the person index in the database
     * @return Result of the request, if an exception was catched, returns -1
     */
    @Override
    public Person get(int index) throws ExceptionDao {
        Person p1 = null;
        try {
            /*
             * CrÃ©er la connexion
             */
            cn = openConnection();

            /*
             * CrÃ©er la requÃªte
             */
            String sql_request = "SELECT * FROM Person WHERE id = ?";
            st = cn.prepareStatement(sql_request);
            st.setInt(1, index);

            /*
             * ExÃ©cuter la requÃªte
             */
            rs = st.executeQuery();

            /*
             * Créer une personne
             */
            if(rs.next())
            {
                int id = rs.getInt("id");
                String firstName = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                int role = rs.getInt("role");
                String password = rs.getString("password");
                Object dateofbirth = rs.getObject("dateofbirth");
                Object subjecttaught = rs.getObject("subjecttaught");

                if(rs.getInt("role") == Role.DIRECTOR.getNum())
                {
                    p1 = new Director(lastname, email, address, phone, id, firstName, password);
                }
                else if(rs.getInt("role") == Role.MANAGER.getNum())
                {
                    p1 = new Manager(lastname, email, address, phone, id, firstName, password);
                }
                else if(rs.getInt("role") == Role.TEACHER.getNum())
                {
                    if(subjecttaught != null) {
                        p1 = new Teacher(lastname, email, address, phone, id, firstName, password, (String)subjecttaught);
                    }
                    else {
                        p1 = new Teacher(lastname, email, address, phone, id, firstName, password, null);
                    }
                }
                else if(rs.getInt("role") == Role.STUDENT.getNum())
                {
                    if(dateofbirth != null) {
                        p1 = new Student(lastname, email, address, phone, id, firstName, password, (Date)dateofbirth);
                    } else {
                        p1 = new Student(lastname, email, address, phone, id, firstName, password, null);
                    }
                }
            }

            /*
             * Fermer la connexion
             */
            cn.close();

        } catch (SQLException e) {
            e.printStackTrace();
            res = -1;
        } finally {

        }
        return p1;
    }

    /**
     * Get all person.
     *
     * @return List of Person, if an exception was catched, returns -1
     */
    @Override
    public List<Person> getAll() throws ExceptionDao {
        List<Person> listPerson = new ArrayList<Person>();
        try {
            /*
             * CrÃ©er la connexion
             */
            cn = openConnection();

            /*
             * CrÃ©er la requÃªte
             */
            String sql_request = "SELECT * FROM Person";
            st = cn.prepareStatement(sql_request);

            /*
             * ExÃ©cuter la requÃªte
             */
            rs = st.executeQuery();

            /*
             * Créer une personne
             */

            while(rs.next())
            {
                int id = rs.getInt("id");
                String firstName = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                int role = rs.getInt("role");
                String password = rs.getString("password");
                Object dateofbirth = rs.getObject("dateofbirth");
                Object subjecttaught = rs.getObject("subjecttaught");

                Person p1 = null;

                if(rs.getInt("role") == Role.DIRECTOR.getNum())
                {
                    p1 = new Director(lastname, email, address, phone, id,  firstName, password);
                }
                else if(rs.getInt("role") == Role.MANAGER.getNum())
                {
                    p1 = new Manager(lastname, email, address, phone, id, firstName, password);
                }
                else if(rs.getInt("role") == Role.TEACHER.getNum())
                {
                    if(subjecttaught != null) {
                        p1 = new Teacher(lastname, email, address, phone, id, firstName, password, (String)subjecttaught);
                    }
                    else {
                        p1 = new Teacher(lastname, email, address, phone, id, firstName, password, null);
                    }
                }
                else if(rs.getInt("role") == Role.STUDENT.getNum())
                {
                    if(dateofbirth != null) {
                        p1 = new Student(lastname, email, address, phone, id, firstName, password, (Date)dateofbirth);
                    }
                    else {
                        p1 = new Student(lastname, email, address, phone, id, firstName, password, null);
                    }
                }
                listPerson.add(p1);
            }

            /*
             * Fermer la connexion
             */

            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            res = -1;
        } finally {

        }
        return listPerson;
    }

    /**
     * Delete person.
     *
     * @param index index of the person in the database
     * @return List of Person, if an exception was catched, returns -1
     */
    @Override
    public int delete(int index) throws ExceptionDao {
        try {
            /*
             * CrÃ©er la connexion
             */
            cn = openConnection();

            /*
             * CrÃ©er la requÃªte
             */
            String sql_request = "DELETE FROM Person WHERE id = ?";
            st = cn.prepareStatement(sql_request);
            st.setInt(1, index);

            /*
             * ExÃ©cuter la requÃªte
             */
            res = st.executeUpdate();

            /*
             * Fermer la connexion
             */
            cn.close();

        } catch (SQLException e) {
            e.printStackTrace();
            res = -1;
        } finally {

        }
        return 0;
    }

    /**
     * Link to course int.
     *
     * @param entity the entity
     * @param course the course
     * @return Result of the request
     */
    public int LinkToCourse(int entity, int course) throws ExceptionDao {
        try {
            /*
             * CrÃ©er la connexion
             */
            cn = openConnection();

            /*
             * CrÃ©er la requÃªte
             */
            String sql_request = "INSERT INTO Course_Person(idPerson, idCourse) VALUES (?, ?)";
            st = cn.prepareStatement(sql_request);
            st.setInt(1, entity);
            st.setInt(2, course);

            /*
             * ExÃ©cuter la requÃªte
             */
            res = st.executeUpdate();

            /*
             * Fermer la connexion
             */
            cn.close();

        } catch (SQLException e) {
            e.printStackTrace();
            res = -1;
        } finally {

        }
        return 0;
    }
}
