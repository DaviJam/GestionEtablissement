package ensup.service;

import ensup.dao.LoginDao;
import ensup.dao.PersonDao;
import ensup.exception.dao.ExceptionDao;
import ensup.exception.service.ExceptionService;

/**
 * The type Service connection.
 */
public class ConnectionService implements IConnectionService {
    private LoginDao dao = new LoginDao();
    private PersonDao daopers = new PersonDao();

    @Override
    public int checkConnection(String mail, String mdp) throws ExceptionService {
        int index;
        try {
            index = this.dao.checkPassword(mail, mdp); // Récupération du MDP et comparaison avec le mdp saisi
        } catch (ExceptionDao e){
            throw new ExceptionService(e.getMessage());
        } finally {

        }
        return index;
    }
}
