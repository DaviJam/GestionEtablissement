package ensup.dao;

import ensup.exception.dao.ExceptionDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static ensup.dao.Connect.openConnection;

/**
 * The type Dao login.
 */
public class LoginDao {
    /**
     * The Connection.
     */
    Connection cn = null;

    /**
     * The Prepared Statement.
     */
    PreparedStatement st = null;

    /**
     * The Result Set.
     */
    ResultSet rs = null;

    /**
     * The update, create and remove result.
     */
    int res = 0;

    /**
     * Gets password.
     *
     * @param mail     the mail
     * @param password the password
     * @return the password
     */
    public int checkPassword(String mail, String password) throws ExceptionDao {
        int id = 0;
        try {
            /*
             * Crer la connexion
             */
            cn = openConnection();

            /*
             * CrÃ©er la requÃªte
             */
            String sql_request = "SELECT id FROM Person WHERE email = ? AND password = ? AND (role = 1 OR role = 2)";
            st = cn.prepareStatement(sql_request);
            st.setString(1, mail);
            st.setString(2, password);

            /*
             * ExÃ©cuter la requÃªte
             */
            rs = st.executeQuery();


            if (rs.next()) {
                id = rs.getInt("id");
            } else {
                throw new ExceptionDao("Login : Mot de passe incorrect.");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return id;
    }
}
