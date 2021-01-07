package ensup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static ensup.dao.Connect.openConnection;

/**
 * The type Dao login.
 */
public class DaoLogin {
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
     * @param mail the mail
     * @return the password
     */
    public int checkPassword(String mail, String password) {
        int count = 0;
        try {
            /*
             * CrÃ©er la connexion
             */
            cn = openConnection();

            /*
             * CrÃ©er la requÃªte
             */
            String sql_request = "SELECT COUNT(email) AS nb FROM Person WHERE email = ? , password = ?";
            st = cn.prepareStatement(sql_request);
            st.setString(1, mail);
            st.setString(1, password);

            /*
             * ExÃ©cuter la requÃªte
             */
            rs = st.executeQuery();


            if (rs.next()) {
                count = rs.getInt("nb");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return count;
    }
}
