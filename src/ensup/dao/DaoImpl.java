package ensup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DaoImpl {
    //Information accès base de donnees
    final String url = "jdbc:mysql://vps-0c0ccce5.vps.ovh.net:3306/GestionEtablissement";
    /**
     * The Username.
     */
    final String username = "web";
    /**
     * The Mdp.
     */
    final String mdp = "Ensup2020*";

    /**
     * The Cn.
     */
// initialisation des variables java permettant de dialoguer avec la bdd
    // connecter a la base de données
    Connection cn = null;
    /**
     * The St.
     */
// exxecuter la requete
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

}
