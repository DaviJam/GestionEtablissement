package ensup.service;

import ensup.dao.ExceptionDao;
import ensup.dao.LoginDao;
import ensup.dao.PersonDao;

/**
 * The type Service connection.
 */
public class ConnectionService implements IConnectionService {
    private LoginDao dao = new LoginDao();
    private PersonDao daopers = new PersonDao();

    @Override
    public int checkConnection(String mail, String mdp) throws ExceptionDao {
        int index = this.dao.checkPassword(mail, mdp); // Récupération du MDP et comparaison avec le mdp saisi
        return index;
    }
}
