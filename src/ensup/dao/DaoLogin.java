package ensup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static ensup.dao.Connect.openConnection;

public class DaoLogin {
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

    String getPassword(String mail) {
        String mdp = null;
        try {
            /*
             * CrÃ©er la connexion
             */
            cn = openConnection();

            /*
             * CrÃ©er la requÃªte
             */
            String sql_request = "SELECT password FROM Person WHERE email = ?";
            st = cn.prepareStatement(sql_request);
            st.setString(1, mail);

            /*
             * ExÃ©cuter la requÃªte
             */
            rs = st.executeQuery();


            if (rs.next()) {
                mdp = rs.getString("password");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return mdp;
    }
}
